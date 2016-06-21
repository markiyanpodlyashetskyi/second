package com.buy_it.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.buy_it.entity.Category;
import com.buy_it.serviceImpl.CategoryServiceImpl;

@Controller
public class CategoryController {

   
	@Autowired
	private CategoryServiceImpl categoryServiceImpl;
	
	@RequestMapping(value = "/saveCategory", method=RequestMethod.GET)
	public String save(Model model){
		model.addAttribute("categories", categoryServiceImpl.getAll());
				
		return "saveCategoryjsp";
	}	
	

	@RequestMapping(value = "/saveCategory", method=RequestMethod.POST)
	public String saveCategory(String nameCategory){
		categoryServiceImpl.saveCategory(new Category(nameCategory));
		return "redirect:/saveCategoryjsp";
	}
	

	@RequestMapping(value = "/deleteCategory/{id}")
	public String deleteCategory(@PathVariable String id){
		categoryServiceImpl.delete(Integer.parseInt(id));
		return "redirect:/saveCategoryjsp";
	}
	
	
	
	
	@RequestMapping(value = "/deleteCtagoryByName", method=RequestMethod.POST)
	public String deleteCategoryByName(@RequestParam String categoryName){
		categoryServiceImpl.delete(categoryName);
		return "redirect:/saveCategoryjsp";
	}
	
	
	
	@RequestMapping(value="/updateCategory/{id}")
	public String updateCategory(@PathVariable String id, Model model){
		model.addAttribute("category", categoryServiceImpl.findOne(Integer.parseInt(id)));
		return "updateCategory";
	}
	
	@RequestMapping (value="/updateCategory/{id}", method=RequestMethod.POST)
	public String update(@PathVariable String id, @RequestParam String newCategoryName){
		Category category = categoryServiceImpl.findOne(Integer.parseInt(id));
		category.setCategoryName(newCategoryName);
		categoryServiceImpl.saveCategory(category);
		return "redirect:/saveCategoryjsp";
	}
	
	
	
	
	
	
	
	
	
	
}