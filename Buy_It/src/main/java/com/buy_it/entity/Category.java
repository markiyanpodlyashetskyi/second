package com.buy_it.entity;

import java.util.List;

import javax.persistence.*;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String categoryName;
	@OneToMany(fetch=FetchType.EAGER, cascade={CascadeType.MERGE},mappedBy="category")
	private List<SubCategory>subCategories;
	
	public Category() {
	}
	
	public Category(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public List<SubCategory> getSubCategories() {
		return subCategories;
	}
	public void setSubCategories(List<SubCategory> subCategories) {
		this.subCategories = subCategories;
	}

	@Override
	public String toString() {
		return "Category{" +
				"id=" + id +
				", categoryName='" + categoryName + '\'' +
				'}';
	}
}
