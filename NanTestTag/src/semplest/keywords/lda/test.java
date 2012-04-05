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
		String pattern = "iphone";
		pattern=pattern.replaceAll("\\s", "+");
		String text = TextUtils.HTMLText("http://www.dmoz.org/search?q="+pattern);
		String[] lines = text.split("\n");
		String categories;
		for(int i=0;i<lines.length;i++){
			if(lines[i].contains("--")){
				categories = lines[i+1];
				categories = categories.replaceAll("\\s", "");
				categories = categories.toLowerCase();
				categories = categories.replaceAll(":", "/");
				categories = "top/"+categories;
				System.out.println(categories);
			}
		}
		
		
	}

}
