package StepDefinitions;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AbstractStep {
	
	protected static AndroidDriver<WebElement> driver;
	
	
	public AndroidDriver<WebElement> getAndroidDriver(){
		if (driver == null){
				
			// set up appium
			String strRelativePath = System.getProperty("user.dir") + "//";
			System.out.println(strRelativePath);
	        File classpathRoot = new File(System.getProperty("user.dir"));
	        File appDir = new File(classpathRoot, "src/test/resource/Apps");
	        File app = new File(appDir, "com.babylon-71-2.2.9.apk");
	        DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability("deviceName","Nexus 5");
	        capabilities.setCapability("platformVersion", "6.0");
	        capabilities.setCapability("app", app.getAbsolutePath());
	        capabilities.setCapability("appPackage", "com.babylon");
	        capabilities.setCapability("appActivity", "com.babylon.activity.RegistrationActivity");
	        try {
				driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		return driver;
	}
	
	
	public boolean waitForElementVisible(WebElement oElement){
		WebDriverWait wait = new WebDriverWait(driver, 60);
		try{
			wait.until(ExpectedConditions.visibilityOf(oElement));
		}catch (Exception e){
			System.out.println("Element not Visisble");
			return false;
		}
		return true;
	}
	

    //Scrolls on the Scrollable element to set the specific value passed 
    public void scrollElementToValue(WebElement oScrolElement, int intCurrentValue, int intSetValue, int intPrecision, double dblScrolPrecesion) throws InterruptedException{
    		Point oScrolElLocationPoint = oScrolElement.getLocation();
        int intLeftX =  oScrolElLocationPoint.getX();        
        int intUpperY = oScrolElLocationPoint.getY();
        

		Dimension oScrolElSizePoint = oScrolElement.getSize();
		
        int intWidth = oScrolElSizePoint.getWidth();
        int intHieght = oScrolElSizePoint.getHeight();
        int intStX = intLeftX + intWidth/2;
        int intStY = (int) (intUpperY + dblScrolPrecesion* (intHieght/8));
        int intEndX = intStX;
        int intEndY = intUpperY + 7*(intHieght/8);
        if (intSetValue!=intCurrentValue){
            if (intSetValue < intCurrentValue){
                int intTemp = intEndY;
                intEndY = intStY;
                intStY = intTemp;
            }
            
            int intIterCount = (int)Math.abs((intSetValue-intCurrentValue)/intPrecision);
            for (int intCnt=0; intCnt< intIterCount; intCnt++){
                driver.swipe(intStX, intEndY, intEndX, intStY, 200);
                Thread.sleep(500);
            }
            
        }
        
            	
    }


	public void quitDriver() {
		driver.quit();
		
	}
}
