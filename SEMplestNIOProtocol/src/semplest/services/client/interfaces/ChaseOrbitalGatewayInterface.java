package semplest.services.client.interfaces;



import java.util.List;

import semplest.server.protocol.SemplestString;
import semplest.server.protocol.chaseorbitalgateway.CustomerObject;
import semplest.server.protocol.chaseorbitalgateway.GatewayReturnObject;

public interface ChaseOrbitalGatewayInterface extends ServiceInitialize
{
	GatewayReturnObject CreateProfile(CustomerObject customerObject, String creditCardNumber, String ExpireDateMMYY) throws Exception;
	List<GatewayReturnObject> GetProfiles(List<String> customerProfileRefNumber) throws Exception;
	GatewayReturnObject CopyProfile(String customerProfileRefNumber) throws Exception;
	GatewayReturnObject AuthorizeAndCapture(String customerProfileRefNumber, Double Amount) throws Exception;
	GatewayReturnObject UpdateProfileRecurringBilling(String customerProfileRefNumber, Double recurringAmount, java.util.Date startDate) throws Exception;
	GatewayReturnObject terminateRecurringPayments(SemplestString customerProfileRefNumber) throws Exception;
	GatewayReturnObject refundPayment(String customerProfileRefNumber, Double Amount) throws Exception;	
}