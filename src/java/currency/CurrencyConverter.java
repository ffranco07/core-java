//package com.practicehouse;

import java.math.BigDecimal;
import java.math.RoundingMode;
 
import java.util.*;
import java.text.DecimalFormat;
 
public final class CurrencyConverter {

	private static final int ROUNDINGMETHOD_NEAREST = 1;
	private static final int ROUNDINGMETHOD_UP = 2;
	private static final int ROUNDINGMETHOD_DOWN = 3;

	private static double roundAmount(double amount, int roundingMethod, double roundingScale) {
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
		BigDecimal rounder=new BigDecimal(amount);
		if(roundingMethod == ROUNDINGMETHOD_NEAREST)
			rounder=rounder.setScale(newScale , RoundingMode.HALF_DOWN);
		else if(roundingMethod == ROUNDINGMETHOD_UP)
			rounder=rounder.setScale(newScale , RoundingMode.UP);
		else if(roundingMethod == ROUNDINGMETHOD_DOWN)
			rounder=rounder.setScale(newScale , RoundingMode.DOWN);
		newAmt=rounder.doubleValue();
		return newAmt;
	}
	
	public static double convertToUSD(double amount, double exchangeRate, int roundingMethod, double roundingScale) {
		double amountInUSD = amount / exchangeRate;
		amountInUSD = roundAmount(amountInUSD, roundingMethod, roundingScale);
		return amountInUSD;
	}
	
	public static void main(String[] args) {
		double amount = 100.00;
		//double exchangeRate = 4000.00;
		double exchangeRate = 4146.00;
		int roundingMethod = 1;
		double roundingScale = 0.0010;
		System.out.println("amount: " + amount);
		double amountInUSD = convertToUSD(amount, exchangeRate, roundingMethod, roundingScale);
		System.out.println("amountInUSD: " + amountInUSD);
	}
}
