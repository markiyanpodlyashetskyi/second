package com.buy_it.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buy_it.dao.CommodityDao;
import com.buy_it.entity.Commodity;

@Service
public class CommodityServiceImpl {

	@Autowired
	private CommodityDao commodityDao;
	
	public void save(Commodity commodity){
		commodityDao.save(commodity);
	}
	
	public Commodity findOneById(int id){
		return commodityDao.findOne(id);
	}
	
	public Commodity findOneByName(String commodityName){
		return commodityDao.findOneByName(commodityName);
	}
	
	public Iterable<Commodity> getAll(){
		return commodityDao.findAll();
	}
	
	public void deleteById(int id){
		commodityDao.delete(id);
	}
	
	public void deleteByName(String commodityName){
		commodityDao.delete(commodityName);
	}
	
}
