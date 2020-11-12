package com.walgreens.goforwardestimateapp.controllers;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.AutoPopulatingList;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.walgreens.goforwardestimateapp.models.FeaturesComponent;
import com.walgreens.goforwardestimateapp.service.ProjectDetailsService;
import com.walgreens.goforwardestimateapp.vo.Features;
import com.walgreens.goforwardestimateapp.vo.ItemWeightage;
import com.walgreens.goforwardestimateapp.vo.ItemsVO;
import com.walgreens.goforwardestimateapp.vo.ProjectDetailsVO;
import com.walgreens.goforwardestimateapp.vo.QAComponentVO;


@Controller
public class ProjectController {
	
	@Autowired
	private ProjectDetailsService projectDetailsService;
	
	@RequestMapping(value = "/redirect_page", method = RequestMethod.GET)
    public String redirect() {
        return "redirect:createNewEstimate";
    }
	
	@RequestMapping(value = "/createNewEstimate", method = RequestMethod.GET)
    public ModelAndView showForm(ModelMap model) {
    	ModelAndView modelAndView=new ModelAndView();
    	ProjectDetailsVO projectDetails = new ProjectDetailsVO();
    	AutoPopulatingList<ItemsVO> items=new AutoPopulatingList<ItemsVO>(ItemsVO.class);
    	AutoPopulatingList<QAComponentVO> qas=new AutoPopulatingList<QAComponentVO>(QAComponentVO.class);
    	Features feSingleVO=new Features();
    	AutoPopulatingList<Features> features = new AutoPopulatingList<Features>(Features.class);
    	feSingleVO.setDevComponents(items);
    	feSingleVO.setQaComponents(qas);
    	features.add(feSingleVO);
    	projectDetails.setProjectFeaturesComponents(features);
    	
    	model.addAttribute("projectDetails", projectDetails);
        modelAndView.addAllObjects(model);
        modelAndView.setViewName("createNewEstimate");
        return modelAndView;
    }

	@RequestMapping(value = "/addProject", method = RequestMethod.POST)
    public ModelAndView submit(@Validated @ModelAttribute("projectDetails")ProjectDetailsVO projectDetails, 
    		ModelAndView model) {
		
		ProjectDetailsVO projectDetails1=new ProjectDetailsVO();
		//List<ItemWeightage> itemWeightage=new ArrayList<>();
    	Double totWtg=0.0,totScore=0.0;
		model.addObject("projectName", projectDetails.getProjectName());
		for(int i=0;i< projectDetails.getProjectFeaturesComponents().size();i++) {
			if(projectDetails.getProjectFeaturesComponents().get(i).getFeatureName()==null)
				projectDetails.getProjectFeaturesComponents().remove(i);
			/*else	
				projectFeatureList.add(projectDetails.getProjectFeaturesComponents().get(i));*/
		}
        
        model.setViewName("projectView");
        if(projectDetails != null) {
        	System.out.println("***************************Inside project Controller ** add project*************************************");
        	System.out.println(projectDetails.getProjectFeaturesComponents());
        	System.out.println("****************************************************************");
        	
        	projectDetails1=projectDetailsService.saveProjectDetails(projectDetails);
        	
        }
        System.out.println("****************Project Controller***************");
        System.out.println(projectDetails1.toString());
        model.addObject("ProjectDetails",projectDetails1);
        model.addObject("projectFeatureList", projectDetails1.getProjectFeaturesComponents());
        for(Features fc:projectDetails1.getProjectFeaturesComponents()) {
        	for(ItemsVO it:fc.getDevComponents()) {
        		totWtg=totWtg+it.getWeightage();
        	}
        	for(QAComponentVO qa:fc.getQaComponents()) {
        		totScore=totScore+qa.getScore();
        	}
        }
        /*model.addObject("itemWeightageList",itemWeightage);*/
        model.addObject("totWtg", totWtg);
        model.addObject("totSc", totScore);
        
        
        return model;
    }

}
