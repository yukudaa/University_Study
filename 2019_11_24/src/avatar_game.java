import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class avatar_game extends JFrame{
	public avatar_game() {
		setTitle("���� ���߱�");
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
	JLabel baseLabel = new JLabel();	//���� �̹���
	JLabel bulletLabel = new JLabel();	//�߻�Ǵ°�
	JLabel targetLabel;					//���� �̹���
	
	public GamePanel() {
		setLayout(null);
		ImageIcon img2 = new ImageIcon("images/canon1.jpg");
		baseLabel = new JLabel(img2);
		baseLabel.setSize(54,30);

		ImageIcon img = new ImageIcon("images/monster1.jpg");
		targetLabel = new JLabel(img);
		targetLabel.setSize(66,35);

		bulletLabel.setSize(10,10);					//������
		bulletLabel.setOpaque(true);				//������� ����
		bulletLabel.setBackground(Color.BLACK);		//�� ������
		add(baseLabel);
		add(targetLabel);
		add(bulletLabel);
	}
	
	public void startGame() {
		baseLabel.setLocation(this.getWidth()/2-20, this.getHeight()-40);		//baseLabel�� ��ġ
		bulletLabel.setLocation(this.getWidth()/2 - 5, this.getHeight()-50);	//bulletLabel�� ��ġ			
		targetLabel.setLocation(0, 0);											//targetLabel�� ��ġ
		
		targetThread = new TargetThread(targetLabel);
		targetThread.start();
		
		baseLabel.requestFocus();	// �� ������Ʈ �����ڿ��� �ϸ� �ȵǰ� �ܺο��� �� �޼ҵ带 ����� �� �̺�Ʈ ��Ŀ���� �� ������Ʈ�� �̷������
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
						sleep(500); // 0.5�� ��ٸ� �Ŀ� ����Ѵ�.
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
				// �����Ͽ����� Ȯ��
				if(hit()) {
					targetThread.interrupt();	//���� �̹����� ģ��
					bullet.setLocation(bullet.getParent().getWidth()/2 - 5, bullet.getParent().getHeight()-50);	//�θ��ڵ� getParent()					
					System.exit(1);										//���߸� Ż��
				}
				else {
					int x = bullet.getX() ;
					int y = bullet.getY() - 5;
					if(y < 0) {
						bullet.setLocation(bullet.getParent().getWidth()/2 - 5, bullet.getParent().getHeight()-50);
						bullet.getParent().repaint();
						return; //������ �� 
					}
					bullet.setLocation(x, y);
					bullet.getParent().repaint();	//�ٽ�
				}
				try {				//����ó��
					sleep(20);
				}
				catch(InterruptedException e) {}		//�μ����� �ɷ��� ����� �Ǹ� ���ͷ�Ʈ �ٷ� ����
				// Thread�� �ߴܵǾ��� �� �߻��ϴ� ����
				// ��, wait()�޼ҵ峪 sleep() �޼ҵ带 ����� Thread�� ��� ���·� ���ٰ�
				// ����� �� �Ҷ� �߻��ϴ� ����
				// ����, interrupt()�޼ҵ带 ����� Thread�� �ߴܽ�ų �� �߻�



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
