package pkg02;

public class Point {
	   double x, y;
	   public Point(double initx, double inity) {
	      x = initx;
	      y = inity;
	   }
	   
	   //� �� ���� �ٸ� ������ �Ÿ��� ����ϴ� �޼ҵ� distance() �� 
	   //���� �ڵ带 �����Ͽ� �ϼ��Ͻÿ�. (Math.sqrt() �޼ҵ� ��� ����)
	   public double distance(Point p) {
		 double sum = 0.0;
		 sum = Math.sqrt( (x- p.x) * (x- p.x) +  (y- p.y) * (y- p.y)) ;
	     return sum;
	   }
	}