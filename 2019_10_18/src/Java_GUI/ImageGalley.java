package Java_GUI;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class ImageGalley extends JFrame implements ItemListener {
	ImageIcon image[] = new ImageIcon[4];
	JLabel label = new JLabel();
	JButton next, prev;
	JCheckBox cbox[] = new JCheckBox[3];
	int r = 0, g = 0, b = 0;

	JPanel cpanel = new JPanel();
	JPanel gpanel = new JPanel();
	JPanel bpanel = new JPanel();
	RadioPanel rpanel = new RadioPanel();

	public ImageGalley() {
		setTitle("이미지 갤러리 예제");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		Container c = getContentPane();

		cbox[0] = new JCheckBox("RED");
		cbox[1] = new JCheckBox("GREEN");
		cbox[2] = new JCheckBox("BLUE");

		for (int i = 0; i < cbox.length; i++) {
			cpanel.add(cbox[i]);
			cbox[i].addItemListener(this);
		}
		for (int i = 0; i < image.length; i++)
			image[i] = new ImageIcon("images/image" + i + ".jpg");
		label.setIcon(image[0]);
		gpanel.add(label);
		gpanel.setBackground(new Color(r, g, b));
		next = new JButton(new ImageIcon("images/right.png"));
		prev = new JButton(new ImageIcon("images/left.png"));
		bpanel.add(prev);
		bpanel.add(next);

		add(cpanel, BorderLayout.NORTH); // 색
		add(gpanel, BorderLayout.CENTER); // 사진
		// add(bpanel, BorderLayout.SOUTH); //왼쪽 오른쪽
		add(rpanel, BorderLayout.SOUTH); // 인물
		setVisible(true);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ImageGalley();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if (e.getStateChange() == ItemEvent.SELECTED) {
			if (e.getItem() == cbox[0])
				r = 255;
			else if (e.getItem() == cbox[1])
				g = 255;
			else if (e.getItem() == cbox[2])
				b = 255;
		} else {
			if (e.getItem() == cbox[0])
				r = 0;
			else if (e.getItem() == cbox[1])
				g = 0;
			else if (e.getItem() == cbox[2])
				b = 0;
		}
		gpanel.setBackground(new Color(r, g, b));
	}
}

class RadioPanel extends JPanel {
	public RadioPanel() {
			ButtonGroup group = new ButtonGroup();
			String str[] = {"스파이더맨","원더우먼","배트맨","슈퍼맨"};
			JRadioButton radio[] = new JRadioButton[4];
			
			for(int i = 0; i <radio.length; i++ ) {
				radio[i] = new JRadioButton(str[i]);
				group.add(radio[i]);
				add(radio[i]);
			
				radio[i].addItemListener(new ItemListener() {
		              
					@Override
		               public void itemStateChanged(ItemEvent e) {
		                  if(e.getStateChange()==ItemEvent.DESELECTED)
		                     return;
		                  if(radio[0].isSelected())
		                     label.setIcon(image[0]);
		                  else if(radio[1].isSelected())
		                     label.setIcon(image[1]);
		                  else if(radio[2].isSelected())
		                     label.setIcon(image[2]);
		                  else if(radio[3].isSelected())
		                     label.setIcon(image[3]);
		                  
		               }
				}
		}
		}
}
