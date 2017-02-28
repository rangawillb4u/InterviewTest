package PageObjects;

import io.appium.java_client.AppiumDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage extends AbstractPage {
	
	Map<Integer, String> dictMenuItems = new HashMap<>();
	

//    HashMap dictMenuItems = new HashMap(); 

	@FindBy(xpath = "//android.widget.TextView")
	private List<WebElement> oMenuItemList;
	
	public SettingsPage(AppiumDriver<WebElement> driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public SettingsPage printMenuItems(){
		
		updateMenuItems(driver, dictMenuItems);
        driver.swipe(200, 600, 200, 200, 500);
        updateMenuItems(driver, dictMenuItems);
        

        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println("Printing the Menu Items");
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        for (int intKey = 1; intKey <dictMenuItems.size(); intKey++){
        	 	System.out.println(dictMenuItems.get(intKey));
        }
		
		return new SettingsPage(driver);
	}

	public void updateMenuItems(AppiumDriver<WebElement> driver, Map<Integer, String> dictMenuItems){
        for (WebElement oEL : oMenuItemList) {
        		String strItem = oEL.getText();
        		if (!dictMenuItems.containsValue(strItem)){
            		dictMenuItems.put(dictMenuItems.size(), strItem);        			
        		}
        }        
	}
	
	
}
