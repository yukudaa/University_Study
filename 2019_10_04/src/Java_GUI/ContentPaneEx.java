package Java_GUI;
import javax.swing.*;
import java.awt.*;

public class ContentPaneEx extends JFrame{
	public ContentPaneEx() {
		setTitle("ContentPane ����");
		setSize(300,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //�������α׷����� ����
		setLocationRelativeTo(null);//���� �𼭸����� �����
		Container c = getContentPane();
		c.setLayout(new FlowLayout());	//��ġ������ ok,cancle,ignore�� ��ġ���
		c.setBackground(Color.ORANGE);
		c.add(new JButton("OK"));
		c.add(new JButton("Cancel"));
		c.add(new JButton("Ignore"));
		setVisible(true);
	}
	public static void main(String[] args) {
		ContentPaneEx frame = new ContentPaneEx();
		
	}

}
