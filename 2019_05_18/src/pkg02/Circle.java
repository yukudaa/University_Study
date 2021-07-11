package pkg02;

public class Circle extends Point {
   double r;
   public Circle(double initx, double inity, double initr) {
      super(initx, inity);
      r = initr;
   }
   //� �� ���� Circle �ȿ� ��� �ִ��� �˻��ϴ� �޼ҵ� isHit() �� 
   //���� �ڵ带 �����Ͽ� �ϼ��Ͻÿ�.
   public boolean isHit(Point p) {
	   double sum = 0.0;
		 sum = Math.sqrt( (x- p.x) * (x- p.x) +  (y- p.y) * (y- p.y)) ;
	     if(sum <= r)
      return true;
	     else
	    	 return false;
   }
   
   //�ϳ��� Circle �� �ٸ� Circle �� �ε������� �˻��ϴ� �޼ҵ� isHit() �� 
   //���� �ڵ带 �����Ͽ� �ϼ��Ͻÿ�.
   public boolean isHit(Circle c) {
	   double sum2 = 0.0;
		 sum2 = Math.sqrt( (x- c.x) * (x- c.x) +  (y- c.y) * (y- c.y)) ;
	     if(sum2 <= c.r + r)
      return true;
	     else 
	    	 return false;
   }
   
   //�ϳ��� Circle �� �ٸ� Rectangle �� �ε������� �˻��ϴ� �޼ҵ� isHit() �� 
   //���� �ڵ带 �����Ͽ� �ϼ��Ͻÿ�.
  public boolean isHit(Rectangle rr) {
	  	double a = 0.0;
	  	double b = 0.0;
	  	double c = 0.0;
	  	double d = 0.0;
		 a = Math.sqrt( (x- rr.x) * (x- rr.x) +  (y- rr.y) * (y- rr.y)) ;
	     b = Math.sqrt((x-rr.x+rr.w) * (x-rr.x + rr.w) + (y-rr.y)* (y-rr.y)  );
		 c = Math.sqrt( (x- rr.x) * (x- rr.x) +  (y- rr.y + rr.h) * (y- rr.y + rr.h)) ;
	     d = Math.sqrt( (x- rr.x + rr.w) * (x- rr.x + rr.w) +  (y- rr.y + rr.h) * (y- rr.y + rr.h)) ;
	     //6��
	     if(x <=rr.x + rr.y ) {
		 if (a <= r)
			 return true;
		 else 
			 return false;
		}
	     //8��
		else if(x>=rr.x + rr.w) { 
			if ( b<= r)
			 return true;
			else
				return false;
		}
	     //1��
		else if(x>=rr.y + rr.h) { 
		  if ( c<= r)
			 return true;
		  else 
			  return false;
		}
	     //3��
		else if(x>=rr.h + rr.w) { 
		  if ( d<= r)
			 return true;
		  else
			  return false;
		}
		 //2,7��
	     
		else if( y<=rr.y && y>=(rr.y+rr.h )) {
		   if(y - rr.y <= a || rr.y - r <= a)
			 return true;
		   else
			   return false;
		}
		 //4, 5��
		else if ( x <= rr.x && x >= (rr.x + rr.w)) {
		   if(x - rr.x <=a || rr.x - x <= a)
			 return true;
		   else 
			   return false;
		}
	    //���� �簢�� �ȿ� �������
		else if (rr.x <= x && rr.y+ rr.h >= y && rr.y <= y && rr.x+ rr.w >= x) {
			
			if (r >= x - rr.x || r >= (rr.x +rr.w) - x || r >= (rr.y + rr.h) - y || r >= y- rr.y) {
				return true;
			}
			else if (r < x- rr.x)
				return false;
			else if (a > r)
				return false;
			else if ( a <= r)
				return true;
				
		}
	     
		  else
			  return false;
		return false;

      
   }
}
