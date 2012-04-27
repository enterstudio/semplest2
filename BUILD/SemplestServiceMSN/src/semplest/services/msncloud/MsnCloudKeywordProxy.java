package semplest.services.msncloud;

import com.microsoft.adcenter.v8.Bid;

public class MsnCloudKeywordProxy {
	private final String text;
	private final Bid broadMatchBid;
	private final Bid contentMatchBid;
	private final Bid exactMatchBid;
	private final Bid phraseMatchBid;
	
	public MsnCloudKeywordProxy(String text, Bid broadMatchBid, Bid contentMatchBid, Bid exactMatchBid, Bid phraseMatchBid) {
		this.text = text;
		this.broadMatchBid = broadMatchBid;
		this.contentMatchBid = contentMatchBid;
		this.exactMatchBid = exactMatchBid;
		this.phraseMatchBid = phraseMatchBid;
	}
	
	public String getText() {
		return text;
	}
	
	public Bid getBroadMatchBid() {
		return broadMatchBid;
	}
	
	public Bid getContentMatchBid() {
		return contentMatchBid;
	}
	
	public Bid getExactMatchBid() {
		return exactMatchBid;
	}
	
	public Bid getPhraseMatchBid() {
		return phraseMatchBid;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((broadMatchBid == null) ? 0 : broadMatchBid.hashCode());
		result = prime * result + ((contentMatchBid == null) ? 0 : contentMatchBid.hashCode());
		result = prime * result + ((exactMatchBid == null) ? 0 : exactMatchBid.hashCode());
		result = prime * result + ((phraseMatchBid == null) ? 0 : phraseMatchBid.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof MsnCloudKeywordProxy)) {
			return false;
		}
		MsnCloudKeywordProxy other = (MsnCloudKeywordProxy) obj;
		if (broadMatchBid == null) {
			if (other.broadMatchBid != null) {
				return false;
			}
		} else if (!broadMatchBid.equals(other.broadMatchBid)) {
			return false;
		}
		if (contentMatchBid == null) {
			if (other.contentMatchBid != null) {
				return false;
			}
		} else if (!contentMatchBid.equals(other.contentMatchBid)) {
			return false;
		}
		if (exactMatchBid == null) {
			if (other.exactMatchBid != null) {
				return false;
			}
		} else if (!exactMatchBid.equals(other.exactMatchBid)) {
			return false;
		}
		if (phraseMatchBid == null) {
			if (other.phraseMatchBid != null) {
				return false;
			}
		} else if (!phraseMatchBid.equals(other.phraseMatchBid)) {
			return false;
		}
		if (text == null) {
			if (other.text != null) {
				return false;
			}
		} else if (!text.equals(other.text)) {
			return false;
		}
		return true;
	}
}
