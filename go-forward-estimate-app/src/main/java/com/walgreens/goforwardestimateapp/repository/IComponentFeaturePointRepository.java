package com.walgreens.goforwardestimateapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.walgreens.goforwardestimateapp.models.ComponentFeaturePoint;

@Repository
public interface IComponentFeaturePointRepository extends JpaRepository<ComponentFeaturePoint, Long>{
	
	
	

	
	@Query("select c from ComponentFeaturePoint c where c.category=:category")
    List<ComponentFeaturePoint> findComponentFeaturePoint(@Param("category") String category);
	
	

}
