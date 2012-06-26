package semplest.analysis.reports.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import semplest.server.protocol.adengine.ReportObject;

public class createReportsOverTime {

	/**
	 * Store data aggrupated by match Type and keyword
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String matchType = "Broad";
		String[] dates = {"20120525" , "20120526" ,"20120527" , "20120528" , "20120529" , "20120531",
				 "20120601", "20120602" , "20120603", "20120604" ,"20120605" ,"20120606" , "20120607" ,
				 "20120608" , "20120609", "20120610", "20120611" ,"20120612" , "20120613" ,"20120614"  , 
				 "20120615"  , "20120616" ,"20120617" ,"20120618", "20120619" ,"20120620"};
		String basePath = "/semplest/data/dailyReportObjects/PiperHallTest/";
		PrintStream stdout = System.out;
		PrintStream outMSN = new PrintStream(new FileOutputStream("/semplest/data/dailyReportObjects/PiperHallTest/MSNdailyPerOverlapKw.csv"));
		PrintStream outGoogle = new PrintStream(new FileOutputStream("/semplest/data/dailyReportObjects/PiperHallTest/GoogledailyOverlapPerKw.csv"));
		
		//Loading msn Data
		ReportObject[] repArrayMSN = loadAndMergeReports(dates, basePath, "_MSNReport.robj");
		//Loading google Data
		ReportObject[] repArrayGoogle = loadAndMergeReports(dates, basePath, "_GoogleReport.robj");

		
		//Get Total report grouped by keyword
		HashMap<String, ArrayList<ReportObject>> mapReportMSNTotal = ReportUtils.groupReportPerMatchType(repArrayMSN, matchType);
		HashMap<String, ArrayList<ReportObject>> mapReportGoogleTotal = ReportUtils.groupReportPerMatchType(repArrayGoogle, matchType);
		
		//Get Reports grouped by date
		HashMap<String, ArrayList<ReportObject>> mapReportMSNDaily = ReportUtils.groupReportPerDate(repArrayMSN);
		HashMap<String, ArrayList<ReportObject>> mapReportGoogleDaily = ReportUtils.groupReportPerDate(repArrayGoogle);
		
		//Get Reports grouped by keyword and date
		HashMap<String,HashMap<String, ArrayList<ReportObject>>> mapReportMSNDailybyKw = 
				ReportUtils.groupReportPerDateAndKeyword(mapReportMSNDaily, matchType);
		HashMap<String,HashMap<String, ArrayList<ReportObject>>> mapReportGoogleDailybyKw = 
				ReportUtils.groupReportPerDateAndKeyword(mapReportGoogleDaily, matchType);
		
		
		//****************** Analysis **************************************************
		
		// General comparison	
		ArrayList<String> totalOverlapKwWithImp = new ArrayList<String>();
		ArrayList<String>  totalOverlapKwWithClicks = new ArrayList<String>();
		ArrayList<String> kwWithClicksMSN = new ArrayList<String>();
		ArrayList<String> kwWithClicksGoogle = new ArrayList<String>();
		stdout.println("General Google Report");
		kwWithClicksMSN = createGeneralReport(mapReportMSNTotal, stdout);
		stdout.println("General MSN Report");
		kwWithClicksGoogle = createGeneralReport(mapReportGoogleTotal, stdout);
		
	
		Set<String> keySet = mapReportMSNTotal.keySet();
		stdout.println("Overlap Keywords with Impressions,");
		for(String kw : keySet){
			if(mapReportGoogleTotal.containsKey(kw))
				totalOverlapKwWithImp.add(kw);
				stdout.print(kw+", ");
		}
		stdout.println("\nSize: "+ totalOverlapKwWithImp.size());
		
		stdout.print("\n");
		stdout.println("Overlap Keywords with Clicks");
		stdout.println("Size: "+ totalOverlapKwWithImp.size());
		for(String kw : kwWithClicksMSN){
			if(kwWithClicksGoogle.contains(kw)){
				totalOverlapKwWithClicks.add(kw);
				stdout.print(kw+", ");
			}
		}
		stdout.println("\nSize: "+ totalOverlapKwWithClicks.size());
		
		//MSN daily Reports
		//String [] keywords2 = keySet.toArray(new String[keySet.size()]); 
		String [] keywords2 = totalOverlapKwWithImp.toArray(new String[totalOverlapKwWithImp.size()]); 
		createDailyReportPerKwQS(mapReportMSNDailybyKw, keywords2 , outMSN);
		createDailyReportPerKwClicks(mapReportMSNDailybyKw, keywords2 , outMSN);
		createDailyReportPerKwCPC(mapReportMSNDailybyKw, keywords2 , outMSN);
		createDailyReportPerKwPosition(mapReportMSNDailybyKw, keywords2 , outMSN);
		createDailyReportPerKwImpressions(mapReportMSNDailybyKw, keywords2 , outMSN);
		createDailyReportPerKwFPCPC(mapReportMSNDailybyKw, keywords2 , outMSN);
		
		createBidEstimReportPerKwQS(mapReportMSNDailybyKw, keywords2 , outMSN);
		createBidEstimReportPerKwClicks(mapReportMSNDailybyKw, keywords2 , outMSN);
		createBidEstimReportPerKwCPC(mapReportMSNDailybyKw, keywords2 , outMSN);
		createBidEstimReportPerKwPosition(mapReportMSNDailybyKw, keywords2 , outMSN);
		createBidEstimReportPerKwImpressions(mapReportMSNDailybyKw, keywords2 , outMSN);
		createBidEstimReportPerKwFPCPC(mapReportMSNDailybyKw, keywords2 , outMSN);
		
		//Google daily Reports
		keySet = mapReportGoogleTotal.keySet();
		//keywords2 = keySet.toArray(new String[keySet.size()]); 
		createDailyReportPerKwQS(mapReportGoogleDailybyKw, keywords2 , outGoogle);
		createDailyReportPerKwClicks(mapReportGoogleDailybyKw, keywords2 , outGoogle);
		createDailyReportPerKwCPC(mapReportGoogleDailybyKw, keywords2 , outGoogle);
		createDailyReportPerKwPosition(mapReportGoogleDailybyKw, keywords2 , outGoogle);
		createDailyReportPerKwImpressions(mapReportGoogleDailybyKw, keywords2 , outGoogle);
		createDailyReportPerKwFPCPC(mapReportGoogleDailybyKw, keywords2 , outGoogle);
		
		createBidEstimReportPerKwQS(mapReportGoogleDailybyKw, keywords2 , outGoogle);
		createBidEstimReportPerKwClicks(mapReportGoogleDailybyKw, keywords2 , outGoogle);
		createBidEstimReportPerKwCPC(mapReportGoogleDailybyKw, keywords2 , outGoogle);
		createBidEstimReportPerKwPosition(mapReportGoogleDailybyKw, keywords2 , outGoogle);
		createBidEstimReportPerKwImpressions(mapReportGoogleDailybyKw, keywords2 , outGoogle);
		createBidEstimReportPerKwFPCPC(mapReportGoogleDailybyKw, keywords2 , outGoogle);
		
		
		
	}
	
	
	private static void createBidEstimReportPerKwQS(HashMap<String,HashMap<String, ArrayList<ReportObject>>> mapReportDailybyKw, 
			String[] keywords , PrintStream stdout) throws Exception{
		stdout.println("Bid vs Avg daily Quality Score");
		Set<String> dates = mapReportDailybyKw.keySet();
		String[] datesS = dates.toArray(new String[dates.size()]);
		Arrays.sort(datesS);
		
		HashMap<String,HashMap<Long, ArrayList<Double>>> mapEstBidPerKw = new  HashMap<String,HashMap<Long,ArrayList<Double>>>();
		ArrayList<Long> bids = new ArrayList<Long>();
		for(String date : datesS){
			HashMap<String, ArrayList<ReportObject>> mapKw = mapReportDailybyKw.get(date);
			for(String kw : keywords){
				ArrayList<ReportObject> rep =mapKw.get(kw);
				HashMap<Long, ArrayList<Double>> mapEstBid = mapEstBidPerKw.get(kw);
				if(mapEstBid== null){
					mapEstBid = new HashMap<Long, ArrayList<Double>>();
				}
				if(rep != null){
					if(rep.size()>1)
						throw new Exception("More than one report");
					if(!bids.contains(rep.get(0).getMicroBidAmount()))
						bids.add(rep.get(0).getMicroBidAmount());
					if(mapEstBid.containsKey(rep.get(0).getMicroBidAmount())){
						mapEstBid.get(rep.get(0).getMicroBidAmount()).add((rep.get(0).getQualityScore()== null)? null : new Double(rep.get(0).getQualityScore()));
					}else{
						ArrayList<Double> aux = new ArrayList<Double>();
						aux.add(new Double((rep.get(0).getQualityScore()== null)? null : new Double(rep.get(0).getQualityScore())));
						mapEstBid.put(rep.get(0).getMicroBidAmount(), aux);
					}
				}
				mapEstBidPerKw.put(kw, mapEstBid);
			}
		}
		
		stdout.print("Bid, ");
		for(String kw : keywords){
			stdout.print(kw+", ");
		}
		stdout.print("\n");
		
		
		Long[] sortedBids = bids.toArray(new Long[bids.size()]);
		Arrays.sort(sortedBids);
		for(Long bid : sortedBids){
			stdout.print(bid+", ");
			for(String kw : keywords){
				HashMap<Long, ArrayList<Double>> mapEstBid = mapEstBidPerKw.get(kw);
				if(mapEstBid!=null && mapEstBid.get(bid) != null){
					stdout.print(ReportUtils.average(mapEstBid.get(bid))+", ");
				} else {
					stdout.print("-1.0, ");
				}
			}
			stdout.print("\n");
		}
		
	}
	
	private static void createBidEstimReportPerKwClicks(HashMap<String,HashMap<String, ArrayList<ReportObject>>> mapReportDailybyKw, 
			String[] keywords , PrintStream stdout) throws Exception{
		stdout.println("Bid vs Avg daily Clicks");
		Set<String> dates = mapReportDailybyKw.keySet();
		String[] datesS = dates.toArray(new String[dates.size()]);
		Arrays.sort(datesS);
		
		HashMap<String,HashMap<Long, ArrayList<Double>>> mapEstBidPerKw = new  HashMap<String,HashMap<Long,ArrayList<Double>>>();
		ArrayList<Long> bids = new ArrayList<Long>();
		for(String date : datesS){
			HashMap<String, ArrayList<ReportObject>> mapKw = mapReportDailybyKw.get(date);
			for(String kw : keywords){
				ArrayList<ReportObject> rep =mapKw.get(kw);
				HashMap<Long, ArrayList<Double>> mapEstBid = mapEstBidPerKw.get(kw);
				if(mapEstBid== null){
					mapEstBid = new HashMap<Long, ArrayList<Double>>();
				}
				if(rep != null){
					if(rep.size()>1)
						throw new Exception("More than one report");
					if(!bids.contains(rep.get(0).getMicroBidAmount()))
						bids.add(rep.get(0).getMicroBidAmount());
					if(mapEstBid.containsKey(rep.get(0).getMicroBidAmount())){
						mapEstBid.get(rep.get(0).getMicroBidAmount()).add((rep.get(0).getNumberClick()== null)? null : new Double(rep.get(0).getNumberClick()));
					}else{
						ArrayList<Double> aux = new ArrayList<Double>();
						aux.add(new Double((rep.get(0).getNumberClick()== null)? null : new Double(rep.get(0).getNumberClick())));
						mapEstBid.put(rep.get(0).getMicroBidAmount(), aux);
					}
				}
				mapEstBidPerKw.put(kw, mapEstBid);
			}
		}
		
		ArrayList<Long> bidPerDay = new ArrayList<Long>();
		for(String date : datesS){
			HashMap<String, ArrayList<ReportObject>> mapKw = mapReportDailybyKw.get(date);
			for(String kw : keywords){
				ArrayList<ReportObject> rep =mapKw.get(kw);
				if(rep!=null && rep.get(0).getMicroBidAmount()!=null){
					bidPerDay.add(rep.get(0).getMicroBidAmount());
					break;
				}
			}
		}
		
		stdout.print("Bid, ");
		for(String kw : keywords){
			stdout.print(kw+", ");
		}
		stdout.print("\n");
		
		
		Long[] sortedBids = bids.toArray(new Long[bids.size()]);
		Arrays.sort(sortedBids);
		for(Long bid : sortedBids){
			stdout.print(bid+", ");
			for(String kw : keywords){
				HashMap<Long, ArrayList<Double>> mapEstBid = mapEstBidPerKw.get(kw);
				if(mapEstBid!=null && mapEstBid.get(bid) != null){
					stdout.print(dailyAveragePerBid(mapEstBid.get(bid), bid, bidPerDay)+", ");
				} else {
					stdout.print("0.0, ");
				}
			}
			stdout.print("\n");
		}
		
	}
	
	private static double dailyAveragePerBid(ArrayList<Double> array , Long refBid, ArrayList<Long> bidPerDay ){
		
		int count =0;
		for(Long bid : bidPerDay){
			if(bid.equals(refBid))
				count++;
		}
		
		double sum = 0.0;
		
		for(Double elem : array){
			if(elem!=null){
				sum = sum+elem;
			
			}
			
		}
		return (count == 0)? -1.0 : sum/count; 
	}
	private static void createBidEstimReportPerKwCPC(HashMap<String,HashMap<String, ArrayList<ReportObject>>> mapReportDailybyKw, 
			String[] keywords , PrintStream stdout) throws Exception{
		stdout.println("Bid vs Avg daily CPC");
		Set<String> dates = mapReportDailybyKw.keySet();
		String[] datesS = dates.toArray(new String[dates.size()]);
		Arrays.sort(datesS);
		
		HashMap<String,HashMap<Long, ArrayList<Double>>> mapEstBidPerKw = new  HashMap<String,HashMap<Long,ArrayList<Double>>>();
		ArrayList<Long> bids = new ArrayList<Long>();
		for(String date : datesS){
			HashMap<String, ArrayList<ReportObject>> mapKw = mapReportDailybyKw.get(date);
			for(String kw : keywords){
				ArrayList<ReportObject> rep =mapKw.get(kw);
				HashMap<Long, ArrayList<Double>> mapEstBid = mapEstBidPerKw.get(kw);
				if(mapEstBid== null){
					mapEstBid = new HashMap<Long, ArrayList<Double>>();
				}
				if(rep != null){
					if(rep.size()>1)
						throw new Exception("More than one report");
					if(!bids.contains(rep.get(0).getMicroBidAmount()))
						bids.add(rep.get(0).getMicroBidAmount());
					if(mapEstBid.containsKey(rep.get(0).getMicroBidAmount())){
						mapEstBid.get(rep.get(0).getMicroBidAmount()).add((rep.get(0).getAverageCPC()== null)? null : new Double(rep.get(0).getAverageCPC()));
					}else{
						ArrayList<Double> aux = new ArrayList<Double>();
						aux.add(new Double((rep.get(0).getAverageCPC()== null)? null : new Double(rep.get(0).getAverageCPC())));
						mapEstBid.put(rep.get(0).getMicroBidAmount(), aux);
					}
				}
				mapEstBidPerKw.put(kw, mapEstBid);
			}
		}
		
		stdout.print("Bid, ");
		for(String kw : keywords){
			stdout.print(kw+", ");
		}
		stdout.print("\n");
		
		
		Long[] sortedBids = bids.toArray(new Long[bids.size()]);
		Arrays.sort(sortedBids);
		for(Long bid : sortedBids){
			stdout.print(bid+", ");
			for(String kw : keywords){
				HashMap<Long, ArrayList<Double>> mapEstBid = mapEstBidPerKw.get(kw);
				if(mapEstBid!=null && mapEstBid.get(bid) != null){
					stdout.print(ReportUtils.average(mapEstBid.get(bid))+", ");
				} else {
					stdout.print("-1.0, ");
				}
			}
			stdout.print("\n");
		}
		
	}
	
	private static void createBidEstimReportPerKwPosition(HashMap<String,HashMap<String, ArrayList<ReportObject>>> mapReportDailybyKw, 
			String[] keywords , PrintStream stdout) throws Exception{
		stdout.println("Bid vs Avg daily Position");
		Set<String> dates = mapReportDailybyKw.keySet();
		String[] datesS = dates.toArray(new String[dates.size()]);
		Arrays.sort(datesS);
		
		HashMap<String,HashMap<Long, ArrayList<Double>>> mapEstBidPerKw = new  HashMap<String,HashMap<Long,ArrayList<Double>>>();
		ArrayList<Long> bids = new ArrayList<Long>();
		for(String date : datesS){
			HashMap<String, ArrayList<ReportObject>> mapKw = mapReportDailybyKw.get(date);
			for(String kw : keywords){
				ArrayList<ReportObject> rep =mapKw.get(kw);
				HashMap<Long, ArrayList<Double>> mapEstBid = mapEstBidPerKw.get(kw);
				if(mapEstBid== null){
					mapEstBid = new HashMap<Long, ArrayList<Double>>();
				}
				if(rep != null){
					if(rep.size()>1)
						throw new Exception("More than one report");
					if(!bids.contains(rep.get(0).getMicroBidAmount()))
						bids.add(rep.get(0).getMicroBidAmount());
					if(mapEstBid.containsKey(rep.get(0).getMicroBidAmount())){
						mapEstBid.get(rep.get(0).getMicroBidAmount()).add((rep.get(0).getAveragePosition()== null)? null : new Double(rep.get(0).getAveragePosition()));
					}else{
						ArrayList<Double> aux = new ArrayList<Double>();
						aux.add(new Double((rep.get(0).getAveragePosition()== null)? null : new Double(rep.get(0).getAveragePosition())));
						mapEstBid.put(rep.get(0).getMicroBidAmount(), aux);
					}
				}
				mapEstBidPerKw.put(kw, mapEstBid);
			}
		}
		
		stdout.print("Bid, ");
		for(String kw : keywords){
			stdout.print(kw+", ");
		}
		stdout.print("\n");
		
		
		Long[] sortedBids = bids.toArray(new Long[bids.size()]);
		Arrays.sort(sortedBids);
		for(Long bid : sortedBids){
			stdout.print(bid+", ");
			for(String kw : keywords){
				HashMap<Long, ArrayList<Double>> mapEstBid = mapEstBidPerKw.get(kw);
				if(mapEstBid!=null && mapEstBid.get(bid) != null){
					stdout.print(ReportUtils.average(mapEstBid.get(bid))+", ");
				} else {
					stdout.print("-1.0, ");
				}
			}
			stdout.print("\n");
		}
		
	}
	
	private static void createBidEstimReportPerKwImpressions(HashMap<String,HashMap<String, ArrayList<ReportObject>>> mapReportDailybyKw, 
			String[] keywords , PrintStream stdout) throws Exception{
		stdout.println("Bid vs Avg daily Impressions");
		Set<String> dates = mapReportDailybyKw.keySet();
		String[] datesS = dates.toArray(new String[dates.size()]);
		Arrays.sort(datesS);
		
		HashMap<String,HashMap<Long, ArrayList<Double>>> mapEstBidPerKw = new  HashMap<String,HashMap<Long,ArrayList<Double>>>();
		ArrayList<Long> bids = new ArrayList<Long>();
		for(String date : datesS){
			HashMap<String, ArrayList<ReportObject>> mapKw = mapReportDailybyKw.get(date);
			for(String kw : keywords){
				ArrayList<ReportObject> rep =mapKw.get(kw);
				HashMap<Long, ArrayList<Double>> mapEstBid = mapEstBidPerKw.get(kw);
				if(mapEstBid== null){
					mapEstBid = new HashMap<Long, ArrayList<Double>>();
				}
				if(rep != null){
					if(rep.size()>1)
						throw new Exception("More than one report");
					if(!bids.contains(rep.get(0).getMicroBidAmount()))
						bids.add(rep.get(0).getMicroBidAmount());
					if(mapEstBid.containsKey(rep.get(0).getMicroBidAmount())){
						mapEstBid.get(rep.get(0).getMicroBidAmount()).add((rep.get(0).getNumberImpressions()== null)? null : new Double(rep.get(0).getNumberImpressions()));
					}else{
						ArrayList<Double> aux = new ArrayList<Double>();
						aux.add(new Double((rep.get(0).getNumberImpressions()== null)? null : new Double(rep.get(0).getNumberImpressions())));
						mapEstBid.put(rep.get(0).getMicroBidAmount(), aux);
					}
				}
				mapEstBidPerKw.put(kw, mapEstBid);
			}
		}
		
		ArrayList<Long> bidPerDay = new ArrayList<Long>();
		for(String date : datesS){
			HashMap<String, ArrayList<ReportObject>> mapKw = mapReportDailybyKw.get(date);
			for(String kw : keywords){
				ArrayList<ReportObject> rep =mapKw.get(kw);
				if(rep!=null && rep.get(0).getMicroBidAmount()!=null){
					bidPerDay.add(rep.get(0).getMicroBidAmount());
					break;
				}
			}
		}
		
		stdout.print("Bid, ");
		for(String kw : keywords){
			stdout.print(kw+", ");
		}
		stdout.print("\n");
		
		
		Long[] sortedBids = bids.toArray(new Long[bids.size()]);
		Arrays.sort(sortedBids);
		for(Long bid : sortedBids){
			stdout.print(bid+", ");
			for(String kw : keywords){
				HashMap<Long, ArrayList<Double>> mapEstBid = mapEstBidPerKw.get(kw);
				if(mapEstBid!=null && mapEstBid.get(bid) != null){
					stdout.print(dailyAveragePerBid(mapEstBid.get(bid), bid, bidPerDay)+", ");
				} else {
					stdout.print("0.0, ");
				}
			}
			stdout.print("\n");
		}
		
	}
	
	private static void createBidEstimReportPerKwFPCPC(HashMap<String,HashMap<String, ArrayList<ReportObject>>> mapReportDailybyKw, 
			String[] keywords , PrintStream stdout) throws Exception{
		stdout.println("Bid vs Avg daily First Page CPC");
		Set<String> dates = mapReportDailybyKw.keySet();
		String[] datesS = dates.toArray(new String[dates.size()]);
		Arrays.sort(datesS);
		
		HashMap<String,HashMap<Long, ArrayList<Double>>> mapEstBidPerKw = new  HashMap<String,HashMap<Long,ArrayList<Double>>>();
		ArrayList<Long> bids = new ArrayList<Long>();
		for(String date : datesS){
			HashMap<String, ArrayList<ReportObject>> mapKw = mapReportDailybyKw.get(date);
			for(String kw : keywords){
				ArrayList<ReportObject> rep =mapKw.get(kw);
				HashMap<Long, ArrayList<Double>> mapEstBid = mapEstBidPerKw.get(kw);
				if(mapEstBid== null){
					mapEstBid = new HashMap<Long, ArrayList<Double>>();
				}
				if(rep != null){
					if(rep.size()>1)
						throw new Exception("More than one report");
					if(!bids.contains(rep.get(0).getMicroBidAmount()))
						bids.add(rep.get(0).getMicroBidAmount());
					if(mapEstBid.containsKey(rep.get(0).getMicroBidAmount())){
						mapEstBid.get(rep.get(0).getMicroBidAmount()).add((rep.get(0).getFirstPageCPC()== null)? null : new Double(rep.get(0).getFirstPageCPC()));
					}else{
						ArrayList<Double> aux = new ArrayList<Double>();
						aux.add(new Double((rep.get(0).getFirstPageCPC()== null)? null : new Double(rep.get(0).getFirstPageCPC())));
						mapEstBid.put(rep.get(0).getMicroBidAmount(), aux);
					}
				}
				mapEstBidPerKw.put(kw, mapEstBid);
			}
		}
		
		stdout.print("Bid, ");
		for(String kw : keywords){
			stdout.print(kw+", ");
		}
		stdout.print("\n");
		
		
		Long[] sortedBids = bids.toArray(new Long[bids.size()]);
		Arrays.sort(sortedBids);
		for(Long bid : sortedBids){
			stdout.print(bid+", ");
			for(String kw : keywords){
				HashMap<Long, ArrayList<Double>> mapEstBid = mapEstBidPerKw.get(kw);
				if(mapEstBid!=null && mapEstBid.get(bid) != null){
					stdout.print(ReportUtils.average(mapEstBid.get(bid))+", ");
				} else {
					stdout.print("-1.0, ");
				}
			}
			stdout.print("\n");
		}
		
	}
	
	private static void createDailyReportPerKwQS(HashMap<String,HashMap<String, ArrayList<ReportObject>>> mapReportDailybyKw, 
			String[] keywords , PrintStream stdout) throws Exception{
		stdout.println("Daily Quality Score");
		Set<String> dates = mapReportDailybyKw.keySet();
		String[] datesS = dates.toArray(new String[dates.size()]);
		Arrays.sort(datesS);
		stdout.print("Date, ");
		for(String kw : keywords){
			stdout.print(kw+", ");
		}
		stdout.print("\n");

		for(String date : datesS){
			HashMap<String, ArrayList<ReportObject>> mapKw = mapReportDailybyKw.get(date);
			stdout.print(date+", ");
			for(String kw : keywords){
				ArrayList<ReportObject> rep =mapKw.get(kw);
				if(rep != null){
					if(rep.size()>1)
						throw new Exception("More than one report");
					stdout.print(rep.get(0).getQualityScore()+", ");
				}else{
					stdout.print("-1.0, ");
				}
				
			}
			stdout.print("\n");
		}
		
		
	}
	private static void createDailyReportPerKwClicks(HashMap<String,HashMap<String, ArrayList<ReportObject>>> mapReportDailybyKw, 
			String[] keywords , PrintStream stdout) throws Exception{
		stdout.println("Daily Clicks");
		Set<String> dates = mapReportDailybyKw.keySet();
		String[] datesS = dates.toArray(new String[dates.size()]);
		Arrays.sort(datesS);
		stdout.print("Date, ");
		for(String kw : keywords){
			stdout.print(kw+", ");
		}
		stdout.print("\n");

		for(String date : datesS){
			HashMap<String, ArrayList<ReportObject>> mapKw = mapReportDailybyKw.get(date);
			stdout.print(date+", ");
			for(String kw : keywords){
				ArrayList<ReportObject> rep =mapKw.get(kw);
				if(rep != null){
					if(rep.size()>1)
						throw new Exception("More than one report");
					stdout.print(rep.get(0).getNumberClick()+", ");
				}else{
					stdout.print("0.0, ");
				}
				
			}
			stdout.print("\n");
		}
		
		
	}
	private static void createDailyReportPerKwCPC(HashMap<String,HashMap<String, ArrayList<ReportObject>>> mapReportDailybyKw, 
			String[] keywords , PrintStream stdout) throws Exception{
		stdout.println("Daily CPC");
		Set<String> dates = mapReportDailybyKw.keySet();
		String[] datesS = dates.toArray(new String[dates.size()]);
		Arrays.sort(datesS);
		stdout.print("Date, ");
		for(String kw : keywords){
			stdout.print(kw+", ");
		}
		stdout.print("\n");

		for(String date : datesS){
			HashMap<String, ArrayList<ReportObject>> mapKw = mapReportDailybyKw.get(date);
			stdout.print(date+", ");
			for(String kw : keywords){
				ArrayList<ReportObject> rep =mapKw.get(kw);
				if(rep != null){
					if(rep.size()>1)
						throw new Exception("More than one report");
					stdout.print(rep.get(0).getAverageCPC()/1000000.0+", ");
				}else{
					stdout.print("-1.0, ");
				}
				
			}
			stdout.print("\n");
		}
		
		
	}
	private static void createDailyReportPerKwPosition(HashMap<String,HashMap<String, ArrayList<ReportObject>>> mapReportDailybyKw, 
			String[] keywords , PrintStream stdout) throws Exception{
		stdout.println("Daily Position");
		Set<String> dates = mapReportDailybyKw.keySet();
		String[] datesS = dates.toArray(new String[dates.size()]);
		Arrays.sort(datesS);
		stdout.print("Date, ");
		for(String kw : keywords){
			stdout.print(kw+", ");
		}
		stdout.print("\n");

		for(String date : datesS){
			HashMap<String, ArrayList<ReportObject>> mapKw = mapReportDailybyKw.get(date);
			stdout.print(date+", ");
			for(String kw : keywords){
				ArrayList<ReportObject> rep =mapKw.get(kw);
				if(rep != null){
					if(rep.size()>1)
						throw new Exception("More than one report");
					stdout.print(rep.get(0).getAveragePosition()+", ");
				}else{
					stdout.print("-1.0, ");
				}
				
			}
			stdout.print("\n");
		}
		
		
	}
	private static void createDailyReportPerKwImpressions(HashMap<String,HashMap<String, ArrayList<ReportObject>>> mapReportDailybyKw, 
			String[] keywords , PrintStream stdout) throws Exception{
		stdout.println("Daily Impressions");
		Set<String> dates = mapReportDailybyKw.keySet();
		String[] datesS = dates.toArray(new String[dates.size()]);
		Arrays.sort(datesS);
		stdout.print("Date, ");
		for(String kw : keywords){
			stdout.print(kw+", ");
		}
		stdout.print("\n");

		for(String date : datesS){
			HashMap<String, ArrayList<ReportObject>> mapKw = mapReportDailybyKw.get(date);
			stdout.print(date+", ");
			for(String kw : keywords){
				ArrayList<ReportObject> rep =mapKw.get(kw);
				if(rep != null){
					if(rep.size()>1)
						throw new Exception("More than one report");
					stdout.print(rep.get(0).getNumberImpressions()+", ");
				}else{
					stdout.print("0.0, ");
				}
				
			}
			stdout.print("\n");
		}
		
		
	}
	private static void createDailyReportPerKwFPCPC(HashMap<String,HashMap<String, ArrayList<ReportObject>>> mapReportDailybyKw, 
			String[] keywords , PrintStream stdout) throws Exception{
		stdout.println("Daily FPCPC");
		Set<String> dates = mapReportDailybyKw.keySet();
		String[] datesS = dates.toArray(new String[dates.size()]);
		Arrays.sort(datesS);
		stdout.print("Date, ");
		for(String kw : keywords){
			stdout.print(kw+", ");
		}
		stdout.print("\n");

		for(String date : datesS){
			HashMap<String, ArrayList<ReportObject>> mapKw = mapReportDailybyKw.get(date);
			stdout.print(date+", ");
			for(String kw : keywords){
				ArrayList<ReportObject> rep =mapKw.get(kw);
				if(rep != null){
					if(rep.size()>1)
						throw new Exception("More than one report");
					stdout.print(rep.get(0).getFirstPageCPC()/1000000.0+", ");
				}else{
					stdout.print("-1.0, ");
				}
				
			}
			stdout.print("\n");
		}
	}
	
	
	private static ArrayList<String> createGeneralReport (HashMap<String, ArrayList<ReportObject>> mapReportTotal, PrintStream stdout){
		
		int totalImpr=0, totalClicks=0;
		double totalAveCpc, totalAvePos=0, totalAveFPCPC=0, totalAveQS=0, totalCost=0;
		int totalKwWithImp=0, totalKwWithClick=0;

		ArrayList<String> kwWithClicks = new ArrayList<String>();
		
		Set<String> keySet = mapReportTotal.keySet();
		totalKwWithImp = keySet.size();
		int count = 0, countFPCPC=0, countQS=0;
		for(String kw : keySet){
			for(ReportObject rep : mapReportTotal.get(kw)){
				totalImpr = totalImpr+rep.getNumberImpressions();
				totalClicks = totalClicks+rep.getNumberClick();
				if(rep.getNumberClick()>0)
					kwWithClicks.add(kw);
				totalCost = totalCost + rep.getMicroCost()/1000000.0;
				totalAvePos = totalAvePos + rep.getAveragePosition()*rep.getNumberImpressions();
				if(rep.getFirstPageCPC()!=null){
					totalAveFPCPC = totalAveFPCPC + rep.getFirstPageCPC();
					countFPCPC++;
				}
				if(rep.getQualityScore()!=null){
					totalAveQS = totalAveQS + rep.getQualityScore();
					countQS++;
				}
				
	
			}
			
		}
		totalAveCpc = totalCost/totalClicks;
		totalAvePos = totalAvePos/totalImpr;
		totalAveFPCPC = totalAveFPCPC/(countFPCPC*1000000.0);
		totalAveQS = totalAveQS/countQS;
		totalKwWithImp = mapReportTotal.size();
		totalKwWithClick = kwWithClicks.size();

		
		stdout.println("totalImpr, "+totalImpr);
		stdout.println("totalClicks, "+totalClicks);
		stdout.println("totalAveCpc, "+totalAvePos);
		stdout.println("totalAveFPCPC, "+totalAveFPCPC);
		stdout.println("totalAveQS, "+totalAveQS);
		stdout.println("totalCost, "+totalCost);
		stdout.println("totalKwWithImp, "+totalKwWithImp);
		stdout.println("totalKwWithClick, "+totalKwWithClick);
		
		return  kwWithClicks;
	}

	private static ReportObject[] loadAndMergeReports(String[] dates, String basePath, String extension) throws Exception{
		ArrayList<ReportObject> reps = new ArrayList<ReportObject>();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		for(String date : dates){
			String path = basePath+date+"/"+date+extension;
			ReportObject[] repsAux = (ReportObject[]) ReportUtils.loadSerializedObject(path);
			if(repsAux!=null){
				for(ReportObject rep : repsAux){
					Date dat = df.parse(date);
					rep.setCreatedDate(dat);
				}
				reps.addAll(new ArrayList<ReportObject>(Arrays.asList(repsAux)));
			}
			System.out.println("Loaded "+path);
		}
		ReportObject[] repArray = new ReportObject[reps.size()];
		reps.toArray(repArray);
		return repArray;
	}

}
