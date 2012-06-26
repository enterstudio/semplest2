package semplest.service.google.adwords;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import semplest.server.protocol.adengine.TrafficEstimatorObject;
import semplest.server.service.SemplestConfiguration;

import com.google.api.adwords.v201109.cm.KeywordMatchType;



public class TestGoogleAdwords {

	private static final Logger logger = Logger.getLogger(TestGoogleAdwords.class);
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String accountID = "2188810777";
		try {
			
			
			
			ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("Service.xml");
			Object object = new Object();
			SemplestConfiguration configDB = new SemplestConfiguration(object);
			Thread configThread = new Thread(configDB);
			configThread.start();
			synchronized (object)
			{
				object.wait();
			}
			
			

			GoogleAdwordsServiceImpl client = new GoogleAdwordsServiceImpl();


			ArrayList<HashMap<String, String>> campaignsByAccountId = client.getCampaignsByAccountId(accountID, false);
			Long campaignID = new Long(campaignsByAccountId.get(0).get("Id"));
			System.out.println(campaignID);
			
			HashMap<String, Long> KeywordWithBid = new HashMap<String, Long>();
			
			
			FileInputStream fstream = new FileInputStream("C:/Users/ssom/Downloads/SummitHillsSuggestedKWs.txt");
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			
			HashMap<String,Long> kwVolumeMap = new HashMap<String,Long>();
			long maxVol = Long.MIN_VALUE;
			while ((strLine = br.readLine()) != null)   {
				//System.out.println (strLine);
				String [] fields = strLine.split(": ");
				//System.out.println(fields[0]);
				//System.out.println(fields[1]);
				kwVolumeMap.put(fields[0], Long.valueOf(fields[1]));
				KeywordWithBid.put(fields[0],5000000L);
				if(maxVol<Long.valueOf(fields[1])){
					maxVol=Long.valueOf(fields[1]);
				}
			}
			//Close the input stream
			in.close();
						
			
//			TrafficEstimatorObject o = client.getTrafficEstimationForKeywords(accountID, campaignID, KeywordMatchType.EXACT, KeywordWithBid);
			TrafficEstimatorObject o = client.getTrafficEstimationForKeywords(null, null, KeywordMatchType.EXACT, KeywordWithBid);

			String[] words = o.getListOfKeywords();
			int missing = 0;
			int obtained = 0;
			for (int i=0; i < words.length; i++)
			{
				HashMap<Long, TrafficEstimatorObject.BidData> points = o.getMapOfPoints(words[i],KeywordMatchType.EXACT.getValue());
				Iterator<Long> bidIT = points.keySet().iterator();
				while(bidIT.hasNext()) {
					Long abid= bidIT.next();
					if(points.get(abid).getMaxTotalDailyMicroCost()>0) {
						//System.out.println(words[i]+":: KWTool US Vol: "+kwVolumeMap.get(words[i])+", TE Max click at $5.00:"+points.get(abid).getMaxClickPerDay()
							//+", TE Max daily cost at $5.00:"+points.get(abid).getMaxTotalDailyMicroCost());
						if(kwVolumeMap.get(words[i])>1000){
							//System.out.println(words[i]+":: KWTool US Vol:"+kwVolumeMap.get(words[i])+": YES");//, Vol/Av Click ratio:"
//									+ kwVolumeMap.get(words[i]).doubleValue()/points.get(abid).getMaxClickPerDay());
							obtained++;
						}
					} else {
						if(kwVolumeMap.get(words[i])>1000){
							System.out.println(words[i]+":: KWTool US Vol:"+kwVolumeMap.get(words[i])+": NO");
							missing++;
						}
					}
				}
			}
			
			System.out.println("Obtained: "+obtained+", missing: "+missing);
			System.out.println("ratio: "+((double) missing)/(missing+obtained));
			System.out.println("Max vol: "+maxVol);
			

		} catch (Exception e) {
			logger.error("Problem", e);
		}
	}

}
