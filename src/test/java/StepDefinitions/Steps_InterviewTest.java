package StepDefinitions;


import io.appium.java_client.AppiumDriver;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;

import PageObjects.HomePage;
import PageObjects.LaunchPage;
import PageObjects.SettingsPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps_InterviewTest extends AbstractStep {

	AppiumDriver<WebElement> driver = getAndroidDriver();
		

	@Given("^The below new user is registered$")
	public void the_below_new_user_is_registered(List<Map<String, String>> oDataTable) throws Throwable {
		
	    System.out.println(oDataTable);
	    Map<String, String> oDataMap = oDataTable.get(0);
	    String strEmail = oDataMap.get("Email");
	    String strPassword = oDataMap.get("Password");
	    String strFName = oDataMap.get("First Name");
	    String strLName = oDataMap.get("Last Name");
	    String strDoB = oDataMap.get("Date of Birth");
	    
		
	    
		LaunchPage launchPage = new LaunchPage(driver);
		launchPage.clickSignUp()
						 .signUpCustomer(strEmail, strPassword, strFName, strLName, strDoB);
	}

	@When("^The Settings menu is clicked$")
	public void the_Settings_menu_is_clicked() throws Throwable {

        HomePage homePage = new HomePage(driver);
        homePage.clickSettings();
	}

	@Then("^Print the Settings menu items to the console$")
	public void print_the_Settings_menu_items_to_the_console() throws Throwable {

		SettingsPage settingsPage = new SettingsPage(driver);
		settingsPage.printMenuItems();
		quitDriver();
	}

	
}
