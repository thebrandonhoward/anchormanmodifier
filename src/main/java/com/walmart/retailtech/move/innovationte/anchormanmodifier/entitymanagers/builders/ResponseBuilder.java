package com.walmart.retailtech.move.innovationte.anchormanmodifier.entitymanagers.builders;

import java.net.URI;

import javax.ws.rs.core.Response;

public class ResponseBuilder 
{	
	public ResponseBuilder() {}
	
	public Response buildSuccess( String json
			                     ,String mediaType
			                     ,String method 
			                     ,int status )
	{
		return Response.ok( json, mediaType )
				       .header( "Access-Control-Allow-Origin", "*" )
			           .header( "Access-Control-Allow-Methods", method )
			           .status( status )
			           .build();
	}
	
	public Response buildInvalidRequest( String method
			                            ,int status )
	{
		return Response.serverError()
		               .header( "Access-Control-Allow-Origin","*" )
	                   .header( "Access-Control-Allow-Methods", method )
	                   .status( status )
	                   .build();
	}

	public Response buildCreatedRequest( String method
	                                    ,int status
	                                    ,URI uri )
	{
		return Response.created( uri )
		.header( "Access-Control-Allow-Origin","*" )
		.header( "Access-Control-Allow-Methods", method )
		.status( status )
		.build();
	}
}