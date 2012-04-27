package semplest.server.protocol.adengine;

import java.util.ArrayList;
import java.util.Calendar;

import org.joda.time.DateTime;


public class ReportObject
{
	private ArrayList<Transaction> Transactions = new ArrayList<Transaction>();
	
	public ArrayList<Transaction> getTransactions() {
		return Transactions;
	}

	public void setTransactions(ArrayList<Transaction> transactions) {
		Transactions = transactions;
	}
	
	public void addTransaction(Transaction transaction){
		Transactions.add(transaction);
	}
	
	public class Transaction{
		 private String Keyword;
		 private int BidAmount;
		 private String BidMatchType;
		 private int NumberImpressions;
		 private int NumberClick;
		 private Double AveragePosition;
		 private int AverageCPC;
		 private int QualityScore;
		 private String ApprovalStatus;
		 private int FirstPageCPC;
		 private DateTime CreatedDate;
		 
		 public Transaction(){
			 
		 }		 
		 
		public Transaction(String keyword, int bidAmount, String bidMatchType,
				int numberImpressions, int numberClick, Double averagePosition,
				int averageCPC, int qualityScore, String approvalStatus,
				int firstPageCPC, DateTime createdDate) {
			Keyword = keyword;
			BidAmount = bidAmount;
			BidMatchType = bidMatchType;
			NumberImpressions = numberImpressions;
			NumberClick = numberClick;
			AveragePosition = averagePosition;
			AverageCPC = averageCPC;
			QualityScore = qualityScore;
			ApprovalStatus = approvalStatus;
			FirstPageCPC = firstPageCPC;
			CreatedDate = createdDate;
		}

		public String getKeyword() {
			return Keyword;
		}

		public void setKeyword(String keyword) {
			Keyword = keyword;
		}

		public int getBidAmount() {
			return BidAmount;
		}

		public void setBidAmount(int bidAmount) {
			BidAmount = bidAmount;
		}

		public String getBidMatchType() {
			return BidMatchType;
		}

		public void setBidMatchType(String bidMatchType) {
			BidMatchType = bidMatchType;
		}

		public int getNumberImpressions() {
			return NumberImpressions;
		}

		public void setNumberImpressions(int numberImpressions) {
			NumberImpressions = numberImpressions;
		}

		public int getNumberClick() {
			return NumberClick;
		}

		public void setNumberClick(int numberClick) {
			NumberClick = numberClick;
		}

		public Double getAveragePosition() {
			return AveragePosition;
		}

		public void setAveragePosition(Double averagePosition) {
			AveragePosition = averagePosition;
		}

		public int getAverageCPC() {
			return AverageCPC;
		}

		public void setAverageCPC(int averageCPC) {
			AverageCPC = averageCPC;
		}

		public int getQualityScore() {
			return QualityScore;
		}

		public void setQualityScore(int qualityScore) {
			QualityScore = qualityScore;
		}

		public String getApprovalStatus() {
			return ApprovalStatus;
		}

		public void setApprovalStatus(String approvalStatus) {
			ApprovalStatus = approvalStatus;
		}

		public int getFirstPageCPC() {
			return FirstPageCPC;
		}

		public void setFirstPageCPC(int firstPageCPC) {
			FirstPageCPC = firstPageCPC;
		}

		public DateTime getCreatedDate() {
			return CreatedDate;
		}

		public void setCreatedDate(DateTime createdDate) {
			CreatedDate = createdDate;
		}		

		
		 
	}	 
	 
}
