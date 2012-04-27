package semplest.server.service.orbital.test;
import com.paymentech.orbital.sdk.interfaces.RequestIF;
import com.paymentech.orbital.sdk.interfaces.ResponseIF;
import com.paymentech.orbital.sdk.interfaces.TransactionProcessorIF;
import com.paymentech.orbital.sdk.request.FieldNotFoundException;
import com.paymentech.orbital.sdk.request.Request;
import com.paymentech.orbital.sdk.transactionProcessor.TransactionException;
import com.paymentech.orbital.sdk.transactionProcessor.TransactionProcessor;
import com.paymentech.orbital.sdk.util.exceptions.InitializationException;

public class RefundSample {
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
    	//Create a request object
        //The request object uses the XML templates along with data we provide
        //to generate a String representation of the xml request
        RequestIF request = null;
        try {
            request = new Request(RequestIF.NEW_ORDER_TRANSACTION);
            
            request.setFieldValue("IndustryType", "EC");
            request.setFieldValue("MessageType", "R");            
            request.setFieldValue("MerchantID", "700000000413");
            request.setFieldValue("BIN", "000002");
            request.setFieldValue("AccountNum", "5191409037560100");
            request.setFieldValue("OrderID", "122003SAR");
            request.setFieldValue("Amount", "100");
            request.setFieldValue("Exp", "1209");
            request.setFieldValue("Comments", "This is a test Credit Card Refund");

            //Display the request
            System.out.println("\nRefund Request:\n" + request.getXML());
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
