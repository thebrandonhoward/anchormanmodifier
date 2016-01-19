package com.walmart.retailtech.move.innovationte.anchormanmodifier.interactors.listeners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.walmart.retailtech.move.innovationte.anchormanmodifier.boundaries.ReportDatastoreConnection;
import com.walmart.retailtech.move.innovationte.anchormanmodifier.parameters.BucketParameters;
import com.walmart.retailtech.move.innovationte.anchormanmodifier.parameters.ConnectionParameters;
import com.walmart.retailtech.move.innovationte.anchormanmodifier.utilities.BucketConnectionUtility;

public class CouchbaseConnection 
	implements ReportDatastoreConnection 
{
	private static Cluster cbClusterClient;
	private static List<Cluster> cbconnectionclients 
		= new ArrayList<Cluster>();	
	private static Bucket inventoryTransactionBucket;
	private static BucketConnectionUtility transactionBucketConnection 
		= new BucketConnectionUtility( "PurchaseHistory" );
			                          //,BucketParameters.INVENTORY_TRANSACTION_BUCKET_PASS );
	
	private static Bucket inventoryOnhandBucket;
	private static BucketConnectionUtility onhandBucketConnection 
		= new BucketConnectionUtility( BucketParameters.INVENTORY_ROLLUP_BUCKET );
									  //,BucketParameters.INVENTORY_ROLLUP_BUCKET_PASSWORD );
	
	// Note the java.util.Properties object is a thread-safe
    // collections that uses synchronization.  If it didn't
    // you would have to use some form of synchronization
    // to ensure the PropertyRegistryBean is thread-safe.
	private static Map<String,Object> properties = new HashMap<>();
	
    // The @Startup annotation ensures that this method is
    // called when the application starts up.
    @Override
    public Map<String,Object> datastoreStartup() 
    {
    	System.out.println( "Starting Up..." );
    	// Add each URI to the array
    	ArrayList<String> nodes = new ArrayList<String>();
    	nodes.add( ConnectionParameters.POOL_1 );
    	//nodes.add( ConnectionParameters.POOL_2 );
    	//nodes.add( ConnectionParameters.POOL_3 );
    	//nodes.add( "10.243.238.24");
    	nodes.add("10.243.238.24");
    	
    	// Get the max connections to create
    	int maxConnections = ConnectionParameters.MAX_CONNECTIONS;
        maxConnections = maxConnections > 0 ? maxConnections : 1;
    	
        int i = 0;
    	while( i < maxConnections )
    	{
    		try 
    		{				
    			// Attempts to make the database connection
    			cbClusterClient = CouchbaseCluster.create( nodes.get(i) );
    			cbconnectionclients.add( cbClusterClient );	
    		} catch ( Exception e ) 
    			{
    				System.out.println( "Error connecting to ClusterConnection_" + i + " : " + e.getMessage() );
    				e.printStackTrace();			    	
    			}
    		i++;
    	}
    	
    	properties.put( "cbconnectionclients", cbconnectionclients );	
    		
    	//inventoryTransactionBucket = transactionBucketConnection.openBucketConnectionWithPass();
    	inventoryTransactionBucket = transactionBucketConnection.openBucketConnectionNoPass();
        properties.put( "cacheBucket", inventoryTransactionBucket );	
    			
    	//inventoryOnhandBucket = onhandBucketConnection.openBucketConnectionWithPass();
    	//properties.put( "inventoryOnhandBucket", inventoryOnhandBucket );
 
    	System.out.println( "Started." );
    	
    	return properties;
    }

    @Override
    public void datastoreShutdown() 
    {
    	System.out.println( "Shutting Down..." );
    	
    	if( !inventoryOnhandBucket.equals( null ) )
    		inventoryOnhandBucket.close();
    	
    	if( !inventoryTransactionBucket.equals( null ) )
    		inventoryTransactionBucket.close();
    	
    	for(Cluster c : cbconnectionclients)
    	{
    		if( !c.equals( null ) )
    			c.disconnect();
    	}
    	
        properties.clear();
        
        System.out.println( "Shutdown." );
    }

    public Object getProperty( final String key ) 
    {
        return properties.get( key );
    }

}