package com.walgreens.goforwardestimateapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walgreens.goforwardestimateapp.mapper.ProjectDetailsMapper;
import com.walgreens.goforwardestimateapp.models.ComponentFeaturePoint;
import com.walgreens.goforwardestimateapp.models.FeaturesComponent;
import com.walgreens.goforwardestimateapp.models.Items;
import com.walgreens.goforwardestimateapp.models.ProjectDetails;
import com.walgreens.goforwardestimateapp.models.QAComponent;
import com.walgreens.goforwardestimateapp.models.QAComponentFeaturePoint;
import com.walgreens.goforwardestimateapp.repository.IComponentFeaturePointRepository;
import com.walgreens.goforwardestimateapp.repository.IFeatureRepository;
import com.walgreens.goforwardestimateapp.repository.IProjectsRepository;
import com.walgreens.goforwardestimateapp.repository.IQAComponentFeaturePointRepository;
import com.walgreens.goforwardestimateapp.vo.Features;
import com.walgreens.goforwardestimateapp.vo.ItemWeightage;
import com.walgreens.goforwardestimateapp.vo.ItemsVO;
import com.walgreens.goforwardestimateapp.vo.ProjectDetailsVO;
import com.walgreens.goforwardestimateapp.vo.QAComponentVO;


@Service
@Transactional
public class ProjectDetailsService {

	@Autowired
	private IProjectsRepository iProjectsRepository;
	@Autowired
	private ProjectDetailsMapper projectDetailsMapper;
	@Autowired
	private IFeatureRepository iFeatureRepository;
	@Autowired
	private IComponentFeaturePointRepository iComponentFeaturePointRepository;
	@Autowired
	private IQAComponentFeaturePointRepository iQAComponentFeaturePointRepository;
	
