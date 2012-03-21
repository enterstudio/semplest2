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
		String a="auto+insure";
		String[] b;
		b=a.split("\\+");
		System.out.println(b[1]);
	}

}
