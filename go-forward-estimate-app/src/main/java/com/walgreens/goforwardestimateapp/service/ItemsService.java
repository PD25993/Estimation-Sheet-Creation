package com.walgreens.goforwardestimateapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walgreens.goforwardestimateapp.models.Items;
import com.walgreens.goforwardestimateapp.repository.IItemsRepository;


@Service
public class ItemsService {

	@Autowired
	private IItemsRepository itemsRepository;
	
	public List<Items> getAllItems() {
		return itemsRepository.findAll();
	}
	
	public Items addItem(Items item)
	{
		return itemsRepository.save(item);
	}
}
