package semplest.nlp;

import java.util.ArrayList;
import java.util.List;

import semplest.nlp.common.RichSentence;
import semplest.nlp.common.Utils;
import semplest.nlp.opennlp.SemplestChucnker;
import semplest.nlp.opennlp.SemplestSentenceExtractor;

public class SemplestOpenNLP  implements SemplestNLP {
	
	private SemplestSentenceExtractor sentenceExtractor;
	private SemplestChucnker chunker;

	
	public SemplestOpenNLP(){
		sentenceExtractor= new SemplestSentenceExtractor();
		chunker = new SemplestChucnker();

	}

	@Override
	public String[] splitIntoSentences(String text) {
		return sentenceExtractor.getSentences(text);
	}
	
	@Override
	public List<String> getNounBlocksFromSentence(String sentence, int minLength) {
		RichSentence sent = null;
		try {
			sent = chunker.getParsedSentence(sentence);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<String> nounBlocks = new ArrayList<String>();
		
		if(sent!=null && sent.getChunks()!=null && sent.getChunks().length>0 && sent.isConsistent()){
			
			String [] chunk = sent.getChunks();
			boolean []  isNounWord = new boolean[chunk.length];
			for(int i=0; i<chunk.length; i++){
				isNounWord[i] = Utils.isNoun(chunk[i]);
			}
			
			int startIndex = -1;
			boolean presentWordNoun = false;
			boolean prevWordNoun = false;
			for(int i=0; i<isNounWord.length; i++){
				if(i>0) {
					prevWordNoun = isNounWord[i-1];
				}
				presentWordNoun = isNounWord[i];
				
				/*
				if(presentWordNoun){
					String[] s = sent.getTokens();
					System.out.println(s[i]);
				}
				*/
				if(presentWordNoun && (!prevWordNoun)){
					startIndex = i;
				} 
				if((!presentWordNoun) && prevWordNoun){
					// create new phrase and add from startIndex to i
					addBlockToList(sent, nounBlocks, startIndex, i-1, minLength);
					startIndex = -1;
				}
			}
			// consider the special case when the last word is noun
			if(presentWordNoun){
				addBlockToList(sent, nounBlocks, startIndex, isNounWord.length-1, minLength);
			}

			
		}
		return nounBlocks;
	}

	private void addBlockToList(RichSentence sent, List<String> nounBlocks,	int startIndex, int endIndex, int minLength) {
		if(endIndex-startIndex>=minLength){
			StringBuffer buffer = new StringBuffer();
			int index = startIndex;
			String [] tokens = sent.getTokens();
			while(index<=endIndex){
				buffer.append(tokens[index]);
				if(index<endIndex){
					buffer.append(" ");
				}
				index++;
			}
			nounBlocks.add(buffer.toString());
		}
	}

	@Override
	public List<List<String>> getNounBlocksFromText(String text, int minLength) {
		String [] sentences = splitIntoSentences(text);
		List<List<String>> listOfListofWords = new ArrayList<List<String>>();
		for(String s : sentences){
			List<String> nounBlocks = getNounBlocksFromSentence(s, minLength);
			listOfListofWords.add(nounBlocks);
		}
		return listOfListofWords;
	}
	
	
	@Override
	public List<String> getNounBlocksFromSentence(String sentence) {
		return getNounBlocksFromSentence(sentence, 1);
	}
	
	@Override
	public List<List<String>> getNounBlocksFromText(String text) {
		String [] sentences = splitIntoSentences(text);
		List<List<String>> listOfListofWords = new ArrayList<List<String>>();
		for(String s : sentences){
			List<String> nounBlocks = getNounBlocksFromSentence(s);
			listOfListofWords.add(nounBlocks);
		}
		return listOfListofWords;
	}
	
	
	public static void main(String [] args){
		String text = "A hypersonic aircraft launched by the Air Force Tuesday spiraled out of " +
				"control and was destroyed before it could reach its goal of speeding to 4,600 mph, " +
				"Pentagon officials said Wednesday. The third test of the X-51A Waverider was " +
				"launched Tuesday off the California coast from a B-52 modified bomber aircraft and " +
				"was to fly for 300 seconds, reaching hypersonic speeds of Mach 6, but only flew for 16 seconds, " +
				"according to the Air Force. Officials said a problem with a tail fin caused the missile-like vehicle to fly " +
				"out of control before the main engine could be ignited, leading researchers to destroy it early. " +
				"\"A fault was identified with one of the cruiser control fins. Once the X-51 separated from the rocket " +
				"booster, approximately 15 seconds later, the cruiser was not able to maintain control due to the faulty " +
				"control fin and was lost,\" said a statement issued by the Air Force. " + 
				" It's unclear what, if any, information was gleaned from the test. According to the statement, " +
				"\"Program officials will now begin the process of working through a rigorous evaluation to determine " +
				"the exact cause of all factors at play.\" "+ 
				"The Air Force plans to go public with details of the failed test in a few weeks, " +
				"after researchers are able to analyze the data from the flight. \"It is unfortunate that a problem " +
				"with this subsystem caused a termination before we could light the Scramjet engine,\" " +
				"said Charlie Brink, X-51A Program Manager for Air Force Research Laboratory. \"All our data " +
				"showed we had created the right conditions for engine ignition and we were very hopeful to meet our test objectives.\" " +
				"The Air Force had four X-51A Waveriders and has tested three. Officials said they do not yet know when " +
				"or if the fourth Waverider will be tested.";
		
		SemplestNLP nlpEngine = new SemplestOpenNLP();
		
		// If we take care of breaking up into sentences
		System.out.println("Parsing sentence by sentence... ");
		String [] sentences = nlpEngine.splitIntoSentences(text);
		for(String s : sentences){
			List<String> nounBlocks = nlpEngine.getNounBlocksFromSentence(s);
			for(int i=0; i<nounBlocks.size(); i++){
				System.out.println(nounBlocks.get(i));
			}
			//System.out.println();
		}
		
		// We can also send the whole text block or paragraphs
		System.out.println("\n\nParsing entire paragraph at once... ");
		List<List<String>> nounBlockLists = nlpEngine.getNounBlocksFromText(text);
		for(List<String> nounBlock : nounBlockLists){
			for(int i=0; i<nounBlock.size(); i++){
				System.out.println(nounBlock.get(i));
			}
			//System.out.println();
		}

	}



}
