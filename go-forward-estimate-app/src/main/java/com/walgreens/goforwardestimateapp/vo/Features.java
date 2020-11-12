package com.walgreens.goforwardestimateapp.vo;

import java.util.List;

import org.springframework.util.AutoPopulatingList;


public class Features {
	
	private String featureName;
	private List<ItemsVO> devComponents;
	private List<QAComponentVO> qaComponents;
	//private AutoPopulatingList<ItemsVO> devComponents = new AutoPopulatingList<ItemsVO>(ItemsVO.class);
	
	public Features() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Features(String featureName, List<ItemsVO> devComponents,List<QAComponentVO> qaComponents) {
		super();
		this.featureName = featureName;
		this.devComponents = devComponents;
		this.qaComponents=qaComponents;
	}



	public String getFeatureName() {
		return featureName;
	}

	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}

	public List<ItemsVO> getDevComponents() {
		return devComponents;
	}

	public void setDevComponents(List<ItemsVO> devComponents) {
		this.devComponents = devComponents;
	}
	
	
	

	public List<QAComponentVO> getQaComponents() {
		return qaComponents;
	}

	public void setQaComponents(List<QAComponentVO> qaComponents) {
		this.qaComponents = qaComponents;
	}

	@Override
	public String toString() {
		return "Features [featureName=" + featureName + ", devComponents=" + devComponents + "]";
	}
	

}
