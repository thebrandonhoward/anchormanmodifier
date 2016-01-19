package com.walmart.retailtech.move.innovationte.anchormanmodifier.parameters;

public class ConnectionParameters 
{
	// GENERAL
	public static final int MAX_CONNECTIONS = 1;
	//public static final String DATABASE_TYPE = "cassandra";
	public static final String DATABASE_TYPE = "couchbase";
	
	// CASSANDRA
	public static final String SUMMARY_KEYSPACE = "anchorman";	
	
	public static final String CASSANDRA_IP_1 = "10.242.183.100";
	
	// COUCHBASE
	public static final String POOL_1 = "10.242.182.84";
	
	//public static final String POOL_2 = "10.242.182.246";
	
	public static final String POOL_3 = "10.242.183.228";
	
	public static final String ROLLUP_BUCKET = "inventory_onhands";
	
	public static final String PASS = "password";
	
	public static final String TRANSACTION_BUCKET = "inventory_transactions";	
}