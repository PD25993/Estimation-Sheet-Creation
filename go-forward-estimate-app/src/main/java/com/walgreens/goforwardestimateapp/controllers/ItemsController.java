package com.walgreens.goforwardestimateapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.walgreens.goforwardestimateapp.models.Items;
import com.walgreens.goforwardestimateapp.service.ItemsService;

@Controller
public class ItemsController {

	@Autowired
	private ItemsService itemsService;

	@RequestMapping(value = "/items", produces = "application/json")
	@ResponseBody
	public List<Items> getAllItems() {
		return itemsService.getAllItems();
	}

	@PostMapping(value = "/items", produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Items addItem(@RequestBody Items item) {
		return itemsService.addItem(item);
	}

}
