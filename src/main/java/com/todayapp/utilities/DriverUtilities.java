package com.todayapp.utilities;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.DateFormatSymbols;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.todayapp.base.DriverFactory;
import com.todayapp.stepdefinitions.Hooks;

public class DriverUtilities extends DriverFactory {

	public static Properties config;
	public static FileInputStream fis;
	public static File file;
	public static String value;
	public static SoftAssert sa = new SoftAssert();
	public static Hooks hook = new Hooks();

	public String readProperty(String key) throws IOException {
		config = new Properties();
		fis = new FileInputStream(
				"/Users/santosh.singh/mobile-automation/mobile-automation-framework/MobileAutomationProject/GlobalSettings.properties");
		// Users/santosh.singh/mobile-automation/mobile-automation-framework/MobileAutomationProject/GlobalSettings.properties
		// Users/santosh.singh/git/repository/MobileAutomationProject/GlobalSettings.properties
		config.load(fis);
		value = config.getProperty(key);
		return value;

	}

	public String readJsonValue(String key) {

		String value = "";

		JSONParser parser = new JSONParser();

		try {

			String platform = System.getProperty("platform");

			if (platform.equals("Android")) {

				Reader reader = new FileReader("src/test/resources/config/AndroidConfig.json");

				JSONObject jsonObject = (JSONObject) parser.parse(reader);

				value = (String) jsonObject.get(key);

			} else {

				Reader reader = new FileReader("src/test/resources/config/iOSConfig.json");

				JSONObject jsonObject = (JSONObject) parser.parse(reader);

				value = (String) jsonObject.get(key);

			}

		} catch (Exception e) {

		}

		return value;
	}

	public String readTestData(String key) {

		String value = "";

		JSONParser parser = new JSONParser();

		try {

			Reader reader = new FileReader("src/test/resources/config/Testdata.json");

			JSONObject jsonObject = (JSONObject) parser.parse(reader);

			value = (String) jsonObject.get(key);

		} catch (Exception e) {

		}

		return value;
	}

	public static void click(By locator) throws Throwable {

		try {
			driver.findElement(locator).click();

		} catch (Exception e) {
			sa.assertTrue(false, "Unable to click button");

		}
	}

	public static void click(WebElement ele) throws Throwable {

		try {
			ele.click();

		} catch (Exception e) {
			sa.assertTrue(false, "Unable to click button");

		}
	}

	public static void waitForElementToBeVisible(By locator) throws Throwable {

		try {

			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		} catch (Exception e) {
			sa.assertTrue(false, "Element is not visible");
		}
	}

	public static void enterText(By locator, String text) throws Throwable {

		try {
			// driver.getKeyboard();
			driver.findElement(locator).click();
			driver.findElement(locator).clear();
			driver.findElement(locator).sendKeys(text);

		} catch (Exception e) {
			sa.assertTrue(false, "Unable to enter text");
			sa.assertAll();

		}
	}

	public static String getText(By locator) throws Throwable {

		String text = "";
		try {
			text = driver.findElement(locator).getText();

		} catch (Exception e) {

			sa.assertTrue(false, "Unable to get text");

		}

		return text;
	}

	public static int getElements(By locator) throws Throwable {

		int count = 0;
		try {
			count = driver.findElements(locator).size();

		} catch (Exception e) {

			sa.assertTrue(false, "Unable to get text");

		}

		return count;
	}

	public static boolean isElementDisplayed(By locator) throws Throwable {

		boolean presenceOfElement = false;
		try {
			presenceOfElement = driver.findElement(locator).isDisplayed();
			System.out.println(presenceOfElement);

		} catch (Exception e) {
			presenceOfElement = false;
			sa.assertTrue(false, "Unable to verify the element");

		}

		return presenceOfElement;
	}

}
