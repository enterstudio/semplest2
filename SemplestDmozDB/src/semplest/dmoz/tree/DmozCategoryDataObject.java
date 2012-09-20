package semplest.dmoz.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DmozCategoryDataObject {
	private Long categoryId;
	private String description;
	private List<UrlDataObject> urlData = new ArrayList<UrlDataObject>();
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public List<UrlDataObject> getUrlData() {
		return urlData;
	}
	public void setUrlData(List<UrlDataObject> urlData) {
		this.urlData = urlData;
	}
	
	public void addUrlData(List<UrlDataObject> urlData){
		this.urlData.addAll(urlData);
	}
	
	public void addUrlData(String url, String urlDesc){
		UrlDataObject newData = new UrlDataObject();
		newData.setUrl(url);
		newData.setUrlDescription(urlDesc);
		this.urlData.add(newData);
	}
	
	public void addUrlData(Long urlDataPK, String url, String urlDesc){
		UrlDataObject newData = new UrlDataObject();
		newData.setUrlDataPK(urlDataPK);
		newData.setUrl(url);
		newData.setUrlDescription(urlDesc);
		this.urlData.add(newData);
	}
	
	public boolean isEmpty(){
		if(description == null && urlData == null){
			return true;
		}
		return false;
	}
	
	public boolean isInsufficientData(){
		if(this.description == null || urlData == null || urlData.size() == 0){
			return true;
		}
		return false;
	}
	
}
