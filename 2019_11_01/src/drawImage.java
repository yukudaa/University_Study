import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class drawImage extends JFrame{
   private MyPanel panel = new MyPanel();

   public drawImage() {
      setTitle("drawimage 사용 예제");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setContentPane(panel);
      setSize(500,500);
      setVisible(true);
   }   
   class MyPanel extends JPanel {
	   int x=50, y=50;
       public MyPanel() { //생성자 꼭 만들어줘야함
          addMouseListener(new MouseAdapter() {
             public void mouseClicked(MouseEvent e) {
                x=e.getX(); y=e.getY();
                repaint();
             }
          });       
       }

      public void paintComponent(Graphics g) {
         super.paintComponent(g);
         ImageIcon icon=new ImageIcon("images/soccer.jpg");
         Image image=icon.getImage();
        // g.drawImage(image,0,0,getWidth(),getHeight(),this);
         g.drawImage(image,x,y,x+100,y+150,50,50,200,200,this);
      }
   }
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      new drawImage();
   }

}