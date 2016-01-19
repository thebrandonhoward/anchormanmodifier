package com.walmart.retailtech.move.innovationte.anchormanmodifier.entitymanagers.factories;

import java.net.ConnectException;

import com.walmart.retailtech.move.innovationte.anchormanmodifier.parameters.ConnectionParameters;
import com.walmart.retailtech.move.innovationte.anchormanmodifier.utilities.RandomConnectionUtility;

public class RandomConnectionFactory 
{

	public RandomConnectionFactory(){}
	
	public RandomConnectionUtility assembleRandomConnection() throws ConnectException
	{
		return new RandomConnectionUtility(ConnectionParameters.DATABASE_TYPE);
	}

}