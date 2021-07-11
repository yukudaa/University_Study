package pkg02;

//(initx,inity) ~ (initx + w, inity + h)
	public class Rectangle extends Point {

	double w,h;
	
	public Rectangle(double initx, double inity, double initw, double inith) {
	super(initx, inity);
	w = initw;
	h = inith;
	}
	// x1이 x0보다 크거나 같고, (x0 + width)보다 작거나 같으면 x좌표상 범위 안에 있고,
   // y1이 y0보다 크거나 같고, (y0 + height)보다 작거나 같으면 사각형 안에 있음을 알 수있다.
	
	//한 점이 Rectangle 안에 들어있는지 검사하는 메소드 isHit() 를 다음 코드를 참조하여 완성하시오.z
	public boolean isHit(Point p) {
		if(p.x >= x && p.x <= x + w && p.y >= y && p.y <= y + h )
		return true;
		else
			return false;
		
		}
	}
	