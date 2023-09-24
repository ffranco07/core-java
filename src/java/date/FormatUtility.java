/*
 * FormatUtility.java
 *
 * Created on November 15, 2007, 10:20 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

//package com.gameteclabs.bizlogic.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Francisco Franco
 * @version %I%, %G%
 * @since 1.0
 */

public final class FormatUtility {
	private static final String CLASS_NAME = "com.gameteclabs.bizlogic.util.FormatUtility";
	
	/** Private Constructor */
	private FormatUtility() {}
	
	public static int getDrawDateAsInt(Date date) throws Exception {
		int day=0;
		int month=0;
		int year=0;
		int dateVal=0;
		try {
			GregorianCalendar gc=new GregorianCalendar();
			gc.setTime(date);
			day=gc.get(GregorianCalendar.DATE);
			month = gc.get(GregorianCalendar.MONTH)+1;
			month = month << 8;
			year = gc.get(GregorianCalendar.YEAR);
			year = year << 16;
			dateVal = day + month + year;
		} 
		catch (Exception e) {
			//Log.exceptionLogger(e.toString(), CLASS_NAME, "getDrawDateAsInt(Date)");
			throw e;
		}
		return dateVal;
	}
	
	public static int getDrawTimeAsInt(Date date) throws Exception {
		int timeVal=0;
		try{
			GregorianCalendar gc=new GregorianCalendar();
			gc.setTime(date);
			timeVal=(gc.get(gc.HOUR_OF_DAY)*60*60)+(gc.get(gc.MINUTE)*60)+gc.get(gc.SECOND);
		} 
		catch (Exception e) {
			//Log.exceptionLogger(e.toString(), CLASS_NAME, "getDrawTimeAsInt(Date)");
			throw e;
		}
		return timeVal;
	}
	
	public static int getDateMonthYear(Date dt) {
		if(dt != null){
			Calendar gc = new GregorianCalendar();
			gc.setTime(dt);
			return (gc.get(Calendar.DATE)+((gc.get(Calendar.MONTH)+1)<<8)+((gc.get(Calendar.YEAR))<<16));
		} 
		else{
			return 0;
		}
	}
	
	public static int getHourMinute(Date dt) {
		if(dt != null){
			Calendar gc = new GregorianCalendar();
			gc.setTime(dt);
			//return gc.get(Calendar.HOUR_OF_DAY) * 100 + gc.get(Calendar.MINUTE);
			return (gc.get(gc.HOUR_OF_DAY)*60*60)+(gc.get(gc.MINUTE)*60)+gc.get(gc.SECOND);
		} 
		else{
			return 0;
		}
	}
	
	public static byte[] blankSpace(int spcLength) {
		byte[] tmp = new byte[spcLength];
		for(int i = 0;i < spcLength; i++) {
			tmp[i]=(byte)0x20;
		}
		return tmp;
	}
	
