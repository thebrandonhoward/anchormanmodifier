package com.walmart.retailtech.move.innovationte.anchormanmodifier.interactors.managers;

import javax.ws.rs.core.HttpHeaders;

import com.walmart.retailtech.move.innovationte.anchormanmodifier.entities.Headers;
import com.walmart.retailtech.move.innovationte.anchormanmodifier.utilities.HeadersValidatorUtility;

public class HeadersManager 
{
	private boolean valid;
	private Headers headersObj;
	
	public HeadersManager() {}
	
	public HeadersManager( HttpHeaders headers )
	{
		this.valid = delegateHeadersValidation( headers );
	}
	
	public boolean delegateHeadersValidation( HttpHeaders headers )
	{
		this.valid = new HeadersValidatorUtility( headers ).getValid();
		return this.valid;
	}
	
	public Headers delegateFinalHeaders()
	{
		return this.headersObj;
	}
	
}