	/*public void saveProjectDetails(ProjectDetailsVO projectDetailsVO)
	{
		ProjectDetails projectDetails = new ProjectDetails();
		projectDetails.setProjectName(projectDetailsVO.getProjectName());
		List<FeaturesComponent> listOfFeaturesComponent = projectDetailsVO.getFeaturesComponent();
		for(FeaturesComponent fc : listOfFeaturesComponent)
		{
			projectDetails.addFeatures(fc);
		}
		
		System.out.println("Project Details Model : "+projectDetails.toString());
		
		iProjectsRepository.save(projectDetails);
		
	}*/
	
	
	public ProjectDetailsVO saveProjectDetails(ProjectDetailsVO projectDetailsVO)
	{
		ProjectDetails projectDetails = new ProjectDetails();
		ProjectDetails projectDetailsForSave = new ProjectDetails();
		ProjectDetailsVO projectDetailsVO1=new ProjectDetailsVO();
		projectDetailsVO1.setProjectName(projectDetailsVO.getProjectName());
		
		List<FeaturesComponent> featureComponenetList = new ArrayList<>();
		List<Features> featureComponenetList1 = new ArrayList<>();
		List<Items> itemDetails = new ArrayList<>();
		Items itemToSave = new Items();
		List<FeaturesComponent> listOfFeaturesComponent = new ArrayList<>();
		//System.out.println("Project Details Model before mapper calling : "+projectDetailsVO.toString());
		
		projectDetails=projectDetailsMapper.projectDetailsVOToProjectDetails(projectDetailsVO);
		

		
		System.out.println("Project Details Model after mapper : "+projectDetails.toString());
		
		//System.out.println("Project Details Model listOfFeaturesComponent : "+projectDetails.getProjectFeaturesComponents().toString());
			
		projectDetailsForSave.setProjectName(projectDetails.getProjectName());
		

		
		
		featureComponenetList= projectDetails.getProjectFeaturesComponents();
		featureComponenetList1=projectDetailsVO.getProjectFeaturesComponents();
		for(FeaturesComponent fc : featureComponenetList)
		{
			//System.out.println("fc : " + fc.toString());
			FeaturesComponent featuresComponentToSave = new FeaturesComponent();
			if(fc.getFeatureName() != null) {
				for(Items it : fc.getDevComponents()) {
					if(it != null) {
						
						//System.out.println("it : " + it.toString());
						featuresComponentToSave.addItems(it);
						
					}
				}
				for(QAComponent qa:fc.getQaComponents()) {
					if(qa !=null) {
						featuresComponentToSave.addQAComponent(qa);
					}
				}
				}
				
				
				
			featuresComponentToSave.setFeatureName(fc.getFeatureName());
			listOfFeaturesComponent.add(featuresComponentToSave);
				
			}
		for(FeaturesComponent featureComponentVar : listOfFeaturesComponent) {
			System.out.println(featureComponentVar);
			projectDetailsForSave.addFeatures(featureComponentVar);
		}
		
		iProjectsRepository.save(projectDetailsForSave);
		//iProjectsRepository.save(projectDetails);
		
//		For weightage Calculation
		List<ComponentFeaturePoint> componentList=new ArrayList<>();
		System.out.println("*****************************************Inside Service*****************************************************\n");
		System.out.println(featureComponenetList1);
		System.out.println("\n**********************************************************************************************");
		//List<ItemWeightage> weightageList=new ArrayList<>();
		for(Features fc : featureComponenetList1)
		{
			//System.out.println("fc : " + fc.toString());
			if(!fc.getFeatureName().isEmpty()) {
				for(ItemsVO it : fc.getDevComponents()) {
					Double wtg=1.00;
					if(!it.getItemName().isEmpty()) {
						String var="";
						if(it.getItemType().equals("Service"))
							var="Service Factors";
						else if(it.getItemType().equals("Batch job"))
							var="Batch Factors";
						else if(it.getItemType().equals("UI"))
							var="UI Factors";
							System.out.println("***************\n"+it.getItemType()+":"+var+"\n********************************");
							componentList.clear();
							componentList.addAll(iComponentFeaturePointRepository.findComponentFeaturePoint(var));
							System.out.println("************************arrayList saved****************************");
							System.out.println(componentList.toString());
							System.out.println("*************************************************************************");
							for(ComponentFeaturePoint cfp: componentList) {
								if(cfp.getComplexityName().equals("Component Complexity")) {
									if(cfp.getComplexityType().equals(it.getComponentComplexityForItem())) {
										System.out.println("***"+cfp.getWeightage()+"***");
										wtg=wtg*cfp.getWeightage();
										System.out.println(wtg);
									}
								}
								else if(cfp.getComplexityName().equals("Degree of Change")) {
									if(cfp.getComplexityType().equals(it.getDegreeOfChangesForItem())) {
										System.out.println("***"+cfp.getWeightage()+"***");
										wtg=wtg*cfp.getWeightage();
										System.out.println(wtg);
									}
								}
								else if(cfp.getComplexityName().equals("Technology")) {
									if(cfp.getComplexityType().equals(it.getTechnologyForItem())) {
										System.out.println("***"+cfp.getWeightage()+"***");
										wtg=wtg*cfp.getWeightage();
										System.out.println(wtg);
									}
								}
								
								
							}
							
						
					}
					System.out.println(wtg);
					System.out.println(it.getItemName());
					if(!it.getItemName().isEmpty()) {
						/*ItemWeightage itemWeightage=new ItemWeightage(it.getItemName(),fc.getFeatureName(),projectDetails.getProjectName(),wtg);
						weightageList.add(itemWeightage);*/
						it.setWeightage(wtg);
					}
					
				}
			}
		}
		
//		End of weightage calculation
		//Score Calculation for QAComponent
		
		List<QAComponentFeaturePoint> scoreList=iQAComponentFeaturePointRepository.findAll();
		for(Features fc : featureComponenetList1)
		{
			//System.out.println("fc : " + fc.toString());
			if(!fc.getFeatureName().isEmpty()) {
				for(QAComponentVO qa : fc.getQaComponents()) {
					Double score=1.0;
					for(QAComponentFeaturePoint sl:scoreList) {
						if(sl.getComplexityName().equals("Test Data")) {
							if(sl.getComplexityType().equals(qa.getTestDataComplexity())) {
								score=score*sl.getScore();
							}
						}
						if(sl.getComplexityName().equals("Validation")) {
							if(sl.getComplexityType().equals(qa.getValidationComponent())) {
								score=score*sl.getScore();
							}
						}
						if(sl.getComplexityName().equals("Requirement")) {
							if(sl.getComplexityType().equals(qa.getRequirementComplexity())) {
								score=score*sl.getScore();
							}
						}
						if(sl.getComplexityName().equals("Validation Point")) {
							if(sl.getComplexityType().equals(Long.toString(qa.getValidationPoints()))) {
								score=score*sl.getScore();
							}
						}
					}
					qa.setScore(score);
				}
			}
		}
		projectDetailsVO1.setProjectFeaturesComponents(featureComponenetList1);
		return projectDetailsVO1;
	}
	
}
