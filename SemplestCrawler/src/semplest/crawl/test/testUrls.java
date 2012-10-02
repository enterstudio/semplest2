package semplest.crawl.test;

import java.io.IOException;

import org.jsoup.Jsoup;

public class testUrls {
	
	public static void main(String[] args){
		try{
			Long start = System.currentTimeMillis();
			String ret = getRobotsTxt("http://www.weddingchannel.com/");
			System.out.println(System.currentTimeMillis() - start);
			
			System.out.println(ret);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static String getRobotsTxt(String url) throws IOException{
		//String robotsFile = url + "robots.txt";
		String robotsFile = url;
		return Jsoup.connect(robotsFile).get().toString();		
	}
}
