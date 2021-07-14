//5주차 실습 1-2
package Java_GUI;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class ActionEventEx extends JFrame{

	public ActionEventEx() {
		JButton btn = new JButton("Action");
		setTitle("Action 이벤트 예제");
		setSize(150,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		add(btn);
		btn.addActionListener(new MyActionListener());
		setVisible(true);		
	}
	public static void main(String[] args) {
		new ActionEventEx();
	}

class MyActionListener implements ActionListener {	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton)(e.getSource());
		b.setText("액션");
		}
	
	}
}