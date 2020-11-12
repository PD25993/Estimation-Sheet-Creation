package com.walgreens.goforwardestimateapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walgreens.goforwardestimateapp.models.QAComponent;
import com.walgreens.goforwardestimateapp.repository.IQAComponentRepository;

@Service
public class QAComponentDao {
	
	@Autowired
	private IQAComponentRepository qaComponentRepository;
	
	public List<QAComponent> getAllQAComponents()  {
	
	List<QAComponent> listofQAComponents = qaComponentRepository.findAll();
		return listofQAComponents;
	}
	
	public QAComponent getQAComponentById(Long qaComponentId)
	{
		Optional<QAComponent> qaDetailsById = qaComponentRepository.findById(qaComponentId);
		if(qaDetailsById.isPresent()) {
			return qaDetailsById.get();
		}else {
			return null;
		}
	}
	
	public QAComponent saveQAComponent(QAComponent qaComponent) {
		return qaComponentRepository.save(qaComponent);
	}
	
	public void editQAComponent(QAComponent qaComponent) {
		qaComponentRepository.save(qaComponent);

	}
	
	public void deleteQAComponent(Long qaComponentId) {
		qaComponentRepository.deleteById(qaComponentId);
	}


}
