package com.nishit.suprdaily.hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReformDates {

	private static final Map<String, String> dayLookUp = new HashMap<>();
	private static final Map<String, String> monthLookUp = new HashMap<>();

	static {
		dayLookUp.put("1st", "01");
		dayLookUp.put("2nd", "02");
		dayLookUp.put("3rd", "03");
		dayLookUp.put("4th", "04");
		dayLookUp.put("5th", "05");
		dayLookUp.put("6th", "06");
		dayLookUp.put("7th", "07");
		dayLookUp.put("8th", "08");
		dayLookUp.put("9th", "09");
		dayLookUp.put("10th", "10");
		dayLookUp.put("11th", "11");
		dayLookUp.put("12th", "12");
		dayLookUp.put("13th", "13");
		dayLookUp.put("14th", "14");
		dayLookUp.put("15th", "15");
		dayLookUp.put("16th", "16");
		dayLookUp.put("17th", "17");
		dayLookUp.put("18th", "18");
		dayLookUp.put("19th", "19");
		dayLookUp.put("20th", "20");
		dayLookUp.put("21st", "21");
		dayLookUp.put("22nd", "22");
		dayLookUp.put("23rd", "23");
		dayLookUp.put("24th", "24");
		dayLookUp.put("25th", "25");
		dayLookUp.put("26th", "26");
		dayLookUp.put("27th", "27");
		dayLookUp.put("28th", "28");
		dayLookUp.put("29th", "29");
		dayLookUp.put("30th", "30");
		dayLookUp.put("31st", "31");
	}

	static {
		monthLookUp.put("Jan", "01");
		monthLookUp.put("Feb", "02");
		monthLookUp.put("Mar", "03");
		monthLookUp.put("Apr", "04");
		monthLookUp.put("May", "05");
		monthLookUp.put("Jun", "06");
		monthLookUp.put("Jul", "07");
		monthLookUp.put("Aug", "08");
		monthLookUp.put("Sep", "09");
		monthLookUp.put("Oct", "10");
		monthLookUp.put("Nov", "11");
		monthLookUp.put("Dec", "12");
	}

	public static List<String> reformatDate(List<String> dates) {
		List<String> reformedDate = new ArrayList<>();
		for(String date : dates){
			reformedDate.add(reformDate(date));
		}
		return reformedDate;
	}
	
	private static String reformDate(final String date){
		String[] tokens = date.split(" ");
		StringBuilder builder = new StringBuilder();
		builder.append(tokens[2]).append("-").append(convertMonthTonumeric(tokens[1])).append("-").append(convertDayToNumeric(tokens[0]));
		return builder.toString();
	}
	
	private static String convertDayToNumeric(final String day){
		return dayLookUp.get(day);
	}
	
	private static String convertMonthTonumeric(final String month){
		return monthLookUp.get(month);
	}
	
	public static void main(String[] args) {
		List<String> datesList = new ArrayList<>();
		datesList.add("1st Mar 1984");
		datesList.add("8th Nov 1991");
		for(String reformedDate : reformatDate(datesList)){
			System.out.println(reformedDate);
		}
	}
}
