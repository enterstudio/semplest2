package semplest.services.client.interfaces;

import semplest.server.protocol.chaseorbitalgateway.CustomerObject;

public interface ChaseOrbitalGatewayInterface extends ServiceInitialize
{
	public abstract String CreateProfile(CustomerObject customerObject, String creditCardNumber)throws Exception; 
}
