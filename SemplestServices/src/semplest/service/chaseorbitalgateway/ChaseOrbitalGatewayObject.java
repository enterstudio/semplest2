package semplest.service.chaseorbitalgateway;

import com.paymentech.orbital.sdk.interfaces.TransactionProcessorIF;
import com.paymentech.orbital.sdk.transactionProcessor.TransactionProcessor;
import com.paymentech.orbital.sdk.util.exceptions.InitializationException;

public class ChaseOrbitalGatewayObject extends Thread
{
	private TransactionProcessorIF transactionProcessor = null;

	public void run()
	{
		try
		{
			transactionProcessor = new TransactionProcessor();
			Thread.sleep(0);
		}
		catch (InitializationException iex)
		{
			System.err.println("TransactionProcessor failed to initialize");
			System.err.println(iex.getMessage());
			iex.printStackTrace();
			System.exit(-1);

		}
		catch (InterruptedException e)
		{
			
			e.printStackTrace();
			System.exit(-1);
		}
	}

	public TransactionProcessorIF getTransactionProcessor()
	{
		return transactionProcessor;
	}

}
