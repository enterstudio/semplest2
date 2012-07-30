package semplest.service.google.adwords;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import semplest.server.protocol.adengine.ReportObject;

/**
 * * Helper class to download the specified reportDefinition XML to a temporary
 * * file. * * @author api.kwinter@gmail.com (Kevin Winter)
 */
// No charge for reports
public class GoogleReportDownloader
{
	private static SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
	private static final int BUF_SIZE = 0x1000;
	// Customer ID to download.
	private final long accountID;
	// String containing the Report Definition XML to download.
	private final String reportDefinitionXml;

	/**
	 * * Creates a ReportDownloader object for the specified report and customer
	 * id. * * @param reportDefinitionXml XML for the report to download. * @param
	 * cid Customer ID to download it for.
	 */
	public GoogleReportDownloader(String reportDefinitionXml, long accountID)
	{
		this.accountID = accountID;
		this.reportDefinitionXml = reportDefinitionXml;
	}

	/**
	 * * Creates a temporary file for storing the results of the report (assumes
	 * * CSV). * * @return {@link File} Object referencing the written file. * @throws
	 * IOException
	 */
	private File createTempFile() throws IOException
	{
		return File.createTempFile("reportDownload-" + this.accountID + "-", ".report");
	}
	
	
	public ArrayList<ReportObject> getSearchQueryReportObject(String authToken, String developerToken) throws Exception
	{
		try{
			
			HttpURLConnection conn = (HttpURLConnection) new URL("https://adwords.google.com/api/adwords/reportdownload/v201109").openConnection();
			conn.setDoOutput(true); // You will need to

			conn.setRequestProperty("clientCustomerId", Long.toString(accountID)); //
			// The AuthToken must be specified as a request header.
			conn.setRequestProperty("Authorization", "GoogleLogin auth=" + authToken);
			conn.setRequestProperty("developerToken", developerToken);
			conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
			conn.setRequestMethod("POST");
			conn.setRequestProperty("returnMoneyInMicros", "true");
			OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream()); 
			
			writer.write("__rdxml=" + URLEncoder.encode(reportDefinitionXml, "UTF-8"));
			writer.close();
			int response = conn.getResponseCode();
			
			if (response == HttpURLConnection.HTTP_OK)
			{
				//read in report data
				ArrayList<String> lines = new ArrayList<String>();
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String strLine;
				while ((strLine = br.readLine()) != null)   {
					lines.add(strLine);
				}
				
				//the first 2 lines are header, and the last line is conclusion. throw them.
				ArrayList<ReportObject> reportObjectList = new ArrayList<ReportObject>();
				for (int i = 2; i < lines.size()-1; i++){
					
					String[] data = lines.get(i).split(",");
					
					ReportObject rdata = new ReportObject();
					
					//parse the data to ReportObject	
					rdata.setAccountID(accountID);
					rdata.setCampaignID(Long.valueOf(data[9]));
					rdata.setSearchTerm(data[2]);
					
					/*
					String maxCpcStr = data[14];
					if(maxCpcStr.equals(" --"))
						maxCpcStr = "0";
					rdata.setMicroBidAmount(Long.valueOf(maxCpcStr));
					*/
					rdata.setBidMatchType(data[3]);
					rdata.setNumberImpressions(Integer.valueOf(data[4]));
					rdata.setNumberClick(Integer.valueOf(data[5]));
					rdata.setAveragePosition(Float.valueOf(data[8]));
					rdata.setAverageCPC(Long.valueOf(data[7]));
					// rdata.setQualityScore(Integer.valueOf(data[8]));
					// rdata.setApprovalStatus(data[15]);
					// rdata.setFirstPageCPC(Integer.valueOf(data[13]));
					rdata.setMicroCost(Long.valueOf(data[6]));
					//yyyy-mm-dd
					rdata.setTransactionDate(dateFormatter.parse(data[0]));
					//google report doesn't have a created date. so the current date is used here.
					rdata.setCreatedDate(new Date());
					
					reportObjectList.add(rdata);
				}
				
				return reportObjectList;
			}
			else
			{
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				BufferedOutputStream output = new BufferedOutputStream(baos);
				copy(conn.getErrorStream(), output);
				output.close();
				throw new HttpException(response, baos.toString());
			}
		}
		catch(HttpException e){
			throw new Exception(e.getMessage());
		}
		catch(MalformedURLException e){
			throw new Exception(e.getMessage());
		}
		catch(IOException e){
			throw new Exception(e);
		}
		
	}
	
	
	
	public ArrayList<ReportObject> getReportObject(String authToken, String developerToken) throws Exception
	{
		try{
			
			HttpURLConnection conn = (HttpURLConnection) new URL("https://adwords.google.com/api/adwords/reportdownload/v201109").openConnection();
			conn.setDoOutput(true); // You will need to

			conn.setRequestProperty("clientCustomerId", Long.toString(accountID)); //
			// The AuthToken must be specified as a request header.
			conn.setRequestProperty("Authorization", "GoogleLogin auth=" + authToken);
			conn.setRequestProperty("developerToken", developerToken);
			conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
			conn.setRequestMethod("POST");
			conn.setRequestProperty("returnMoneyInMicros", "true");
			OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream()); 
			
			writer.write("__rdxml=" + URLEncoder.encode(reportDefinitionXml, "UTF-8"));
			writer.close();
			int response = conn.getResponseCode();
			
			if (response == HttpURLConnection.HTTP_OK)
			{
				//read in report data
				ArrayList<String> lines = new ArrayList<String>();
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String strLine;
				while ((strLine = br.readLine()) != null)   {
					lines.add(strLine);
				}
				
				//the first 2 lines are header, and the last line is conclusion. throw them.
				ArrayList<ReportObject> reportObjectList = new ArrayList<ReportObject>();
				for (int i = 2; i < lines.size()-1; i++){
					
					
					String[] data = lines.get(i).split(",");
					
					ReportObject rdata = new ReportObject();
					
					//parse the data to ReportObject	
					//THE COLUMN POSITION OF DATA HEAVILY DEPENDS ON THE FIELDS CHOSEN FOR THE REPORT IN THE XML
					rdata.setAccountID(accountID);
					rdata.setCampaignID(Long.valueOf(data[11]));
					rdata.setKeyword(data[3]);
					String maxCpcStr = data[14];
					if(maxCpcStr.equals(" --"))
						maxCpcStr = "0";
					rdata.setMicroBidAmount(Long.valueOf(maxCpcStr));
					rdata.setBidMatchType(data[4]);
					rdata.setNumberImpressions(Integer.valueOf(data[5]));
					rdata.setNumberClick(Integer.valueOf(data[6]));
					rdata.setAveragePosition(Float.valueOf(data[10]));
					rdata.setAverageCPC(Long.valueOf(data[9]));
					rdata.setQualityScore(Integer.valueOf(data[8]));
					rdata.setApprovalStatus(data[15]);
					rdata.setFirstPageCPC(Long.valueOf(data[13]));
					rdata.setMicroCost(Long.valueOf(data[7]));
					rdata.setAdGroupID(Long.valueOf(data[1]));
					//rdata.setKeywordID(Long.valueOf(data[2]));


					//yyyy-mm-dd
					rdata.setTransactionDate(dateFormatter.parse(data[0]));
					//google report doesn't have a created date. so the current date is used here.
					rdata.setCreatedDate(new Date());
					
					reportObjectList.add(rdata);
				}
				
				return reportObjectList;
			}
			else
			{
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				BufferedOutputStream output = new BufferedOutputStream(baos);
				copy(conn.getErrorStream(), output);
				output.close();
				throw new HttpException(response, baos.toString());
			}
		}
		catch(HttpException e){
			throw new Exception(e.getMessage());
		}
		catch(MalformedURLException e){
			throw new Exception(e.getMessage());
		}
		catch(IOException e){
			throw new Exception(e);
		}
		
	}

	/**
	 * * Downloads the report for the customer to a temporary file using the new
	 * * report download feature. * * @param authToken AuthToken for the MCC
	 * that manages the CustomerId * @param developerToken Developer token. * @return
	 * File object representing downloaded report if successful, otherwise *
	 * null if the HTTP request fails. * @throws IOException * @throws
	 * MalformedURLException
	 */
	public File downloadReport(String authToken, String developerToken) throws HttpException, MalformedURLException, IOException
	{ // The new report download feature uses a similar download url to the old
		// // one, but is now versioned.
		HttpURLConnection conn = (HttpURLConnection) new URL("https://adwords.google.com/api/adwords/reportdownload/v201109").openConnection();
		conn.setDoOutput(true); // You will need to
		// specify a clientCustomerId header - clientEmail will not // be
		// supported in future versions of the API.
		conn.setRequestProperty("clientCustomerId", Long.toString(accountID)); //
		// The AuthToken must be specified as a request header.
		conn.setRequestProperty("Authorization", "GoogleLogin auth=" + authToken);
		conn.setRequestProperty("developerToken", developerToken);
		conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
		conn.setRequestMethod("POST");
		conn.setRequestProperty("returnMoneyInMicros", "true");
		OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream()); // The
																					// report
																					// definition
		// XML must be passed as a parameter with name // __rdxml. You can
		// choose to GET or POST with content type of //
		// 'application/x-www-form-urlencoded'. Be aware that GET requests
		// should // not exceed 2000 characters in the URI after url encoding.
		writer.write("__rdxml=" + URLEncoder.encode(reportDefinitionXml, "UTF-8"));
		writer.close();
		int response = conn.getResponseCode(); //
		// Note that as of the date this code was written, the report download
		// code will still return 200 OK even if there was a problem running
		// the // report, such as invalid Report Definition XML or the wrong
		// type of report
		// for the specified clientId.
		if (response == HttpURLConnection.HTTP_OK)
		{
			File f = createTempFile();
			BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(f));
			copy(conn.getInputStream(), output);
			output.close();
			return f;
		}
		else
		{
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			BufferedOutputStream output = new BufferedOutputStream(baos);
			copy(conn.getErrorStream(), output);
			output.close();
			throw new HttpException(response, baos.toString());
		}
	}

	/**
	 * * Static helper method that copys bytes from the inputstream to // the *
	 * outputstream. * * @param from Stream to copy from. * @param to // Stream
	 * to copy to. * @throws IOException
	 */
	private static void copy(InputStream from, OutputStream to) throws IOException
	{
		byte[] buf = new byte[BUF_SIZE];
		int r;
		while ((r = from.read(buf)) != -1)
		{
			to.write(buf, 0, r);
		}
	}

	/**
	 * * Encapsulates an unsuccessful report // download.
	 */
	public static class HttpException extends Exception
	{
		private final int code;
		private final String message;

		public HttpException(int code, String message)
		{
			this.code = code;
			this.message = message;
		}

		/** * @return the code */
		public int getCode()
		{
			return code;
		}

		/** * @return the message */
		public String getMessage()
		{
			return message;
		}
	}
}
