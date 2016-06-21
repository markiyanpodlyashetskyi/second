package com.buy_it.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CommodityImage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String extention;
	@ManyToOne(fetch=FetchType.LAZY)
	private Commodity commodity;
	public CommodityImage() {
	}
	public CommodityImage(int id, String extention) {
		this.id = id;
		this.extention = extention;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getExtention() {
		return extention;
	}
	public void setExtention(String extention) {
		this.extention = extention;
	}
	public Commodity getCommodity() {
		return commodity;
	}
	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

}
