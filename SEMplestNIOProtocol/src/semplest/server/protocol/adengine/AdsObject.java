package semplest.server.protocol.adengine;

public class AdsObject
{
	private Integer PromotionAdsPK;
	private Integer PromotionFK;
	private String AdTitle;
	private String AdTextLine1;
	private String AdTextLine2;
	private Long AdEngineAdID;
	
	public String getAdTitle()
	{
		return AdTitle;
	}
	public void setAdTitle(String adTitle)
	{
		AdTitle = adTitle;
	}
	public Integer getPromotionAdsPK()
	{
		return PromotionAdsPK;
	}
	public void setPromotionAdsPK(Integer promotionAdsPK)
	{
		PromotionAdsPK = promotionAdsPK;
	}
	public Integer getPromotionFK()
	{
		return PromotionFK;
	}
	public void setPromotionFK(Integer promotionFK)
	{
		PromotionFK = promotionFK;
	}
	public Long getAdEngineAdID()
	{
		return AdEngineAdID;
	}
	public void setAdEngineAdID(Long adEngineAdID)
	{
		AdEngineAdID = adEngineAdID;
	}
	public String getAdTextLine1()
	{
		return AdTextLine1;
	}
	public void setAdTextLine1(String adTextLine1)
	{
		AdTextLine1 = adTextLine1;
	}
	public String getAdTextLine2()
	{
		return AdTextLine2;
	}
	public void setAdTextLine2(String adTextLine2)
	{
		AdTextLine2 = adTextLine2;
	}
	@Override
	public String toString()
	{
		return "AdsObject [PromotionAdsPK=" + PromotionAdsPK + ", PromotionFK=" + PromotionFK + ", AdTitle=" + AdTitle + ", AdTextLine1="
				+ AdTextLine1 + ", AdTextLine2=" + AdTextLine2 + ", AdEngineAdID=" + AdEngineAdID + "]";
	}
	
}
