package com.buy_it.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buy_it.entity.UserOrder;

public interface UserOrderDao extends JpaRepository<UserOrder, Integer>{

}
