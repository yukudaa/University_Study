package Shape;

public class WrapperExample {
	public static void main(String[] args) {
		String[] str = {"10","25","33","74","58"};
		int sum = 0;
		for(int i = 0; i <str.length; i++) {
			sum += Integer.parseInt(str[i]);//���ڿ��� �����ιٲٱ����� Integer.parseInt
		}
		System.out.println("���ڿ� �迭 ������ ����� ��� ���� "+ sum/str.length);	
	}
}