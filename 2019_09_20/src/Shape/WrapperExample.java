package Shape;

public class WrapperExample {
	public static void main(String[] args) {
		String[] str = {"10","25","33","74","58"};
		int sum = 0;
		for(int i = 0; i <str.length; i++) {
			sum += Integer.parseInt(str[i]);//문자열을 정수로바꾸기위해 Integer.parseInt
		}
		System.out.println("문자열 배열 변수에 저장된 평균 값은 "+ sum/str.length);	
	}
}