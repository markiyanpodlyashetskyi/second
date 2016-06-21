package com.buy_it.serviceImpl;

import javax.swing.text.StyledEditorKit.ItalicAction;

import com.buy_it.dao.SubCategoryDao;
import com.buy_it.entity.SubCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.buy_it.dao.CategoryDao;
import com.buy_it.entity.Category;

@Service
public class CategoryServiceImpl {

	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private SubCategoryDao subCategoryDao;
	
	public void saveCategory(Category category){
		categoryDao.save(category);
	}
	
	public Category findOne(int id){
		return categoryDao.findOne(id);
	}
	
	public Iterable<Category> getAll(){
		return categoryDao.findAll();
	}
	
	public void delete(String categoryName){
		categoryDao.delete(categoryName);

	}

	public Category findCategoryByName(String categoryName){
		return categoryDao.findByName(categoryName);
	}

	public void delete(int id){
		categoryDao.delete(id);
	};
}
