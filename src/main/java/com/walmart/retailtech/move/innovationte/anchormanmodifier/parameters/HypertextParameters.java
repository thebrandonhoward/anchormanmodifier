package com.walmart.retailtech.move.innovationte.anchormanmodifier.parameters;

public class HypertextParameters 
{
	// *********************************** inventory collections ***************************************
	public static final String COLLECTION_DOCS = "rollupDocsGet";
	public static final String COLLECTION_DOCS_LINK = "{protocol}://{proxy}:{port}/inventorycollector";
	
	public static final String COLLECTION_OPTIONS = "rollupOptionsGet";
	public static final String COLLECTION_OPTIONS_LINK = "{protocol}://{proxy}:{port}/inventorycollector/retailtech/apiv1";
	
	public static final String COLLECTION_SITE_ITEM = "rollupSiteItemGet";
	public static final String COLLECTION_SITE_ITEM_LINK = "{protocol}://{proxy}:{port}/inventorycollector/retailtech/apiv1/{site}/{itemNbr}";
	
	// ************************************ inventory modifiers ****************************************
	public static final String MODIFIER_BASE_URL = "http://localhost:8080/anchormanmodifier/";
	
	public static final String MODIFIER_DOCS = "modifierDocsGet";
	public static final String MODIFIER_DOCS_LINK = "{protocol}://{proxy}:{port}/anchormanmodifier/";
	
	public static final String MODIFIER_OPTIONS = "modifierOptionsGet";
	public static final String MODIFIER_OPTIONS_LINK = "{protocol}://{proxy}:{port}/inventorymodifier/retailtech/apiv1";
	
	public static final String MODIFIER_ROLLUP_SITE_ITEM_DATE = "modifierSiteItemDatePost(insert) no body";
	public static final String MODIFIER_ROLLUP_SITE_ITEM_DATE_LINK = "{protocol}://{proxy}:{port}/inventorymodifier/retailtech/apiv1/{site}/{itemNbr}/{yyyymmdd}";
	
	public static final String MODIFIER_ROLLUP_MODIFY_SITE_ITEM_DATE = "modifierSiteItemDatePut(update) client will get resource first, then add complete json document as body";
	public static final String MODIFIER_ROLLUP_MODIFY_ITEM_DATE_LINK = "{protocol}://{proxy}:{port}/inventorymodifier/retailtech/apiv1/{site}/{itemNbr}/{yyyymmdd}";
	
	// ************************************* inventory events ******************************************
	public static final String EVENT_DOCS = "eventDocsGet";
	public static final String EVENT_DOCS_LINK = "{protocol}://{proxy}:{port}/inventoryevent";
	
	public static final String EVENT_OPTIONS = "eventOptionsGet";
	public static final String EVENT_OPTIONS_LINK = "{protocol}://{proxy}:{port}/inventoryevent/retailtech/apiv1";
	
	public static final String EVENT_TRANSACTION_SITE_ITEM_TIMESTAMP = "eventTransactionJsonPost(insert) json as body";
	public static final String EVENT_TRANSACTION_SITE_ITEM_TIMESTAMP_LINK = "{protocol}://{proxy}:{port}/inventoryevent/retailtech/apiv1/{site}/{itemNbr}/{timestamp}";
	
	public static final String EVENT_MODIFY_TRANSACTION_SITE_ITEM_TIMESTAMP = "eventTransactionJsonPut(update) client will get resource first, then add complete json document as body";
	public static final String EVENT_MODIFYTRANSACTION_SITE_ITEM_TIMESTAMP_LINK = "{protocol}://{proxy}:{port}/inventoryevent/retailtech/apiv1/{site}/{itemNbr}/{timestamp}";
	
	private HypertextParameters() {}
}