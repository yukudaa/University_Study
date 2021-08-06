import java.io.*;
import java.util.*;

public class checksum {

	public static void main(String[] args) {

		String str;		//입력값
		int count = 0;	
		int length;		//길이
		int sum[] = new int[8];	
		int sum1[] = new int[8];
		int carry[] = new int[8];
		Scanner scanner = new Scanner(System.in);
		int checksum[] = new int[8];
		String checksum2[] = new String[40];	//숫자를 문자로 바꾸기 위해
		String sum2[] = new String[40];		//숫자를 문자로 바꾸기 위해
		System.out.println("영문 이름과주소를 입력하시오");
		str = scanner.nextLine();
		str = str.replace(" ","");		// 공백제거
		str = str.replace("/","");		// /제거
		System.out.println(str);
		String hex = stringToHex(str);
		// 8로 나눴을떄 나머지가 0일때
		if (hex.length() % 8 == 0)
			length = hex.length();

		// 8로 나눴을때 나머지가 0이 아닐떄
		else
			length = (hex.length() / 8 + 1) * 8;

		String[] re = new String[length];

		for (int i = 0; i < re.length; i++) {
			if (i < hex.length()) {
				re[i] = Character.toString(hex.charAt(i));// charAt = hex를 한글자씩 끊어 배열에 저장

			} else
				re[i] = "0";	//0으로 채움

		}
		// i+1이 8로 나누어 떨어질때 넘어감
		for (int i = 0; i < length; i++) {
			System.out.print(re[i]);
			if ((i + 1) % 8 == 0) {
				System.out.println("");
			}

		} // 문자를 숫자로 바꾸어 계산하기 위해
		for (int i = 0; i < length / 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (re[count].equals("A")) {
					sum[j] += 10;
				} else if (re[count].equals("B")) {
					sum[j] += 11;
				} else if (re[count].equals("C")) {
					sum[j] += 12;
				} else if (re[count].equals("D")) {
					sum[j] += 13;
				} else if (re[count].equals("E")) {
					sum[j] += 14;
				} else if (re[count].equals("F")) {
					sum[j] += 15;
				} else
					sum[j] += Integer.parseInt(re[count]);
				count++;
			}

		}

		// 29 => 15+14로 바뀌는 과정
		
		// carry값
		for (int i = 0; i < 8; i++) {
			carry[i] = sum[i] / 16;

		}
		// sum값
		for (int i = 0; i < 8; i++) {
			sum[i] = sum[i] % 16;

		}
		
		for (int i = 0; i < 7; i++) {
			sum[i] += carry[i + 1];
			// sum[]값이 16면서 i가 0일때
			if (sum[i] == 16 && i == 0) {
				carry[i] += 1;
				sum[i] = 0;
			}
			// sum[]값이 16이면서 i가 0이 아닐때
			else if (sum[i] == 16 && i != 0) {
				carry[i] += 1;
				sum[i -1] += 1;
				sum[i] = 0;
			}
			// sum[]값이 carry값을 더해져서 16이 넘어갈때
			// sum[]값이 16초과면서 i가0일때
			else if (sum[i] > 16 && i == 0) {
				carry[i] += 1;
				sum[i] = sum[i] % 16;
			}
			// sum[]값이 16초과면서 i가0이아닐때
			else if (sum[i] > 16 && i != 0) {
				carry[i] += 1;
				sum[i -1] += 1;
				sum[i] = sum[i] % 16;
			}
		}

		// 숫자를 문자로 변환
		// sum구하기
		System.out.println("sum");
		for (int i = 0; i < 8; i++) {
			if (sum[i] == 10) {
				sum2[i] = "A";
				System.out.print(sum2[i] + " ");
			} else if (sum[i] == 11) {
				sum2[i] = "B";
				System.out.print(sum2[i] + " ");
			} else if (sum[i] == 12) {
				sum2[i] = "C";
				System.out.print(sum2[i] + " ");
			} else if (sum[i] == 13) {
				sum2[i] = "D";
				System.out.print(sum2[i] + " ");
			} else if (sum[i] == 14) {
				sum2[i] = "E";
				System.out.print(sum2[i] + " ");
			} else if (sum[i] == 15) {
				sum2[i] = "F";
				System.out.print(sum2[i] + " ");

			} else {
				System.out.print(sum[i] + " ");
			}
		}
		System.out.println("");

