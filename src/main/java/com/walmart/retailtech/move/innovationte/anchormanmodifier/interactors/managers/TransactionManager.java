package com.walmart.retailtech.move.innovationte.anchormanmodifier.interactors.managers;

import javax.ws.rs.core.Response;

import com.walmart.retailtech.move.innovationte.anchormanmodifier.entities.Headers;
import com.walmart.retailtech.move.innovationte.anchormanmodifier.entitymanagers.builders.ResponseBuilder;
import com.walmart.retailtech.move.innovationte.anchormanmodifier.interactors.implementations.ReportTransactionServiceCacheImpl;

public class TransactionManager 
{
	public TransactionManager() {}
	
	public Response delegateInsertDocument( Headers headersObj
										   ,String reportid
                                           ,String requestTransaction )
	{				
		if(   !requestTransaction.equals( "" ) 
		   && !requestTransaction.equals( null ) )
		{
			Response cache = new ReportTransactionServiceCacheImpl()
			                   	.setCacheInsertDocument( reportid, requestTransaction );
		
			return cache;
		} else {
			return new ResponseBuilder().buildInvalidRequest( "PUT"
                                                             ,400 );
		}	
	}
}