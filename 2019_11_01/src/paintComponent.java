import javax.swing.*;
import java.awt.*;

public class paintComponent extends JFrame {

	private MyPanel panel = new MyPanel();
	public paintComponent() {
		setTitle("drawRectangle 사용 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(500,500);
		setVisible(true);
	}

	class MyPanel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);;
			g.setColor(Color.blue);	
			/*int x = 0;
			int y = 0;
			for(int i = 0; i < 9; i++) {
				g.drawLine(getWidth()/10 + x, 0, getWidth()/10 + x, getHeight());
				g.drawLine(0, getHeight()/10 + y, getWidth(), getHeight()/10 + y);
				x += getWidth()/10;
				y += getHeight()/10;
			}*/
			int dw = getWidth()/10;
			int dh = getHeight()/10;
			for(int i = 0; i <10 ; i++)
				g.drawLine(0, dh*i, getWidth(),dh*i);
			for(int j = 0; j <10 ;j ++)
				g.drawLine(dh*j, 0, dh*j,getHeight());
			
		}
	}
	public static void main(String[] args) {
		new paintComponent();

	}

}
