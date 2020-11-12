package com.walgreens.goforwardestimateapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walgreens.goforwardestimateapp.models.FeaturesComponent;
import com.walgreens.goforwardestimateapp.repository.IFeatureRepository;

@Service
public class FeatureService {
	
	@Autowired
	private IFeatureRepository featureRepository;
	
	public FeaturesComponent addFeatureComponent(FeaturesComponent featuresComponent)
	{
		FeaturesComponent newFeatureComponent = featureRepository.save(featuresComponent);
		return newFeatureComponent;
	}

}
