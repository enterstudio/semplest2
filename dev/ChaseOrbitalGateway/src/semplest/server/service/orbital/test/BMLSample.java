package semplest.server.service.orbital.test;
import com.paymentech.orbital.sdk.interfaces.RequestIF;
import com.paymentech.orbital.sdk.interfaces.ResponseIF;
import com.paymentech.orbital.sdk.interfaces.TransactionProcessorIF;
import com.paymentech.orbital.sdk.request.FieldNotFoundException;
import com.paymentech.orbital.sdk.request.Request;
import com.paymentech.orbital.sdk.transactionProcessor.TransactionException;
import com.paymentech.orbital.sdk.transactionProcessor.TransactionProcessor;
import com.paymentech.orbital.sdk.util.exceptions.InitializationException;

public class BMLSample {
    //Global Constants
    public final static int NORMAL_EXIT = 1;
    public final static int ERROR_EXIT = -1;
    public static void main(String[] args) {
    	/**
    	 * Please note that this code is for documentation purposes only and is 
    	 * specifically written in a simplistic way, in order to better represent and 
    	 * convey specific concepts in the use of the Orbital SDK.  
    	 * Best practices in error handling and control flow for java coding, 
    	 * have often been ignored in favor of providing code that clearly represents 
    	 * a specific concept.  
    	 * Due to the best practices compromises we have made in our sample code, 
    	 * we do not recommend using this code in a production environment without 
    	 * rigorous improvements to error handling and overall architecture.
    	 */
    	//Create a Transaction Processor
        //The Transaction Processor acquires and releases resources and executes transactions.
        //It configures a pool of protocol engines, then uses the pool to execute transactions.
        TransactionProcessorIF tp = null;
        try {
            tp = new TransactionProcessor();
        } catch (InitializationException iex) {
            System.err.println("TransactionProcessor failed to initialize");
            System.err.println(iex.getMessage());
            iex.printStackTrace();
            System.exit(ERROR_EXIT);
        }
    	//Create a request object
        //The request object uses the XML templates along with data we provide
        //to generate a String representation of the xml request
        RequestIF request = null;
        try {
            //Tell the request object which template to use (see RequestIF.java)
            request = new Request(RequestIF.NEW_ORDER_TRANSACTION);
            
            //If there were no errors preparing the template, we can now specify the data
            //Basic Auth Fields
		request.setFieldValue("IndustryType","MO");
		request.setFieldValue("MessageType","A");
		request.setFieldValue("BIN","000001");
		request.setFieldValue("MerchantID","639013");
		request.setFieldValue("TerminalID","001");
		request.setFieldValue("AccountNum","5049900000000000");
		request.setFieldValue("CurrencyCode","840");
		request.setFieldValue("CurrencyExponent","2");
		request.setFieldValue("AVSzip","21093");
		request.setFieldValue("AVSaddress1","9690 DEERECO RD");
		request.setFieldValue("AVSaddress2","SUITE 705");
		request.setFieldValue("AVScity","TIMONIUM");
		request.setFieldValue("AVSstate","MD");
		request.setFieldValue("AVSphoneNum","4439211900");
		request.setFieldValue("AVSname","ORBITALC MERCHANTC");
		request.setFieldValue("AVScountryCode","US");
		request.setFieldValue("AVSDestzip","894139700");
		request.setFieldValue("AVSDestaddress1","1245 TAMARACK DR UNIT 15");
		request.setFieldValue("AVSDestcity","LINCOLN PARK");
		request.setFieldValue("AVSDeststate","NV");
		request.setFieldValue("AVSDestphoneNum","4439211900");
		request.setFieldValue("AVSDestname","JUSTIN MERCHANTC");
		request.setFieldValue("AVSDestcountryCode","US");
		request.setFieldValue("OrderID","CC0010");
		request.setFieldValue("Amount","27500");
		request.setFieldValue("Comments","1");
		request.setFieldValue("BMLShippingCost","650");
		request.setFieldValue("BMLTNCVersion","12103");
		request.setFieldValue("BMLCustomerRegistrationDate","20060922");
		request.setFieldValue("BMLCustomerTypeFlag","N");
		request.setFieldValue("BMLItemCategory","5500");
		request.setFieldValue("BMLCustomerBirthDate","19601117");
		request.setFieldValue("BMLCustomerSSN","4016");
		request.setFieldValue("BMLCustomerAnnualIncome","25000");
		request.setFieldValue("BMLCustomerResidenceStatus","R");
		request.setFieldValue("BMLCustomerCheckingAccount","Y");
		request.setFieldValue("BMLCustomerSavingsAccount","Y");
		request.setFieldValue("BMLProductDeliveryType","PHY");
            //Display the request
            System.out.println("\nBML Auth Request:\n" + request.getXML());
        } catch (InitializationException ie) {
            System.err.println("Unable to initialize request object");
            System.err.println(ie.getMessage());
            ie.printStackTrace();
            System.exit(ERROR_EXIT);
        } catch (FieldNotFoundException fnfe) {
            System.err.println("Unable to find XML field in template");
            System.err.println(fnfe.getMessage());
            fnfe.printStackTrace();
            System.exit(ERROR_EXIT);
        } catch (Exception e) {
			e.printStackTrace();
			System.exit(ERROR_EXIT);
		}
        //Process the transaction
        //Pass in the request object (created above), and receive a response object.
        //If the resources required by the Transaction Processor have been exhausted,
        //this code will block until the resources become available.
        //The "TransactionProcessor.poolSize" configuration property specifies how many resources
        //will be available.  The TransactionProcessor acts as a governor, only allowing
        //up to "poolSize" transactions outstanding at any point in time.
        //As transactions are completed, their resources are placed back in the pool.
        ResponseIF response = null;
        try {
            response = tp.process(request);
        } catch (TransactionException tex) {
            System.err.println("Transaction failed, including retries and failover");
            System.err.println(tex.getMessage());
            tex.printStackTrace();
            System.exit(ERROR_EXIT);
        }
        //Display the response
        //This line displays the entire xml response on the java system console.
        System.out.println("\nResponse:\n" + response.toXmlString() + "\n");
        //The lines below report all the various attributes of the response object.
        //It is not necessary to use all of these attributes - use only the ones you need.
        //Also, some of the attributes are meaningful only for specific types of transactions,
        //but for consistency and simplicity in the sample code we dump them all for every transaction type.
        System.out.println("Response Attributes:");
        System.out.println("isGood=" + response.isGood());
        System.out.println("isError=" + response.isError());
        System.out.println("isQuickResponse=" + response.isQuickResponse());
        System.out.println("isApproved=" + response.isApproved());
        System.out.println("isDeclined=" + response.isDeclined());
        System.out.println("AuthCode=" + response.getAuthCode());
        System.out.println("TxRefNum=" + response.getTxRefNum());
        System.out.println("ResponseCode=" + response.getResponseCode());
        System.out.println("Status=" + response.getStatus());
        System.out.println("Message=" + response.getMessage());
        System.out.println("AVSCode=" + response.getAVSResponseCode());
        System.out.println("CVV2ResponseCode=" + response.getCVV2RespCode());
    }
}
