//5�� �ǽ�5
package Java_GUI;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class KeyEventEx2 extends JFrame{
		  JLabel label = new JLabel("Hello");		 
		  public KeyEventEx2() {
		      setTitle("Key �̺�Ʈ  ����");
		      setSize(300,300);
		      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		      setLocationRelativeTo(null);
		      Container cp = getContentPane();
		      setLayout(null);
		      label.setSize(50,20);
		      label.setLocation(30,30); 
		      cp.add(label);
		      cp.setFocusable(true);
		      cp.requestFocus();
		      cp.addKeyListener(new KeyAdapter() {
		    	  public void keyPressed(KeyEvent e) {
		    		  switch(e.getKeyCode()) {
		    		  case KeyEvent.VK_UP:
		    			  label.setLocation(label.getX(), label.getY()-10);	  
		    			  break;
		    		  case KeyEvent.VK_DOWN:
		    			  label.setLocation(label.getX(), label.getY()+10);
		    			  break;
		    		  case KeyEvent.VK_RIGHT:
		    			  label.setLocation(label.getX()+10, label.getY());
		    			  break;
		    		  case KeyEvent.VK_LEFT:
		    			  label.setLocation(label.getX()-10, label.getY());
		    			  break;		    			  
		    		  }
		    	  	
		    	  }
		      });
		      cp.addMouseListener(new MouseAdapter() {
		    	  public void mousePressed(MouseEvent e) {
		    		  cp.setBackground(Color.BLUE);
		    	  }
		    	  public void mouseReleased(MouseEvent e) {
		    		  cp.setBackground(Color.YELLOW);
		    	  }
		      });
		      setVisible(true);
		   }
		   public static void main(String[] args) {
		      // TODO Auto-generated method stub
		      new KeyEventEx2();
		   }	   	         	      		   	 	   
		}
