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
      setTitle("���� GUI");
      setSize(300, 300);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      cpanel = new CoursePanel();
      insert = new JButton("�߰�");
      cancel = new JButton("���");
      search = new JButton("�˻�");
      next = new JButton("����");
      prev = new JButton("����");
      home = new JButton("Ȩ");
      home.addMouseListener(new MouseAdapter() {
           public void mouseClicked(MouseEvent r){
              if(home.getText().equals("Ȩ"))
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
             if(cancel.getText().equals("���"))
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
         add(new JLabel("�й�"));
         add(field[0]);
         add(new JLabel("�����ȣ"));
         add(field[1]);
         add(new JLabel("��û��¥"));
         add(field[2]);
         add(new JLabel("�߰�����"));
         add(field[3]);
         add(new JLabel("�⸻����"));
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

   private static void addCourse(String id, String cno, String in_date, int midterm, int fscore) {
      Connection con = makeConnection();
      try {
         Statement stmt = con.createStatement();
         String s = "INSERT INTO ���� (�й�, �����ȣ, ��û��¥, �߰�����, �⸻����) VALUES ";
         s += "('" + id + "','" + cno + "','" + in_date + "','" + midterm + "','" + fscore + "')";
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




