
package com.walgreens.goforwardestimateapp.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;


import com.walgreens.goforwardestimateapp.models.QAComponent;
import com.walgreens.goforwardestimateapp.vo.QAComponentVO;


@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QAComponentMapper {

	QAComponentMapper INSTANCE = Mappers.getMapper(QAComponentMapper.class);

	QAComponentVO QAComponentToQAComponentVO(QAComponent qaComponent);

	QAComponent QAComponentVOToQAComponent(QAComponentVO qaComponentVO);

}
