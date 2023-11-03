import java.io.File;

public class FileTestor {
	public static final String JSON_DIRECTORY = "/cygwin64/home/franc/workspace-eclipse/svn/haitisports/trunk/lsports-connector-haiti/src/main/resources/json";
	
	public static void main(String[] args) {
		File folder = new File(JSON_DIRECTORY + "/target");
		File[] files = folder.listFiles();
		for (File file : files) {
			if (file.isFile()) {
				System.out.println(file.getName());
			}
		}
	}
}
