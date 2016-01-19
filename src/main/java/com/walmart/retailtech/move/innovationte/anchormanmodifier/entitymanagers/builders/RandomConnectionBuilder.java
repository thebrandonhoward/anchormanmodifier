package com.walmart.retailtech.move.innovationte.anchormanmodifier.entitymanagers.builders;

import java.net.ConnectException;

import com.walmart.retailtech.move.innovationte.anchormanmodifier.entitymanagers.factories.RandomConnectionFactory;
import com.walmart.retailtech.move.innovationte.anchormanmodifier.utilities.RandomConnectionUtility;

public class RandomConnectionBuilder 
{
	private RandomConnectionFactory randomConnectionFactory = new RandomConnectionFactory();
	private RandomConnectionUtility randomConnectionUtility;
	
	public RandomConnectionBuilder() {};
	
	public RandomConnectionUtility constructRandomConnection() throws ConnectException
	{
		try
		{
			randomConnectionUtility = randomConnectionFactory.assembleRandomConnection();
		}
		catch( ConnectException ce )
		{
			ce.printStackTrace();
		}
		
		return randomConnectionUtility;
	}

}