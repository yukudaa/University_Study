package pkg02;

//(initx,inity) ~ (initx + w, inity + h)
	public class Rectangle extends Point {

	double w,h;
	
	public Rectangle(double initx, double inity, double initw, double inith) {
	super(initx, inity);
	w = initw;
	h = inith;
	}
	// x1�� x0���� ũ�ų� ����, (x0 + width)���� �۰ų� ������ x��ǥ�� ���� �ȿ� �ְ�,
   // y1�� y0���� ũ�ų� ����, (y0 + height)���� �۰ų� ������ �簢�� �ȿ� ������ �� ���ִ�.
	
	//�� ���� Rectangle �ȿ� ����ִ��� �˻��ϴ� �޼ҵ� isHit() �� ���� �ڵ带 �����Ͽ� �ϼ��Ͻÿ�.z
	public boolean isHit(Point p) {
		if(p.x >= x && p.x <= x + w && p.y >= y && p.y <= y + h )
		return true;
		else
			return false;
		
		}
	}
	