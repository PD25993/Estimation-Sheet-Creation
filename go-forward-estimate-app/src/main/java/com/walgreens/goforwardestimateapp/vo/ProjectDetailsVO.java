package com.walgreens.goforwardestimateapp.vo;

import java.util.ArrayList;
import java.util.List;


public class ProjectDetailsVO {

	private String projectName;
	private List<Features> projectFeaturesComponents=new ArrayList<>();
	public ProjectDetailsVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ProjectDetailsVO [projectName=" + projectName + ", projectFeaturesComponents=" + projectFeaturesComponents + "]";
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public List<Features> getProjectFeaturesComponents() {
		return projectFeaturesComponents;
	}
	public void setProjectFeaturesComponents(List<Features> projectFeaturesComponents) {
		this.projectFeaturesComponents = projectFeaturesComponents;
	}
	public ProjectDetailsVO(String projectName, List<Features> projectFeaturesComponents) {
		super();
		this.projectName = projectName;
		this.projectFeaturesComponents = projectFeaturesComponents;
	}
	
	
	
	
}

