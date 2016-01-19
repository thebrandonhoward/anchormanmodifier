package com.walmart.retailtech.move.innovationte.anchormanmodifier.utilities;

import java.net.ConnectException;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.JsonDocument;
import com.walmart.retailtech.move.innovationte.anchormanmodifier.entitymanagers.builders.RandomConnectionBuilder;

public class BucketConnectionUtility 
{
	private String bucketid, bucketpass;
	
	private RandomConnectionBuilder randomConnectionBuilder = new RandomConnectionBuilder();
	private RandomConnectionUtility randomConnectionUtility;
	
	private Bucket bucket;

	public BucketConnectionUtility(){} 
	
	public BucketConnectionUtility( String id )
	{
		setBucketid( id );
	}
	
	public BucketConnectionUtility( String id, String pass )
	{
		setBucketid( id );
		setBucketpass( pass );
	}

	public String getBucketid() {
		return bucketid;
	}

	public void setBucketid(String bucketid) {
		this.bucketid = bucketid;
	}

	public String getBucketpass() {
		return bucketpass;
	}

	public void setBucketpass(String bucketpass) {
		this.bucketpass = bucketpass;
	}
	
	public Bucket openBucketConnectionWithPass()
	{
		try 
		{
			randomConnectionUtility = randomConnectionBuilder.constructRandomConnection();
			
			bucket = randomConnectionUtility.getCluster().openBucket( bucketid, bucketpass );
			
		}
		catch ( ConnectException ce ) 
		{
			// TODO Auto-generated catch block
			ce.printStackTrace();
		}
		
		return bucket;
	}
	
	public Bucket openBucketConnectionNoPass()
	{
		try 
		{
			randomConnectionUtility = randomConnectionBuilder.constructRandomConnection();
			
			//System.out.println( randomConnectionUtility.getCluster().toString() );
			
			//bucket = randomConnectionUtility.getCluster().openBucket( bucketid );
			Cluster cluster = CouchbaseCluster.create( "10.243.238.239" );
			Bucket bucket = cluster.openBucket( "PurchaseHistory" );
			JsonDocument walter = bucket.get("BR_000000123_20150920_20150922_01");
			System.out.println( walter );
			
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bucket;
	}
	
	public void closeBucket( Bucket bucket )
	{
		bucket.close();
	}
	
}