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
                    System.out.println("����̹� ���� ����");
                    con = DriverManager.getConnection(url, id, password);
                    System.out.println("�����ͺ��̽� ���� ����");
             } catch (ClassNotFoundException e) {
                    System.out.println("����̹��� ã�� �� �����ϴ�.");
             } catch (SQLException e) {
            	 System.out.println(e.toString());
                    System.out.println("���ῡ �����Ͽ����ϴ�.");
             }
             return con;
       }

       public static void main(String arg[]) throws SQLException {
    	   Connection con = makeConnection();
           Statement stmt = con.createStatement();
           ResultSet rs = stmt.executeQuery("SELECT * FROM ����");
           while (rs.next()) {
                  String id = rs.getString("�����ȣ");
                  String title = rs.getString("�̸�");
                  String room = rs.getString("���ǽ�");
                  String dept = rs.getString("�����а�");
                  int time = rs.getInt("�ü�");
                  System.out.println(id + "  " + title+" "+room+" "+dept+" "+time);
           }
       }
}