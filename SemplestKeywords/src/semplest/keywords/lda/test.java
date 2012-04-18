package semplest.keywords.lda;

import java.io.*;
import java.util.*;

import org.htmlparser.util.ParserException;

import semplest.keywords.javautils.*;


public class test {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws ParserException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, IOException, ParserException {
		String a = null;
		String b = null;
		String c = null;
		String d = "porsche gt3";
		System.out.println(a+b+c);
		System.out.println(stemvString(d));
	}
	private static String stemvString( String raws){
		//Returns the stemmed version of a word
	    String os = "";
	    for( String w: raws.split("\\s+")){
	    	String aux = dictUtils.getStemWord( w );
	    	if(aux != null)
	    		os = os + aux + " ";
	    	else 
	    		os = os + w + " "; 
	    }
	    return os;
	  }

}
