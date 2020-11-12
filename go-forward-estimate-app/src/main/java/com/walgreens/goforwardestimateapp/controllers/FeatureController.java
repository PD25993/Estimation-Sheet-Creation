package com.walgreens.goforwardestimateapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.walgreens.goforwardestimateapp.models.FeaturesComponent;
import com.walgreens.goforwardestimateapp.service.FeatureService;

@RestController
public class FeatureController {

	@Autowired
	private FeatureService featureService;

	@PostMapping("/feature")
	public FeaturesComponent addFeature(@RequestBody FeaturesComponent featuresComponent) {
		FeaturesComponent newFeatureComponent = featureService.addFeatureComponent(featuresComponent);
		return newFeatureComponent;
	}

}
