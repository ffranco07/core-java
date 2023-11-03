import java.text.DecimalFormat;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Format {
	private static final int ROUNDINGMETHOD_NEAREST = 1;
	private static final int ROUNDINGMETHOD_UP = 2;
	private static final int ROUNDINGMETHOD_DOWN = 3;

	/**
	 *  Checks if messsage is a retransmission.
	 *  It bit 2 is set messsage is a retransmission.
	 *  @param terminalFlag
	 *  @return boolean value If retry flag set-true else false
	 */
	private static boolean checkRetransmission(byte terminalFlag) {
		boolean isRetrans = false;
		int result = terminalFlag & 1;
		System.out.println("terminalFlag:" + terminalFlag + " result:" + result);
		if (result == 1) {
			isRetrans = true;
		} 
		else {
			isRetrans = false;
		}
		return isRetrans;
	}

	/**
	 *
	 * @param value
	 * @return String
	 */
	public static String appendSpace( String value) {
		int length=value.length();
		if(length<20) {
			for(int i=0; i<18-length;i++)
				value+=" ";
		}
		return value;
	}
	
	public static String formatValue(long _fieldValue) {
		DecimalFormat NumberFormat = new DecimalFormat("###0.00");
		String strValue=NumberFormat.format((double)_fieldValue/100);
		int length=strValue.length();
		if(strValue.length()<20) {
			for(int i=20; i>=length;i--)
				strValue=" "+strValue;
		}
		return strValue;
	}

	public static Double getFormattedDecimalAsDouble(double input, String pattern) throws ArithmeticException {
		DecimalFormat decimalFormat = new DecimalFormat(pattern);
		return Double.valueOf(decimalFormat.format(input));
	}

	public static Double roundAmount(Double amount, int roundingMethod, double roundingScale) {
		double newAmt=0.0;
		int newScale=0;
		String temp=String.valueOf(roundingScale);            
		if(temp.split("\\.").length > 0){
			if(temp.split("\\.")[1].equals("0")) // for 1.0
				newScale=0;
			else
				newScale=temp.split("\\.")[1].length();
		}
		else
			newScale=0;
		System.out.println("newScale:" + newScale);
		BigDecimal rounder=new BigDecimal(amount);
		if(roundingMethod==ROUNDINGMETHOD_NEAREST)
			rounder=rounder.setScale(newScale , RoundingMode.HALF_DOWN);
		else if(roundingMethod==ROUNDINGMETHOD_UP)
			rounder=rounder.setScale(newScale , RoundingMode.UP);
		else if(roundingMethod==ROUNDINGMETHOD_DOWN)
			rounder=rounder.setScale(newScale , RoundingMode.DOWN);
		newAmt=rounder.doubleValue();
		return newAmt;
	}

	public static void main (String[] args) {
		// 	long myVal = 7104000;
		// 		//long myVal = -2300000;
		// 		//double myValDbl = -23000.00;
		// 		//double myValDbl = 500.345;
		// 		String myValStr = formatValue(myVal);
		// 		System.out.println(myValStr);
		// 		//myValStr = appendSpace(myValStr);
		// 		//System.out.println(myValStr);
		// 		//System.out.println("1) " + myValDbl);
		// 		//if (myValDbl < 0) 
		// 		//myValDbl = (-myValDbl);
		// 		//myValDbl = getFormattedDecimalAsDouble(myValDbl, "#.##");
		// 		//System.out.println("2) " + myValDbl);
		// 		//String myVal = "20,000.00";
		// 		//myVal = myVal.replaceAll(",", "");
		// 		//double myValDbl = Double.parseDouble(myVal);
		// 		//double myValDbl = 1.4586;
		// 		//String myValStr = "700";
		// 		//String myValStr = "175";
		// 		//String myValStr = "1500";
		// 		//String myValStr = "1875";
		// 		//int myVal = 1875;
		// 		//String myValStr = "7";
		// 		//System.out.println("myValStr:" + myValStr);
		// 		//double myValDbl = Double.valueOf(myValStr);
		
		
		// 		//long myLong = (long)(myValDbl * 100);
		// 		//System.out.println("myLong:" + myLong);
		// 		//int myInt = new Long(myLong).intValue();
		// 		//System.out.println("myInt:" + myInt);
		// 		//int roundedValueInt = Integer.valueOf(Math.round(myValDbl * 100));
		// 		//System.out.println("0) roundedValueInt:" + roundedValue);
		
		// 		//System.out.println("1) myValDbl:" + myValDbl);
		// 		//myValDbl = myValDbl * 100.00;
		// 		//System.out.println("2) myValDbl:" + myValDbl);
		// 		//double roundedDbl = roundAmount(myValDbl, ROUNDINGMETHOD_NEAREST, 0.010);
		
		// 		//System.out.println("roundedDbl:" + roundedDbl);
		// 		//int myValInt = (int)roundedDbl;
		// 		//System.out.println("3) myValInt:" + myValInt);
		
		// 		int planAmount = 700;
		// 		int planTaxAmount = 175;
		// 		double planTaxPercent = (double)planTaxAmount /  (double)planAmount;
		// 		//System.out.println("planTaxPercent:" + planTaxPercent);
		
		// 		byte myByte = (byte)5;
		
		// 		switch(myByte) {
		// 		case 1:
		// 		case 5:
		// 			System.out.println("Success");
		// 			break;
		// 		default:
		// 			System.out.println("Failure");
		// 			break;
		// 		}
		
		checkRetransmission((byte)1);
	}
}
