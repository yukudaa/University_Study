
public class PositivePoint extends Point{
	
	public PositivePoint() {
		super(0,0);
	}
	
	public PositivePoint(int x, int y) {
		super(x, y);
		if ( x < 0 || y < 0) {
			super.move(0, 0);
		}

	}
	
	@Override
	protected void move(int x, int y) {
		if(x>0 && y > 0) {
			super.move(x, y);
		}
		else
			return;
	}
	
	public String toString() {
		return "(" + getX() + "," + getY() + ")의 점";
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PositivePoint p1 = new PositivePoint(10, 10);
		p1.move(10,10);
		System.out.println(p1.toString() + "입니다");
		p1.move(-5,-5);
		System.out.println(p1.toString() + "입니다");
		PositivePoint p2 = new PositivePoint(-5,10);
		System.out.println(p2.toString() + "입니다");
	}

}
