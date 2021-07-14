//5주차 실습 2
package Java_GUI;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class MouseEventEx extends JFrame {
	
	JLabel label = new JLabel("Hello");
	MouseEventEx() {   
      setTitle("Mouse 이벤트 예제");
      setSize(300, 300);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      Container cp = getContentPane();
      setLayout(null);
      label.setSize(50, 20);
      label.setLocation(30, 30);
      cp.add(label);
      cp.addMouseListener(new MyMouseListener());
      setVisible(true);
   }

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      new MouseEventEx();
   }

   class MyMouseListener implements MouseListener {

      @Override
      public void mouseClicked(MouseEvent e) {
         // TODO Auto-generated method stub
         
      }

      @Override
      public void mousePressed(MouseEvent e) {
         // TODO Auto-generated method stub
         int x = e.getX();
         int y = e.getY();
         label.setLocation(x,y);
      }

      @Override
      public void mouseReleased(MouseEvent e) {
         // TODO Auto-generated method stub
         
      }

      @Override
      public void mouseEntered(MouseEvent e) {
         // TODO Auto-generated method stub
         
      }

      @Override
      public void mouseExited(MouseEvent e) {
         // TODO Auto-generated method stub
         
      }
      
   }
}