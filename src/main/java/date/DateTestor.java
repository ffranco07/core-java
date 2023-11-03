import java.util.*;
import java.text.*;

public class DateTestor {
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
	private static final String[] resultArray = {"550", "2042"};

	public DateTestor() {
		try {
			//Timestamp stamp = new Timestamp(1547605351030);
			//Date mydate = new Date(stamp.getTime());
			//System.out.println("mydate: " + mydate);
			//long timestamp = 1547605351030L;
			//long timestamp = 1547591100273L;
			//long timestamp = 1556657400000L;
			//long nyTimestamp = 1601335794000L;
			long nyTimestamp = 1601400093000L;
			long nyTimestamp2 = 1601400093530L;
			Date nyDate = new Date(nyTimestamp);
			Date nyDate2 = new Date(nyTimestamp2);
			//Date formattedNyDate = getFormattedDate(nyDate, "yyyy-MM-dd'T'HH:mm:ss");
			//Date formattedNyDate2 = getFormattedDate(nyDate, "yyyy-MM-dd'T'HH:mm:ss");
			Date formattedNyDate = getFormattedDate(nyDate, "yyyy-MM-dd HH:mm");
			Date formattedNyDate2 = getFormattedDate(nyDate2, "yyyy-MM-dd HH:mm");
			//System.out.println("formattedNyDate: " + formattedNyDate);
			//System.out.println("formattedNyDate2: " + formattedNyDate2);
			boolean isEqual = false;
			if (formattedNyDate.compareTo(formattedNyDate2) != 0) {
				isEqual = false;
			}
			else {
				isEqual = true;
			}
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
			//System.out.println("EQUAL:" + isEqual);
			Date today = new Date();
			//Date eodDate = addDays(today, -3);
			Date eodDate = addDays(today, -1);
			eodDate = setTime(eodDate, 0, 0 , 0, 0);
			System.out.println("eodDate date is: " + eodDate);
			int dbEndDayOfWeek = 6;
			// DEBUG
			System.out.println("CURRENT WEEK BALANCE REQUEST, dbEndDayOfWeek:" + dbEndDayOfWeek);
			//System.out.println("eodDate dayOfWeek is: " + getDayOfWeek(eodDate));
			//Date prevWkStartDate = new Date(eodDate.getTime() -8 * 24 * 3600 * 1000l);
			//Date prevWkEndDate = new Date(eodDate.getTime() -2 * 24 * 3600 * 1000l);
			//Date prevWkStartDate = new Date(eodDate.getTime() - ((getDayOfWeek(eodDate) - Calendar.MONDAY) + 7) * 24 * 3600 * 1000l);
			int javaEndDayOfWeek = FormatUtility.getJavaCalendarEndDayOfWeek(dbEndDayOfWeek);
			int javaStartDayOfWeek = (javaEndDayOfWeek < 7) ? (javaEndDayOfWeek + 1) : 1; 
			// DEBUG
			System.out.println("CURRENT WEEK BALANCE REQUEST, javaStartDayOfWeek:" + javaStartDayOfWeek + " javaEndDayOfWeek:" + javaEndDayOfWeek);
			Date fromDate = new Date(eodDate.getTime() - (FormatUtility.getDayOfWeek(eodDate) - javaStartDayOfWeek) * 24 * 3600 * 1000l);
			Date toDate = new Date(eodDate.getTime() + 1 * 24 * 3600 * 1000l);
			// DEBUG
			System.out.println("CURRENT WEEK BALANCE REQUEST, fromDate:" + fromDate + " toDate:" + toDate);

			fromDate = new Date(eodDate.getTime() - ((FormatUtility.getDayOfWeek(eodDate) - javaStartDayOfWeek) + 7) * 24 * 3600 * 1000l);
			toDate = new Date(eodDate.getTime() - (FormatUtility.getDayOfWeek(eodDate) - javaEndDayOfWeek + 7) * 24 * 3600 * 1000l);
			// DEBUG
			System.out.println("PREVIOUS WEEK BALANCE REQUEST, fromDate:" + fromDate + " toDate:" + toDate);
			
			//Date prevWkEndDate = new Date(eodDate.getTime() - (getDayOfWeek(eodDate) - Calendar.SUNDAY) * 24 * 3600 * 1000l);
			////Date prevWkStartDate = new Date(eodDate.getTime() - (getDayOfWeek(eodDate) - Calendar.MONDAY) * 24 * 3600 * 1000l);
			////Date prevWkEndDate  = new Date(eodDate.getTime() + 1 * 24 * 3600 * 1000l);
			////System.out.println("prevWkStartDate is: " + prevWkStartDate);
			////System.out.println("prevWkEndDate is: " + prevWkEndDate);
			//Date today = new Date(timestamp);
			//today.setTime(1547605351030);
			//today.setTime(1547591100273);
			Date tomorrow = addDays(today, 1);
			//Date startDate = addDays(today, 1);
			//Date startDate = addDays(today, 0);
			//startDate = setTime(startDate, 0, 0, 0, 0);
			//Date endDate = addDays(today, 1);
			//Date endDate = addDays(today, -7);
			//endDate = setTime(endDate, 0, 0, 0, 0);
			//endDate = setTime(endDate, 23, 0, 0, 0);
			tomorrow = setTime(tomorrow, 0, 0, 0, 0);
			//System.out.println("today date is: " + today);
			//System.out.println("tomrrow date is: " + tomorrow);
			//System.out.println("startDate is: " + startDate);
			//System.out.println("endDate is: " + endDate);
			Date formattedDate = getFormattedDate("1970-01-01 23:40:00", "yyyy-MM-dd HH:mm:ss");
			System.out.println("formattedDate is: " + formattedDate);
			Date sysDate = copyTimeToDate(new Date(), formattedDate);
			System.out.println("sysDate is: " + sysDate);
	
			//System.out.println("createDate is: " + createDate(0, 0, 0, 1, 0, 2099)); 
			//System.out.println("Day difference is: " + getDayDifference(endDate, today));
			//endDate = getFormattedDate("11/05/2018", "MM/dd/yyyy");
			//Date startDate = getFormattedDate("11/05/2018", "MM/dd/yyyy");
			//System.out.println("Day difference is: " + getDayDifference(endDate, startDate));
			//System.out.println("Formatted today date is: " + DATE_FORMAT.format(today));
			//StringBuilder builder = new StringBuilder();
			//builder.append(DATE_FORMAT.format(today));
			//builder.append("\n");
			//builder.append("MIDI: " + resultArray[0] + "-" + resultArray[1].substring(0, 2) + "-" + resultArray[1].substring(2, 4));
			//System.out.println(builder.toString());
			//System.out.println("tomorrow date is: " + tomorrow);
			//if (today.compareTo(tomorrow) < 0) {
			//System.out.println("today date is less than tomorrow date");
			//	}
			//else if (today.compareTo(tomorrow) > 0) {
			//System.out.println("today date is greater than tomorrow date");
			//} 
			//else {
			//System.out.println("today date is EQUAL to tomorrow date");
			//}
			Date minCloseDate = FormatUtility.getTime(FormatUtility.addDays(today, -1), 23, 59, 59, 0);
			Date maxCloseDate = FormatUtility.getTime(FormatUtility.addDays(today, 1), 0, 0, 0, 0);
			// DEBUG
			System.out.println("minCloseDate:" + minCloseDate);
			System.out.println("maxCloseDate:" + maxCloseDate);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int getDayOfWeek(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_WEEK); 
	}
	
	public static Date addDays(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days); //minus number would decrement the days
		return cal.getTime();
	}

