package com.walmart.retailtech.move.innovationte.anchormanmodifier.interactors.listeners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.walmart.retailtech.move.innovationte.anchormanmodifier.boundaries.ReportDatastoreConnection;
import com.walmart.retailtech.move.innovationte.anchormanmodifier.parameters.ConnectionParameters;

public class CassandraConnection 
	implements ReportDatastoreConnection 
{
	private static List<Cluster> cbconnectionclusters 
		= new ArrayList<Cluster>();
	
	private static List<Session> cbconnectionclients 
		= new ArrayList<Session>();
	
	// Note the java.util.Properties object is a thread-safe
    // collections that uses synchronization.  If it didn't
    // you would have to use some form of synchronization
    // to ensure the PropertyRegistryBean is thread-safe.
	private static Map<String,Object> properties = new HashMap<>();
	
	@Override
	public Map<String, Object> datastoreStartup() 
	{
		// Add each URI to the array
    	ArrayList<String> nodes = new ArrayList<String>();
    	nodes.add( ConnectionParameters.CASSANDRA_IP_1 );
    	
    	// Get the max connections to create
    	int maxConnections = ConnectionParameters.MAX_CONNECTIONS;
        maxConnections = maxConnections > 0 ? maxConnections : 1;
    	
        int i = 0;
    	while( i < maxConnections )
    	{
    		try 
    		{				
    			Cluster cluster = Cluster.builder()
    					         .addContactPoint( nodes.get(i) )
    					         .build();
    			
    			Session session = cluster.connect( ConnectionParameters.SUMMARY_KEYSPACE );
    			
    			cbconnectionclusters.add( cluster );
    			cbconnectionclients.add( session );
    		} catch ( Exception e ) 
			{
				System.out.println( "Error connecting to ClusterConnection_" + i + " : " + e.getMessage() );
				e.printStackTrace();			    	
			}
    		i++;
    	}

    	properties.put( "cbconnectionclusters", cbconnectionclusters );	
    	properties.put( "cbconnectionclients", cbconnectionclients );
    	
		return properties;
	}

	@Override
	public void datastoreShutdown() 
	{
		if( !cbconnectionclusters.equals(null) )
		{
			for(Cluster c : cbconnectionclusters)
			{
				c.close();
			}
		}
		
		if( !cbconnectionclients.equals(null) )
		{
			for(Session s : cbconnectionclients)
			{
				s.close();
			}
		}
	}

	@Override
	public Object getProperty(String key) 
	{
		return properties.get( key );
	}

}