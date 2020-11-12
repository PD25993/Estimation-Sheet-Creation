package com.walgreens.goforwardestimateapp.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.walgreens.goforwardestimateapp.models.FeaturesComponent;
import com.walgreens.goforwardestimateapp.vo.Features;

@Mapper(uses= {ItemMapper.class}, componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FeaturesMapper {
	
	FeaturesMapper INSTANCE = Mappers.getMapper(FeaturesMapper.class);

	Features featuresComponentToFeatures(FeaturesComponent featuresComponent);

	FeaturesComponent featuresToFeaturesComponent(Features features);

}
