package com.walgreens.goforwardestimateapp.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Items {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long itemId;
	private String itemName;
	
	private String itemType;
	private String newOrModify;
	private String componentComplexityForItem;
	private String degreeOfChangesForItem;
	private String technologyForItem;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name="feature_id")
	private FeaturesComponent featuresComponent;
	

	public FeaturesComponent getFeaturesComponent() {
		return featuresComponent;
	}

	public void setFeaturesComponent(FeaturesComponent featuresComponent) {
		this.featuresComponent = featuresComponent;
	}

	public Items(Long itemId, String itemName, String itemType, String newOrModify, String componentComplexityForItem,
			String degreeOfChangesForItem, String technologyForItem, FeaturesComponent featuresComponent) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemType = itemType;
		this.newOrModify = newOrModify;
		this.componentComplexityForItem = componentComplexityForItem;
		this.degreeOfChangesForItem = degreeOfChangesForItem;
		this.technologyForItem = technologyForItem;
		this.featuresComponent = featuresComponent;
	}

	public Items() {
		super();
	}
	


	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	/*public FeaturesComponent getFeatureComponent() {
		return featureComponent;
	}

	public void setFeatureComponent(FeaturesComponent featureComponent) {
		this.featureComponent = featureComponent;
	}*/

	public String getNewOrModify() {
		return newOrModify;
	}
	public void setNewOrModify(String newOrModify) {
		this.newOrModify = newOrModify;
	}
	public String getComponentComplexityForItem() {
		return componentComplexityForItem;
	}
	public void setComponentComplexityForItem(String componentComplexityForItem) {
		this.componentComplexityForItem = componentComplexityForItem;
	}
	public String getDegreeOfChangesForItem() {
		return degreeOfChangesForItem;
	}
	public void setDegreeOfChangesForItem(String degreeOfChangesForItem) {
		this.degreeOfChangesForItem = degreeOfChangesForItem;
	}

	
	public String getTechnologyForItem() {
		return technologyForItem;
	}

	public void setTechnologyForItem(String technologyForItem) {
		this.technologyForItem = technologyForItem;
	}

	@Override
	public String toString() {
		return "Items [itemId=" + itemId + ", itemName=" + itemName + ", itemType=" + itemType + ", newOrModify="
				+ newOrModify + ", componentComplexityForItem=" + componentComplexityForItem
				+ ", degreeOfChangesForItem=" + degreeOfChangesForItem + ", technologyForItem=" + technologyForItem 
				+ "]";
				//+ ", featuresComponent=" + featuresComponent + "]";
				//
	}
	
	

}
