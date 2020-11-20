package com.walgreens.goforwardestimateapp.mapper;

import com.walgreens.goforwardestimateapp.models.FeaturesComponent;
import com.walgreens.goforwardestimateapp.models.ProjectDetails;
import com.walgreens.goforwardestimateapp.vo.Features;
import com.walgreens.goforwardestimateapp.vo.ProjectDetailsVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-08-18T11:53:23+0530",
    comments = "version: 1.3.0.Final, compiler: Eclipse JDT (IDE) 3.13.0.v20170516-1929, environment: Java 1.8.0_92 (Oracle Corporation)"
)
@Component
public class ProjectDetailsMapperImpl implements ProjectDetailsMapper {

    private final FeaturesMapper featuresMapper;

    @Autowired
    public ProjectDetailsMapperImpl(FeaturesMapper featuresMapper) {

        this.featuresMapper = featuresMapper;
    }

    @Override
    public ProjectDetailsVO projectDetailsToProjectDetailsVO(ProjectDetails projectDetails) {
        if ( projectDetails == null ) {
            return null;
        }

        ProjectDetailsVO projectDetailsVO = new ProjectDetailsVO();

        projectDetailsVO.setProjectName( projectDetails.getProjectName() );
        projectDetailsVO.setProjectFeaturesComponents( featuresComponentListToFeaturesList( projectDetails.getProjectFeaturesComponents() ) );

        return projectDetailsVO;
    }

    @Override
    public ProjectDetails projectDetailsVOToProjectDetails(ProjectDetailsVO projectDetailsVO) {
        if ( projectDetailsVO == null ) {
            return null;
        }

        ProjectDetails projectDetails = new ProjectDetails();

        projectDetails.setProjectName( projectDetailsVO.getProjectName() );
        projectDetails.setProjectFeaturesComponents( featuresListToFeaturesComponentList( projectDetailsVO.getProjectFeaturesComponents() ) );

        return projectDetails;
    }

    protected List<Features> featuresComponentListToFeaturesList(List<FeaturesComponent> list) {
        if ( list == null ) {
            return null;
        }

        List<Features> list1 = new ArrayList<Features>( list.size() );
        for ( FeaturesComponent featuresComponent : list ) {
            list1.add( featuresMapper.featuresComponentToFeatures( featuresComponent ) );
        }

        return list1;
    }

    protected List<FeaturesComponent> featuresListToFeaturesComponentList(List<Features> list) {
        if ( list == null ) {
            return null;
        }

        List<FeaturesComponent> list1 = new ArrayList<FeaturesComponent>( list.size() );
        for ( Features features : list ) {
            list1.add( featuresMapper.featuresToFeaturesComponent( features ) );
        }

        return list1;
    }
}
