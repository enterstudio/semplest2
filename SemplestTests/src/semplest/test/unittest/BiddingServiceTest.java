package semplest.test.unittest;

import semplest.services.client.api.SemplestBiddingServiceClient;

public class BiddingServiceTest
{

	private int errorCounter = 0;

	public int Test_BiddingService_Client()
	{
		errorCounter = 0;

		System.out.println("####################################################################################");
		System.out.println("#                                                                                  #");
		System.out.println("#                          Bidding Service (Client) Test                           #");
		System.out.println("#                                                                                  #");
		System.out.println("####################################################################################");

		try
		{
			SemplestBiddingServiceClient client = new SemplestBiddingServiceClient(null, null);

			try
			{
				System.out.println("------------------------------------------------------------");
				System.out.println("GetMonthlyBudgetPercentPerSE:");

				System.out.println("service not ready yet");

			}
			catch (Exception e)
			{
				errorHandler(e);
			}

			try
			{
				System.out.println("------------------------------------------------------------");
				System.out.println("getInitialValues:");

				System.out.println("service not ready yet");

			}
			catch (Exception e)
			{
				errorHandler(e);
			}

			try
			{
				System.out.println("------------------------------------------------------------");
				System.out.println("setBidsInitial:");

				System.out.println("service not ready yet");

			}
			catch (Exception e)
			{
				errorHandler(e);
			}

			try
			{
				System.out.println("------------------------------------------------------------");
				System.out.println("setBidsUpdate:");

				System.out.println("service not ready yet");

			}
			catch (Exception e)
			{
				errorHandler(e);
			}

			try
			{
				System.out.println("------------------------------------------------------------");
				System.out.println("getBid:");

				System.out.println("service not ready yet");

			}
			catch (Exception e)
			{
				errorHandler(e);
			}

			try
			{
				System.out.println("------------------------------------------------------------");
				System.out.println("getBidsInitial:");

				System.out.println("service not ready yet");

			}
			catch (Exception e)
			{
				errorHandler(e);
			}

			try
			{
				System.out.println("------------------------------------------------------------");
				System.out.println("getBidsInitialNaive:");

				System.out.println("service not ready yet");

			}
			catch (Exception e)
			{
				errorHandler(e);
			}

			try
			{
				System.out.println("------------------------------------------------------------");
				System.out.println("getBidsUpdate:");

				System.out.println("service not ready yet");

			}
			catch (Exception e)
			{
				errorHandler(e);
			}

			try
			{
				System.out.println("------------------------------------------------------------");
				System.out.println("getBidsUpdateNaive:");

				System.out.println("service not ready yet");

			}
			catch (Exception e)
			{
				errorHandler(e);
			}

		}
		catch (Exception e)
		{
			errorHandler(e);
		}

		if (errorCounter > 0)
		{
			System.out.println(" ");
			System.out.println("####################################################################################");
			System.out.println("#                      Bidding Service (Client) Test FAILED!                       #");
			System.out.println("####################################################################################");
		}
		else
		{
			System.out.println(" ");
			System.out.println("####################################################################################");
			System.out.println("#                      Bidding Service (Client) Test PASSED!                       #");
			System.out.println("####################################################################################");
		}

		return errorCounter;
	}

	private void errorHandler(Exception e)
	{
		e.printStackTrace();
		System.out.println("////////////////////////////////////////////////////");
		System.out.println("ERROR:");
		System.out.println(e.getMessage());
		StackTraceElement[] ste = e.getStackTrace();
		for (StackTraceElement s : ste)
		{
			System.out.println(s.getClassName() + ": " + s.getMethodName() + ": " + s.getLineNumber());
		}
		System.out.println();
		System.out.println("");
		System.out.println("////////////////////////////////////////////////////");

		errorCounter++;
	}
}
