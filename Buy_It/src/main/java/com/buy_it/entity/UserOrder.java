package com.buy_it.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
@Entity
public class UserOrder {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToMany
	@JoinTable(name="commodity_userOrder", joinColumns=@JoinColumn(name="id_userOrder"), inverseJoinColumns=@JoinColumn(name="id_commodity"))
	private List<Commodity> commodities;
	@ManyToMany
	@JoinTable(name="user_userOrder", joinColumns=@JoinColumn(name="id_userOrder"), inverseJoinColumns=@JoinColumn(name="id_user"))
	private List<User> users;
	public UserOrder() {
	}
	public UserOrder(List<Commodity> commodities, List<User> users) {
		this.commodities = commodities;
		this.users = users;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Commodity> getCommodities() {
		return commodities;
	}
	public void setCommodities(List<Commodity> commodities) {
		this.commodities = commodities;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
	
}
