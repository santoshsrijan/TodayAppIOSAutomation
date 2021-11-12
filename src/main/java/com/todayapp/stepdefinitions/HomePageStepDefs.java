package com.todayapp.stepdefinitions;

import java.io.InputStreamReader;

import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.testng.asserts.SoftAssert;

import com.cucumber.listener.Reporter;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.todayapp.pageobjects.HomePage;
import com.todayapp.stepdefinitions.Hooks;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageStepDefs extends HomePage {
	static SoftAssert softassert = new SoftAssert();
	Hooks hooks = new Hooks();

	@Then("^I verify the data$")
	public void i_verify_the_data() {

		String uri = "https://images-api.nasa.gov/search?q=clouds";
		List<String> hrefs = new ArrayList<String>();

	}

	@When("^I am in app splash screen in today app$")
	public void i_am_in_app_splash_screen_in_today_app() throws Throwable {

	}

	@When("^I click on minute menu$")
	public void i_click_on_minute_menu() throws Throwable {
		clickMinuteMenu();
	}

	@When("^I verify the minute menu is selected$")
	public void i_verify_the_minute_menu_is_selected() throws Throwable {
		boolean verifyMenuItem = verifyMinuteMenuIsHighlighted();

		if (verifyMenuItem) {
			Reporter.addStepLog("Minute menu is highlighted");

		} else {
			softassert.assertEquals(true, false);
			Reporter.addStepLog("Failed to verify the element ");
			hooks.addScreenshot();
		}
	}
	
	@And("^I click on search button$")
	public void i_click_on_search_button() throws Throwable {
		clickSearchButton();
	}
	
    

	@And("^I enter the \"([^\"]*)\" search text$")
    public void i_enter_the_search_text_as(String searchText) throws Throwable {
    	enterSearchText(searchText);
    }
    
   

	@Then("^I should see the \"([^\"]*)\" search results$")
    public void i_should_see_the_results(String searchText) throws Throwable {
    	verifySearchResults(searchText);
    }
	
	@Then("I should see the \"([^\"]*)\" error message$")
    public void i_should_see_the_error_message(String searchText) throws Throwable {
    	verifyErrorMessage(searchText);
    }

	

	

	

	
}
