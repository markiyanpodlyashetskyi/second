package com.buy_it.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.buy_it.entity.Category;

public interface CategoryDao extends JpaRepository<Category, Integer> {
	
	@Transactional
	@Modifying
	@Query("delete from Category c where c.categoryName=:name")
	void delete(@Param(value = "name") String name);

	
	
	@Query("select c from Category c where c.categoryName=:name")
	Category findByName(@Param(value = "name") String name);

}
