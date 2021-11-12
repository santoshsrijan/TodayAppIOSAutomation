package com.todayapp.runners;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.cucumber.listener.Reporter;
import com.google.common.io.Files;
import com.todayapp.base.DriverFactory;

import cucumber.api.CucumberOptions;
//import io.cucumber.java.After;
import cucumber.api.Scenario;
//import io.cucumber.java.Scenario;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "features", glue = { "com.todayapp.stepdefinitions" }, plugin = {
		"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html", "pretty",
		"junit:target/cucumber-reports/cucumber-junitreport.xml",
		"json:target/cucumber.json" }, tags = { "@invalidsearch" }, monochrome = true
// dryRun = true
)
public class SmokeRunner extends AbstractTestNGCucumberTests {
	@AfterClass
	public static void setup() {

		String devicename = System.getProperty("device");
		Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
		// Reporter.setSystemInfo("Test User", System.getProperty("user.name"));
		Reporter.setSystemInfo("User Name", "Santosh");
		Reporter.setSystemInfo("Application Name", "Today App");
		Reporter.setSystemInfo("Environment", "QA");
		Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
		Reporter.setSystemInfo("Device", devicename);
		Reporter.setSystemInfo("Testing Type", "Functional Testing");

	}

	DriverFactory factory = new DriverFactory();

	public static byte[] getByteScreenshot() throws IOException {
		File src = ((TakesScreenshot) DriverFactory.driver).getScreenshotAs(OutputType.FILE);
		byte[] fileContent = FileUtils.readFileToByteArray(src);
		return fileContent;
	}

	// @AfterStep
	public void as(Scenario scenario) throws IOException, InterruptedException {

		scenario.embed(getByteScreenshot(), "image/png");
	}

	@BeforeClass
	public void launchApp() throws MalformedURLException, IOException {
		factory = new DriverFactory();
		factory.launchApp();
	}

	// @After
	public void addScreenshot(Scenario scenario) {

		System.out.println("scenario is " + scenario.isFailed());
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			try {
				// This takes a screenshot from the driver at save it to the specified location
				TakesScreenshot screenshot = (TakesScreenshot) DriverFactory.driver;

				File sourcePath = screenshot.getScreenshotAs(OutputType.FILE);
				// Building up the destination path for the screenshot to save
				// Also make sure to create a folder 'screenshots' with in the cucumber-report
				// folder
				File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/"
						+ screenshotName + ".png");

				// Copy taken screenshot from source location to destination location
				// Files.copy(destinationPath, destinationPath)o
				Files.copy(sourcePath, destinationPath);

				// This attach the specified screenshot to the test
				Reporter.addScreenCaptureFromPath(destinationPath.toString());
			} catch (IOException e) {
			}
		}
	}
}
