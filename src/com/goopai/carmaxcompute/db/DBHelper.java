package com.goopai.carmaxcompute.db;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;

public class DBHelper {

	private static Connection connection = null;
	private static java.sql.PreparedStatement psmt = null;
	

	private static Connection getConnection() throws SQLException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		connection = (Connection) DriverManager.getConnection("jdbc:mysql://120.25.83.231:3306/goopai_car_db", "didiphp", "DotDeeMy365com");
		return connection;
	}

	public static ResultSet executeQuery(String sql) throws SQLException {
		ResultSet rs = null;
        psmt = getConnection().prepareStatement(sql);
        rs = psmt.executeQuery();
		return rs;
	}
}
