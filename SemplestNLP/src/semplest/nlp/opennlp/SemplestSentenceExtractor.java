package semplest.nlp.opennlp;



import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;


public class SemplestSentenceExtractor {
	
	private SentenceDetectorME sentenceDetector;
	
	
	// constructor
	public SemplestSentenceExtractor(){
		InputStream modelIn = null;
		try{
			modelIn = new FileInputStream("models/en-sent.bin");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			SentenceModel modelSent = new SentenceModel(modelIn);
			sentenceDetector = new SentenceDetectorME(modelSent);
		}
		catch (Exception e) {
		  e.printStackTrace();
		}
		finally {
		  if (modelIn != null) {
		    try {
		      modelIn.close();
		    }
		    catch (IOException e) {
				e.printStackTrace();
		    }
		  }
		}
	}
	
	
	public String [] getSentences(String text){
		return sentenceDetector.sentDetect(text);
	}
	
	
	
	

}
