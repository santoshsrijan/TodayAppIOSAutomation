package com.todayapp.pageobjects;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import com.cucumber.listener.Reporter;
import com.todayapp.utilities.DriverUtilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;

public class AndroidLoginPage extends DriverUtilities {

	// public static By btnLogin =
	// By.xpath("//XCUIElementTypeButton[@name='AI_tapLogin']");


	public static By inputEmailId = By.xpath("(//android.widget.EditText[@resource-id='com.channelnewsasia:id/text_input_editText'])[1]");
	public static By inputPassword = By.xpath("(//android.widget.EditText[@resource-id='com.channelnewsasia:id/text_input_editText'])[2]");

	public static By btnSignIn = By.xpath("//android.widget.Button[@resource-id='com.channelnewsasia:id/btn_sign_in']");
	public static By txtMainInfo = By.id("com.channelnewsasia:id/tv_main_info");
	public static By menuSetting = MobileBy.AccessibilityId("Sync Data");
	public static By txtGeneral = By.xpath("//android.widget.TextView[@text='General']");
	public static By txtAccount = By.xpath("//android.widget.TextView[@text='Account']");
	public static By txtNotifications = By.xpath("//android.widget.TextView[@text='Notifications']");
	public static By txtContact = By.xpath("//android.widget.TextView[@text='Contact']");
	public static By txtHelpAndFeedback = By.xpath("//android.widget.TextView[@text='Help and feedback']");
	public static By btnSettings = By
			.xpath("//android.widget.ImageView[@resource-id='com.channelnewsasia:id/iv_setting']");
	public static By btnLogin = By.xpath("//android.widget.Button[@resource-id='com.channelnewsasia:id/bt_login']");
	public static By btnSignInWithMeConnect = By
			.xpath("//android.view.ViewGroup[@resource-id='com.channelnewsasia:id/cl_me_connect']");
	public static By btnCNAEyeWitness = By
			.xpath("//android.widget.TextView[@resource-id='com.channelnewsasia:id/tv_cna_eye_witness']");

	public static By btnMedia = By
			.xpath("//android.widget.TextView[@resource-id='com.channelnewsasia:id/tv_mediacorp_digital_network']");

	public static By btnEdition = By
			.xpath("//android.widget.TextView[@resource-id='com.channelnewsasia:id/tv_edition']");
	
	public static By btnBack = By.xpath("//android.widget.ImageView[@resource-id='com.channelnewsasia:id/iv_back']");
	
	public static By btnTopStories = By.xpath("//android.widget.CompoundButton[@text='Top Stories']");
	

	public static void clickSettingsMenu() throws Throwable {

		try {

			click(btnSettings);
			Reporter.addStepLog("Clicked on settings button");
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.addStepLog("Unable to click on settings button");

		}
	}

	public static void clickLoginButton() throws Throwable {

		try {

			Thread.sleep(2000);
			TouchAction action = new TouchAction(driver);
			// [41,1906][1039,1977]
			// [41,878][1039,1038]

			// action.pre
			action.longPress(driver.findElement(btnMedia)).moveTo(driver.findElement(btnEdition)).release().perform();

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
	
	public static void clickBackButton() throws Throwable {

		try {
			click(btnBack);
			Reporter.addStepLog("Clicked on back button");

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	public static boolean dashboardPresence() throws Throwable {
		
		boolean isDashboardPresent = false;
		try {
			
			isDashboardPresent = driver.findElement(btnTopStories).isDisplayed();
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		
		return isDashboardPresent;
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

			By txtAccountName = By.xpath("//android.widget.TextView[@text='"+strArg1+"']");
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
	
	action.longPress(driver.findElement(txtNotifications)).moveTo(driver.findElement(txtHelpAndFeedback)).release().perform();
	
}



}
