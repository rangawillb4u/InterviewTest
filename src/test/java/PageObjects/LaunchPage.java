package PageObjects;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LaunchPage extends AbstractPage {
	
	@FindBy(how = How.ID, using = "activity_registration_sign_up")
	private WebElement btnSignUp;
	
	public LaunchPage(AppiumDriver<WebElement> driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public CreateAccountPage clickSignUp(){
		if (waitForElementVisible(btnSignUp)){		
			btnSignUp.click();
		}else System.out.println("Error: Control not in Launch Page");
		return new CreateAccountPage(driver) ;
		
	}
	
	
}