	public static Date setTime(Date date, int hourOfDay, int minute, int second, int millisecond) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, hourOfDay);
		cal.set(Calendar.MINUTE, minute);
		cal.set(Calendar.SECOND, second);
		cal.set(Calendar.MILLISECOND, millisecond);
		return cal.getTime();
	}
	
	public static Date createDate(int second, int minute, int hour, int day, int month, int year) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month, day, hour, minute, second);
		return cal.getTime();
	}
	
	public static int getDayDifference(Date date1, Date date2) {
		Calendar date1Cal = Calendar.getInstance();
		date1Cal.setTime(date1);
		Calendar date2Cal = Calendar.getInstance();
		date2Cal.setTime(date2);
		long dayDiff = Math.round((((new GregorianCalendar(date1Cal.get(date1Cal.YEAR), date1Cal.get(date1Cal.MONTH), date1Cal.get(date1Cal.DATE)).getTime().getTime()) - (new GregorianCalendar(date2Cal.get(date2Cal.YEAR), date2Cal.get(date2Cal.MONTH), date2Cal.get(date2Cal.DATE)).getTime().getTime())) / (1000 * 60 * 60 * 24)));
		return (int) dayDiff;
	}

	public static Date getFormattedDate(Date inputDate, String pattern) throws ParseException {
		DateFormat df = new SimpleDateFormat(pattern);
		df.format(inputDate);
		//System.out.println(df.format(inputDate));
		Date date = df.getCalendar().getTime();
		return date;
	}

	public static Date getFormattedDate(String inputString, String pattern) throws ParseException {
		SimpleDateFormat inputFormatter = new SimpleDateFormat(pattern);
		Date date = inputFormatter.parse(inputString);
		return date;
	}

	/**
	 * Copy only the time of one date to the date of another date.
	 */
	public static Date copyTimeToDate(Date date, Date time) {
    Calendar t = Calendar.getInstance();
    t.setTime(time);
		
    Calendar c = Calendar.getInstance();
    c.setTime(date);
    c.set(Calendar.HOUR_OF_DAY, t.get(Calendar.HOUR_OF_DAY));
    c.set(Calendar.MINUTE, t.get(Calendar.MINUTE));
    c.set(Calendar.SECOND, t.get(Calendar.SECOND));
    c.set(Calendar.MILLISECOND, t.get(Calendar.MILLISECOND));
    return c.getTime();
	}
	
	public static void main(String...args) {
		DateTestor dateTestor = new DateTestor();
	} 
}
