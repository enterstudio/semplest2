package semplest.services.client.interfaces;

import semplest.server.protocol.chaseorbitalgateway.CustomerObject;
import semplest.server.protocol.chaseorbitalgateway.GatewayReturnObject;

public interface ChaseOrbitalGatewayInterface extends ServiceInitialize
{
	public abstract GatewayReturnObject CreateProfile(CustomerObject customerObject, String creditCardNumber, String ExpireDateMMYY)throws Exception; 
	public abstract GatewayReturnObject AuthorizeAndCapture(String customerProfileRefNumber, Double Amount) throws Exception;
}