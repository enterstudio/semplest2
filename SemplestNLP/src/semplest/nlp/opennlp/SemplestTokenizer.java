package semplest.nlp.opennlp;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;


public class SemplestTokenizer {
	
	private Tokenizer tokenizer;
	
	public SemplestTokenizer(){
		InputStream modelIn = null;

		try {
			modelIn = new FileInputStream("models/en-token.bin");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		try {
			TokenizerModel modelToken = new TokenizerModel(modelIn);
			tokenizer = new TokenizerME(modelToken); // note that there are three possible classes here, Tokenizer is an interface
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
	
	
	public String [] getTokens(String sentence){	
		return tokenizer.tokenize(sentence);
	}
	


}
