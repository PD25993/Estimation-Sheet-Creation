package com.walgreens.goforwardestimateapp.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class FeaturesComponent {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long featureId;
	private String featureName;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="project_id")
	private ProjectDetails projectDetails;
	
    @OneToMany(mappedBy="featuresComponent",cascade=CascadeType.PERSIST)
	private List<Items> devComponents= new ArrayList<Items>();
    
    @OneToMany(mappedBy="featuresComponent",cascade=CascadeType.PERSIST)
    private List<QAComponent> qaComponents=new ArrayList<QAComponent>();
	
   

	public FeaturesComponent() {
		super();

	}
	
	
	
	public FeaturesComponent(Long featureId, String featureName, ProjectDetails projectDetails, List<Items> devComponents,List<QAComponent> qaComponent) {
		super();
		this.featureId = featureId;
		this.featureName = featureName;
		this.projectDetails = projectDetails;
		this.devComponents = devComponents;
		this.qaComponents=qaComponent;
	}
	public Long getFeatureId() {
		return featureId;
	}
	public void setFeatureId(Long featureId) {
		this.featureId = featureId;
	}
	public ProjectDetails getProjectDetails() {
		return projectDetails;
	}
	public void setProjectDetails(ProjectDetails projectDetails) {
		this.projectDetails = projectDetails;
	}
	public String getFeatureName() {
		return featureName;
	}
	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}
	public List<Items> getDevComponents() {
		return devComponents;
	}
	public void setDevComponents(List<Items> devComponents) {
		this.devComponents = devComponents;
	}
	 public List<QAComponent> getQaComponents() {
			return qaComponents;
		}

		public void setQaComponents(List<QAComponent> qaComponents) {
			this.qaComponents = qaComponents;
		}

	@Override
	public String toString() {
		return "FeaturesComponent [featureId=" + featureId + ", featureName=" + featureName + ", projectDetails="+ projectDetails
				+"]";
		
	}

	public void addItems(Items item){
		System.out.println("In addItems : "+item.toString());
		devComponents.add(item);
		item.setFeaturesComponent(this);
	}
	public void addQAComponent(QAComponent qa) {
		System.out.println("In addQAComponent : "+qa.toString());
		this.qaComponents.add(qa);
		qa.setFeaturesComponent(this);
	}
}
