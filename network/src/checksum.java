import java.io.*;
import java.util.*;

public class checksum {

	public static void main(String[] args) {

		String str;		//�Է°�
		int count = 0;	
		int length;		//����
		int sum[] = new int[8];	
		int sum1[] = new int[8];
		int carry[] = new int[8];
		Scanner scanner = new Scanner(System.in);
		int checksum[] = new int[8];
		String checksum2[] = new String[40];	//���ڸ� ���ڷ� �ٲٱ� ����
		String sum2[] = new String[40];		//���ڸ� ���ڷ� �ٲٱ� ����
		System.out.println("���� �̸����ּҸ� �Է��Ͻÿ�");
		str = scanner.nextLine();
		str = str.replace(" ","");		// ��������
		str = str.replace("/","");		// /����
		System.out.println(str);
		String hex = stringToHex(str);
		// 8�� �������� �������� 0�϶�
		if (hex.length() % 8 == 0)
			length = hex.length();

		// 8�� �������� �������� 0�� �ƴҋ�
		else
			length = (hex.length() / 8 + 1) * 8;

		String[] re = new String[length];

		for (int i = 0; i < re.length; i++) {
			if (i < hex.length()) {
				re[i] = Character.toString(hex.charAt(i));// charAt = hex�� �ѱ��ھ� ���� �迭�� ����

			} else
				re[i] = "0";	//0���� ä��

		}
		// i+1�� 8�� ������ �������� �Ѿ
		for (int i = 0; i < length; i++) {
			System.out.print(re[i]);
			if ((i + 1) % 8 == 0) {
				System.out.println("");
			}

		} // ���ڸ� ���ڷ� �ٲپ� ����ϱ� ����
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

		// 29 => 15+14�� �ٲ�� ����
		
		// carry��
		for (int i = 0; i < 8; i++) {
			carry[i] = sum[i] / 16;

		}
		// sum��
		for (int i = 0; i < 8; i++) {
			sum[i] = sum[i] % 16;

		}
		
		for (int i = 0; i < 7; i++) {
			sum[i] += carry[i + 1];
			// sum[]���� 16�鼭 i�� 0�϶�
			if (sum[i] == 16 && i == 0) {
				carry[i] += 1;
				sum[i] = 0;
			}
			// sum[]���� 16�̸鼭 i�� 0�� �ƴҶ�
			else if (sum[i] == 16 && i != 0) {
				carry[i] += 1;
				sum[i -1] += 1;
				sum[i] = 0;
			}
			// sum[]���� carry���� �������� 16�� �Ѿ��
			// sum[]���� 16�ʰ��鼭 i��0�϶�
			else if (sum[i] > 16 && i == 0) {
				carry[i] += 1;
				sum[i] = sum[i] % 16;
			}
			// sum[]���� 16�ʰ��鼭 i��0�̾ƴҶ�
			else if (sum[i] > 16 && i != 0) {
				carry[i] += 1;
				sum[i -1] += 1;
				sum[i] = sum[i] % 16;
			}
		}

		// ���ڸ� ���ڷ� ��ȯ
		// sum���ϱ�
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

		// carry��
		System.out.println("carry");
		for (int i = 0; i < 8; i++) {
			System.out.print(carry[i] + " ");
		}

		System.out.println("");
		sum[7] += carry[0]; // sum[7]�� carry[0]�� �����ֱ�;

		// ���ڸ� ���ڷ� ��ȯ
		// sum�� ���ϱ�
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

		// ���ڸ� ���ڷ� ��ȯ
		// sum�� ���� ���ϱ�
		System.out.println("Checksum(1��s Complement)");
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

		// ���ڸ� ���ڷ� ��ȯ
		// ckecksum[i]�� sum[i]�� ���ļ� F�� ������ �ϱ�
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

	// �Էµ� ���� 16������ �ٲ㼭 result������ ����
	public static String stringToHex(String s) {
		String result = "";

		for (int i = 0; i < s.length(); i++) {
			result += String.format("%02X", (int) s.charAt(i));
		}

		return result;
	}

}