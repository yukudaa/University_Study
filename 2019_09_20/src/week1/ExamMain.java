package week1;

import Shape.Circle;
import Shape.Rectangle;
import Shape.Shape;

public class ExamMain {
	public static void main(String[] args) {
		//Shape 형의 크기 5를 갖는 배열변수를 선언하시오.  (2점)
		Shape shape[]=new Shape[5];

		shape[0]=new Rectangle(5, 10);
		shape[1]=new Rectangle(10,10, 5, 10);
		shape[2]=new Rectangle(20, 30, 12.3, 15.6);
		shape[3]=new Circle(8);
		shape[4]=new Circle(30,30, 12.5);
		
		for(int i=0; i<shape.length; i++) {
			System.out.print(shape[i].toString()); //toString() 메소드를 호출하시오. (1점) 

			System.out.printf("\tArea = %6.2f", 
					shape[i].getArea());
		//출력 결과와 같이 객체가 사각형인 경우에는 두 점 사이의 거리를 출력하고,
		//원인 경우에는 원의 지름을 출력하도록 구현하시오. (10점)
			if(shape[i] instanceof Rectangle)
				System.out.printf("\t사가형 두점 사이의 거리=%6.2f\n", ((Rectangle)shape[i]).getDistance());
			else {
				System.out.printf("\t원의 지름=%6.2f\n", ((Circle)shape[i]).getDiameter());
				((Circle)shape[i]).draw();
			}
		}
		System.out.println("--------------------------------------------------------");
		System.out.println("면적이 가장 큰 도형은 ?");
//		greatestShape(shape);
	}
	
	//객체의 면적중에 가장 큰 면적의 도형을 찾아내어 어떠한 도형인가와 면적을 함께 출력하는 
        //  greatest(shape) 메소드를 작성하시오. (10점) 
	public static void greatestShape(Shape[] s) {


	}

}
