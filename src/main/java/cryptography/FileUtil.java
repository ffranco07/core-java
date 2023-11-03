import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Francisco Franco
 * @version %I%, %G%
 * @since 1.0
 */
 
public final class FileUtil {
 
	public static void writeToFile(String filePath, String data) {
		File file = new File(filePath);
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		try {
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			byte[] bytes = data.getBytes();
			bos.write(bytes);
			bos.close();
			fos.close();
			System.out.println("Data written to file successfully.");
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (bos != null) {
					bos.close();
				}
				
				if (fos != null) {
					fos.close();
				}
			}
			catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}
}
