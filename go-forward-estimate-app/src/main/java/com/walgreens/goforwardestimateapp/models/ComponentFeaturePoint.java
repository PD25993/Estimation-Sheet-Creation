package com.walgreens.goforwardestimateapp.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ComponentFeaturePoint {
	
	@Id
	private Long id;
	private String category;
	private String complexityName;
	private String complexityType;
	@Override
	public String toString() {
		return "ComponentFeaturePoint [id=" + id + ", category=" + category + ", complexityName=" + complexityName
				+ ", complexityType=" + complexityType + ", weightage=" + weightage + "]";
	}
	private Double weightage;
	
	public String getComplexityType() {
		return complexityType;
	}
	public void setComplexityType(String complexityType) {
		this.complexityType = complexityType;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getComplexityName() {
		return complexityName;
	}
	public void setComplexityName(String complexityName) {
		this.complexityName = complexityName;
	}
	public Double getWeightage() {
		return weightage;
	}
	public void setWeightage(Double weightage) {
		this.weightage = weightage;
	}
	public ComponentFeaturePoint(Long id, String category, String complexityName, String complexityType,
			Double weightage) {
		super();
		this.id = id;
		this.category = category;
		this.complexityName = complexityName;
		this.complexityType = complexityType;
		this.weightage = weightage;
	}
	public ComponentFeaturePoint() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
