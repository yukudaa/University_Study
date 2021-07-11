package pkg02;

public class Point {
	   double x, y;
	   public Point(double initx, double inity) {
	      x = initx;
	      y = inity;
	   }
	   
	   //어떤 한 점과 다른 점과의 거리를 계산하는 메소드 distance() 를 
	   //다음 코드를 참조하여 완성하시오. (Math.sqrt() 메소드 사용 가능)
	   public double distance(Point p) {
		 double sum = 0.0;
		 sum = Math.sqrt( (x- p.x) * (x- p.x) +  (y- p.y) * (y- p.y)) ;
	     return sum;
	   }
	}