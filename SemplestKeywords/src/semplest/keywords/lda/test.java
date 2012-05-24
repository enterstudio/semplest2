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
		TextUtils.changeKeywordMatchtoExact("/semplest/lluis/PiperHallTest/total.txt");
		//TextUtils.getUniqueKeywords(new String[]{"/semplest/lluis/PiperHallTest/keywords.txt",
		//		"/semplest/lluis/PiperHallTest/msnSuggestedKw.txt"},"/semplest/lluis/PiperHallTest/total.txt");
		
	}


}
