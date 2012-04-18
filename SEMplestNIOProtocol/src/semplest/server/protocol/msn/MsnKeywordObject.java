package semplest.server.protocol.msn;

import com.google.gson.Gson;
import com.microsoft.adcenter.v8.*;

public class MsnKeywordObject {
	private Long Id;
	private KeywordStatus Status;
	private KeywordEditorialStatus EditorialStatus;
	private String Text;
	private String Bids;  //a string contains BroadMatchBid, ContentMatchBid, ExactMatchBid and PhraseMatchBid (in seq)
	private String Param123;  //a string contains Param1, Param2 and Param3. Separated by the separator
	
	private static String separator1 = "#";
	private static String separator2 = "|";
	
	private static Gson gson = new Gson();
	
	public MsnKeywordObject(){
		
	}
	
	public MsnKeywordObject(Keyword keyword){
		this.fromKeyword(keyword);
	}
	
	public void fromKeyword(Keyword keyword){
		if(keyword == null) return;
		
		Id = keyword.getId();
		Status = keyword.getStatus();
		EditorialStatus = keyword.getEditorialStatus();
		Text = keyword.getText();
		Param123 = keyword.getParam1() + separator2 + keyword.getParam2() + separator2 + keyword.getParam3();
		Bids = gson.toJson(keyword.getBroadMatchBid())
				+ separator1 + gson.toJson(keyword.getContentMatchBid()) 
				+ separator1 + gson.toJson(keyword.getExactMatchBid()) 
				+ separator1 + gson.toJson(keyword.getPhraseMatchBid());
	}
	
	public Keyword toKeyword(){
		Keyword ret = new Keyword();
		
		ret.setId(Id);
		ret.setStatus(Status);
		ret.setEditorialStatus(EditorialStatus);
		ret.setText(Text);
		
		String[] params = Param123.split(separator2);
		int numOfParams = params.length;
		if(numOfParams>0)
			ret.setParam1(params[0]);
		if(numOfParams>1)		
			ret.setParam2(params[1]);
		if(numOfParams>2)
			ret.setParam3(params[2]);
		
		String[] bidslist = Bids.split(separator1);
		int numOfBids = bidslist.length;
		if(numOfBids>0)
			ret.setBroadMatchBid(gson.fromJson(bidslist[0], Bid.class));
		if(numOfBids>1)
			ret.setContentMatchBid(gson.fromJson(bidslist[1], Bid.class));
		if(numOfBids>2)
			ret.setExactMatchBid(gson.fromJson(bidslist[2], Bid.class));
		if(numOfBids>3)
			ret.setPhraseMatchBid(gson.fromJson(bidslist[3], Bid.class));		
		
		return ret;
	}
	

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public KeywordStatus getStatus() {
		return Status;
	}

	public void setStatus(KeywordStatus status) {
		Status = status;
	}

	public KeywordEditorialStatus getEditorialStatus() {
		return EditorialStatus;
	}

	public void setEditorialStatus(KeywordEditorialStatus editorialStatus) {
		EditorialStatus = editorialStatus;
	}

	public String getText() {
		return Text;
	}

	public void setText(String text) {
		Text = text;
	}

	public String getBids() {
		return Bids;
	}

	public void setBids(String bids) {
		Bids = bids;
	}

	public String getParam123() {
		return Param123;
	}

	public void setParam123(String param123) {
		Param123 = param123;
	}
	

}
