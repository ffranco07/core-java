import java.util.Base64;

/**
 *
 * @author Francisco Franco
 */

public class Base64Testor {

	public Base64Testor() {}
	
	private void printEncodedBytes(String inputStr) {
		//String inputStr = "1,2,3,4,5";
		//String inputStr = "11,12,13,14,15";
		String[] matrix1StrArray = inputStr.split(",");
		byte[] matrix1 = new byte[matrix1StrArray.length];
		for (int j = 0; j < matrix1StrArray.length; j++) {
			//System.out.println("matrix1StrArray [" + j + "]:" + matrix1StrArray[j].trim());
			matrix1[j] = Byte.valueOf(matrix1StrArray[j].trim());
		}
		byte[] encoded = Base64.getEncoder().encode(matrix1);
		System.out.println(new String(encoded));
	}
	
	public static void main(String[] args) {
		if (args == null || args.length <= 0 || args[0].isEmpty()) {
			System.out.println("java Base64Testor <selections> where selections = 1,2,3,4,5 or selections = 11,12,13,14,15");
		}
		else {
			Base64Testor base64Testor = new Base64Testor();
			base64Testor.printEncodedBytes(args[0]);
		} 
	}
}
