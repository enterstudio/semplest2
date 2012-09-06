package semplest.dmoz.tree;

import java.util.HashMap;

public class DmozCategoryData {
	private Long categoryId;
	private String description;
	private HashMap<String,String> urlData;
	
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
	public HashMap<String, String> getUrlData() {
		return urlData;
	}
	public void setUrlData(HashMap<String, String> urlData) {
		this.urlData = urlData;
	}
	
	public void addUrlData(HashMap<String, String> urlData){
		this.urlData.putAll(urlData);
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
