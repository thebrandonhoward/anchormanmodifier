package com.walmart.retailtech.move.innovationte.anchormanmodifier.utilities;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.couchbase.client.java.Cluster;
import com.walmart.retailtech.move.innovationte.anchormanmodifier.interactors.listeners.CassandraConnection;
import com.walmart.retailtech.move.innovationte.anchormanmodifier.interactors.listeners.ConnectionListener;
import com.walmart.retailtech.move.innovationte.anchormanmodifier.interactors.listeners.CouchbaseConnection;

public class RandomConnectionUtility
{
	private Cluster cluster;
	
	public RandomConnectionUtility( ){}
	
	public RandomConnectionUtility(String databaseType) throws ConnectException
	{
		getRandomConnectionClusters(databaseType);
	}
	
	@SuppressWarnings("unchecked")
	private void getRandomConnectionClusters(String databaseType) throws ConnectException
	{
		List<Cluster> couchbaseClient = new ArrayList<Cluster>();
		
		// get connections array of singletons.
		switch(databaseType)
		{
			case "couchbase":
				couchbaseClient = (List<Cluster>) new CouchbaseConnection().getProperty( "cbconnectionclients" );
				break;
			case "cassandra":
				couchbaseClient = (List<Cluster>) new CassandraConnection().getProperty( "cbconnectionclients" );
				break;
			default:
				break;
		}
		
		// choose a random connection from the array of connection objects.
		Random random = new Random();
		
		if( !couchbaseClient.equals(null) )
		{
			int clusterSize = couchbaseClient.size();
			
			if (clusterSize > 0 )
			{
				if( clusterSize < 2 )
					this.cluster = couchbaseClient.get( 0 );
				else
					this.cluster = couchbaseClient.get( random.nextInt( clusterSize - 1 ) );
			} else
			{
				this.cluster = null;
			
				throw new ConnectException("No Connections Available.");
			}
		}
		else
		{
			throw new ConnectException("No Client objects created on startup." );
		}
	}
	
	public Cluster getCluster()
	{
		return this.cluster;
	}

}
