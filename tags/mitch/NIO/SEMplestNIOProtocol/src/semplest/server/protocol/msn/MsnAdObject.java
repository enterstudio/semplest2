package semplest.server.protocol.msn;

import semplest.server.protocol.*;

import com.microsoft.adcenter.v8.*;

public class MsnAdObject {
	private Long Id;
	private AdType Type;
	private AdStatus Status;
	private AdEditorialStatus EditorialStatus;	
	
	private String Title;
	private String Text;
	private String BusinessName;
	private String DestinationUrl;
	private SemplestString DisplayUrl = new SemplestString();
	private String PhoneNumber;
	
	public MsnAdObject(){
		
	}
	
	public MsnAdObject(Ad ad){
		this.fromAd(ad);
	}
	
	public void fromAd(Ad ad){
		if (ad == null) return;
		
		Id = ad.getId();
		Type = ad.getType();
		Status = ad.getStatus();
		EditorialStatus = ad.getEditorialStatus();
		
		if(ad.getType() == ad.getType().Text){
			//Text Ad
			TextAd ad1 = (TextAd)ad;
			Title = ad1.getTitle();
			Text = ad1.getText();
			DestinationUrl = ad1.getDestinationUrl();
			DisplayUrl.setSemplestString(ad1.getDisplayUrl());
		}
		else{
			//Mobile Ad
			MobileAd ad1 = (MobileAd)ad;
			Title = ad1.getTitle();
			Text = ad1.getText();
			DestinationUrl = ad1.getDestinationUrl();
			DisplayUrl.setSemplestString(ad1.getDisplayUrl());
			BusinessName = ad1.getBusinessName();
			PhoneNumber = ad1.getPhoneNumber();
		}
	}
	
	public Ad toAd(){
		Ad ret = new Ad();		
		
		if(Type == AdType.Text){
			//Text Ad
			TextAd ret1 = new TextAd();
			ret1.setTitle(Title);
			ret1.setText(Text);
			ret1.setDisplayUrl(DisplayUrl.getSemplestString());
			ret1.setDestinationUrl(DestinationUrl);			
			ret = ret1;
		}
		else{
			//Mobile Ad
			MobileAd ret1 = new MobileAd();
			ret1.setTitle(Title);
			ret1.setText(Text);
			ret1.setDisplayUrl(DisplayUrl.getSemplestString());
			ret1.setDestinationUrl(DestinationUrl);			
			ret = ret1;
		}
		
		ret.setId(Id);
		ret.setType(Type);
		ret.setStatus(Status);
		ret.setEditorialStatus(EditorialStatus);
		
		return ret;
	}
	
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public AdType getType() {
		return Type;
	}
	public void setType(AdType type) {
		Type = type;
	}
	public AdStatus getStatus() {
		return Status;
	}
	public void setStatus(AdStatus status) {
		Status = status;
	}
	public AdEditorialStatus getEditorialStatus() {
		return EditorialStatus;
	}
	public void setEditorialStatus(AdEditorialStatus editorialStatus) {
		EditorialStatus = editorialStatus;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getText() {
		return Text;
	}
	public void setText(String text) {
		Text = text;
	}
	public String getBusinessName() {
		return BusinessName;
	}
	public void setBusinessName(String businessName) {
		BusinessName = businessName;
	}
	public String getDestinationUrl() {
		return DestinationUrl;
	}
	public void setDestinationUrl(String destinationUrl) {
		DestinationUrl = destinationUrl;
	}
	public SemplestString getDisplayUrl() {
		return DisplayUrl;
	}
	public void setDisplayUrl(SemplestString displayUrl) {
		DisplayUrl = displayUrl;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

}
