package com.youbemodi.model;

import java.util.ArrayList;
import java.util.List;

public class QualityDetails {
	private String qualityName = "";
	private Long quantity = 0L;
	private Integer numberOfElements = 0;
	private List<Quality> listOfQualities = new ArrayList<Quality>();
	
	public String getName() {
		return qualityName;
	}
	public void setName(String name) {
		this.qualityName = name;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Integer getNumberOfElements() {
		return numberOfElements;
	}
	public void setNumberOfElements(Integer numberOfElements) {
		this.numberOfElements = numberOfElements;
	}
	public List<Quality> getListOfQualities() {
		return listOfQualities;
	}
	public void setListOfQualities(List<Quality> listOfQualities) {
		this.listOfQualities = listOfQualities;
	}
}
