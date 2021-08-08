// SimplifiedDES.java

import java.io.*;

import java.lang.*;

// Main operations
public class SimplifiedDES_CBC {
	public static void main(String args[]) throws Exception {

		DataInputStream inp = new DataInputStream(System.in);
		String p1 = "happy poppy";
		String p2 = "leeyookoo";
		byte[] b1 = p1.getBytes("utf-8");
		byte[] b2 = p2.getBytes("utf-8");
		byte[] xor1 = new byte[p1.length()]; // xor한것
		byte[] xor2 = new byte[p2.length()]; // xor한것
		System.out.print("Enter the 8 Bit IV :");
		int IV = Integer.parseInt(inp.readLine(), 2);
		byte IV1 = (byte) IV;
		System.out.print("Enter the 10 Bit Key :");
		int K = Integer.parseInt(inp.readLine(), 2);
		System.out.println("");
		System.out.println("Plaintext1 : happy poppy");
		System.out.println("Plaintext2 : leeyookoo");
		System.out.println("");
		SDES A = new SDES(K);
		byte[] x1 = new byte[b1.length]; // 암호화한것
		byte[] x2 = new byte[b2.length]; // 암호화한것
		byte[] y1 = new byte[x1.length]; // 복호화한것
		byte[] y2 = new byte[x2.length]; // 복호화한것

		xor1[0] = (byte) (b1[0] ^ IV1); // 첫번째 블록을 IV와 xor
		x1[0] = A.encrypt(xor1[0]);

		for (int i = 1; i < b1.length; i++) {
			xor1[i] = (byte) (b1[i] ^ x1[i - 1]);
			x1[i] = A.encrypt(xor1[i]);
		}

		System.out.print("First Ciphertext(CBC) : ");
		for (int i = 0; i < b1.length; i++) {
			System.out.print((char) x1[i] + " ");
		}
		System.out.println("");
		//////////////////////////////////////////////////////////

		y1[0] = A.decrypt(x1[0]);
		xor1[0] = (byte) (IV1 ^ y1[0]);

		for (int i = 1; i < x1.length; i++) {
			y1[i] = A.decrypt(x1[i]);
			xor1[i] = (byte) (x1[i - 1] ^ y1[i]);
		}

		System.out.print("First Decryption(CBC) : ");
		for (int i = 0; i < b1.length; i++) {
			System.out.print((char) xor1[i] + " ");
		}
		System.out.println("");
		//////////////////////////////////////////////////////////
		xor2[0] = (byte) (b2[0] ^ IV1); // 첫번째 블록을 IV와 xor
		x2[0] = A.encrypt(xor2[0]);

		for (int i = 1; i < b2.length; i++) {
			xor2[i] = (byte) (b2[i] ^ x2[i - 1]);
			x2[i] = A.encrypt(xor2[i]);
		}

		System.out.print("Second Ciphertext(CBC) : ");
		for (int i = 0; i < b2.length; i++) {
			System.out.print((char) x2[i] + " ");
		}
		//////////////////////////////////////////////////////////

		System.out.println("");

		y2[0] = A.decrypt(x2[0]);
		xor2[0] = (byte) (IV1 ^ y2[0]);

		for (int i = 1; i < x2.length; i++) {
			y2[i] = A.decrypt(x2[i]);
			xor2[i] = (byte) (x2[i - 1] ^ y2[i]);
		}

		System.out.print("Second Decryption(CBC) : ");
		for (int i = 0; i < b2.length; i++) {
			System.out.print((char) xor2[i] + " ");
		}
		System.out.println("");

	}

}
