package com.hanshin.database;

//https://github.com/Yeunwoong/JDBCProject
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ex3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbc_driver = "com.mysql.cj.jdbc.Driver";
		String jdbc_url = "jdbc:mysql://localhost:3306/databasetest?serverTimezone=UTC";
		try {
			Class.forName(jdbc_driver).newInstance();
			Connection con = DriverManager.getConnection(jdbc_url, "root", "1234");
			//Statement st = con.createStatement(); 
			String sql = "SELECT * FROM databasetest.member";
			PreparedStatement st = con.prepareStatement("INSERT INTO databasetest.member VALUES (?,?,?,?,?)");			
			st.setInt(1, 10);
			st.setString(2, "Park");
			st.setString(3, "1999-02-15");
			st.setString(4, "Art");
			st.setString(5, "park");
			st.executeUpdate();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				@SuppressWarnings("unused")
				int id = rs.getInt("id");
				String userName = rs.getString("username");
				String birth = rs.getString("birth");
				String dept = rs.getString("dept");
				String email = rs.getString("email");
				System.out.printf("id : %d , userName : %s ,birth : %s ,dept : %s ,email : %s \n", id, userName, birth,
						dept, email);
			}
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
