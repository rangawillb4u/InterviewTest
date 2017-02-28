package PageObjects;

import io.appium.java_client.AppiumDriver;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import StepDefinitions.AbstractStep;



public class AbstractPage extends AbstractStep{

	protected AppiumDriver<WebElement> driver = getAndroidDriver();
	
	public AbstractPage(AppiumDriver<WebElement> driver){
		this.driver = driver;
	}
	



}
