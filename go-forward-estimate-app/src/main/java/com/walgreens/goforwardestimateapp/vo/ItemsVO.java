package com.walgreens.goforwardestimateapp.vo;

public class ItemsVO {
	
	
	private String itemName;
	
	private String itemType;
	

	private String newOrModify;
	private String componentComplexityForItem;
	private String degreeOfChangesForItem;
	private String technologyForItem;
	private Double weightage;

	public ItemsVO(String itemName, String itemType, String newOrModify, String componentComplexityForItem,
			String degreeOfChangesForItem, String technologyForItem, Double weightage) {
		super();
		this.itemName = itemName;
		this.itemType = itemType;
		this.newOrModify = newOrModify;
		this.componentComplexityForItem = componentComplexityForItem;
		this.degreeOfChangesForItem = degreeOfChangesForItem;
		this.technologyForItem = technologyForItem;
		this.weightage = weightage;
	}

	public Double getWeightage() {
		return weightage;
	}

	public void setWeightage(Double weightage) {
		this.weightage = weightage;
	}

	public ItemsVO(String itemName, String itemType, String newOrModify, String componentComplexityForItem,
			String degreeOfChangesForItem, String technologyForItem) {
		super();		
		this.itemName = itemName;
		this.itemType = itemType;
		this.newOrModify = newOrModify;
		this.componentComplexityForItem = componentComplexityForItem;
		this.degreeOfChangesForItem = degreeOfChangesForItem;
		this.technologyForItem = technologyForItem;		
	}

	public ItemsVO(String itemName) {
		super();
		this.itemName = itemName;
	}

	public ItemsVO() {
		super();
	}
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/*@Override
	public String toString() {
		return "ItemsVO [itemName=" + itemName + "]";
	}*/
	
	
	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

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
		return "Items [itemName=" + itemName + ", itemType=" + itemType + ", newOrModify=" + newOrModify
				+ ", componentComplexityForItem=" + componentComplexityForItem + ", degreeOfChangesForItem="
				+ degreeOfChangesForItem + ", technologyForItem=" + technologyForItem + "]";
	}

	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((componentComplexityForItem == null) ? 0 : componentComplexityForItem.hashCode());
		result = prime * result + ((degreeOfChangesForItem == null) ? 0 : degreeOfChangesForItem.hashCode());
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((newOrModify == null) ? 0 : newOrModify.hashCode());
		result = prime * result + ((technologyForItem == null) ? 0 : technologyForItem.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemsVO other = (ItemsVO) obj;
		if (componentComplexityForItem == null) {
			if (other.componentComplexityForItem != null)
				return false;
		} else if (!componentComplexityForItem.equals(other.componentComplexityForItem))
			return false;
		if (degreeOfChangesForItem == null) {
			if (other.degreeOfChangesForItem != null)
				return false;
		} else if (!degreeOfChangesForItem.equals(other.degreeOfChangesForItem))
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (newOrModify == null) {
			if (other.newOrModify != null)
				return false;
		} else if (!newOrModify.equals(other.newOrModify))
			return false;
		if (technologyForItem == null) {
			if (other.technologyForItem != null)
				return false;
		} else if (!technologyForItem.equals(other.technologyForItem))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}*/
	
	

}
