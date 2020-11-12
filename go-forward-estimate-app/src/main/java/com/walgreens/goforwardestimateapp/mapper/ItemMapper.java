package com.walgreens.goforwardestimateapp.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;


import com.walgreens.goforwardestimateapp.models.Items;

import com.walgreens.goforwardestimateapp.vo.ItemsVO;


@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ItemMapper {

	ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);

	ItemsVO ItemsToItemsVO(Items items);

	Items ItemsVOToItems(ItemsVO itemvVO);

}
