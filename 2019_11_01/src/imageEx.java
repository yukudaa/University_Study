import javax.swing.*;
import java.awt.*;

public class imageEx extends JFrame{
   private MyPanel panel = new MyPanel();

   public imageEx() {
      setTitle("drawimage 사용 예제");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setContentPane(panel);
      setSize(500,500);
      setVisible(true);
   }   
   class MyPanel extends JPanel {
      public void paintComponent(Graphics g) {
         super.paintComponent(g);
         ImageIcon icon=new ImageIcon("images/soccer.jpg");
         Image image=icon.getImage();
         // g.drawImage(image,100,50,200,200,50,50,150,100,this);
         g.drawImage(image,0,0,getWidth(),getHeight(),this);
      }
   }
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      new imageEx();
   }

}
