package com.walgreens.goforwardestimateapp.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walgreens.goforwardestimateapp.models.Items;
import com.walgreens.goforwardestimateapp.repository.IItemsRepository;

@Service
public class ItemDao {
	
	@Autowired
	IItemsRepository itemRepository;
	
	public List<Items> getAllItems()  {
		List<Items> listProducts= new ArrayList<Items>(); 
		listProducts = itemRepository.findAll();
		return listProducts;
	}
	
	public Items getItemByID(Long id)
	{
		Optional<Items> itemDetailsFindById = itemRepository.findById(id);
		if(itemDetailsFindById.isPresent()) {
			return itemDetailsFindById.get();
		}else {
			return null;
		}
	}
	
	/*public List<Items> getItemByFeatureComponentID(Long featureId)
	{
		List<Items> productDetailsFindByCategoryId = itemRepository.findByFeatureComponent(featureId);
		return productDetailsFindByCategoryId;
	}*/
	
	public Items saveItem(Items items) {
		return itemRepository.saveAndFlush(items);
	}
	
	public void editItem(Items items) {
		itemRepository.save(items);
		
	}
	
	public void deleteItem(Long id) {
		itemRepository.deleteById(id);
	}

}
