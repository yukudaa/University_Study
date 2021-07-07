package C0418_;

import CircleArea.Circle;

/*public class Circle {
	public int radius;
	final double PI = 3.14;
	
	public Circle(int radius) {
		this.radius = radius;
	}
	
	public double getArea() {
	double result;
	result = PI * radius * radius;
	return result;
	}

*/

public class CircleArea {
	
	public static void main(String[] args) {
		Circle [] c;
		k = new Circle[5];
		int ii ;
		for (ii = 0; ii <5; ii++) {
			k[ii] = new Circle((1+ii) * 10);
		}
		
		for (ii = 0; ii < 5; ii++) {
			System.out.println("Area_" + ii + " = " + k[ii].getArea());
		}
		
		
	}
	
	
}

public class Circle {
	public int radius;
	final double PI = 3.14;
	
	public Circle(int radius) {
		this.radius = radius;
	}
	
	public double getArea() {
	double result;
	result = PI * radius * radius;
	return result;
	}

}
