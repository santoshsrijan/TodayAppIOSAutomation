package com.todayapp.stepdefinitions;

import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

import com.todayapp.utilities.DriverUtilities;

public class sample {

	
	
	public static void test() {
		
	}
	@Test
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

		//get current date time with Date()
		Date date = new Date();

		// Now format the date
		String dateFormatted= dateFormat.format(date);
		
		System.out.println(dateFormatted);
	}

}
