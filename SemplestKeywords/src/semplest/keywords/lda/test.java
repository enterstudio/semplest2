package semplest.keywords.lda;

import java.io.*;
import java.text.SimpleDateFormat;
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
		//TextUtils.changeKeywordMatchtoExact("/semplest/data/biddingTest/PiperHall/keywords.txt");
		String word = "word1+word2";
		String[] split = word.split("\\+");
		System.out.println(dictUtils.getRoot("flowers"));
	}


}
