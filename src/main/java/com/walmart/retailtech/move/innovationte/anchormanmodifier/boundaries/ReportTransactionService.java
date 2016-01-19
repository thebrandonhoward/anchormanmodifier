package com.walmart.retailtech.move.innovationte.anchormanmodifier.boundaries;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

public interface ReportTransactionService 
{
	public Response getDocs();
	
	public Response getHead();
	
	public Response getOptions();
	
	public Response insertDocument( HttpHeaders headers
								   ,String reportid
                                   ,String requestTransaction );
	
	public Response updateDocument( HttpHeaders headers
                                   ,String requestTransaction );
	
	public Response deleteDocument( HttpHeaders headers
                                   ,String requestTransaction );
	
	public Response patchDocument( HttpHeaders headers
                                  ,String requestTransaction );
}