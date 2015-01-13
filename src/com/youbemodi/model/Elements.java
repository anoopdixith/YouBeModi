package com.youbemodi.model;

import java.util.ArrayList;
import java.util.List;

public class Elements {
	private String elementName = "";
	private Integer numberOfVariables = 0;
	private List<Variables> listOfVariables = new ArrayList<Variables>();
	
	public String getElementName() {
		return elementName;
	}
	public void setElementName(String elementName) {
		this.elementName = elementName;
	}
	public Integer getNumberOfVariables() {
		return numberOfVariables;
	}
	public void setNumberOfVariables(Integer numberOfVariables) {
		this.numberOfVariables = numberOfVariables;
	}
	public List<Variables> getListOfVariables() {
		return listOfVariables;
	}
	public void setListOfVariables(List<Variables> listOfVariables) {
		this.listOfVariables = listOfVariables;
	} 
	
}
