package Java_GUI;
import javax.swing.*;
import java.awt.*;

public class Converter extends JFrame{
	public Converter() {
		setTitle("�µ���ȯ��");
		setSize(300,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setLocationRelativeTo(null);
		Container c = getContentPane();
		c.add(new JLabel("ȭ���µ�"));
		c.add(new JTextField(15));
		c.add(new JLabel("�����µ�"));
		c.add(new JTextField(15));	
		c.setLayout(new FlowLayout());	
		c.add(new JButton("��ȯ"));			
		setVisible(true);			
	}
	public static void main(String[] args) {
		Converter frame = new Converter();
				
	}

}
