package com.walgreens.goforwardestimateapp.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.walgreens.goforwardestimateapp.models.ProjectDetails;
import com.walgreens.goforwardestimateapp.vo.ProjectDetailsVO;

@Mapper(uses= {FeaturesMapper.class}, componentModel = "spring", 
		injectionStrategy=InjectionStrategy.CONSTRUCTOR, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProjectDetailsMapper {
	
	ProjectDetailsMapper INSTANCE = Mappers.getMapper(ProjectDetailsMapper.class);
	
	//@Mapping(target="featuresDetails",source="projectDetails.projectFeaturesComponents")
	ProjectDetailsVO projectDetailsToProjectDetailsVO(ProjectDetails projectDetails);
	

	//@InheritInverseConfiguration
	ProjectDetails projectDetailsVOToProjectDetails(ProjectDetailsVO projectDetailsVO);
}
