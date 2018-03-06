import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
/**
 * symmetric encryption
 * @author tomato
 *
 */
public class SymmetriEncryption {

	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		
		byte[] keyBytes = new byte[] {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		String algorithm = "RawBytes";
		SecretKeySpec key = new SecretKeySpec(keyBytes, algorithm);
		
		cipher.init(Cipher.ENCRYPT_MODE, key);
		
		byte[] input = "HelloWorld".getBytes("UTF-8");
		byte[] encryptedData = cipher.doFinal(input);
		
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] decryptedData = cipher.doFinal(encryptedData);
		System.out.println(new String(decryptedData));
		
		
	}

}
