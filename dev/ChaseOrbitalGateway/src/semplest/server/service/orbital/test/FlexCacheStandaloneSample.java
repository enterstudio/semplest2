package semplest.server.service.orbital.test;
import com.paymentech.orbital.sdk.interfaces.RequestIF;
import com.paymentech.orbital.sdk.interfaces.ResponseIF;
import com.paymentech.orbital.sdk.interfaces.TransactionProcessorIF;
import com.paymentech.orbital.sdk.request.FieldNotFoundException;
import com.paymentech.orbital.sdk.request.Request;
import com.paymentech.orbital.sdk.transactionProcessor.TransactionException;
import com.paymentech.orbital.sdk.transactionProcessor.TransactionProcessor;
import com.paymentech.orbital.sdk.util.exceptions.InitializationException;

public class FlexCacheStandaloneSample {
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
            request = new Request(RequestIF.FLEX_CACHE_TRANSACTION);

            //Basic Auth Fields
            request.setFieldValue("MerchantID", "848481");
            request.setFieldValue("BIN", "000001");
            request.setFieldValue("OrderID", "122003SA");
            request.setFieldValue("AccountNum", "6035718888880650404");
            request.setFieldValue("Amount", "100");
            request.setFieldValue("FlexAction", "AUTH");
            //Additional Information
            request.setFieldValue("Comments", "Test FlexCache Standalone Request ");
            request.setFieldValue("ShippingRef", "FEDEX WB12345678 Pri 1");

            System.out.println("\nFlex Cache Standalone Request:\n" + request.getXML());
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
        } catch (Exception ex) {
        	ex.printStackTrace();
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
    }
}
