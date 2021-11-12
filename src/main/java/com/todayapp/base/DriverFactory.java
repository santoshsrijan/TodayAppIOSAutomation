package com.todayapp.base;

import java.io.IOException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentTest;
import com.todayapp.utilities.DriverUtilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class DriverFactory {

	@SuppressWarnings("rawtypes")
	public static AppiumDriver driver;
	public static ExtentTest test;
	public static DriverUtilities utils = new DriverUtilities();
	public static String platform, appMainActivity, appPackage, deviceName, automationName, bundleid, platformVersion,
			udid, host, port, waitTime,app;
	//private final AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();

	@BeforeSuite

	@SuppressWarnings("rawtypes")
	public void launchApp() throws MalformedURLException, IOException {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		platform = System.getProperty("platform");
		String device = System.getProperty("device");

		if (platform.equals("Android")) {
			appMainActivity = utils.readJsonValue("appactivity");
			appPackage = utils.readJsonValue("package");
			deviceName = utils.readJsonValue("androiddevice");
			app=utils.readJsonValue("app");
			
			if(device.equals("pixel")) {
			udid = utils.readJsonValue("pixeludid");
			platformVersion = utils.readJsonValue("platformversion1");
			}else {
				udid = utils.readJsonValue("samsungudid");
				platformVersion = utils.readJsonValue("platformversion");
			}
		     
		    

			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
			capabilities.setCapability(MobileCapabilityType.UDID, udid);
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
			//capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appMainActivity);
			//capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage);
			capabilities.setCapability(MobileCapabilityType.APP,app);
			
			capabilities.setCapability(MobileCapabilityType.NO_RESET, "true");
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} else if (platform.equals("ios")) {

			deviceName = utils.readJsonValue("deviceName");
			udid = utils.readJsonValue("udid");
			platformVersion = utils.readJsonValue("platformVersion");

			//bundleid = utils.readJsonValue("bundleid");
			app = utils.readJsonValue("app");
			
			
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "ios");
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
			capabilities.setCapability(MobileCapabilityType.UDID, udid);
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
			
			
				capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
			
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
			//capabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, bundleid);
			capabilities.setCapability(MobileCapabilityType.NO_RESET, "true");
			capabilities.setCapability(MobileCapabilityType.APP, app);
			
			

			driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		}

	}
	
	/*public void initializeAppiumServer(String executionEnv,String executionHost,int port) {
         
            this.serviceBuilder.withIPAddress(executionHost);
            this.serviceBuilder.usingPort(port).usingDriverExecutable(new File(nodePath)).withAppiumJS(new File(appiumPath));
            this.server = AppiumDriverLocalService.buildService(serviceBuilder);
            this.server.start();
    
    }

	/*
	 * String platform = System.getProperty("platform");
	 * 
	 * 
	 * 
	 * 
	 * host = utils.readJsonValue("host"); port=utils.readJsonValue("port");
	 * 
	 * if (platform.equalsIgnoreCase("ios")) { System.out.println(platform); driver
	 * = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"),
	 * setDeviceCapabilities()); driver.manage().timeouts().implicitlyWait(20,
	 * TimeUnit.SECONDS); //driver.installApp(
	 * "/Users/admin/Downloads/C365Fields_16June/ConstructMobile.iOS");
	 * 
	 * 
	 * } else if (platform.equalsIgnoreCase("android")) { //driver = new
	 * AndroidDriver(new URL("http://" + host + ":" + port + "/wd/hub"),
	 * setDeviceCapabilities()); driver = new AndroidDriver(new
	 * URL("http://127.0.0.1:4723/wd/hub"), setDeviceCapabilities()); }
	 * 
	 * driver.manage().timeouts().implicitlyWait(Integer.parseInt(waitTime),
	 * TimeUnit.SECONDS); }
	 */

	public static DesiredCapabilities setDeviceCapabilities() throws IOException {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		platform = System.getProperty("platform");

		if (System.getProperty("device").equals("samsung")) {

			System.out.println("Launching the app in samsung device");
			deviceName = utils.readJsonValue("androiddevice");
			udid = utils.readJsonValue("samsungudid");

		} else if (System.getProperty("device").equals("iphone")) {
			System.out.println("Launching the app in iphone");

			deviceName = utils.readJsonValue("iphonedevice");
			udid = utils.readProperty("iphoneudid");

		}
		automationName = utils.readJsonValue("automationname");
		// bundleid = utils.readProperty("bundleid");
		platformVersion = utils.readJsonValue("platformversion");
		host = utils.readJsonValue("host");
		port = utils.readJsonValue("port");
		waitTime = utils.readJsonValue("waittime");

		if (platform.equals("android")) {
			appMainActivity = utils.readJsonValue("appactivity");
			appPackage = utils.readJsonValue("package");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
			capabilities.setCapability(MobileCapabilityType.UDID, udid);
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
			capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appMainActivity);
			capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage);
		} else {
			bundleid = utils.readJsonValue("bundleid");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platform);
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
			capabilities.setCapability(MobileCapabilityType.UDID, udid);
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, automationName);
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
			capabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, bundleid);

		}

		// capabilities.setCapability(MobileCapabilityType.NO_RESET,true);

		// capabilities.setCapability(MobileCapabilityType.FULL_RESET,false);

		return capabilities;
	}

}
