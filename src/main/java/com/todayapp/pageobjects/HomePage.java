package com.todayapp.pageobjects;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import com.todayapp.base.DriverFactory;
import com.todayapp.stepdefinitions.Hooks;

import com.cucumber.listener.Reporter;
import com.todayapp.utilities.DriverUtilities;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class HomePage extends DriverFactory {

	static SoftAssert softassert = new SoftAssert();
	Hooks hooks = new Hooks();

	public By minuteButton = By.xpath("//android.widget.TextView[@text='MINUTE']");
	public By minuteHighlightedText = By.xpath("//android.widget.TextView[@text='MINUTE' and @selected = 'true']");
	public By searchButton = By.xpath("//android.widget.ImageView[@resource-id='com.channelnewsasia.mcbeta:id/iv_search']");
	public By searchBox = By.xpath("//android.widget.EditText[@resource-id='com.channelnewsasia.mcbeta:id/et_search']");
	public By searchSuggestion = By.xpath("//android.widget.TextView[@resource-id='com.channelnewsasia.mcbeta:id/tv_suggestion']");
	public By searchErrorMessage = By.xpath("//android.widget.TextView[@resource-id='com.channelnewsasia.mcbeta:id/tv_content']");

	public void clickMinuteMenu() throws Throwable {

		Thread.sleep(4000);

		String platform = System.getProperty("platform");

		try {

			if (platform.equals("Android")) {

				DriverUtilities.click(minuteButton);
				Reporter.addStepLog("clicked the element ");

			} else {
				DriverUtilities.click(minuteButton);
				Reporter.addStepLog("clicked the element ");
			}
		} catch (Exception e) {
			softassert.assertEquals(true, false);
			Reporter.addStepLog("Failed to click the element ");
			hooks.addScreenshot();
		}
	}

	public boolean verifyMinuteMenuIsHighlighted() throws Throwable {

		String platform = System.getProperty("platform");

		boolean menuItemPresence = false;

		try {

			if (platform.equals("Android")) {

				menuItemPresence = driver.findElement(minuteHighlightedText).isDisplayed();
			} else {
				menuItemPresence = driver.findElement(minuteHighlightedText).isDisplayed();
			}
		} catch (Exception e) {
			softassert.assertEquals(true, false);
			Reporter.addStepLog("Failed to capture the element ");
			hooks.addScreenshot();

		}
		return menuItemPresence;

	}

	public void clickSearchButton() throws Throwable {

		String platform = System.getProperty("platform");

		try {
			Thread.sleep(6000);

			if (platform.equals("Android")) {

				DriverUtilities.click(searchButton);
				Reporter.addStepLog("clicked the element ");

			} else {
				DriverUtilities.click(searchButton);
				Reporter.addStepLog("clicked the element ");
			}
		} catch (Exception e) {
			softassert.assertEquals(true, false);
			Reporter.addStepLog("Failed to click the element ");
			hooks.addScreenshot();
		}
	}

	public void enterSearchText(String searchText) throws Throwable {
		String platform = System.getProperty("platform");

		try {

			if (platform.equals("Android")) {

				DriverUtilities.enterText(searchBox, searchText);
				driver.getKeyboard().pressKey(platform);
				Reporter.addStepLog("clicked the element ");

			} else {
				DriverUtilities.enterText(searchBox, searchText);
				Reporter.addStepLog("clicked the element ");
			}
		} catch (Exception e) {
			softassert.assertEquals(true, false);
			Reporter.addStepLog("Failed to click the element ");
			hooks.addScreenshot();
		}

	}

	public void verifySearchResults(String searchText) throws Throwable {
		String platform = System.getProperty("platform");

		if (platform.equals("Android")) {
			DriverUtilities.click(searchSuggestion);

			ArrayList<String> searchresults = new ArrayList<String>();

			List<WebElement> searchresultelements = new ArrayList<WebElement>();

			searchresultelements = driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.channelnewsasia.mcbeta:id/tv_title']"));

			for (WebElement ele : searchresultelements) {

				searchresults.add(ele.getText());

			}

			for (String s : searchresults) {
				if (s.contains(searchText)) {
					Reporter.addStepLog("Search result contains " + searchText);
				} else {
					softassert.assertEquals(true, false);
					Reporter.addStepLog("Search result dont contain  " + searchText);
					hooks.addScreenshot();
				}
			}

		}

	}
	
	public void verifyErrorMessage(String searchText) throws Throwable {
		String platform = System.getProperty("platform");

		if (platform.equals("Android")) {
			
			String errorMessage = "Sorry, we can't find any results for '"+searchText+"' with the selected filters. "
					+ "Please try again by refining your keyword(s) or applying different filters. Alternatively you might "
					+ "want to check out these top stories:";

		String actualErrorMessage = DriverUtilities.getText(searchErrorMessage);
			
				if (actualErrorMessage.equals(errorMessage)) {
					Reporter.addStepLog("Search Error message is validated " +errorMessage);
				} else {
					softassert.assertEquals(errorMessage, actualErrorMessage);
					Reporter.addStepLog("Search error message is not validated    " + errorMessage);
					hooks.addScreenshot();
				}
			}

		}
		
	}


