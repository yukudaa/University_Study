package Shape;

public class ShapeMain {
	public static void main(String[] args) {
		Circle[] c= new Circle[3];
		c[0] = new Circle(20);
		c[1] = new Circle(10);
		c[2] = new Circle(10);
		
		for(int i=0;i <c.length; i++) {
			System.out.println(c[i].toString());
		}
		if(c[1].equals(c[2]))
			System.out.println("�� ���� �������� �����ϴ�.");
		else
			System.out.println("�� ���� �������� �ٸ��ϴ�.");
	}
}

