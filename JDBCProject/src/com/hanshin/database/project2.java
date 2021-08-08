package com.hanshin.database;

//https://github.com/Yeunwoong/JDBCProject
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class project2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbc_driver = "com.mysql.cj.jdbc.Driver";
		String jdbc_url = "jdbc:mysql://localhost:3306/databasetest?serverTimezone=UTC";
		try {
			Class.forName(jdbc_driver).newInstance();
			Connection con = DriverManager.getConnection(jdbc_url, "root", "1234");
			Statement st = con.createStatement();
			String sql = "SELECT * FROM databasetest.addressbook";
			PreparedStatement st1 = con.prepareStatement("INSERT INTO databasetest.addressbook VALUES (1, 'Lee', '01000000000', 'lee', 'Gimpo')");
			PreparedStatement st2 = con.prepareStatement("INSERT INTO databasetest.addressbook VALUES (2, 'Kim', '01011111111', 'kim', 'Seoul')");
			PreparedStatement st3 = con.prepareStatement("INSERT INTO databasetest.addressbook VALUES (3, 'Lee', '01022222222', 'lee', 'Yangju')");
			PreparedStatement st4 = con.prepareStatement("INSERT INTO databasetest.addressbook VALUES (4, 'Kim', '01033333333', 'kim', 'Seoul')");
			PreparedStatement st5 = con.prepareStatement("INSERT INTO databasetest.addressbook VALUES (5, 'Yang', '01044444444', 'yang', 'Seoul')");
			st1.executeUpdate();
			st2.executeUpdate();
			st3.executeUpdate();
			st4.executeUpdate();
			st5.executeUpdate();
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
			st5.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
