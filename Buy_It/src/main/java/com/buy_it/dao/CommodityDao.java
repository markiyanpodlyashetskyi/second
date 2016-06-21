package com.buy_it.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.buy_it.entity.Commodity;
import org.springframework.transaction.annotation.Transactional;

public interface CommodityDao extends JpaRepository<Commodity, Integer>{

	@Query("select c from Commodity c where c.commodityName=:name")
	Commodity findOneByName(@Param(value = "name") String name);

	@Transactional
	@Modifying
	@Query("delete from Commodity c where c.commodityName=:name")
	void delete(@Param(value = "name") String name);
	
}
