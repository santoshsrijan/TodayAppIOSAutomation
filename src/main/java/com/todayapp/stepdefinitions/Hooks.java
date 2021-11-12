package com.todayapp.stepdefinitions;

import java.io.File;


import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cucumber.listener.Reporter;
import com.todayapp.base.DriverFactory;

import cucumber.api.Scenario;

public class Hooks extends DriverFactory {

	// @Before
	public void beforeScenario(Scenario scenario) {
		Reporter.assignAuthor("TodayApp - Santosh");
	}

	public void addScreenshot() {

		System.out.println(System.getProperty("user.dir"));
		// if (scenario.isFailed()) {
		// String screenshotName = scenario.getName().replaceAll(" ", "_");
		String screenshotName = "screenshot" + System.currentTimeMillis();

		try {
			// This takes a screenshot from the driver at save it to the specified location
			TakesScreenshot screenshot = (TakesScreenshot) DriverFactory.driver;

			File sourcePath = screenshot.getScreenshotAs(OutputType.FILE);
			// Building up the destination path for the screenshot to save
			// Also make sure to create a folder 'screenshots' with in the cucumber-report
			// folder
			File destinationPath = new File(
					System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotName + ".png");
			System.out.println(destinationPath.toString());
			// Copy taken screenshot from source location to destination location
			// Files.copy(destinationPath, destinationPath)o
			FileUtils.copyFile(sourcePath, destinationPath);
			// Files.copy(sourcePath, destinationPath);

			// This attach the specified screenshot to the test
			Reporter.addScreenCaptureFromPath(destinationPath.toString());

		} catch (IOException e) {
		}
	}
	// }

}
