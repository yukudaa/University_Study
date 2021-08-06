package checksum_sender;

import java.util.*;

class Checksum_NETWORK {
	public static void main(String args[]) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("영문이름과주소를 작성하시오:");
		String input = scan.next();
		int checksum = generateChecksum(input);
		//체크섬을 생성하는 메소드 호출
		
		System.out.println("생성된 체크섬 = "+ Integer.toHexString(checksum));
		System.out.println("전송할 데이터:");
		input = scan.next();
		System.out.println("보낼 체크섬을 입력하십시오:");
		checksum = Integer.parseInt((scan.next()), 16);
		// User inputs data as hexadecimal value but it will be stored as a 사용자는 16 진수 값으로 데이터를 입력하지만
		// decimal value unless it is converted into hexadecimal first. 16 진수로 변환되지 않는 한 10 진수 값입니다.
		
		receive(input, checksum);
		// Call the method to receive the data.메소드를 호출하여 데이터를 수신하십시오.
	}
	
	static int generateChecksum(String s) {
		String hex_value = new String();
		// 'hex_value' will be used to store various hex values as a string 'hex_value'는 다양한 16 진수 값을 문자열로 저장하는 데 사용됩니다.
		
		int x, i, checksum=0;
		// 'x' will be used for general purpose storage of integer values 'x'는 정수 값의 범용 저장에 사용됩니다
		// 'i' is used for loops 'i'는 루프에 사용됩니다
		// 'checksum' will store the final checksum '체크섬'은 최종 체크섬을 저장합니다		
		for(i=0 ; i < s.length()-2 ; i=i+2) {
			x = (int) (s.charAt(i));
			hex_value = Integer.toHexString(x);
			x = (int) (s.charAt(i+1));	//넘어가면 1더함
			hex_value = hex_value + Integer.toHexString(x)+Integer.toHexString(x+1)+Integer.toHexString(x+2);
			// Extract two characters and get their hexadecimal ASCII values 두 문자를 추출하고 16 진수 ASCII 값을 얻습니다.			
			System.out.println(s.charAt(i)+""+s.charAt(i+1)+""+s.charAt(i+2)+""+s.charAt(i+3) + " : "+ hex_value);
			x = Integer.parseInt(hex_value, 16);
			// Convert the hex_value into int and store it    hex_value를 int로 변환하여 저장하십시오.
			checksum += x;
			// Add 'x' into 'checksum' checksum에다가 x를 더함
		}
		if(s.length()%2 == 0) {
			// If number of characters is even, then repeat above loop's steps 문자 수가 짝수이면 루프 단계를 반복하십시오

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