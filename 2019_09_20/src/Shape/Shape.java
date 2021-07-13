package Shape;

public abstract class Shape {
	private Point point=new Point();
	public Shape() {
		point.x=0;
		point.y=0;
	}
	public Shape(double x, double y) {
		point.x=x; 
		point.y=y;
	}
	public Point getPoint() {
		return point;
	}
	public String toString() {
		return "ÁÂÇ¥ ("+point.x+", "+point.y+")";
	}
	public abstract double getArea();
}