		// carry값
		System.out.println("carry");
		for (int i = 0; i < 8; i++) {
			System.out.print(carry[i] + " ");
		}

		System.out.println("");
		sum[7] += carry[0]; // sum[7]에 carry[0]값 더해주기;

		// 숫자를 문자로 변환
		// sum값 구하기
		System.out.println("sum + [" + carry[0] + "]carry");
		for (int i = 0; i < 8; i++) {
			if (sum[i] == 10) {
				sum2[i] = "A";
				System.out.print(sum2[i] + " ");
			} else if (sum[i] == 11) {
				sum2[i] = "B";
				System.out.print(sum2[i] + " ");
			} else if (sum[i] == 12) {
				sum2[i] = "C";
				System.out.print(sum2[i] + " ");
			} else if (sum[i] == 13) {
				sum2[i] = "D";
				System.out.print(sum2[i] + " ");
			} else if (sum[i] == 14) {
				sum2[i] = "E";
				System.out.print(sum2[i] + " ");
			} else if (sum[i] == 15) {
				sum2[i] = "F";
				System.out.print(sum2[i] + " ");

			} else {
				System.out.print(sum[i] + " ");
			}
		}
		System.out.println("");

		// 숫자를 문자로 변환
		// sum의 보수 취하기
		System.out.println("Checksum(1’s Complement)");
		for (int i = 0; i < 8; i++) {

			checksum[i] = Integer.parseInt("F", 16) - sum[i];
			if (checksum[i] == 10) {
				checksum2[i] = "A";
				System.out.print(checksum2[i] + " ");
			} else if (checksum[i] == 11) {
				checksum2[i] = "B";
				System.out.print(checksum2[i] + " ");
			} else if (checksum[i] == 12) {
				checksum2[i] = "C";
				System.out.print(checksum2[i] + " ");
			} else if (checksum[i] == 13) {
				checksum2[i] = "D";
				System.out.print(checksum2[i] + " ");
			} else if (checksum[i] == 14) {
				checksum2[i] = "E";
				System.out.print(checksum2[i] + " ");
			} else if (checksum[i] == 15) {
				checksum2[i] = "F";
				System.out.print(checksum2[i] + " ");
			} else {
				System.out.print(checksum[i] + " ");// 15-sum[i]
			}
		}
		System.out.println("");

		// 숫자를 문자로 변환
		// ckecksum[i]랑 sum[i]를 합쳐서 F가 나오게 하기
		for (int i = 0; i < 8; i++) {
			sum1[i] = checksum[i] + sum[i];
			if (sum1[i] == 10) {
				sum2[i] = "A";
				System.out.print(sum2[i] + " ");
			} else if (sum1[i] == 11) {
				sum2[i] = "B";
				System.out.print(sum2[i] + " ");
			} else if (sum1[i] == 12) {
				sum2[i] = "C";
				System.out.print(sum2[i] + " ");
			} else if (sum1[i] == 13) {
				sum2[i] = "D";
				System.out.print(sum2[i] + " ");
			} else if (sum1[i] == 14) {
				sum2[i] = "E";
				System.out.print(sum2[i] + " ");
			} else if (sum1[i] == 15) {
				sum2[i] = "F";
				System.out.print(sum2[i] + " ");

			} else {
				System.out.print(sum1[i] + " ");
			}
		}

	}

	// 입력된 수를 16진수로 바꿔서 result값으로 리턴
	public static String stringToHex(String s) {
		String result = "";

		for (int i = 0; i < s.length(); i++) {
			result += String.format("%02X", (int) s.charAt(i));
		}

		return result;
	}

}