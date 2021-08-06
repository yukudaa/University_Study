package checksum_sender;

import java.util.*;

class Checksum_NETWORK {
	public static void main(String args[]) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("�����̸����ּҸ� �ۼ��Ͻÿ�:");
		String input = scan.next();
		int checksum = generateChecksum(input);
		//üũ���� �����ϴ� �޼ҵ� ȣ��
		
		System.out.println("������ üũ�� = "+ Integer.toHexString(checksum));
		System.out.println("������ ������:");
		input = scan.next();
		System.out.println("���� üũ���� �Է��Ͻʽÿ�:");
		checksum = Integer.parseInt((scan.next()), 16);
		// User inputs data as hexadecimal value but it will be stored as a ����ڴ� 16 ���� ������ �����͸� �Է�������
		// decimal value unless it is converted into hexadecimal first. 16 ������ ��ȯ���� �ʴ� �� 10 ���� ���Դϴ�.
		
		receive(input, checksum);
		// Call the method to receive the data.�޼ҵ带 ȣ���Ͽ� �����͸� �����Ͻʽÿ�.
	}
	
	static int generateChecksum(String s) {
		String hex_value = new String();
		// 'hex_value' will be used to store various hex values as a string 'hex_value'�� �پ��� 16 ���� ���� ���ڿ��� �����ϴ� �� ���˴ϴ�.
		
		int x, i, checksum=0;
		// 'x' will be used for general purpose storage of integer values 'x'�� ���� ���� ���� ���忡 ���˴ϴ�
		// 'i' is used for loops 'i'�� ������ ���˴ϴ�
		// 'checksum' will store the final checksum 'üũ��'�� ���� üũ���� �����մϴ�		
		for(i=0 ; i < s.length()-2 ; i=i+2) {
			x = (int) (s.charAt(i));
			hex_value = Integer.toHexString(x);
			x = (int) (s.charAt(i+1));	//�Ѿ�� 1����
			hex_value = hex_value + Integer.toHexString(x)+Integer.toHexString(x+1)+Integer.toHexString(x+2);
			// Extract two characters and get their hexadecimal ASCII values �� ���ڸ� �����ϰ� 16 ���� ASCII ���� ����ϴ�.			
			System.out.println(s.charAt(i)+""+s.charAt(i+1)+""+s.charAt(i+2)+""+s.charAt(i+3) + " : "+ hex_value);
			x = Integer.parseInt(hex_value, 16);
			// Convert the hex_value into int and store it    hex_value�� int�� ��ȯ�Ͽ� �����Ͻʽÿ�.
			checksum += x;
			// Add 'x' into 'checksum' checksum���ٰ� x�� ����
		}
		if(s.length()%2 == 0) {
			// If number of characters is even, then repeat above loop's steps ���� ���� ¦���̸� ���� �ܰ踦 �ݺ��Ͻʽÿ�

			// one more time.
			
			x = (int) (s.charAt(i));
			hex_value = Integer.toHexString(x);
			x = (int) (s.charAt(i+1));
			hex_value = hex_value + Integer.toHexString(x);
			System.out.println(s.charAt(i)+""+s.charAt(i+1) + " : " + hex_value);
			x = Integer.parseInt(hex_value, 16);
		} else {
			// If number of characters is odd, last 2 digits will be 00.
			
			x = (int) (s.charAt(i));
			hex_value = "00" + Integer.toHexString(x);
			x = Integer.parseInt(hex_value, 16);
			System.out.println(s.charAt(i) + " : " + hex_value);
		}
		checksum += x;
		// Add the generated value of 'x' from the if-else case into 'checksum'
		hex_value = Integer.toHexString(checksum);
		// Convert into hexadecimal string
		
		if(hex_value.length() > 4) {
			// If a carry is generated, then we wrap the carry
			int carry = Integer.parseInt((""+hex_value.charAt(0)), 16);
			// Get the value of the carry bit
			hex_value = hex_value.substring(1,5);
			// Remove it from the string
			checksum = Integer.parseInt(hex_value, 16);
			// Convert it into an int
			checksum += carry;
			// Add it to the checksum
		}
		checksum = generateComplement(checksum);
		// Get the complement
		return checksum;
	}
	
	static void receive(String s, int checksum) {
		int generated_checksum = generateChecksum(s);
		// Calculate checksum of received data
		generated_checksum = generateComplement(generated_checksum);
		// Then get its complement, since generated checksum is complemented
		
		int syndrome = generated_checksum + checksum;
		// Syndrome is addition of the 2 checksums
		syndrome = generateComplement(syndrome);
		// It is complemented
		
		System.out.println("Syndrome = " + Integer.toHexString(syndrome));
		if(syndrome == 0) {
			System.out.println("Data is received without error.");
		} else {
			System.out.println("There is an error in the received data.");
		}
	}
	
	static int generateComplement(int checksum) {
		// Generates 15's complement of a hexadecimal value
		checksum = Integer.parseInt("FFFF", 16) - checksum;
		return checksum;
	}
}