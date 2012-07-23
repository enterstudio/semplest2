package semplest.system.tester;

import semplest.services.client.api.SemplestMailServiceClient;
import semplest.services.client.interfaces.SemplestMailServiceInterface;

public class MailServiceTest implements SemplestMailServiceInterface{

	private String serviceName = "Mail";	
	
	private SemplestMailServiceClient mailService;
	
	public int Test_MailService(String serviceURL){
		try{			
			SystemTestFunc.PrintServiceHeader(serviceName);			
			SystemTestDataModel.errorCounter = 0;			
			
			mailService = new SemplestMailServiceClient(serviceURL);
						
			/* ***** List of Methods ***** */
			
			SendEmail(null, null, null, null, null);
			
			/* ***** End of List of Methods ***** */
			
		}
		catch(Exception e){
			SystemTestFunc.PrintLineSeperator();
			SystemTestFunc.ErrorHandler(e);
		}
		
		SystemTestFunc.PrintServiceFooter(serviceName, SystemTestDataModel.errorCounter);		
		SystemTestDataModel.mailErrors = SystemTestDataModel.errorCounter;
		return SystemTestDataModel.errorCounter;
	}

	@Override
	public Boolean SendEmail(String subject, String from, String recipient,
			String msgTxt, String msgType) throws Exception {
		SystemTestFunc.PrintLineSeperator();	
		
		SystemTestFunc.PrintMethodCall("SendEmail(SystemTestDataModel.mail_subject, SystemTestDataModel.mail_from, SystemTestDataModel.mail_recipient, SystemTestDataModel.mail_msgTxt, SystemTestDataModel.mail_msgType)");
		try{			
			boolean ret = mailService.SendEmail(SystemTestDataModel.mail_subject, SystemTestDataModel.mail_from, SystemTestDataModel.mail_recipient, SystemTestDataModel.mail_msgTxt, SystemTestDataModel.mail_msgType);
		
			//Verification
			if(!ret){
				SystemTestFunc.ErrorHandler("SendEmail failed.");
			}
		}
		catch(Exception e){
			SystemTestFunc.ErrorHandler(e);
		}
		return null;
	}
	
	//unrelated methods	
	@Override
	public void initializeService(String input) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String checkStatus(String input1, String input2) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean scheduleSendEmail(String subject, String from,
			String recipient, String msgTxt, String msgType) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
