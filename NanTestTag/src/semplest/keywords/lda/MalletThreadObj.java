package semplest.keywords.lda;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

import semplest.keywords.javautils.ioUtils;
import cc.mallet.types.Instance;
import cc.mallet.types.InstanceList;
/**
 * Object created to allow multithreading when loading Instances from file
 * @author lluis
 *
 */
public class MalletThreadObj implements Runnable {

	private InstanceList instances;
	private int threadAction;
	private int startLine;
	private int finishLine;
	private ArrayList<String> lines;
	
	public MalletThreadObj(InstanceList inst, int action, int strtline, int fnishline, ArrayList<String> lin){
		instances = inst;
		threadAction = action;
		startLine = strtline;
		finishLine = fnishline;
		lines = lin;
	}
	public void run(){
		switch(threadAction){
		default : //Load and malletize Instances from a file
		     addAndMalletize();
		}
	}
	
	public void addAndMalletize(){
		
		String line;
        System.out.println("Number of lines: "+lines.size());
        
        for(int i=startLine; i<=finishLine;i++){
        	line=lines.get(i);
        	System.out.println("Adding Category " + i);
        	ArrayList<String> tokens = ioUtils.malletizeLine( line );
        	instances.addThruPipe(new Instance(tokens.get(2),tokens.get(0),tokens.get(1),null));
        	i++;
        }
        
	}
}
