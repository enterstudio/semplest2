package semplest.nlp.opennlp;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;


public class SemplestPOSTagger {
		
	POSTaggerME tagger;
	
	
	public SemplestPOSTagger(){

		InputStream modelIn = null;

		try {
			modelIn = new FileInputStream("models/en-pos-maxent.bin");
			POSModel modelPOS = new POSModel(modelIn);
			tagger = new POSTaggerME(modelPOS);
		}
		catch (Exception e) {
			// Model loading failed, handle the error
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
	
	
	public String [] getTags(String tokens[]){
		return tagger.tag(tokens);
	}
	
	

}
