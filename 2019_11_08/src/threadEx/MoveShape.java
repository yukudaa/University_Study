package threadEx;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class MoveShape extends JFrame{
   MyPanel panel = new MyPanel();
   public MoveShape() {
      setTitle("도형이동 예제");
      setSize(500,500);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      setContentPane(panel);
      Thread t = new Thread(panel);
      t.start();
      setVisible(true);
   }
   public static void main(String[] args) {
      new MoveShape();
   }
   class MyPanel extends JPanel implements Runnable{
      int x1=10, y1=10,x2=10,y2=10;
      public void paintComponent(Graphics g) {
         super.paintComponent(g);
         g.setColor(Color.RED);
         g.fillRect(x1,y1,30,30);
         g.setColor(Color.BLUE);
         g.fillOval(x2,y2,30,30);
      }
      
      public void run() {
         while(true) {
            x1+=10;
            y2+=10;
            if(x1>=getWidth()) x1=0;
            if(y2>=getHeight()) y2=0;
            try {
            Thread.sleep(100);
            repaint();
            }catch(InterruptedException e) {
            return;
            }
            }
         }
   }
}
