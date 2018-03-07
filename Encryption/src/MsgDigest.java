import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
/**
 * Message Digest
 * @author tomato
 *
 */
public class MsgDigest {

	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
		
		MessageDigest md = MessageDigest.getInstance("SHA");
		
		
		byte[] input = "HideMe".getBytes("UTF-8");
		byte[] encryptedData = md.digest(input);
		
		byte[] input2 = "HideMe".getBytes("UTF-8");
		byte[] encryptedData1 = md.digest(input2);
		
		System.out.println(Arrays.equals(encryptedData, encryptedData1));
		
		
	}

}
