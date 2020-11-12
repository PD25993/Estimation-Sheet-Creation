package com.walgreens.goforwardestimateapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.walgreens.goforwardestimateapp.models.QAComponent;

@Repository
public interface IQAComponentRepository extends JpaRepository<QAComponent, Long>{

}
