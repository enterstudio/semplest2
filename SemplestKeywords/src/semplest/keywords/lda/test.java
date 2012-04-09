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
		String pattern = "wed service";
		pattern = pattern.replace("wed", "wedding");
		System.out.println(pattern);
		
		
	}

}
