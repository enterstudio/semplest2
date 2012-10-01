package semplest.crawler;

import java.util.List;
import java.util.Queue;

import semplest.dmoz.tree.UrlDataObject;

public class RoundRobin
{
	  private List<Queue<UrlDataObject>> qList;
	  private int index = 0;
	  private int size;
	  
	  public RoundRobin(List<Queue<UrlDataObject>> work){
		  this.qList = work;
		  this.size = work.size();
	  }
	  
	  public UrlDataObject getNextWork(){
		  if(index == size){
			  index = 0;
		  }
		  
		  UrlDataObject ret = qList.get(index).poll();
		  index ++;
		  
		  return ret;
	  }
	  
	  public boolean isEmpty(){
		  boolean allEmpty = true;
		  for(Queue<UrlDataObject> q : qList){
			  allEmpty = allEmpty && q.isEmpty();
		  }		  
		  
		  return allEmpty;
	  }
}
