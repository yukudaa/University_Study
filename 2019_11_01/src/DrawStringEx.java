import javax.swing.*;
import java.awt.*;

public class DrawStringEx extends JFrame{

	
		private MyPanel panel = new MyPanel();
		
		public DrawStringEx() {
			setTitle("drawString ��� ����");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setContentPane(panel);
			setSize(500,500);
			setVisible(true);
		}

		class MyPanel extends JPanel{
			public void paintComponent(Graphics g) {
				super.paintComponent(g);;
				g.drawString("�ڹٴ� ��մ�~~",30,30);
				g.setColor(new Color(255,0,0));
				g.drawString("�󸶳�? �ϴø�ŭ����ŭ!!", 60, 60);
				g.setColor(Color.green);		
				Font f = new Font("�ü�ü",Font.ITALIC,30);
				g.setFont(f);
				g.drawString("�ڹٴ� ��ƴ�??", 30, 90);
				
				/*for(int i = 0; i <5; i++) {
					g.setColor(new Color(100+100*i, 0, 50+50*i));
					g.setFont(new Font("����ü", Font.BOLD, 10+10*i));
					g.drawString("�ڹٴ�.........", 20, 120+10*i);
				}*/
				
				
			}
		}
		public static void main(String[] args) {
			new DrawStringEx();
	}

}
