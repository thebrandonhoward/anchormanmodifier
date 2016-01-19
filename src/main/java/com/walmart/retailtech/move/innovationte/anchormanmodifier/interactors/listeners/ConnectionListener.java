package com.walmart.retailtech.move.innovationte.anchormanmodifier.interactors.listeners;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import com.walmart.retailtech.move.innovationte.anchormanmodifier.boundaries.ReportDatastoreConnection;
import com.walmart.retailtech.move.innovationte.anchormanmodifier.parameters.ConnectionParameters;

@Singleton
@Startup
public class ConnectionListener 
{
	// Note the java.util.Properties object is a thread-safe
    // collections that uses synchronization.  If it didn't
    // you would have to use some form of synchronization
    // to ensure the PropertyRegistryBean is thread-safe.
	private static Map<String,Object> properties = new HashMap<>();
	
	//private static final ReportDatastoreConnection reportDatastoreConnection
		//= new CassandraConnection();
	private static final ReportDatastoreConnection reportDatastoreConnection
		= new CouchbaseConnection();
	
    // The @Startup annotation ensures that this method is
    // called when the application starts up.
    @PostConstruct
    public void applicationStartup() 
    { 	
    	System.out.printf( "Starting %s ...\n", ConnectionParameters.DATABASE_TYPE );
    	properties = reportDatastoreConnection.datastoreStartup();
    	System.out.printf( "%s started.\n", ConnectionParameters.DATABASE_TYPE );
    }

    @PreDestroy
    public void applicationShutdown() 
    {
    	System.out.printf( "Stopping %s\n", ConnectionParameters.DATABASE_TYPE );
    	reportDatastoreConnection.datastoreShutdown();
    	System.out.printf( "%s stopped\n", ConnectionParameters.DATABASE_TYPE );
    }

    public Object getProperty( final String key ) 
    {
        return properties.get( key );
    }
}