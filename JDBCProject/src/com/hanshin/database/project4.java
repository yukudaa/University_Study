package com.hanshin.database;

//https://github.com/Yeunwoong/JDBCProject
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class project4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbc_driver = "com.mysql.cj.jdbc.Driver";
		String jdbc_url = "jdbc:mysql://localhost:3306/databasetest?serverTimezone=UTC";
		try {
			Class.forName(jdbc_driver).newInstance();
			Connection con = DriverManager.getConnection(jdbc_url, "root", "1234");
			Statement st = con.createStatement();
			String sql = "SELECT * FROM databasetest.addressbook";
			String sql1 = "DELETE FROM databasetest.addressbook WHERE id = 4 ";
			String sql2 = "DELETE FROM databasetest.addressbook WHERE id = 5 ";
			st.executeUpdate(sql1);
			st.executeUpdate(sql2);
			// st.executeUpdate(sql2);
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
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
