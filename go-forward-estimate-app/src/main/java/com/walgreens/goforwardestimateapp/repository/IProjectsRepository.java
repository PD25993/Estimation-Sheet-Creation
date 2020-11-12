package com.walgreens.goforwardestimateapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.walgreens.goforwardestimateapp.models.ProjectDetails;

@Repository
public interface IProjectsRepository extends JpaRepository<ProjectDetails, Long>{

}
