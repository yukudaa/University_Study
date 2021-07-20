package DB;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.sql.*;
import java.io.*;
import java.util.*;

public class CourseGUI extends JFrame {
   CoursePanel cpanel;
   JPanel bpanel = new JPanel();
   JTextField[] field = new JTextField[5];
   JButton insert, cancel, search, next, prev, home;

   public CourseGUI() {
      setTitle("수강 GUI");
      setSize(300, 300);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      cpanel = new CoursePanel();
      insert = new JButton("추가");
      cancel = new JButton("취소");
      search = new JButton("검색");
      next = new JButton("다음");
      prev = new JButton("이전");
      home = new JButton("홈");
      home.addMouseListener(new MouseAdapter() {
           public void mouseClicked(MouseEvent r){
              if(home.getText().equals("홈"))
              bpanel.removeAll();
            bpanel.setVisible(false);
            bpanel.add(insert);
            bpanel.add(cancel);
            bpanel.add(search);
            bpanel.setVisible(true);
               
           }
      });
      
      bpanel.add(insert);
      bpanel.add(cancel);
      bpanel.add(search);
      insert.addActionListener(cpanel);
      search.addActionListener(cpanel);
      add(cpanel, BorderLayout.CENTER);
      add(bpanel, BorderLayout.SOUTH);
      
      cancel.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent h){
             if(cancel.getText().equals("취소"))
              for(int i = 0;i<5;i++) {
                 field[i].setText("");
              }
          }
     });
      setVisible(true);
   }

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      new CourseGUI();
   }

   class CoursePanel extends JPanel implements ActionListener {

      public CoursePanel() {
         for (int i = 0; i < 5; i++)
            field[i] = new JTextField();

         setLayout(new GridLayout(5, 2));
         add(new JLabel("학번"));
         add(field[0]);
         add(new JLabel("과목번호"));
         add(field[1]);
         add(new JLabel("신청날짜"));
         add(field[2]);
         add(new JLabel("중간성적"));
         add(field[3]);
         add(new JLabel("기말성적"));
         add(field[4]);
      }

      public void actionPerformed(ActionEvent e) {

         if (e.getSource() == insert) {
            String id = field[0].getText();
            String cno = field[1].getText();
            String in_date = field[2].getText();
            int midterm = Integer.parseInt(field[3].getText());
            int fscore = Integer.parseInt(field[4].getText());

            addCourse(id, cno, in_date, midterm, fscore);
         } 
          else if (e.getSource() == search) {
            bpanel.removeAll();
            bpanel.setVisible(false);
            bpanel.add(next);
            bpanel.add(prev);
            bpanel.add(home);
            bpanel.setVisible(true);                     
          }
         
         
      }
   }

   public static Connection makeConnection() {
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

   private static void addCourse(String id, String cno, String in_date, int midterm, int fscore) {
      Connection con = makeConnection();
      try {
         Statement stmt = con.createStatement();
         String s = "INSERT INTO 수강 (학번, 과목번호, 신청날짜, 중간성적, 기말성적) VALUES ";
         s += "('" + id + "','" + cno + "','" + in_date + "','" + midterm + "','" + fscore + "')";
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




