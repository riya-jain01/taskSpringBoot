package com.products.app.modal;

import org.springframework.beans.factory.annotation.Value;

public class Request {
	
	@Value("${static-api-key}")
	private String apiKey;	
	private String country;	
	private String category;
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getApiKey() {
		return apiKey;
	}
	@Override
	public String toString() {
		return "Request [apiKey=" + apiKey + ", country=" + country + ", category=" + category + "]";
	}	
}
