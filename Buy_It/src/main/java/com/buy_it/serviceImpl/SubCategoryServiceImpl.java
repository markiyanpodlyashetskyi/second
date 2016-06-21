package com.buy_it.serviceImpl;

import com.buy_it.dao.CategoryDao;
import com.buy_it.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buy_it.dao.SubCategoryDao;
import com.buy_it.entity.SubCategory;

@Service
public class SubCategoryServiceImpl {
		@Autowired
		private SubCategoryDao subCategoryDao;

		@Autowired
		private CategoryDao categoryDao;

		public void saveSubCategoty(SubCategory subCategory){
			/*if(subCategory.getCategory().equals(null)){
				categoryDao.findByName(subCategory.getCategory().getCategoryName());
			}*/
			subCategoryDao.save(subCategory);
		}
		
		public SubCategory findOne(int id){
			return subCategoryDao.findOne(id);
		}
		
		public Iterable<SubCategory> getAll(){
			return subCategoryDao.findAll();
		}
		
		public void delete(int id){
			subCategoryDao.delete(id);
		}

}
