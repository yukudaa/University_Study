import javax.swing.*;
import java.awt.*;

public class DrawStringEx extends JFrame{

	
		private MyPanel panel = new MyPanel();
		
		public DrawStringEx() {
			setTitle("drawString 사용 예제");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setContentPane(panel);
			setSize(500,500);
			setVisible(true);
		}

		class MyPanel extends JPanel{
			public void paintComponent(Graphics g) {
				super.paintComponent(g);;
				g.drawString("자바는 재밌다~~",30,30);
				g.setColor(new Color(255,0,0));
				g.drawString("얼마나? 하늘만큼땅만큼!!", 60, 60);
				g.setColor(Color.green);		
				Font f = new Font("궁서체",Font.ITALIC,30);
				g.setFont(f);
				g.drawString("자바는 어렵다??", 30, 90);
				
				/*for(int i = 0; i <5; i++) {
					g.setColor(new Color(100+100*i, 0, 50+50*i));
					g.setFont(new Font("굴림체", Font.BOLD, 10+10*i));
					g.drawString("자바는.........", 20, 120+10*i);
				}*/
				
				
			}
		}
		public static void main(String[] args) {
			new DrawStringEx();
	}

}
