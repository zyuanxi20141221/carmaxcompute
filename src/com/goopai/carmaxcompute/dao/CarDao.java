package com.goopai.carmaxcompute.dao;

import java.util.List;
import com.goopai.carmaxcompute.db.PageBean;
import com.goopai.carmaxcompute.domain.Car;

public interface CarDao {

	public abstract List getCarnewsChaSQL(PageBean page);

	public abstract List getAllCarNews();

	public abstract Car getCarBeanById(int id);

}