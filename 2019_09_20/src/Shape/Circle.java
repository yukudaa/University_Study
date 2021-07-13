package Shape;

public class Circle extends Shape {
	private double radius;
	final double PI = 3.14159;
	public Circle(double radius) {
		this.radius = radius;
	}
	public Circle(double x,double y, double radius) {
		super(x,y);
		this.radius = radius;
	}
	public double getDiameter() {
		return 2*radius;
	}
	public String toString() {
		return "Center "+super.toString() + "\tRadius="+radius;
	}
	public double getArea() {
		return PI*radius*radius;
	}
	public void draw() {
		System.out.println("원을 그리다.");
	}
	public boolean equals(Circle c) {
		if(this.radius==c.radius)
			return true;
		else return false;
	}
}
