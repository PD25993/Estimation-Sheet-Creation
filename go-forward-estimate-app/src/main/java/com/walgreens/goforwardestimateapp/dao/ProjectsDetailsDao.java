package com.walgreens.goforwardestimateapp.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walgreens.goforwardestimateapp.models.ProjectDetails;
import com.walgreens.goforwardestimateapp.repository.IProjectsRepository;

@Service
@Transactional
public class ProjectsDetailsDao {

	@Autowired
	private IProjectsRepository projectsRepository;
	
	public List<ProjectDetails> getAllProjectDetails()  {
		
		List<ProjectDetails> listofProjectDetails = projectsRepository.findAll();
			return listofProjectDetails;
		}
		
		public ProjectDetails getProjectDetailsById(Long projectDetailsId)
		{
			Optional<ProjectDetails> projectDetailsById = projectsRepository.findById(projectDetailsId);
			if(projectDetailsById.isPresent()) {
				return projectDetailsById.get();
			}else {
				return null;
			}
		}
		
		public ProjectDetails saveProjectDetails(ProjectDetails projectDetails) {
			return projectsRepository.save(projectDetails);
		}
		
		public void editProjectDetails(ProjectDetails projectDetails) {
			projectsRepository.save(projectDetails);

		}
		
		public void deleteProjectDetails(Long projectDetailsId) {
			projectsRepository.deleteById(projectDetailsId);
		}
		
}
