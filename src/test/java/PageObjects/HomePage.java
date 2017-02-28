package PageObjects;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractPage{
	
	

	@FindBy(id = "activity_home_page_settings")
	private WebElement btnSettings;
	
	public HomePage(AppiumDriver<WebElement> driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	public SettingsPage clickSettings(){
		if (waitForElementVisible(btnSettings)){
			btnSettings.click();		
		}
		return new SettingsPage(driver);
		
	}
}
