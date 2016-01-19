package com.walmart.retailtech.move.innovationte.anchormanmodifier.boundaries;

import java.util.Map;

public interface ReportDatastoreConnection 
{
	public Map<String,Object> datastoreStartup();
	public void datastoreShutdown();
	public Object getProperty( String key );
}