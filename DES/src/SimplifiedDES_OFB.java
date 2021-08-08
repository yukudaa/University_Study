
// SimplifiedDES.java

import java.io.*;

import java.lang.*;

// Main operations
public class SimplifiedDES_OFB {
	public static void main(String args[]) throws Exception {
		DataInputStream inp = new DataInputStream(System.in);
		String p1 = "happy poppy";
		String p2 = "leeyookoo";
		byte[] b1 = p1.getBytes("utf-8"); // 평문을 byte화
		byte[] b2 = p2.getBytes("utf-8"); // 평문을 byte화
		byte[] xor1 = new byte[p1.length()]; // xor할것
		byte[] xor2 = new byte[p2.length()]; // xor할것
		System.out.print("Enter the 8 Bit IV :");
		int IV = Integer.parseInt(inp.readLine(), 2);
		byte IV1 = (byte) IV;
		System.out.print("Enter the 10 Bit Key :");
		int K = Integer.parseInt(inp.readLine(), 2);

		SDES A = new SDES(K);
		byte[] x1 = new byte[b1.length]; // 암호화할것
		byte[] x2 = new byte[b2.length]; // 암호화할것
		byte[] y1 = new byte[b1.length];
		byte[] y2 = new byte[b2.length];
		byte[] xor3 = new byte[p1.length()]; // xor할것
		byte[] xor4 = new byte[p2.length()]; // xor할것

		System.out.println("");
		System.out.println("Plaintext1 : happy poppy");
		System.out.println("Plaintext2 : leeyookoo");
		System.out.println("");

		x1[0] = A.encrypt(IV1);
		xor1[0] = (byte) (b1[0] ^ x1[0]);

		for (int i = 1; i < x1.length; i++) {
			x1[i] = A.encrypt(x1[i - 1]);
			xor1[i] = (byte) (b1[i] ^ x1[i]);
		}

		System.out.print("First Ciphertext(OFB) : ");
		for (int i = 0; i < xor1.length; i++) {
			System.out.print((char) xor1[i] + " ");
		}
		System.out.println("");

		///////////////////////////////////////////////////////

		y1[0] = A.encrypt(IV1);
		xor3[0] = (byte) (xor1[0] ^ y1[0]);

		for (int i = 1; i < xor3.length; i++) {
			y1[i] = A.encrypt(y1[i - 1]);
			xor3[i] = (byte) (xor1[i] ^ y1[i]);
		}
		System.out.print("First Decryption(OFB) : ");
		for (int i = 0; i < xor3.length; i++) {
			System.out.print((char) xor3[i] + " ");
		}
		System.out.println("");
		///////////////////////////////////////////////////////

		x2[0] = A.encrypt(IV1);
		xor2[0] = (byte) (b2[0] ^ x2[0]);

		for (int i = 1; i < x2.length; i++) {
			x2[i] = A.encrypt(x2[i - 1]);
			xor2[i] = (byte) (b2[i] ^ x2[i]);
		}

		System.out.print("Second Ciphertext(OFB) : ");
		for (int i = 0; i < xor2.length; i++) {
			System.out.print((char) xor2[i] + " ");
		}
		System.out.println("");

		///////////////////////////////////////////////////////

		y2[0] = A.encrypt(IV1);
		xor4[0] = (byte) (xor2[0] ^ y2[0]);

		for (int i = 1; i < xor4.length; i++) {
			y2[i] = A.encrypt(y2[i - 1]);
			xor4[i] = (byte) (xor2[i] ^ y2[i]);
		}
		System.out.print("Second Decryption(OFB) : ");
		for (int i = 0; i < xor4.length; i++) {
			System.out.print((char) xor4[i] + " ");
		}

		System.out.println("");

	}

}
