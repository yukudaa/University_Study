import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class avatar_game extends JFrame{
	public avatar_game() {
		setTitle("괴물 맞추기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		setLocationRelativeTo(null);
		GamePanel p = new GamePanel();
		setContentPane(p);
		setSize(500,500);
		setResizable(false);		
		setVisible(true);
		p.startGame();
	}	
	public static void main(String [] args) {
		new avatar_game();
	}
}
class GamePanel extends JPanel {
	TargetThread targetThread=null;
	JLabel baseLabel = new JLabel();	//밑의 이미지
	JLabel bulletLabel = new JLabel();	//발사되는것
	JLabel targetLabel;					//위의 이미지
	
	public GamePanel() {
		setLayout(null);
		ImageIcon img2 = new ImageIcon("images/canon1.jpg");
		baseLabel = new JLabel(img2);
		baseLabel.setSize(54,30);

		ImageIcon img = new ImageIcon("images/monster1.jpg");
		targetLabel = new JLabel(img);
		targetLabel.setSize(66,35);

		bulletLabel.setSize(10,10);					//사이즈
		bulletLabel.setOpaque(true);				//변경사항 존재
		bulletLabel.setBackground(Color.BLACK);		//색 검은색
		add(baseLabel);
		add(targetLabel);
		add(bulletLabel);
	}
	
	public void startGame() {
		baseLabel.setLocation(this.getWidth()/2-20, this.getHeight()-40);		//baseLabel의 위치
		bulletLabel.setLocation(this.getWidth()/2 - 5, this.getHeight()-50);	//bulletLabel의 위치			
		targetLabel.setLocation(0, 0);											//targetLabel의 위치
		
		targetThread = new TargetThread(targetLabel);
		targetThread.start();
		
		baseLabel.requestFocus();	// 그 컴포넌트 생성자에서 하면 안되고 외부에서 이 메소드를 사용할 시 이벤트 포커스가 이 컴포넌트로 이루어진다
		baseLabel.addKeyListener(new KeyAdapter() {
			BulletThread  bulletThread = null;
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar() == '\n') {
					if(bulletThread==null || !bulletThread.isAlive()) {
						bulletThread = new BulletThread(bulletLabel, targetLabel, targetThread);
						bulletThread.start();
					}
				}
			}
		});
	}
	
	class TargetThread extends Thread {
		JComponent target;
		public TargetThread(JComponent target) {
			this.target = target;
			target.setLocation(0, 0);
			target.getParent().repaint();
		}	
		public void run() {
			while(true) {
				int x = target.getX()+5;
				int y = target.getY();
				if(x > GamePanel.this.getWidth()) 
					target.setLocation(0,0);
				else 
					target.setLocation(x, y);

				target.getParent().repaint();
				try {
					sleep(20);
				}
				catch(InterruptedException e) {
					// the case of hit by a bullet
					target.setLocation(0, 0);
					target.getParent().repaint();
					try {
						sleep(500); // 0.5초 기다린 후에 계속한다.
					}catch(InterruptedException e2) {}					
				}
			}
		}			
	}
	
	class BulletThread extends Thread {
		JComponent bullet, target;
		Thread targetThread;
		public BulletThread(JComponent bullet, JComponent target, Thread targetThread) {
			this.bullet = bullet;
			this.target = target;
			this.targetThread = targetThread;				
		}
		
		public void run() {
			while(true) {
				// 명중하였는지 확인
				if(hit()) {
					targetThread.interrupt();	//위의 이미지를 친다
					bullet.setLocation(bullet.getParent().getWidth()/2 - 5, bullet.getParent().getHeight()-50);	//부모핸들 getParent()					
					System.exit(1);										//맞추면 탈출
				}
				else {
					int x = bullet.getX() ;
					int y = bullet.getY() - 5;
					if(y < 0) {
						bullet.setLocation(bullet.getParent().getWidth()/2 - 5, bullet.getParent().getHeight()-50);
						bullet.getParent().repaint();
						return; //스레드 끝 
					}
					bullet.setLocation(x, y);
					bullet.getParent().repaint();	//다시
				}
				try {				//예외처리
					sleep(20);
				}
				catch(InterruptedException e) {}		//인셉션이 걸려서 깨어나게 되면 인터럽트 바로 해제
				// Thread가 중단되었을 때 발생하는 예외
				// 즉, wait()메소드나 sleep() 메소드를 사용해 Thread가 대기 상태로 들어갔다가
				// 깨어나지 못 할때 발생하는 예외
				// 또한, interrupt()메소드를 사용해 Thread를 중단시킬 때 발생



			}
		}
		
		private boolean hit() {
			if(targetContains(bullet.getX(), bullet.getY()) || 
					targetContains(bullet.getX() + bullet.getWidth() - 1, bullet.getY()) ||
					targetContains(bullet.getX() + bullet.getWidth() - 1, bullet.getY()+bullet.getHeight() - 1) ||
					targetContains(bullet.getX(), bullet.getY()+bullet.getHeight() - 1))
				return true;
			else
				return false;					
		}
		
		private boolean targetContains(int x, int y) {
			if(((target.getX() <= x) && (target.getX() + target.getWidth() - 1 >= x)) &&
					((target.getY() <= y)&& (target.getY() + target.getHeight() - 1 >= y))) {
				return true;
			}
			else
				return false;
			
		}
	}	
}
