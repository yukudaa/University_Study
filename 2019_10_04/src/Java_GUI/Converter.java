package Java_GUI;
import javax.swing.*;
import java.awt.*;

public class Converter extends JFrame{
	public Converter() {
		setTitle("¿Âµµº¯È¯±â");
		setSize(300,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setLocationRelativeTo(null);
		Container c = getContentPane();
		c.add(new JLabel("È­¾¾¿Âµµ"));
		c.add(new JTextField(15));
		c.add(new JLabel("¼·¾¾¿Âµµ"));
		c.add(new JTextField(15));	
		c.setLayout(new FlowLayout());	
		c.add(new JButton("º¯È¯"));			
		setVisible(true);			
	}
	public static void main(String[] args) {
		Converter frame = new Converter();
				
	}

}
