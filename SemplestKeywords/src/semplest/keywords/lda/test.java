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
		String a = "wedding      flowers";
		String b = " ";
		System.out.println(a.contains(""));
		System.out.println(a.replaceAll("\\s+", " "));
	}
	private static String stemvString( String raws){
		//Returns the stemmed version of a word
	    String os = "";
	    for( String w: raws.split("\\s+"))
	      os = os + dictUtils.getStemWord( w ) + " ";
	    return os;
	  }

}
