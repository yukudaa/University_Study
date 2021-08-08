// SimplifiedDES.java

//00010100 10011101 10101111 11000011 01000000 10101111 01001010 01101100 11111111 11111111 01101100 11111111 
//01001010 11000011 01101100 00001010 11000011 10011101 11001010 11011100 00000101 11000011 11110000 00000101 
//11000011 00010100 10011101 10101111 11000011 01101111 10011101 11110000 11011100 10101111
import java.lang.*;

public class SimplifiedDES {
	public static void main(String args[]) throws Exception {

		// 00010100 10011101 10101111 11000011 01000000 10101111 01001010 01101100
		// 11111111 11111111 01101100 11111111
		// 01001010 11000011 01101100 00001010 11000011 10011101 11001010 11011100
		// 00000101 11000011 11110000 00000101
		// 11000011 00010100 10011101 10101111 11000011 01101111 10011101 11110000
		// 11011100 10101111
		for (int K = 0; K < 2014; K++) {
			System.out.print("Key : " + K + "\t");

			SDES A = new SDES(K);

			int m = Integer.parseInt("00010100", 2);
			m = A.decrypt(m);
			System.out.print((char) m);

			m = Integer.parseInt("10011101", 2);
			m = A.decrypt(m);
			System.out.print((char) m);

			m = Integer.valueOf("10101111", 2);
			m = A.decrypt(m);
			System.out.print((char) m);

			m = Integer.parseInt("11000011", 2);
			m = A.decrypt(m);
			System.out.print((char) m);

			m = Integer.parseInt("01000000", 2);
			m = A.decrypt(m);
			System.out.print((char) m);

			m = Integer.parseInt("10101111", 2);
			m = A.decrypt(m);
			System.out.print((char) m);

			m = Integer.parseInt("01001010", 2);
			m = A.decrypt(m);
			System.out.print((char) m);

			m = Integer.parseInt("01101100", 2);
			m = A.decrypt(m);
			System.out.print((char) m);

			m = Integer.parseInt("11111111", 2);
			m = A.decrypt(m);
			System.out.print((char) m);

			m = Integer.parseInt("11111111", 2);
			m = A.decrypt(m);
			System.out.print((char) m);

			m = Integer.parseInt("01101100", 2);
			m = A.decrypt(m);
			System.out.print((char) m);

			m = Integer.parseInt("11111111", 2);
			m = A.decrypt(m);
			System.out.print((char) m);

			m = Integer.parseInt("01001010", 2);
			m = A.decrypt(m);
			System.out.print((char) m);

			m = Integer.parseInt("11000011", 2);
			m = A.decrypt(m);
			System.out.print((char) m);

			m = Integer.parseInt("01101100", 2);
			m = A.decrypt(m);
			System.out.print((char) m);

			m = Integer.parseInt("00001010", 2);
			m = A.decrypt(m);
			System.out.print((char) m);

			m = Integer.parseInt("11000011", 2);
			m = A.decrypt(m);
			System.out.print((char) m);

			m = Integer.parseInt("10011101", 2);
			m = A.decrypt(m);
			System.out.print((char) m);

			m = Integer.parseInt("11001010", 2);
			m = A.decrypt(m);
			System.out.print((char) m);

			m = Integer.parseInt("11011100", 2);
			m = A.decrypt(m);
			System.out.print((char) m);

			m = Integer.parseInt("00000101", 2);
			m = A.decrypt(m);
			System.out.print((char) m);

			m = Integer.parseInt("11000011", 2);
			m = A.decrypt(m);
			System.out.print((char) m);

			m = Integer.parseInt("11110000", 2);
			m = A.decrypt(m);
			System.out.print((char) m);

			m = Integer.parseInt("00000101", 2);
			m = A.decrypt(m);
			System.out.print((char) m);

			m = Integer.parseInt("11000011", 2);
			m = A.decrypt(m);
			System.out.print((char) m);

			m = Integer.parseInt("00010100", 2);
			m = A.decrypt(m);
			System.out.print((char) m);

			m = Integer.parseInt("10011101", 2);
			m = A.decrypt(m);
			System.out.print((char) m);

			m = Integer.parseInt("10101111", 2);
			m = A.decrypt(m);
			System.out.print((char) m);

			m = Integer.parseInt("11000011", 2);
			m = A.decrypt(m);
			System.out.print((char) m);

			m = Integer.parseInt("01101111", 2);
			m = A.decrypt(m);
			System.out.print((char) m);

			m = Integer.parseInt("10011101", 2);
			m = A.decrypt(m);
			System.out.print((char) m);

			m = Integer.parseInt("11110000", 2);
			m = A.decrypt(m);
			System.out.print((char) m);

			m = Integer.parseInt("11011100", 2);
			m = A.decrypt(m);
			System.out.print((char) m);

			m = Integer.parseInt("10101111", 2);
			m = A.decrypt(m);
			System.out.println((char) m);

		}

	}
}