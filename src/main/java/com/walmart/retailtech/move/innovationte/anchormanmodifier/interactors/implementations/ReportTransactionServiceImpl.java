package com.walmart.retailtech.move.innovationte.anchormanmodifier.interactors.implementations;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.walmart.retailtech.move.innovationte.anchormanmodifier.boundaries.ReportTransactionService;
import com.walmart.retailtech.move.innovationte.anchormanmodifier.entities.Headers;
import com.walmart.retailtech.move.innovationte.anchormanmodifier.entitymanagers.builders.ResponseBuilder;
import com.walmart.retailtech.move.innovationte.anchormanmodifier.interactors.managers.HeadersManager;
import com.walmart.retailtech.move.innovationte.anchormanmodifier.interactors.managers.TransactionManager;

@Path("/")
public class ReportTransactionServiceImpl implements ReportTransactionService 
{	
	@GET
	@Override
	public Response getDocs() {
		// TODO Auto-generated method stub
		return null;
	}

	@HEAD
	@Override
	public Response getHead() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@OPTIONS
	@Override
	public Response getOptions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Path("{reportid}")
	@PUT
	@Override
	public Response insertDocument( @Context HttpHeaders headers
								   ,@PathParam( "reportid" ) String reportid
			                       ,String requestTransaction ) 
	{ 
		HeadersManager headersManager = new HeadersManager();
		boolean validHeader = headersManager.delegateHeadersValidation( headers );
		Headers headersObj = headersManager.delegateFinalHeaders();
		
		if( validHeader )
		{
			return new TransactionManager().delegateInsertDocument( headersObj
					                                               ,reportid
					                                               ,requestTransaction );
		} else {
			return new ResponseBuilder().buildInvalidRequest( "PUT"
                                                             ,400 );
		}
	}

	@Path("{reportid}")
	@POST
	@Override
	public Response updateDocument( @Context HttpHeaders headers
                                   ,String requestTransaction ) 
    {
		return null;
	}

	@Path("{reportid}")
	@DELETE
	@Override
	public Response deleteDocument( @Context HttpHeaders headers
                                   ,String requestTransaction ) 
    {
		return null;
	}

	//@PATCH( not currently supported in javax )
	@Override
	@Path("{reportid}")
	public Response patchDocument( @Context HttpHeaders headers
                                  ,String requestTransaction ) 
    {
		return null;
	}
}