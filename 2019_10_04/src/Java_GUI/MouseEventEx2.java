//5주차 실습 3
package Java_GUI;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class MouseEventEx2 extends JFrame{
	   JLabel label = new JLabel("Hello");
	   public MouseEventEx2() {
	      setTitle("마우스 이벤트  예제");
	      setSize(300,300);
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      setLocationRelativeTo(null);
	      Container cp = getContentPane();
	      setLayout(null);
	      label.setSize(50,20);
	      label.setLocation(30,30); 
	      cp.add(label);
	      
	      cp.addMouseListener(new MouseAdapter() {
	         public void mousePressed(MouseEvent e) {
	            int x = e.getX();
	            int y = e.getY();
	            if(e.getButton()==MouseEvent.BUTTON1)
	               label.setText("Hello");
	            else
	               label.setText("안녕");
	            label.setLocation(x, y);
	         }
	      });
	      setVisible(true);
	   }

	   public static void main(String[] args) {
	      // TODO Auto-generated method stub
	      new MouseEventEx();
	   }	   	         	      
	   	 	   
	}