	public static String formatPromoText(String promoText){
		byte prmTxt[] = promoText.getBytes();
		byte[] newLine = {(byte)0x0D,(byte)0x0A};
		byte[] tempArr = new byte[60];
		if(prmTxt.length<=28){
			System.arraycopy(prmTxt,0,tempArr,0,(prmTxt.length%28 == 0)?28:prmTxt.length%28);
			System.arraycopy(blankSpace(30-prmTxt.length%28),0,tempArr,prmTxt.length,blankSpace(30-prmTxt.length%28).length);
		} 
		else{
			System.arraycopy(prmTxt,0,tempArr,0,28);
		}
		System.arraycopy(newLine,0,tempArr,28,newLine.length);
		if(prmTxt.length>28 && prmTxt.length%28>=0){
			System.arraycopy(prmTxt,prmTxt.length<=28?0:28,tempArr,30,prmTxt.length<=28?0:prmTxt.length-28);
			System.arraycopy(blankSpace(56-prmTxt.length),0,tempArr,prmTxt.length+2,blankSpace(56-prmTxt.length).length);
		}
		if(prmTxt.length<=28){
			System.arraycopy(blankSpace(28),0,tempArr,30,blankSpace(28).length);
		}
		System.arraycopy(newLine,0,tempArr,58,newLine.length);
		return new String(tempArr);
	}
	
// 	public static Double roundAmount(Double amount, int roundingMethod, double roundingScale) {
// 		double newAmt=0.0;
// 		int newScale=0;
// 		String temp=String.valueOf(roundingScale);            
// 		if(temp.split("\\.").length > 0){
// 			if(temp.split("\\.")[1].equals("0")) // for 1.0
// 				newScale=0;
// 			else
// 				newScale=temp.split("\\.")[1].length();
// 		}
// 		else
// 			newScale=0;            
// 		BigDecimal rounder=new BigDecimal(amount);
// 		if(roundingMethod==DomainConstants.ROUNDINGMETHOD_NEAREST)
// 			rounder=rounder.setScale(newScale , RoundingMode.HALF_DOWN);
// 		else if(roundingMethod==DomainConstants.ROUNDINGMETHOD_UP)
// 			rounder=rounder.setScale(newScale , RoundingMode.UP);
// 		else if(roundingMethod==DomainConstants.ROUNDINGMETHOD_DOWN)
// 			rounder=rounder.setScale(newScale , RoundingMode.DOWN);
// 		newAmt=rounder.doubleValue();
// 		return newAmt;
// 	}
	
	public static String convertByteArrayToString(byte[] prawData,int i,int length){
		byte[] byteArray=new byte[length];
		System.arraycopy(prawData, i, byteArray, 0, length);
		return new String(byteArray);
	}



	public static int getDayDifference(Date date1, Date date2) {
		Calendar date1Cal = Calendar.getInstance();
		date1Cal.setTime(date1);
		Calendar date2Cal = Calendar.getInstance();
		date2Cal.setTime(date2);
		long dayDiff = Math.round((((new GregorianCalendar(date1Cal.get(date1Cal.YEAR), date1Cal.get(date1Cal.MONTH), date1Cal.get(date1Cal.DATE)).getTime().getTime()) - (new GregorianCalendar(date2Cal.get(date2Cal.YEAR), date2Cal.get(date2Cal.MONTH), date2Cal.get(date2Cal.DATE)).getTime().getTime())) / (1000 * 60 * 60 * 24)));
		return (int) dayDiff;
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

	public static Date addHours(Date date, int hours) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.HOUR, hours); //minus number would decrement the days
		return cal.getTime();
	}

	public static Date addMinutes(Date date, int minutes) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MINUTE, minutes); //minus number would decrement the days
		return cal.getTime();
	}

	public static Date getTime(Date date, int hourOfDay, int minute, int second, int millisecond) {
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

	public static Date getFormattedDate(Date inputDate, String pattern) throws ParseException {
		DateFormat df = new SimpleDateFormat(pattern);
		df.format(inputDate);
		Date date = df.getCalendar().getTime();
		return date;
	}
	
	public static Date getFormattedDate(String inputString, String pattern) throws ParseException {
		SimpleDateFormat inputFormatter = new SimpleDateFormat(pattern);
		Date date = inputFormatter.parse(inputString);
		return date;
	}

	public static int getJavaCalendarEndDayOfWeek(int dbEndDayOfWeek) {
		int javaEndDayOfWeek = -9;
		switch(dbEndDayOfWeek) {
		case 1:
			javaEndDayOfWeek = Calendar.MONDAY;
			break;
		case 2:
			javaEndDayOfWeek = Calendar.TUESDAY;
			break;
		case 3:
			javaEndDayOfWeek = Calendar.WEDNESDAY;
			break;
		case 4:
			javaEndDayOfWeek = Calendar.THURSDAY;
			break;
		case 5:
			javaEndDayOfWeek = Calendar.FRIDAY;
			break;
		case 6:
			javaEndDayOfWeek = Calendar.SATURDAY;
			break;
		case 7:
			javaEndDayOfWeek = Calendar.SUNDAY;
			break;
		default:
			break;
		}
		return javaEndDayOfWeek; 
	}
}
