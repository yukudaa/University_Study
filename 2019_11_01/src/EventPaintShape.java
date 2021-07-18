import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class EventPaintShape extends JFrame implements ItemListener{
	MyPanel panel = new MyPanel();
	JPanel bpanel = new JPanel();
	JRadioButton button[] = new JRadioButton[3];
  
   public EventPaintShape() {
      setTitle("이벤트 처리");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(500,500);
      ButtonGroup group = new ButtonGroup();
      button[0] = new JRadioButton("사각형", true);
      button[1] = new JRadioButton("타원", true);
      button[2] = new JRadioButton("이미지", true);
      for(int i = 0; i<3;i++) {
    	  group.add(button[i]);
    	  bpanel.add(button[i]);
      }
      add(bpanel, BorderLayout.NORTH);
      add(panel,BorderLayout.CENTER);
      setVisible(true);
   }   
   public void itemStatechanged(ItemEvent e) {
	   if(e.getStateChange() == ItemEvent.DESELECTED)
		   return;
	   if(button[0].isSelected())
		   type=0;
	   else if(button[1].isSelected())
		   type=1;
	   else if(button[2].isSelected())
		   type=2;
	  repaint(0); 
	   
   }
   public static void main(String[] args) {
	      // TODO Auto-generated method stub
	      new EventPaintShape();
	   }

   class MyPanel extends JPanel {	  
      public void paintComponent(Graphics g) {
         super.paintComponent(g);
         switch(type) {
         case 0:
        	 g.drawRect(10,10,getWidth()-20, getHeight()-20);
         
         case 1:
    	  g.drawOval(10,10,getWidth()-20, getHeight()-20);
     	 
         case 2:
    	  g.drawRect(10,10,getWidth()-20, getHeight()-20);
   }
         g.drawRect(10,10,getWidth()-20, getHeight()-20);
      }       
}
   }