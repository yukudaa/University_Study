import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import java.security.InvalidKeyException;
import java.security.Key;
import java.util.Random;

public class DES {
	private static String plainText = "LeeYooko";
	private static Cipher c;
	private static DESKeySpec desKeySpec;
	private static SecretKeyFactory keyFactory;
	private static Key key;
	private static byte[] randomKey = new byte[8];

	private static void SetEnc() throws Exception {
		c = Cipher.getInstance("DES");	//DES 암호화 생성
		desKeySpec = new DESKeySpec(randomKey); //randomKey를 desKeySpec형식에 맞춘 객체 생성
		keyFactory = SecretKeyFactory.getInstance("DES");
		key = keyFactory.generateSecret(desKeySpec); //key 완성
	}

	// 암호화
	private static byte[] Encrypts(String str)
			throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		c.init(Cipher.ENCRYPT_MODE, key);
		return c.doFinal(str.getBytes());
	}

	// 복호화
	private static byte[] Decryptions(byte[] str) throws Exception {
		c.init(Cipher.DECRYPT_MODE, key);
		return c.doFinal(str);
	}

	public static void main(String[] args) throws Exception {

		// randomkey안 8바이트에 난수를 적용
		Random randomGenerator = new Random();
		randomGenerator.nextBytes(randomKey);

		SetEnc(); // key 생성

		byte[] Ciphertext = null;	//암호화
		byte[] Decryption = null;	//복호화

		System.out.println("###### DES encryption");
		System.out.println("key : " + new String(randomKey));
		System.out.println("plaintext : " + plainText);
		Ciphertext = Encrypts(plainText);
		System.out.println("Ciphertext: " + new String(Ciphertext));

		System.out.println("###### DES decryption");	
		System.out.println("key : " + new String(randomKey));
		System.out.println("Ciphertext: " + new String(Ciphertext));
		Decryption = Decryptions(Ciphertext);
		System.out.println("Decryption: " + new String(Decryption));
	}

}