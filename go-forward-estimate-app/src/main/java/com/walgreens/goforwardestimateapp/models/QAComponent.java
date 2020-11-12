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
public class QAComponent {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long qaComponentId;
	private String testDataComplexity;
	private String validationComponent;
	private String requirementComplexity;
	private Long validationPoints;
	@ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name="feature_id")
	private FeaturesComponent featuresComponent;
	
	public QAComponent()
	{
		super();
	}
	
	public QAComponent(Long qaComponentId, String testDataComplexity, String validationComponent,
			String requirementComplexity, Long validationPoints,FeaturesComponent featuresComponent) {
		super();
		this.qaComponentId = qaComponentId;
		this.testDataComplexity = testDataComplexity;
		this.validationComponent = validationComponent;
		this.requirementComplexity = requirementComplexity;
		this.validationPoints = validationPoints;
		this.featuresComponent=featuresComponent;
	}

	public Long getQaComponentId() {
		return qaComponentId;
	}
	public void setQaComponentId(Long qaComponentId) {
		this.qaComponentId = qaComponentId;
	}
	public String getTestDataComplexity() {
		return testDataComplexity;
	}
	public void setTestDataComplexity(String testDataComplexity) {
		this.testDataComplexity = testDataComplexity;
	}
	public String getValidationComponent() {
		return validationComponent;
	}
	public void setValidationComponent(String validationComponent) {
		this.validationComponent = validationComponent;
	}
	public String getRequirementComplexity() {
		return requirementComplexity;
	}
	public void setRequirementComplexity(String requirementComplexity) {
		this.requirementComplexity = requirementComplexity;
	}
	
	
	public Long getValidationPoints() {
		return validationPoints;
	}

	public void setValidationPoints(Long validationPoints) {
		this.validationPoints = validationPoints;
	}
	
	
	
	

	public FeaturesComponent getFeaturesComponent() {
		return featuresComponent;
	}

	public void setFeaturesComponent(FeaturesComponent featuresComponent) {
		this.featuresComponent = featuresComponent;
	}

	@Override
	public String toString() {
		return "QAComponent [testDataComplexity=" + testDataComplexity + ", validationComponent=" + validationComponent
				+ ", requirementComplexity=" + requirementComplexity + ", validationPoints=" + validationPoints + "]";
	}
	

}
