package semplest.dmoz.tree;

import java.util.HashMap;

public class DmozCategoryData {
	private Long categoryId;
	private String description;
	private HashMap<String,String> urlsAndDescs;
	
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
	public HashMap<String, String> getUrlsAndDescs() {
		return urlsAndDescs;
	}
	public void setUrlsAndDescs(HashMap<String, String> urlsAndDescs) {
		this.urlsAndDescs = urlsAndDescs;
	}

	
	public boolean isEmpty(){
		if(description == null && urlsAndDescs == null){
			return true;
		}
		return false;
	}
	
	public boolean isInsufficientData(){
		if(this.description == null || urlsAndDescs == null || urlsAndDescs.size() == 0){
			return true;
		}
		return false;
	}
	
}
