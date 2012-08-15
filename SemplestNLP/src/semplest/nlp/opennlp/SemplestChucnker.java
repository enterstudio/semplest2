package semplest.nlp.opennlp;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.chunker.ChunkerME;
import opennlp.tools.chunker.ChunkerModel;

import semplest.nlp.common.RichSentence;
import semplest.nlp.common.Utils;


public class SemplestChucnker {
	
	
	private ChunkerME chunker;
	private SemplestPOSTagger tagger;
	private SemplestTokenizer tokenizer;
	


	public SemplestChucnker() {
		InputStream modelIn = null;
		try {
			modelIn = new FileInputStream("models/en-chunker.bin");
			ChunkerModel modelChunker = new ChunkerModel(modelIn);
			chunker = new ChunkerME(modelChunker);
		} catch (Exception e) {
			// Model loading failed, handle the error
			e.printStackTrace();
		} finally {
			if (modelIn != null) {
				try {
					modelIn.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		tagger = new SemplestPOSTagger();
		tokenizer = new SemplestTokenizer();
	}

	public RichSentence getParsedSentence(String sentence) throws Exception{


			String tokens[] = tokenizer.getTokens(sentence);
			String [] tags = tagger.getTags(tokens);
			String [] chunks = chunker.chunk(tokens, tags);
			//double [] prob =chunker.probs();
			
			RichSentence sent = new RichSentence();
			sent.setSentence(sentence);
			sent.setTokens(tokens);
			sent.setTags(tags);
			sent.setChunks(chunks);
			
			if(!sent.isConsistent()){
				throw new Exception("Parsing results are wrong for the sentence: " + sent.getSentence() + "\n"+sent);
			}

			/*
			for(String c : tokens){
				System.out.print(c+" || ");
			}
			System.out.println("");
			for(String c : tags){
				System.out.print(c+" || ");
			}
			System.out.println("");
			for(String c : chunks){
				System.out.print(c+" || ");
			}
			System.out.println("");
			for(String c : chunks){
				System.out.print(Utils.isNoun(c)+" || ");
			}
			System.out.println("");
			/*
			for(double p : prob){
				System.out.print(p+" "); // 1-p ?? 
			}
			System.out.println("");
			*/
			
			return sent;
		}
	

}
