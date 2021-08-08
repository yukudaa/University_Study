package com.hanshin.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class project1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbc_driver = "com.mysql.cj.jdbc.Driver";
		String jdbc_url = "jdbc:mysql://localhost:3306/databasetest?serverTimezone=UTC";
		try {
			Class.forName(jdbc_driver).newInstance();
			Connection con = DriverManager.getConnection(jdbc_url, "root", "1234");
			Statement st = con.createStatement();
			String sql1 = "CREATE TABLE dbProject " + "(id VARCHAR(45) not NULL, " + "pw VARCHAR(45),"
					+ " name VARCHAR(45), " + " tell VARCHAR(45), " + " email VARCHAR(60), " + " dept VARCHAR(60), "
					+ "gender VARCHAR(45)," + "birth VARCHAR(60)," + "intro VARCHAR(200)," + "PRIMARY KEY ( id ))";
			st.executeUpdate(sql1);
			String sql = "SELECT * FROM databasetest.dbProject";

			ResultSet rs = st.executeQuery(sql);
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
