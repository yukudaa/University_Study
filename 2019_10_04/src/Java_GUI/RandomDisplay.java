package Java_GUI;
import java.awt.*;
import javax.swing.*;
public class RandomDisplay extends JFrame{
	public RandomDisplay() {
		setTitle("랜덤레이블 표시");
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		JPanel npanel=new JPanel();
		npanel.add(new JButton("OPEN"));
		npanel.add(new JButton("READ"));
		npanel.add(new JButton("CLOSE"));
		add(npanel, BorderLayout.NORTH);
		JPanel cp=new JPanel();
		cp.setLayout(null);
		JLabel[] label=new JLabel[10];
		for(int i=0; i<label.length; i++) {
			label[i]=new JLabel(Integer.toString(i));
			int x=(int)(Math.random()*150)+50;
			int y=(int)(Math.random()*150)+50;
			label[i].setLocation(x,y);
			label[i].setSize(10,10);
			label[i].setForeground(Color.RED);
			cp.add(label[i]);
		}
		add(cp, BorderLayout.CENTER);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RandomDisplay();
	}

}
