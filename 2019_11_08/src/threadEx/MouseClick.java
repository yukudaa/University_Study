package threadEx;
import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
public class MouseClick extends JFrame{
   MyPanel panel = new MyPanel();
   int x=50, y=50;
   boolean flag = true;
   public MouseClick() {
      setTitle("flag 를 이용한 종료");
      setSize(500,500);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      setContentPane(panel);
   
      setVisible(true);
      panel.addMouseListener(new MouseAdapter() {
         public void mousePressed(MouseEvent e) {
            flag = false;
         }
      });
   RandomThread th = new RandomThread();
   th.start();
   }
   public static void main(String[] args) {
      new MouseClick();
   }
   class MyPanel extends JPanel {
      public void paintComponent(Graphics g) {
         super.paintComponent(g);
         g.setColor(Color.BLUE);
         if(flag==true)
            g.fillOval(x,y,15,15);
         else
            g.drawString("finish",x,y);
      }
   }
   class RandomThread extends Thread {
      public void run() {
         while(true) {
            x=(int)(Math.random()*getWidth());
            y=(int)(Math.random()*getHeight());
            try {
               if(flag==true) {
               sleep(300);
               repaint();
               }else return;
            }catch(InterruptedException e){
               return;
            }
            
         }
      }
   }
}