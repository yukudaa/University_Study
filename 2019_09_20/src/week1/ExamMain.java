package week1;

import Shape.Circle;
import Shape.Rectangle;
import Shape.Shape;

public class ExamMain {
	public static void main(String[] args) {
		//Shape ���� ũ�� 5�� ���� �迭������ �����Ͻÿ�.  (2��)
		Shape shape[]=new Shape[5];

		shape[0]=new Rectangle(5, 10);
		shape[1]=new Rectangle(10,10, 5, 10);
		shape[2]=new Rectangle(20, 30, 12.3, 15.6);
		shape[3]=new Circle(8);
		shape[4]=new Circle(30,30, 12.5);
		
		for(int i=0; i<shape.length; i++) {
			System.out.print(shape[i].toString()); //toString() �޼ҵ带 ȣ���Ͻÿ�. (1��) 

			System.out.printf("\tArea = %6.2f", 
					shape[i].getArea());
		//��� ����� ���� ��ü�� �簢���� ��쿡�� �� �� ������ �Ÿ��� ����ϰ�,
		//���� ��쿡�� ���� ������ ����ϵ��� �����Ͻÿ�. (10��)
			if(shape[i] instanceof Rectangle)
				System.out.printf("\t�簡�� ���� ������ �Ÿ�=%6.2f\n", ((Rectangle)shape[i]).getDistance());
			else {
				System.out.printf("\t���� ����=%6.2f\n", ((Circle)shape[i]).getDiameter());
				((Circle)shape[i]).draw();
			}
		}
		System.out.println("--------------------------------------------------------");
		System.out.println("������ ���� ū ������ ?");
//		greatestShape(shape);
	}
	
	//��ü�� �����߿� ���� ū ������ ������ ã�Ƴ��� ��� �����ΰ��� ������ �Բ� ����ϴ� 
        //  greatest(shape) �޼ҵ带 �ۼ��Ͻÿ�. (10��) 
	public static void greatestShape(Shape[] s) {


	}

}
