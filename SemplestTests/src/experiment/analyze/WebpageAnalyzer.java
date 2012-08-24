package experiment.analyze;

import java.util.TreeMap;

public class WebpageAnalyzer {
	
	public static void main(String[] args){
		WebpageAnalyzer wa = new WebpageAnalyzer();
		try{
			String homepageUrl = "http://www.salesathlete.com/";
			wa.analyzeLandingPage(homepageUrl);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void analyzeLandingPage(String url) throws Exception{		
		Searcher searcher = new Searcher();
		ArticleProcesser processer = new ArticleProcesser();
		
		String content = searcher.getContentOfWebsite(url);
		TreeMap<String, Double> keywords = processer.ProcessContent(content);
		
		for(String s : keywords.descendingKeySet()){
			System.out.println(s);
		}
	}
	
}