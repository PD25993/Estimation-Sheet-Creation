package com.walgreens.goforwardestimateapp.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class QAComponentFeaturePoint {
	@Id
	private Long id;
	private String complexityName;
	private String complexityType;
	private Double score;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getComplexityName() {
		return complexityName;
	}
	public void setComplexityName(String complexityName) {
		this.complexityName = complexityName;
	}
	public String getComplexityType() {
		return complexityType;
	}
	public void setComplexityType(String complexityType) {
		this.complexityType = complexityType;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public QAComponentFeaturePoint(Long id, String complexityName, String complexityType, Double score) {
		super();
		this.id = id;
		this.complexityName = complexityName;
		this.complexityType = complexityType;
		this.score = score;
	}
	public QAComponentFeaturePoint() {
		super();
	}
	
	
	
	
	
	
}
