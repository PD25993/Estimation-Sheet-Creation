package com.walgreens.goforwardestimateapp.vo;



public class QAComponentVO {

    private String testDataComplexity;
    private String validationComponent;
    private String requirementComplexity;
    private Long validationPoints;
    private Double score;
    
    public QAComponentVO(String testDataComplexity, String validationComponent, String requirementComplexity,
			Long validationPoints, Double score) {
		super();
		this.testDataComplexity = testDataComplexity;
		this.validationComponent = validationComponent;
		this.requirementComplexity = requirementComplexity;
		this.validationPoints = validationPoints;
		this.score = score;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public QAComponentVO()
    {
        super();
    }
    
    public QAComponentVO(String testDataComplexity, String validationComponent,
            String requirementComplexity, Long validationPoints) {
        super();
        this.testDataComplexity = testDataComplexity;
        this.validationComponent = validationComponent;
        this.requirementComplexity = requirementComplexity;
        this.validationPoints = validationPoints;
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

    @Override
    public String toString() {
        return "QAComponent [testDataComplexity=" + testDataComplexity + ", validationComponent=" + validationComponent
                + ", requirementComplexity=" + requirementComplexity + ", validationPoints=" + validationPoints + "]";
    }

}
