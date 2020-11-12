package com.walgreens.goforwardestimateapp.vo;

public class ItemWeightage {
	String itemName;
	String featuresName;
	String projectName;
	Double itemWeightage;
	
	
	
	public ItemWeightage(String itemName, String featuresName, String projectName, Double itemWeightage) {
		super();
		this.itemName = itemName;
		this.featuresName = featuresName;
		this.projectName = projectName;
		this.itemWeightage = itemWeightage;
	}

	
	
	
	public String getItemName() {
		return itemName;
	}
	
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Double getItemWeightage() {
		return itemWeightage;
	}
	public void setItemWeightage(Double itemWeightage) {
		this.itemWeightage = itemWeightage;
	}
	/*public ItemWeightage(String itemName, Double itemWeightage) {
		super();
		this.itemName = itemName;
		this.itemWeightage = itemWeightage;
	}*/

	public ItemWeightage() {
		// TODO Auto-generated constructor stub
	}
}
