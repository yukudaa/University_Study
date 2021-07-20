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


       public static void main(String arg[]) {
           addSubject("C007", "웹 프로그래밍", "130", "컴퓨터", 3);
     }
      private static void addSubject(String id, String title, String room, String dept,
            int time) {
     Connection con = makeConnection();
     try {
            Statement stmt = con.createStatement();
            String s = "INSERT INTO 과목 (과목번호, 이름, 강의실, 개설학과, 시수) VALUES ";
            s += "('" + id + "','" + title + "','" + room + "','"
                         + dept + "','" + time+"')";
            System.out.println(s);
            int i = stmt.executeUpdate(s);
            if (i == 1)
                   System.out.println("레코드 추가 성공");
            else
                   System.out.println("레코드 추가 실패");
     } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.exit(0);
     }
}
}
