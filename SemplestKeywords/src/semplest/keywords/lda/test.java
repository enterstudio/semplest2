package semplest.keywords.lda;

import java.io.*;
import java.util.*;

import semplest.keywords.javautils.*;


public class test {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		String url1="http://www.subway.com/subwayroot/default.aspx";
		ArrayList<String> words1 = TextUtils.validHtmlWords (url1);
	    System.out.println("Words from URL1: "+ words1.size());
	    for(String word:words1){
	    	System.out.println(word);
	    }
	}

}
