package com.walmart.retailtech.move.innovationte.anchormanmodifier.interactors.implementations;

import java.util.ArrayList;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.google.gson.Gson;
import com.walmart.retailtech.move.innovationte.anchormanmodifier.entitymanagers.builders.ResponseBuilder;
import com.walmart.retailtech.move.innovationte.anchormanmodifier.interactors.listeners.ConnectionListener;

public class ReportTransactionServiceCacheImpl 
{
	public ReportTransactionServiceCacheImpl() {}
	
	/*
	public Response setCacheInsertDocument( String reportid, String transaction )
	{
		JsonObject jsonObject = JsonObject.fromJson( transaction );
		JsonDocument reqJsonDocument = JsonDocument.create( reportid, jsonObject );
		
		// 	
		Bucket inventoryTransactionBucket = (Bucket) new ConnectionListener().getProperty( "inventoryTransactionBucket" );
		JsonDocument resJsonDocument = inventoryTransactionBucket.upsert( reqJsonDocument );
		
		return new ResponseBuilder().buildSuccess( resJsonDocument.content().toString()
								                  ,MediaType.APPLICATION_JSON
								                  ,"PUT"
								                  ,200 );
	}
	*/
	
	public Response setCacheInsertDocument( String reportid, String transaction )
	{
		@SuppressWarnings("unchecked")
		ArrayList<Session> inventoryTransactionKeyspace = (ArrayList<Session>) new ConnectionListener().getProperty( "cbconnectionclients" );
		
		ResultSet resJsonDocument = null;
		try
		{
			resJsonDocument 
				= inventoryTransactionKeyspace.get(0).execute( "INSERT INTO summary (id, data) VALUES ('" + reportid + "', " + "'" + transaction + "')" );
		} catch( Exception e )
		{
			System.out.println( "Exception: " + e.getMessage() );
		}
		return new ResponseBuilder().buildSuccess( transaction
								                  ,MediaType.APPLICATION_JSON
								                  ,"PUT"
								                  ,200 );
	}
}