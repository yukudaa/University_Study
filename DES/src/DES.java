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
		c = Cipher.getInstance("DES");	//DES ��ȣȭ ����
		desKeySpec = new DESKeySpec(randomKey); //randomKey�� desKeySpec���Ŀ� ���� ��ü ����
		keyFactory = SecretKeyFactory.getInstance("DES");
		key = keyFactory.generateSecret(desKeySpec); //key �ϼ�
	}

	// ��ȣȭ
	private static byte[] Encrypts(String str)
			throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		c.init(Cipher.ENCRYPT_MODE, key);
		return c.doFinal(str.getBytes());
	}

	// ��ȣȭ
	private static byte[] Decryptions(byte[] str) throws Exception {
		c.init(Cipher.DECRYPT_MODE, key);
		return c.doFinal(str);
	}

	public static void main(String[] args) throws Exception {

		// randomkey�� 8����Ʈ�� ������ ����
		Random randomGenerator = new Random();
		randomGenerator.nextBytes(randomKey);

		SetEnc(); // key ����

		byte[] Ciphertext = null;	//��ȣȭ
		byte[] Decryption = null;	//��ȣȭ

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