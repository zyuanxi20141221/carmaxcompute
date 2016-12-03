package com.goopai.carmaxcompute.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.goopai.carmaxcompute.dao.CarDao;
import com.goopai.carmaxcompute.db.DBHelper;
import com.goopai.carmaxcompute.db.PageBean;
import com.goopai.carmaxcompute.domain.Car;

public class CarDaoImpl implements CarDao {

	public int count(String name) {
		int count = 0;
		String sql = "select count(*) as aa from " + name;
		ResultSet rs;
		try {
			rs = DBHelper.executeQuery(sql);
			if (rs.next()) {
				count = rs.getInt("aa");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	/* (non-Javadoc)
	 * @see com.goopai.carmaxcompute.dao.impl.CarDao#getCarnewsChaSQL(java.lang.String, com.goopai.carmaxcompute.db.PageBean)
	 */
	@Override
	public List getCarnewsChaSQL(PageBean page) {
		List<Car> list = new ArrayList<>();
		if (page != null) {
			if (page.getTotalCount() == 0) {
				page.setTotalCount(count("car_news"));
			}
			String sqlString = "select * from car_news limit " + page.getStart() + "," + page.getPageSize();
			System.out.println("sql:" + sqlString);
			try {
				ResultSet rs = DBHelper.executeQuery(sqlString);
				while (rs.next()) {
					long id = rs.getLong("id");
					String title = rs.getString("title");
					String pubtime = rs.getString("publish_time");
					String source = rs.getString("source");
					String category = rs.getString("category");
					String author = rs.getString("author");
					String content = rs.getString("content");
					Date createtime = rs.getDate("create_time");
					String keywords = rs.getString("keywords");
					Car car = new Car(id, title, pubtime, source, category, author, content, createtime, keywords);
					list.add(car);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see com.goopai.carmaxcompute.dao.impl.CarDao#getAllCarNews()
	 */
	@Override
	public List getAllCarNews() {

		List<Car> list = new ArrayList<>();
		String sql = "select * from car_news limit 50";
		ResultSet rs = null;
		try {
			rs = DBHelper.executeQuery(sql);
			while (rs.next()) {
				long id = rs.getLong("id");
				String title = rs.getString("title");
				String pubtime = rs.getString("publish_time");
				String source = rs.getString("source");
				String category = rs.getString("category");
				String author = rs.getString("author");
				String content = rs.getString("content");
				Date createtime = rs.getDate("create_time");
				String keywords = rs.getString("keywords");
				Car car = new Car(id, title, pubtime, source, category, author, content, createtime, keywords);
				list.add(car);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
	
	/* (non-Javadoc)
	 * @see com.goopai.carmaxcompute.dao.impl.CarDao#getCarBeanById(int)
	 */
	@Override
	public Car getCarBeanById(int id){
		Car car = null;
		String sql = "select * from car_news where id = '"+id+"'";
		ResultSet rs = null;
		try {
			rs = DBHelper.executeQuery(sql);
			if(rs.next()){
				long _id = rs.getLong("id");
				String title = rs.getString("title");
				String pubtime = rs.getString("publish_time");
				String source = rs.getString("source");
				String category = rs.getString("category");
				String author = rs.getString("author");
				String content = rs.getString("content");
				Date createtime = rs.getDate("create_time");
				String keywords = rs.getString("keywords");
				car = new Car(_id, title, pubtime, source, category, author, content, createtime, keywords);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return car;
	}
}
