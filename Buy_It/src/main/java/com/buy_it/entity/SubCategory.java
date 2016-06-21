package com.buy_it.entity;

import java.util.List;

import javax.persistence.*;

@Entity
public class SubCategory {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String subCategoryName;
	@ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.MERGE)
	private Category category;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="subCategory")
	private List<Commodity> commodities;
	public SubCategory() {
	}
	public SubCategory(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubCategoryName() {
		return subCategoryName;
	}
	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public List<Commodity> getCommodities() {
		return commodities;
	}
	public void setCommodities(List<Commodity> commodities) {
		this.commodities = commodities;
	}

	@Override
	public String toString() {
		return "SubCategory{" +
				"id=" + id +
				", subCategoryName='" + subCategoryName + '\'' +
				", category=" + category +
				'}';
	}
}
