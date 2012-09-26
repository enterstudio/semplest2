package semplest.crawler;

public class Status {
	public static Integer TotalWorkSize;
	public static Integer WorkQueueSize;
	public static Integer NumOfResultsCollected;
	
	public static boolean isDone(){
		if(TotalWorkSize.equals(NumOfResultsCollected)){
			return true;
		}
		return false;
	}
}
