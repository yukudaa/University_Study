// SimplifiedDES.java

import java.io.*;

import java.lang.*;

// Main operations
public class SimplifiedDES_ECD {
	public static void main(String args[]) throws Exception {

		String p1 = "happy poppy";
		String p2 = "leeyookoo";
		byte[] b1 = p1.getBytes("utf-8");
		byte[] b2 = p2.getBytes("utf-8");

		DataInputStream inp = new DataInputStream(System.in);
		System.out.print("Enter the 10 Bit Key :");
		int K = Integer.parseInt(inp.readLine(), 2);

		SDES A = new SDES(K);
		byte[] x1 = new byte[b1.length];
		byte[] y1 = new byte[b1.length];
		byte[] x2 = new byte[b2.length];
		byte[] y2 = new byte[b2.length];
		System.out.println("");
		System.out.println("Plaintext1 : happy poppy");
		System.out.println("Plaintext2 : leeyookoo");
		System.out.println("");
		///////////////////////////////////////////////////////////// 암호화
		System.out.print("First Ciphertext(ECB) : ");
		for (int i = 0; i < b1.length; i++) {
			x1[i] = A.encrypt(b1[i]);
			System.out.print((char) x1[i] + " ");
		}

		///////////////////////////////////////////////////////////// 복호화
		System.out.println("");
		System.out.print("First Decryption(ECB) : ");
		for (int i = 0; i < b1.length; i++) {
			y1[i] = A.decrypt(x1[i]);
			System.out.print((char) y1[i] + " ");
		}

		///////////////////////////////////////////////////////////// 암호화
		System.out.println("");
		System.out.print("Second Ciphertext(ECB) : ");
		for (int i = 0; i < b2.length; i++) {
			x2[i] = A.encrypt(b2[i]);
			System.out.print((char) x2[i] + " ");
		}

		///////////////////////////////////////////////////////////// 복호화
		System.out.println("");
		System.out.print("Second Decryption(ECB) : ");
		for (int i = 0; i < b2.length; i++) {
			y2[i] = A.decrypt(x2[i]);
			System.out.print((char) y2[i] + " ");
		}

	}

}
