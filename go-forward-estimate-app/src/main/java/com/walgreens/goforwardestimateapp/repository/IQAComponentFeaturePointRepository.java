package com.walgreens.goforwardestimateapp.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.walgreens.goforwardestimateapp.models.QAComponentFeaturePoint;
@Repository
public interface IQAComponentFeaturePointRepository extends JpaRepository<QAComponentFeaturePoint, Long>{
	
	

}
