import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
/**
 * symmetric encryption
 * @author tomato
 *
 */
public class SymmetriEncryption {

	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
		
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		
		
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		SecretKey key = keyGenerator.generateKey();
		
		cipher.init(Cipher.ENCRYPT_MODE, key);
		
		byte[] input = "HideMe".getBytes("UTF-8");
		byte[] encryptedData = cipher.doFinal(input);
		
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] decryptedData = cipher.doFinal(encryptedData);
		System.out.println(new String(decryptedData));
		
		
	}

}
