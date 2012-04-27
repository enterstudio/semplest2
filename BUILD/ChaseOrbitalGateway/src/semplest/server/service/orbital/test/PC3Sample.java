package semplest.server.service.orbital.test;
import com.paymentech.orbital.sdk.interfaces.RequestIF;
import com.paymentech.orbital.sdk.interfaces.ResponseIF;
import com.paymentech.orbital.sdk.interfaces.TemplateIF;
import com.paymentech.orbital.sdk.interfaces.TransactionProcessorIF;
import com.paymentech.orbital.sdk.request.FieldNotFoundException;
import com.paymentech.orbital.sdk.request.Request;
import com.paymentech.orbital.sdk.transactionProcessor.TransactionException;
import com.paymentech.orbital.sdk.transactionProcessor.TransactionProcessor;
import com.paymentech.orbital.sdk.util.exceptions.InitializationException;

public class PC3Sample {
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
            request = new Request (RequestIF.NEW_ORDER_TRANSACTION);
            
            //Basic Information
            request.setFieldValue("IndustryType", "EC");
            request.setFieldValue("MessageType", "A");
            request.setFieldValue("MerchantID", "041756");
            request.setFieldValue("BIN", "000001");
            request.setFieldValue("OrderID", "122003SA");
            request.setFieldValue("AccountNum", "5191409037560100");
            request.setFieldValue("Amount", "25000");
            request.setFieldValue("Exp", "1209");
            //AVS Information
            request.setFieldValue("AVSname", "Jon Smith");
            request.setFieldValue("AVSaddress1", "4200 W Cypress St");
            request.setFieldValue("AVScity", "Tampa");
            request.setFieldValue("AVSstate", "FL");
            request.setFieldValue("AVSzip", "33607");
            //Common Optional
            request.setFieldValue("Comments", "This is Java SDK");
            request.setFieldValue("ShippingRef", "FEDEX WB12345678 Pri 1");
            
            // PC 2 Data
            request.setFieldValue("TaxInd", "1");
            request.setFieldValue("Tax", "100");
            request.setFieldValue("PCOrderNum", "PO8347465");
            request.setFieldValue("PCDestZip", "33607");
            request.setFieldValue("PCDestName", "Terry");
            request.setFieldValue("PCDestAddress1", "88301 Teak Street");
            request.setFieldValue("PCDestAddress2", "Apt 5");
            request.setFieldValue("PCDestCity", "Hudson");
            request.setFieldValue("PCDestState", "FL");            
            
            // add the PC3 data
            TemplateIF pc3Root = request.getComplexRoot(RequestIF.PC3_CORE);
            
            // add data to the top level PC3 element
            pc3Root.setFieldValue("PC3FreightAmt", "10");
            pc3Root.setFieldValue("PC3DutyAmt", "10");
            pc3Root.setFieldValue("PC3DestCountryCd", "USA");
            pc3Root.setFieldValue("PC3ShipFromZip", "34667");
            pc3Root.setFieldValue("PC3DiscAmt", "5");
            pc3Root.setFieldValue("PC3VATtaxAmt", "5");
            pc3Root.setFieldValue("PC3VATtaxRate", "2");
            pc3Root.setFieldValue("PC3AltTaxInd", "1");
            pc3Root.setFieldValue("PC3AltTaxAmt", "5");          
            
            // add 5 line items (recursive elements)
            TemplateIF lineItem = null;
            
            for (int i = 0; i < 5; i++) {
            	lineItem = pc3Root.getRecursiveElement(RequestIF.PC3_LINE_ITEMS);
            	
            	// fill the line item with data
            	lineItem.setFieldValue("PC3DtlDesc", "1234567890123456789");
            	lineItem.setFieldValue("PC3DtlProdCd", "123456789");
            	lineItem.setFieldValue("PC3DtlQty", "1");
            	lineItem.setFieldValue("PC3DtlUOM", "LBR");
				lineItem.setFieldValue("PC3DtlTaxAmt", "0");
				lineItem.setFieldValue("PC3DtlTaxRate", "0");
				lineItem.setFieldValue("PC3Dtllinetot", "50");
				lineItem.setFieldValue("PC3DtlDisc", "0");
				lineItem.setFieldValue("PC3DtlCommCd", "3");
				lineItem.setFieldValue("PC3DtlUnitCost", "5");
				lineItem.setFieldValue("PC3DtlGrossNet", "Y");
				lineItem.setFieldValue("PC3DtlTaxType", "Y");
				lineItem.setFieldValue("PC3DtlDiscInd", "Y");
				lineItem.setFieldValue("PC3DtlDebitInd", "D");
            }

            //Display the request
            System.out.println("\nPC3 Request:\n" + request.getXML());
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
