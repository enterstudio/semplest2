package semplest.ml.text;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.LowerCaseTokenizer;
import org.apache.lucene.analysis.PorterStemFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.util.Version;
import org.apache.mahout.math.RandomAccessSparseVector;
import org.apache.mahout.math.Vector;
import org.apache.mahout.vectorizer.encoders.FeatureVectorEncoder;
import org.apache.mahout.vectorizer.encoders.StaticWordValueEncoder;

import semplest.ml.interfaces.TextAnalyzer;

public class LuceneAnalyzer implements TextAnalyzer{
	
	Analyzer analyzer;

	/**
	 * @param args
	 */
	
	public LuceneAnalyzer(){
		analyzer = new StandardAnalyzer(Version.LUCENE_36);
	}
	
	@Override
	public List<String> getTokens(String text) {
		List<String> result = new ArrayList<String>();
		try {
			TokenStream stream  = analyzer.tokenStream(null, new StringReader(text));
			while (stream.incrementToken()) {
				result.add(stream.getAttribute(CharTermAttribute.class).toString());
			}
		} catch (IOException e) {
			// not thrown b/c we're using a string reader...
			throw new RuntimeException(e);
		}
		return result;
	}
	@Override
	public List<String> getStemmedTokens(String text) {
		List<String> result = new ArrayList<String>();
		try {
			TokenStream stream  = new PorterStemFilter(new LowerCaseTokenizer(new StringReader(text)));
			while (stream.incrementToken()) {
				result.add(stream.getAttribute(CharTermAttribute.class).toString());
			}
		} catch (IOException e) {
			// not thrown b/c we're using a string reader...
			throw new RuntimeException(e);
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		TextAnalyzer analyzer = new LuceneAnalyzer();
		
		String to_be_parsed = "I am doing amazingly well. I am hungry though! I am going to meet Harry. Then I'll buy wedding flowers.";
		//List<String> tokenized_string = analyzer.getTokens(to_be_parsed);
		List<String> tokenized_string = analyzer.getStemmedTokens(to_be_parsed);
		//FeatureVectorEncoder encoder = new StaticWordValueEncoder("text string");
		FeatureVectorEncoder encoder = new StaticWordValueEncoder("text string");
		Vector v1 = new RandomAccessSparseVector(100);
		for(String s : tokenized_string){
			System.out.println(s);
			//encoder.addToVector(s, 1, v1);
		}
		//System.out.println(v1);

	}

}
