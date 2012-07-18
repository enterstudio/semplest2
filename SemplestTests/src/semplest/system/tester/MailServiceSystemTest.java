package semplest.system.tester;

import semplest.server.protocol.ProtocolEnum.AdEngine;
import semplest.services.client.api.SemplestMailServiceClient;
import semplest.services.client.interfaces.SemplestMailServiceInterface;

public class MailServiceSystemTest implements SemplestMailServiceInterface{

	private String serviceName = "Mail";	
	private int errorCounter = 0;
	
	private SemplestMailServiceClient mailService;
	
	public int Test_MailService(String serviceURL){
		try{			
			SystemTestFunc.PrintServiceHead(serviceName);			
			errorCounter = 0;			
			
			mailService = new SemplestMailServiceClient(serviceURL);
						
			/* ***** List of Methods ***** */
			
			
			
			/* ***** End of List of Methods ***** */
			
		}
		catch(Exception e){
			SystemTestFunc.PrintLineSeperator();
			SystemTestFunc.ErrorHandler(e);
			errorCounter++;
		}
		
		SystemTestFunc.PrintServiceEnd(serviceName, errorCounter);		
		return errorCounter;
	}

	@Override
	public Boolean SendEmail(String subject, String from, String recipient,
			String msgTxt, String msgType) throws Exception {
		SystemTestFunc.PrintLineSeperator();		
		try{
			System.out.println("SendEmail(" + SystemTestDataModel.mail_subject + ", " + SystemTestDataModel.mail_from + ", " + SystemTestDataModel.mail_recipient + ", " + SystemTestDataModel.mail_msgTxt + ", " + SystemTestDataModel.mail_msgType + ")");
			boolean ret = mailService.SendEmail(SystemTestDataModel.mail_subject, SystemTestDataModel.mail_from, SystemTestDataModel.mail_recipient, SystemTestDataModel.mail_msgTxt, SystemTestDataModel.mail_msgType);
		
			//Verification
			if(!ret){
				SystemTestFunc.ErrorHandler("SendEmail failed.");
				errorCounter++;
			}
		}
		catch(Exception e){
			SystemTestFunc.ErrorHandler(e);
			errorCounter++;
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
