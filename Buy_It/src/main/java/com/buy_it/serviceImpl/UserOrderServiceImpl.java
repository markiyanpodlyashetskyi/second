package com.buy_it.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buy_it.dao.UserOrderDao;
import com.buy_it.entity.UserOrder;

@Service
public class UserOrderServiceImpl {
	@Autowired
	private UserOrderDao userOrderDao;

	public void save(UserOrder userOrder) {
		userOrderDao.save(userOrder);
	}

	public UserOrder findOne(int id) {
		return userOrderDao.findOne(id);
	}

	public Iterable<UserOrder> getAll() {
		return userOrderDao.findAll();
	}

	public void delete(int id) {
		userOrderDao.delete(id);
	}

}
