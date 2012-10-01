package semplest.crawler;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class SimpleLogger {
	private String logFile;
	
	public SimpleLogger(String fileName){
		logFile = fileName;		
	}
	
	public void info(String info)
	{
		try{
			FileWriter logWriter = new FileWriter(logFile,true);
			logWriter.append(new Date() + " [INFO] " + info + "\r\n");
			logWriter.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void error(String error)
	{
		try{
			FileWriter logWriter = new FileWriter(logFile,true);
			logWriter.append(new Date() + " [ERROR] " + error + "\r\n");
			logWriter.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void debug(String debug)
	{
		try{
			FileWriter logWriter = new FileWriter(logFile,true);
			logWriter.append(new Date() + " [DEBUG] " + debug + "\r\n");
			logWriter.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void message(String message)
	{
		try{
			FileWriter logWriter = new FileWriter(logFile,true);
			logWriter.append(new Date() + " [MSG] " + message + "\r\n");
			logWriter.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
