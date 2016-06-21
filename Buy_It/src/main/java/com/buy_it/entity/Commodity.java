package com.buy_it.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Commodity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String commodityName;

	private int price;
	@ManyToOne(fetch=FetchType.EAGER)
	private SubCategory subCategory;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="commodity")
	private List<CommodityImage> commodityImages;
	@ManyToMany
	@JoinTable(name="commodity_userOrder", joinColumns=@JoinColumn(name="id_commodity"), inverseJoinColumns=@JoinColumn(name="id_userOrder"))
	private List<UserOrder> userOrders;
	
	public Commodity() {
	}

	public Commodity(String commodityName, int price) {
		this.commodityName = commodityName;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	public List<CommodityImage> getCommodityImages() {
		return commodityImages;
	}

	public void setCommodityImages(List<CommodityImage> commodityImages) {
		this.commodityImages = commodityImages;
	}

	public List<UserOrder> getUserOrders() {
		return userOrders;
	}

	public void setUserOrders(List<UserOrder> userOrders) {
		this.userOrders = userOrders;
	}
}
