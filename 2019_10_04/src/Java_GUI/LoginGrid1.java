package Java_GUI;
import javax.swing.*;
import java.awt.*;

public class LoginGrid1 extends JFrame{
	public LoginGrid1() {
	setTitle("�α��� ȭ��");
	setSize(250,150);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	setLocationRelativeTo(null);
	Container c = getContentPane();	
	c.setLayout(new BorderLayout()); 
	
	JPanel ptop = new JPanel();
	ptop.setLayout(new GridLayout(2,2));
	ptop.add(new JLabel("ID"));
	ptop.add(new JTextField());
	ptop.add(new JLabel("PASSWORD"));
	ptop.add(new JTextField());
	
	JPanel pbottom = new JPanel();
	pbottom.setLayout(new FlowLayout());
	pbottom.add(new JButton("Ȯ��"));	
	pbottom.add(new JButton("���"));			
	
	add(ptop, BorderLayout.CENTER);
	add(pbottom, BorderLayout.SOUTH);
	setVisible(true);	
	}
	public static void main(String[] args) {
		LoginGrid1 frame = new LoginGrid1();

	}

}

