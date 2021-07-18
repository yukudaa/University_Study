package Java_GUI;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class KeyEventEx extends JFrame{
			ImageIcon car = new ImageIcon("images/car.gif");
			ImageIcon ship = new ImageIcon("images/ship.jpg");
		 // JLabel label = new JLabel("Hello");
			JLabel label = new JLabel(car);
		  public KeyEventEx() {
		      setTitle("Key 이벤트  예제");
		      setSize(300,300);
		      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		      setLocationRelativeTo(null);
		      Container cp = getContentPane();
		      setLayout(null);
		      label.setSize(60,50);
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
		    	  public void keyTyped(KeyEvent e) {
		    		  switch(e.getKeyChar()) {
		    		  case 'c' :
		    		  label.setIcon(car);
		    		  break;
		    		  
		    		  case 's' :
			    	  label.setIcon(ship);
			    	  break;
		    		  }
		    	  	
		    	  }
		    	  
		      });
		      setVisible(true);
		   }
		   public static void main(String[] args) {
		      // TODO Auto-generated method stub
		      new KeyEventEx();
		   }	   	         	      		   	 	   
		}