package com.walgreens.goforwardestimateapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.walgreens.goforwardestimateapp.models.Items;

@Repository
public interface IItemsRepository extends JpaRepository<Items, Long>{
	
	//List<Items> findByFeatureComponent(Long featureId);

}
