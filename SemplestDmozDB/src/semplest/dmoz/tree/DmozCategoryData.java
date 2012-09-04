package semplest.dmoz.tree;

import java.util.Arrays;

public class DmozCategoryData {
	private String description;
	private String[] urls;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String[] getUrls() {
		return urls;
	}
	public void setUrls(String[] urls) {
		this.urls = urls;
	}
	
	public boolean isEmpty(){
		if(description == null && urls == null){
			return true;
		}
		return false;
	}
	
	public boolean isInsufficientData(){
		if(this.description == null || urls == null){
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "CategoryData [description=" + description + ", urls="
				+ Arrays.toString(urls) + "]";
	}	
	
}
