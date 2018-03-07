import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
/**
 * Digital Signature
 * @author tomato
 *
 */
public class DigitalSignature {

	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, SignatureException {
		
		KeyPairGenerator pair = KeyPairGenerator.getInstance("DSA");
		KeyPair keyPair = pair.generateKeyPair();
		
		Signature signature = Signature.getInstance("SHA256WithDSA");
		signature.initSign(keyPair.getPrivate(), new SecureRandom());
		byte [] data = "I agree with this".getBytes("UTF-8");
		signature.update(data);
		byte[] signedData = signature.sign();
		
		signature.initVerify(keyPair.getPublic());
		data = "I agree with this".getBytes("UTF-8");
		signature.update(data);

		System.out.println(signature.verify(signedData));
		
		
	}

}
