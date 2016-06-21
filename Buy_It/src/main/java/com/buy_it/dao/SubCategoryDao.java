package com.buy_it.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buy_it.entity.SubCategory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SubCategoryDao extends JpaRepository<SubCategory, Integer>{

    @Query("select sub from SubCategory sub where sub.subCategoryName=:name")
    SubCategory findBySubCategoryName(@Param(value = "name") String name);

}
