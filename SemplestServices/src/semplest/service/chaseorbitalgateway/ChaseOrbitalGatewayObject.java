package semplest.service.chaseorbitalgateway;

import org.apache.log4j.Logger;

import semplest.server.encryption.AESBouncyCastle;
import semplest.server.service.SemplestConfiguration;

import com.paymentech.orbital.sdk.interfaces.TransactionProcessorIF;
import com.paymentech.orbital.sdk.transactionProcessor.TransactionProcessor;
import com.paymentech.orbital.sdk.util.exceptions.InitializationException;

public class ChaseOrbitalGatewayObject extends Thread
{
	/*
	 * THESE NEED TO BE PUT INTO CONFIG DATABASE
	 */
	public static String SALEM_PLATFORM = (String) SemplestConfiguration.configData.get("OrbitalGatewaySalemPlatform"); //"000001";
	public static String MERCHANTID = (String) SemplestConfiguration.configData.get("OrbitalGatewayMerchantID"); //"041756";
	public static String ORBITAL_USERNAME = (String) SemplestConfiguration.configData.get("OrbitalGatewayUsername"); //"TSEMPLEST01";
	public static String ORBITAL_PASSWORD = (String) SemplestConfiguration.configData.get("OrbitalGatewayPassword"); //"01tsemplest";
	public static String key = (String) SemplestConfiguration.configData.get("SemplestEncryptionkey");
	public static String MerchantName = "SEMplest";
	public static final String ORDERIDSTRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	public static final int ORDERIDLENGTH = 22;
	
	
	private static final Logger logger = Logger.getLogger(ChaseOrbitalGatewayObject.class);
	private TransactionProcessorIF transactionProcessor = null;
	private AESBouncyCastle aes = null;
	private final Object object;

	public ChaseOrbitalGatewayObject(Object object)
	{
		this.object = object;
	}
	public void run()
	{
		try
		{
			aes = AESBouncyCastle.getInstance(key);
			transactionProcessor = new TransactionProcessor();
			
		}
		catch (InitializationException iex)
		{
			logger.error("TransactionProcessor failed to initialize " + iex.getMessage());
			iex.printStackTrace();
		}
		catch (Exception e)
		{
			logger.error("Exception in ChaseOrbitalGatewayObject " + e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized(object)
		{
			object.notify();
		}
	}

	public TransactionProcessorIF getTransactionProcessor()
	{
		return transactionProcessor;
	}

	public AESBouncyCastle getAes()
	{
		return aes;
	}

}
