package semplest.server.protocol.adengine;

public class AdsObject
{
	private Integer PromotionAdsPK;
	private Integer PromotionFK;
	private String AdTitle;
	private String AdText;
	private Long AdEngineAdID;
	public String getAdTitle()
	{
		return AdTitle;
	}
	public void setAdTitle(String adTitle)
	{
		AdTitle = adTitle;
	}
	public String getAdText()
	{
		return AdText;
	}
	public void setAdText(String adText)
	{
		AdText = adText;
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
}
