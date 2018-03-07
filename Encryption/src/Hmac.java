import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
/**
 * Hmac
 * @author tomato
 *
 */
public class Hmac {

	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {		
		
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		SecretKey key = keyGenerator.generateKey();
		
		Mac mac = Mac.getInstance("HmacSHA256");
		mac.init(key);
		
		byte[] input = "HideMe".getBytes("UTF-8");
		byte[] encryptedData = mac.doFinal(input);
		
		byte[] input2 = "HideMe".getBytes("UTF-8");
		byte[] encryptedData1 = mac.doFinal(input2);
		
		System.out.println(Arrays.equals(encryptedData, encryptedData1));
		
		
	}

}
