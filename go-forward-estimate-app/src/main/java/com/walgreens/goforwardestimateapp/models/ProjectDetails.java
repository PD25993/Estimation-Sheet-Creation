package com.walgreens.goforwardestimateapp.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ProjectDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long projectId;
	private String projectName;
	
	 @OneToMany(mappedBy="projectDetails",cascade=CascadeType.ALL)
	 private List<FeaturesComponent> projectFeaturesComponents = new ArrayList<FeaturesComponent>();
	 
	
	 
	public Long getProjectId() {
		return projectId;
	}


	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<FeaturesComponent> getProjectFeaturesComponents() {
		return projectFeaturesComponents;
	}

	public void setProjectFeaturesComponents(List<FeaturesComponent> projectFeaturesComponents) {
		this.projectFeaturesComponents = projectFeaturesComponents;
	}

	
	public ProjectDetails(String projectName, List<FeaturesComponent> projectFeaturesComponents) {
		super();
		this.projectName = projectName;
		this.projectFeaturesComponents = projectFeaturesComponents;
	}

	public ProjectDetails() {
		super();
		
	}

	
	@Override
	public String toString() {
		return "ProjectDetails [projectId=" + projectId + ", projectName=" + projectName
				+ ", projectFeaturesComponents=" + projectFeaturesComponents + "]";
	}


	public void addFeatures(FeaturesComponent features){
		System.out.println("In addFeatures : "+features.toString());
		projectFeaturesComponents.add(features);
		features.setProjectDetails(this);
	}
	
}
