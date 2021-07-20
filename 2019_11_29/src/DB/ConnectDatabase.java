package DB;
import java.sql.*;
public class ConnectDatabase {
       public static Connection makeConnection()
       {
    	   String url = "jdbc:mysql://localhost/hanshindb?characterEncoding=UTF-8&serverTimezone=UTC";
             String id = "root";
             String password = "1234";
             Connection con = null;
             try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    System.out.println("드라이버 적재 성공");
                    con = DriverManager.getConnection(url, id, password);
                    System.out.println("데이터베이스 연결 성공");
             } catch (ClassNotFoundException e) {
                    System.out.println("드라이버를 찾을 수 없습니다.");
             } catch (SQLException e) {
            	 System.out.println(e.toString());
                    System.out.println("연결에 실패하였습니다.");
             }
             return con;
       }

       public static void main(String arg[]) throws SQLException {
    	   Connection con = makeConnection();
           Statement stmt = con.createStatement();
           ResultSet rs = stmt.executeQuery("SELECT * FROM 과목");
           while (rs.next()) {
                  String id = rs.getString("과목번호");
                  String title = rs.getString("이름");
                  String room = rs.getString("강의실");
                  String dept = rs.getString("개설학과");
                  int time = rs.getInt("시수");
                  System.out.println(id + "  " + title+" "+room+" "+dept+" "+time);
           }
       }
}