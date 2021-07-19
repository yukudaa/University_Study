package PhoneBook;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;
import java.util.*;

public class PhoneLabEx extends JFrame {
	JTextField top,name, phone;
	JButton in_button, get_button;
	JTextArea output;
	PhonePanel panel = new PhonePanel();
	public PhoneLabEx() {
		setTitle("��ȭ��ȣ��");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		top = new JTextField();
		top.setEditable(false);
		output =  new JTextArea();
		add(top, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
		add(output, BorderLayout.SOUTH);
		setVisible(true);
	}
	public static void main(String[] args) {
		new PhoneLabEx();
	}
	class PhonePanel extends JPanel implements ActionListener{
	      public PhonePanel() {
	         setLayout(new GridLayout(3,2));
	         in_button = new JButton("÷��");
	         get_button = new JButton("��������");
	         in_button.addActionListener(this);
	         get_button.addActionListener(this);
	         name = new JTextField();
	         phone = new JTextField();
	         add(new JLabel("�̸�"));
	         add(name);
	         add(new JLabel("��ȭ��ȣ"));
	         add(phone);
	         add(in_button);
	         add(get_button);
	      }
	      public void actionPerformed(ActionEvent e) {
	    	  try {
	    		  if(e.getSource() == in_button) {
	    		  FileWriter fout = new FileWriter("phone.txt", true);
	    		  fout.write(name.getText()+ " "+phone.getText()+"\r\n");
	    		  top.setText("���� �ԷµǾ����ϴ�");
	    		  name.setText("");
	    		  phone.setText("");
	    		  fout.close();}else if(e.getSource() ==get_button) {
	    			  String str="";
	    			  int ch;
	    			  FileReader fin = new FileReader("phone.txt");
	    			  while((ch=fin.read()) != -1)
	    				  str +=(char)ch;
	    			  output.setText(str);;
	    			  fin.close();
	    		  }
	    	  }catch(IOException ex) {
	    		  System.out.println("���� ����");
	    	  }
	      }
	   }
	
	

}
