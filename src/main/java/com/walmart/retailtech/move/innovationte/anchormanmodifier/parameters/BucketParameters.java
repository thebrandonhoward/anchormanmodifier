package com.walmart.retailtech.move.innovationte.anchormanmodifier.parameters;

public class BucketParameters 
{
	// onhand rollup
	public static final String INVENTORY_ROLLUP_BUCKET = "inventory_onhands";
	public static final String INVENTORY_ROLLUP_BUCKET_PASSWORD = "password";
	//public static final String INVENTORY_ROLLUP_BUCKET_PASSWORD = " ";
	
	// onhand views
	public static final String INVENTORY_ROLLUP_BUCKET_DESIGN = "dev_inventory_onhands";
	public static final String INVENTORY_ROLLUP_BUCKET_LATEST_ONHAND_VIEW = "latestOnhandsInventory";
	
	// transactions
	public static final String INVENTORY_TRANSACTION_BUCKET = "inventory_transactions";
	public static final String INVENTORY_TRANSACTION_BUCKET_PASS = "password";
	//public static final String INVENTORY_TRANSACTION_BUCKET_PASS = " ";
	
	// transaction views
	public static final String INVENTORY_TRANSACTION_BUCKET_DESIGN = "dev_inventory_transactions";
	public static final String INVENTORY_TRANSACTION_BUCKET_TRANSACTION_QTY_SUM_VIEW = "transactionsQtySum";
	
	// max query timestamp
	public static final long MAX_QUERY_ENDKEY_TIMESTAMP = 9999999999999L;
	
	private BucketParameters() {}
}