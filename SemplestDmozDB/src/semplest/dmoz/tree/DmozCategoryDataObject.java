package semplest.dmoz.tree;

import java.util.HashMap;
import java.util.Map;

public class DmozCategoryDataObject {
	private Long categoryId;
	private String description;
	private Map<String,String> urlData = new HashMap<String,String>();
	
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
	public Map<String, String> getUrlData() {
		return urlData;
	}
	public void setUrlData(Map<String, String> urlData) {
		this.urlData = urlData;
	}
	
	public void addUrlData(Map<String, String> urlData){
		this.urlData.putAll(urlData);
	}
	
	public void addUrlData(String url, String urlDesc){
		this.urlData.put(url, urlDesc);
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
