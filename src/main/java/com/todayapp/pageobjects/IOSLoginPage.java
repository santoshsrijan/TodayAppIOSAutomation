package com.todayapp.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cucumber.listener.Reporter;
import com.todayapp.utilities.DriverUtilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;

public class IOSLoginPage extends DriverUtilities {

	// public static By btnLogin =
	// By.xpath("//XCUIElementTypeButton[@name='AI_tapLogin']");

	public static By inputEmailId = By.xpath("//XCUIElementTypeStaticText[@name=\"Sign in to CNA with meCONNECT\"]/following::XCUIElementTypeTextField");
	public static By inputPassword = By.xpath("//XCUIElementTypeStaticText[@name=\"Sign in to CNA with meCONNECT\"]/following::XCUIElementTypeSecureTextField");

	public static By btnSignIn = By.xpath("//XCUIElementTypeButton[@name=\"Sign In\"]");
	public static By txtAbout = By.xpath("//XCUIElementTypeStaticText[@name=\"About\"]");
	public static By txtAccount = By.xpath("//XCUIElementTypeStaticText[@name=\"Account\"]");
	public static By txtContact = By.xpath("//XCUIElementTypeStaticText[@name=\"Contact\"]");
	public static By txtGeneral = By.xpath("//XCUIElementTypeStaticText[@name=\"General\"]");
	public static By txtMainInfo = By.id("com.channelnewsasia:id/tv_main_info");
	public static By menuSetting = MobileBy.AccessibilityId("Sync Data");
	public static By btnSettings = By
			.xpath("//XCUIElementTypeButton[@name=\"icon settings\"]");
	public static By btnLogin = By.xpath("//XCUIElementTypeButton[@name=\"Log in\"]");
	public static By btnSignInWithMeConnect = By
			.xpath("//XCUIElementTypeButton[@name=\"Sign in with meCONNECT\"]");
	public static By btnCNAEyeWitness = By
			.xpath("//android.widget.TextView[@resource-id='com.channelnewsasia:id/tv_cna_eye_witness']");

	public static By btnMedia = By
			.xpath("//XCUIElementTypeStaticText[@name=\"Mediacorp Digital Network\"]");

	public static By btnEdition = By
			.xpath("//XCUIElementTypeStaticText[@name=\"Edition\"]");
	
	
	

	public static void clickSettingsMenu() throws Throwable {

		try {

			click(btnSettings);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public static void clickLoginButton() throws Throwable {

		try {

			Thread.sleep(2000);
			TouchAction action = new TouchAction(driver);
			
			action.longPress(driver.findElement(txtAbout)).moveTo(driver.findElement(btnEdition)).release().perform();

			click(btnLogin);
			Reporter.addStepLog("Clicked on login button");
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public static void clickSignInWithMeConnect() throws Throwable {

		try {
			click(btnSignInWithMeConnect);
			Reporter.addStepLog("Clicked on signin with me connect button");
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public static void clickSignInButton() throws Throwable {

		try {
			click(btnSignIn);
			Reporter.addStepLog("Clicked on Signin button");

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	
	public static void enterEMailId(String text) throws Throwable {

		try {
			enterText(inputEmailId, text);
			Reporter.addStepLog("Entered email id" + text);

		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	public static void enterPassword(String text) throws Throwable {

		try {
			enterText(inputPassword, text);
			Reporter.addStepLog("Entered password" + text);

		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	
	
	public static String captureMainInfoText() throws Throwable {
		String text = "";

		try {

			text = getText(txtMainInfo);
			Reporter.addStepLog("MainInfo text is captured " + text);
		} catch (Exception e) {
			e.printStackTrace();

		}

		return text;
	}

	public static String captureAccountName(String strArg1) throws Throwable {
		
		String text = "";

		try {

			By txtAccountName = By.xpath("//XCUIElementTypeStaticText[@name='"+strArg1+"']");
			text = getText(txtAccountName);
			Reporter.addStepLog("Account name text is captured " + text);
		} catch (Exception e) {
			e.printStackTrace();

		}

		return text;
		
		
	}

	public static void moveToAccount() throws InterruptedException {
		Thread.sleep(2000);
		TouchAction action = new TouchAction(driver);
		
		action.longPress(driver.findElement(txtGeneral)).moveTo(driver.findElement(txtAccount)).release().perform();
		
	}

}
