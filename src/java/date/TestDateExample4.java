import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDateExample4 {
	public static void main(String[] argv) {
		//SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMM dd, yyyy HH:mm:ss a");
		//String dateInString = "Friday, Jun 7, 2013 12:10:56 PM";
		SimpleDateFormat inputFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		String dateInString = "2018-08-03T00:05:00";
		try {
			Date date = inputFormatter.parse(dateInString);
			System.out.println(date);
			System.out.println(inputFormatter.format(date));
			
			
		} 
		catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
