package DB;
import java.sql.*;

public class SQLInsertTest {
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


       public static void main(String arg[]) {
           addSubject("C007", "�� ���α׷���", "130", "��ǻ��", 3);
     }
      private static void addSubject(String id, String title, String room, String dept,
            int time) {
     Connection con = makeConnection();
     try {
            Statement stmt = con.createStatement();
            String s = "INSERT INTO ���� (�����ȣ, �̸�, ���ǽ�, �����а�, �ü�) VALUES ";
            s += "('" + id + "','" + title + "','" + room + "','"
                         + dept + "','" + time+"')";
            System.out.println(s);
            int i = stmt.executeUpdate(s);
            if (i == 1)
                   System.out.println("���ڵ� �߰� ����");
            else
                   System.out.println("���ڵ� �߰� ����");
     } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.exit(0);
     }
}
}
