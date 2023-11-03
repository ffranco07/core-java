import java.util.*;
import java.text.*;
import java.security.SecureRandom;

public class RandomTestor {
	
	public RandomTestor() {
		//getThunderBall();
		String token = generateNewToken();
		System.out.println(token);
	}
	
	private byte[] getThunderBall() {
		byte[] tbArray = new byte[1];
		Random rnd = new Random(System.currentTimeMillis());
		int rndNum = 0;
		while (rndNum == 0) {
			rndNum = rnd.nextInt(3);
			System.out.println("1) rndNum:" + rndNum);
		}
		System.out.println("2) rndNum:" + rndNum);
		tbArray[0] = (byte)rndNum;
		return tbArray;
	}
	
	private String generateNewToken() {
		SecureRandom secureRandom = new SecureRandom();
		Base64.Encoder base64Encoder = Base64.getUrlEncoder();
		byte[] randomBytes = new byte[24];
		secureRandom.nextBytes(randomBytes);
		return base64Encoder.encodeToString(randomBytes);
	}
	
	public static void main(String...args) {
		RandomTestor randomTestor = new RandomTestor();
	} 
}
