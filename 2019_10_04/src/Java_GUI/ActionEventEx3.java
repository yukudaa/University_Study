//5주차 실습 1-3
package Java_GUI;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class ActionEventEx3 extends JFrame{

	public ActionEventEx3() {
		JButton btn = new JButton("Action");
		setTitle("Action 이벤트 예제");
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		add(btn);
		//btn.addActionListener(new MyActionListener());
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton)(e.getSource());
				b.setText("액션");
				ActionEventEx3.this.setTitle(b.getText());	
				}
		});
		setVisible(true);		
	}
	public static void main(String[] args) {
		new ActionEventEx3();
	}

class MyActionListener implements ActionListener {	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton)(e.getSource());
		b.setText("액션");
		ActionEventEx3.this.setTitle(b.getText());	
		}
	
	}
}
