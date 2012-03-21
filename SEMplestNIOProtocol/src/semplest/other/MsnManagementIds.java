package semplest.other;

/**
 * Notes on Customer vs User vs Account
 * ---------
 * General Notes
 * ---------
 * There is a one to one relationship between Account - Customer - User (hence this object)
 * Current the Account name does not appear to be used (The Customer name is used instead)
 * All three ids should be saved since how to retrieve them is unclear
 * Creating two customer with the same name is allowed but it confuses the system (Same User name is not allowed)
 * ---------
 * CUSTOMER
 * ---------
 * Customer is "above" User and Account
 * very high level information like the industry and market the customers works in
 * ---------
 * USER
 * ---------
 * Contact (address, email...) and basic information (Name, job...)
 * contains password
 * ---------
 * ACCOUNT
 * ---------
 * Object "in control" of the Campaigns API (i.e. an account must be specficied in order to do anything in the campaign
 * mangement API)
 * 
 * @author kristian
 */
public class MsnManagementIds {
	private final Long accountId;
	private final Long customerId;
	private final Long userId;
	
	public MsnManagementIds(Long accountId, Long customerId, Long userId) {
		this.accountId = accountId;
		this.customerId = customerId;
		this.userId = userId;
	}
	
	public Long getAccountId() {
		return accountId;
	}
	
	public Long getCustomerId() {
		return customerId;
	}
	
	public Long getUserId() {
		return userId;
	}
	
	@Override
	public String toString() {
		return "MsnManagementIds [accountId=" + accountId + ", customerId=" + customerId + ", userId=" + userId + "]";
	}
	
}
