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
		int repeatUser=1;
	    int repeatUrl=1;
	    int userIn1=19;
	    int words1=107;
	    double weight1=1;
	    if(words1>=userIn1 && weight1!=1)
	    	repeatUser=(int) Math.round(weight1*words1/(userIn1*(1-weight1)));
	    if(words1<userIn1&& weight1!=0)
	    	repeatUrl=(int) Math.round(userIn1*(1-weight1)/(weight1*words1));
	    if (weight1==0){
	    	repeatUser=0;
	    }
	    if (weight1==1){
	    	repeatUrl=0;
	    }
	    System.out.println("Number of times to repeat user data "+repeatUser);
	    System.out.println("Number of times to repeat ulr data "+repeatUrl);
	    double finalweight = 1.0*(userIn1*repeatUser)/(words1*repeatUrl+userIn1*repeatUser);
	    System.out.println("Final weight of user data"+ finalweight);
	}

}
