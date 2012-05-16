package semplest.services.client.interfaces;



import semplest.server.protocol.chaseorbitalgateway.CustomerObject;
import semplest.server.protocol.chaseorbitalgateway.GatewayReturnObject;

public interface ChaseOrbitalGatewayInterface extends ServiceInitialize
{
	public abstract GatewayReturnObject CreateProfile(CustomerObject customerObject, String creditCardNumber, String ExpireDateMMYY)throws Exception; 
	public abstract GatewayReturnObject AuthorizeAndCapture(String customerProfileRefNumber, Double Amount) throws Exception;
	public abstract GatewayReturnObject UpdateProfileRecurringBilling(String customerProfileRefNumber, Double recurringAmount, java.util.Date startDate)throws Exception;
	public abstract GatewayReturnObject terminatePayment(String customerProfileRefNumber)throws Exception;
	public abstract GatewayReturnObject refundPayment(String customerProfileRefNumber, Double Amount) throws Exception;
}