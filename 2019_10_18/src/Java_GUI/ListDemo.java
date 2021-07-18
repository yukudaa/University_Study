package Java_GUI;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;


public class ListDemo extends JFrame{
	ImageIcon image[] = new ImageIcon[4];
	String str[] = {"apple","banana","kiwi","mango"};
	JList<String> strlist = new JList<String>(str);
	
	public ListDemo() {
		setTitle("����Ʈ ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(500,500);
		JPanel tp = new JPanel();
		JPanel ip = new JPanel();
		JPanel lp = new JPanel();
		tp.add(new JLabel("�߰��� ���ϸ� �Է�..."));
		JTextField input = new JTextField(20);
		tp.add(input);
		
		for(int i = 0; i <image.length; i++)
			image[i] = new ImageIcon("image/"+ str[i] + ".jpg");
		JLabel label = new JLabel(image[0]);
		ip.add(label);
		ip.add(strlist);
		add(tp, BorderLayout.NORTH);
		add(ip, BorderLayout.CENTER);
		add(lp, BorderLayout.EAST);
		
		setVisible(true);

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ListDemo();
	}

}
