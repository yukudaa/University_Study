package Java_GUI;
import javax.swing.*;
import java.awt.*;

public class ContentPaneEx extends JFrame{
	public ContentPaneEx() {
		setTitle("ContentPane 예제");
		setSize(300,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //응용프로그램까지 종료
		setLocationRelativeTo(null);//왼쪽 모서리에서 가운데로
		Container c = getContentPane();
		c.setLayout(new FlowLayout());	//배치관리자 ok,cancle,ignore을 위치대로
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
