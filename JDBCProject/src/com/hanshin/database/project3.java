package com.hanshin.database;

//https://github.com/Yeunwoong/JDBCProject
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class project3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbc_driver = "com.mysql.cj.jdbc.Driver";
		String jdbc_url = "jdbc:mysql://localhost:3306/databasetest?serverTimezone=UTC";
		try {
			Class.forName(jdbc_driver).newInstance();
			Connection con = DriverManager.getConnection(jdbc_url, "root", "1234");
			Statement st = con.createStatement();
			String sql = "SELECT * FROM databasetest.addressbook";
			PreparedStatement st1 = con.prepareStatement("UPDATE databasetest.addressbook SET email = concat(SUBSTRING_INDEX(email, '@', 1), '@naver.com') WHERE NOT email LIKE '%@naver.com'");	
			st1.executeUpdate();			
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				@SuppressWarnings("unused")
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String tell = rs.getString("tell");
				String email = rs.getString("email");
				String address = rs.getString("address");
				System.out.printf("id : %d , name : %s ,tell : %s ,email : %s ,address : %s \n", id, name, tell, email,
						address);
			}
			rs.close();
			st1.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
