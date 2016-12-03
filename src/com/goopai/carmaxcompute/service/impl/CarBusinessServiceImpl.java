package com.goopai.carmaxcompute.service.impl;

import java.util.List;
import com.goopai.carmaxcompute.dao.CarDao;
import com.goopai.carmaxcompute.dao.impl.CarDaoImpl;
import com.goopai.carmaxcompute.db.PageBean;
import com.goopai.carmaxcompute.domain.Car;

public class CarBusinessServiceImpl {

	private CarDao carDao = new CarDaoImpl();
	
	public List<Car> getCarNewsList(){
		return carDao.getAllCarNews();
	}
	
	public Car getCarNewsById(int id){
		return carDao.getCarBeanById(id);
	}
	
	public List<Car> getCarNewsByPage(PageBean page){
		return carDao.getCarnewsChaSQL(page);
	}
}
