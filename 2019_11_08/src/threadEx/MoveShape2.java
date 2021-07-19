package threadEx;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class MoveShape2 extends JFrame{
	MyPanel panel = new MyPanel();
	int rx=50, ry=50, cx=100, cy=100;
	public MoveShape2() {
		setTitle("도형이동 예제");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setContentPane(panel);
//		Thread t=new Thread(panel);
		MoveThread t1 = new MoveThread('r');
		MoveThread t2 = new MoveThread('c');
		t1.start();
		t2.start();
		setVisible(true);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MoveShape2();
	}
	class MyPanel extends JPanel  {

		public void paintComponent(Graphics g) {
			//빨간색 사각형을 그리세요
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.fillRect(rx, ry, 30, 30);
			g.setColor(Color.BLUE);
			g.fillOval(cx, cy, 30, 30);
		}
		/*
		public void run() {
			while(true) {
				x+=10;
				if(x>=getWidth()) x=0;
				try {
				Thread.sleep(100);
				repaint();
				}catch(InterruptedException e) {
				return;
				}
			}
		} */
	}
	
	class MoveThread extends Thread {
		public char type;
		public MoveThread(char type) {
			this.type=type;
		}
		public void run() {
			while(true) {
				if(type=='r') rx+=10;
				else cy+=10;
				try {
					if(type=='r')
						Thread.sleep(100);
					else
						Thread.sleep(300);
					repaint();
					}catch(InterruptedException e) {
					return;
					}
			}
		}
	}
}
