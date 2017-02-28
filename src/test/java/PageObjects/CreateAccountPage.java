package PageObjects;

import io.appium.java_client.AppiumDriver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage extends AbstractPage{

	@FindBy(xpath = "//android.widget.TextView[@text='Create Your Account']")
	private WebElement lblCreateAccountTitle;
	
	@FindBy(id = "emailEdt")
	private WebElement edtEmail;
	
	@FindBy(id = "passwordEdt")
	private WebElement edtPassword;
	
	@FindBy(id = "nameEdt")
	private WebElement edtFirstName;
	
	@FindBy(id = "lastNameEdt")
	private WebElement edtLastName;
	
	@FindBy(id = "dateofBirthEdt")
	private WebElement edtDoB;
	
	@FindBy(id = "numberpicker_input")
	private List<WebElement> dtpDatePicker;
	

	@FindBy(xpath = "//android.widget.Button[@text='OK']")
	private WebElement btnOK;
	

	@FindBy(id = "create_account_terms_and_conditions_check_box")
	private WebElement chkTermsCondition;
	

	@FindBy(id = "createAccountBtn")
	private WebElement btnCreateAccount;
	
	
	public CreateAccountPage(AppiumDriver<WebElement> driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	public HomePage signUpCustomer(String strEmail, String strPassword, String strFName, String strLName, String strDoB){

		try {
			if (waitForElementVisible(lblCreateAccountTitle)){
				//Enter the User Details
				edtEmail.sendKeys(strEmail);
				edtPassword.sendKeys(strPassword);
				edtFirstName.sendKeys(strFName);
				edtLastName.sendKeys(strLName);
				
				//Get current and DoB date, month & Year
			    Calendar oDoBDate = new GregorianCalendar();
			    Date dtDOB;
				dtDOB = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).parse(strDoB);
			    oDoBDate.setTime(dtDOB);
			    Calendar oToday = Calendar.getInstance();
			    Calendar odtSetDate = new GregorianCalendar();
				
				int intDoBYear = oDoBDate.get(Calendar.YEAR);
				int intDoBMonth = oDoBDate.get(Calendar.MONTH);
				int intDoBDay = oDoBDate.get(Calendar.DAY_OF_MONTH);
				
				int intCurYear = oToday.get(Calendar.YEAR);
				int intCurMonth = oToday.get(Calendar.MONTH);
				int intCurDay = oToday.get(Calendar.DAY_OF_MONTH);
		
				//Enter the Date of Birth
				int intLoopCntr = 0;
				while(((intCurYear != intDoBYear) || (intCurMonth !=intDoBMonth) || (intCurDay != intDoBDay)) && intLoopCntr <3){	
					intLoopCntr++;
			        edtDoB.click();
			        List<WebElement> oDatePickList = dtpDatePicker;
			        //Set Month
			        scrollElementToValue(oDatePickList.get(0), intCurMonth, intDoBMonth, 1, 0.1);			        
			        //Set Day
			        scrollElementToValue(oDatePickList.get(1), intCurDay, intDoBDay, 1, 0.1);
			        //Set Year
			        scrollElementToValue(oDatePickList.get(2), intCurYear, intDoBYear, 1, 0.1);
			
			        btnOK.click();

			        String strSetDate = edtDoB.getText();
			        Date oSetDate = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(strSetDate);
			        odtSetDate.setTime(oSetDate);

					intCurYear = odtSetDate.get(Calendar.YEAR);
					intCurMonth = odtSetDate.get(Calendar.MONTH);
					intCurDay = odtSetDate.get(Calendar.DAY_OF_MONTH);
					System.out.println(intCurYear + " " + intCurMonth + " "  +  intCurDay);
				}
		        chkTermsCondition.click();
		        btnCreateAccount.click();
			}else System.out.println("Error: Control not in Create your Account Page");
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new HomePage(driver);
		
	}
}
