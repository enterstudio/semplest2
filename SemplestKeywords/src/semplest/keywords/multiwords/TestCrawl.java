package semplest.keywords.multiwords;

import org.apache.log4j.Logger;
import org.apache.nutch.crawl.*;

//necessary imports
import org.apache.hadoop.conf.Configuration;
import org.apache.nutch.parse.*;
import org.apache.nutch.plugin.*;
//import org.apache.nutch.searcher.Hit;
//import org.apache.nutch.searcher.HitDetails;
//import org.apache.nutch.searcher.Hits;
//import org.apache.nutch.searcher.NutchBean;
//import org.apache.nutch.searcher.Query;
import org.apache.nutch.util.NutchConfiguration;
//import java.util.Date;

public class TestCrawl {
	
	private static final Logger logger = Logger.getLogger(TestCrawl.class);
	
	public static void main(String [] args) {
		
		try {
			// configure nutch
            Configuration nutchConf = NutchConfiguration.create();
//            nutchConf.addResource("/home/subhojit/Softwares/apache-nutch-1.4-bin/runtime/local/conf/nutch-site.xml");
            nutchConf.set("plugin.folders","/home/subhojit/Softwares/apache-nutch-1.4-bin/runtime/local/plugins");
            nutchConf.set("http.agent.name","SubhojitTest");
            
            Crawl crawler = new Crawl();
            crawler.setConf(nutchConf);
            
            String [] s = {"/home/subhojit/Softwares/apache-nutch-1.4-bin/runtime/local/urls/","-dir","/tmp/subhojit","-depth","2","-topN","10"};
            crawler.run(s);
            
            System.out.println("He He I am done.");
            
            
//            String [] argToCrawl = new String[2];
//            argToCrawl[1]= "/home/subhojit/Softwares/apache-nutch-1.4-bin/runtime/local/urls";
//            argToCrawl[0]= "/tmp/trial";
//            crawler.run(argToCrawl);
            
            
            
//            CrawlDbReader crawlDbReader = new  CrawlDbReader();
////			crawlDbReader.readUrl("/home/subhojit/Softwares/apache-nutch-1.4-bin/runtime/local/autoInsurance/crawldb","http://dir.yahoo.com",nutchConf);
//			crawlDbReader.processStatJob("/home/subhojit/Softwares/apache-nutch-1.4-bin/runtime/local/autoInsurance/crawldb",nutchConf,true);

//		ParseData parseData = new ParseData();	
//		parseData.
			
		} catch ( Exception e )	{ 
			logger.error("Problem", e);
		} 
		

	}

}



