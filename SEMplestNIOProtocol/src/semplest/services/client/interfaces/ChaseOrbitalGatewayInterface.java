package semplest.services.client.interfaces;

import java.util.List;

import semplest.server.protocol.SemplestString;
import semplest.server.protocol.chaseorbitalgateway.CustomerObject;
import semplest.server.protocol.chaseorbitalgateway.GatewayReturnObject;

public interface ChaseOrbitalGatewayInterface extends ServiceInitialize
{
	GatewayReturnObject CreateProfile(CustomerObject customerObject) throws Exception;
	List<CustomerObject> GetProfiles(List<String> customerProfileRefNumbers) throws Exception;
	GatewayReturnObject CopyProfile(SemplestString customerProfileRefNumber) throws Exception;
	GatewayReturnObject AuthorizeAndCapture(String customerProfileRefNumber, Double Amount, String cardSecVal) throws Exception;
	GatewayReturnObject UpdateProfileRecurringBilling(String customerProfileRefNumber, Double recurringAmount, java.util.Date startDate) throws Exception;
	GatewayReturnObject terminateRecurringPayments(SemplestString customerProfileRefNumber) throws Exception;
	GatewayReturnObject refundPayment(String customerProfileRefNumber, Double Amount) throws Exception;	
}