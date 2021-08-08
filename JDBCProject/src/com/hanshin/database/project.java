package com.hanshin.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class project {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbc_driver = "com.mysql.cj.jdbc.Driver";
		String jdbc_url = "jdbc:mysql://localhost:3306/databasetest?serverTimezone=UTC";
		try {
			Class.forName(jdbc_driver).newInstance();
			Connection con = DriverManager.getConnection(jdbc_url, "root", "1234");
			Statement st = con.createStatement();
			String sql1 = "CREATE TABLE introduction " + "(id INTEGER not NULL, " + " name VARCHAR(45), "
					+ " tell VARCHAR(45), " + " email VARCHAR(60), " + " address VARCHAR(60), " + "university VARCHAR(45),"
					+ " PRIMARY KEY ( id ))";
			st.executeUpdate(sql1);
			String sql = "SELECT * FROM databasetest.introduction";
	
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				@SuppressWarnings("unused")
				int id = rs.getInt("id ");
				String name = rs.getString("name");
				String tell = rs.getString("tell");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String university = rs.getString("university");
				System.out.printf("id : %d , name : %s ,tell : %s ,email : %s ,address : %s ,university : %s\n", id, name, tell, email,
						address,university);
			}
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}