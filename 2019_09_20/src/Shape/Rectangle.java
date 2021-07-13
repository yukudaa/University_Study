package Shape;

public class Rectangle extends Shape {
	private double width, height;
	public Rectangle(double width, double height) {
		this.width = width;
		this.height=height;
	}
	public Rectangle(double x, double y, double width, double height) {
		super(x,y);
		this.width = width;
		this.height=height;
	}
	public double getWidth() {
		return width;
	}
	public double getHeight() {
		return height;
	}
	public Point getOtherPoint() {
		Point p1=getPoint();
		Point p2=new Point();
		p2.x=p1.x+width;
		p2.y=p1.y+height;
		return p2;
		
	}
	public double getDistance() {
		double value;
		value=Math.pow((getOtherPoint().x-getPoint().x),2) +
				Math.pow((getOtherPoint().y-getPoint().y),2);
		return Math.sqrt(value);
	}
	public String toString() {
		String result="Top "+super.toString() ;
		result+="\tBottom ÁÂÇ¥ ("+getOtherPoint().x;
		result+=","+getOtherPoint().y+")";
		result+="\nWidth =" + width + "\tHeight="+height;
		return result;
	}
	public double getArea() {
		return width*height;
	}
}
	