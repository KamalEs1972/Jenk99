package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.TestBase;

public class SignUpPage extends TestBase {
	
	
	@FindBy(css="#inputFirstName")
	WebElement firstName;
	
	@FindBy(css="#inputLastName")
	WebElement lastName;
	
	@FindBy(css="#inputEmail")
	WebElement email;
	
	@FindBy(css="#inputPhone")
	WebElement phoneNumber;
	
	@FindBy(css="#containerNewUserSignup > div:nth-child(1) > div > div > div:nth-child(4) > div > div > div > div > div.iti-arrow")
	WebElement selectedDialCode;
	
	@FindBy(css="#containerNewUserSignup > div:nth-child(1) > div > div > div:nth-child(4) > div > div > div > ul > li:nth-child(2) > span.country-name")
	WebElement countryName;
	
	//**************************
	
	@FindBy (css="#inputCompanyName")
	WebElement companyName;
	
	@FindBy (css="#inputAddress1")
	WebElement addess1;
	
	@FindBy (css="#inputAddress2")
	WebElement address2;
	
	@FindBy (css="#inputCity")
	WebElement city;
	
	@FindBy (css="#stateinput")
	WebElement state;
	
	@FindBy (css="#inputPostcode")
	WebElement postCode;
	
	@FindBy(css="#inputCountry")
	WebElement inputCounty;
	
	@FindBy(css="#frmCheckout > div.card.mb-4 > div > div > div > span.bootstrap-switch-handle-on.bootstrap-switch-success")
	WebElement mailingList;
	
	@FindBy(css=".btn-large")
	WebElement register;
	
	@FindBy(css="#main-body > div > div.row > div.col-lg-8.col-xl-9.primary-content > div.alert.alert-danger > ul > li")
	WebElement textMuted;
	
	@FindBy(css="#inputNewPassword1")
	WebElement password;
	
	@FindBy(css="#inputNewPassword2")
	WebElement confirmPassword;
	
	@FindBy(css="div[class='recaptcha-checkbox-border']")
	WebElement recaptch;
	
	@FindBy(css="#\\#divDynamicRecaptcha1 > div > div > iframe")
	WebElement recaptchIframe;
	
	
	
	
//	@FindBy(css="#containerNewUserSignup > div:nth-child(1) > div > div > div:nth-child(4) > div > div > div > ul")
//	String countriesList;
	
	
	
	
	
	
	
	
	
	public SignUpPage(){
		PageFactory.initElements(driver, this);
		
			}
	
	public void enterPersonalInfo(){
		firstName.sendKeys("Kamal3");
	
		lastName.sendKeys("Essalhi");
	
		email.sendKeys("djkimo945@yahoo.com");
//	}
//	public void selectDialCode() {
		
	//	Select objSelect =new Select(selectedDialCode);
	//	objSelect.selectByVisibleText("United States");
	//	objSelect.getClass();
		selectedDialCode.click();
	//	countryName.click();
		
		List <WebElement> list= driver.findElements(By.xpath("//ul[contains(@class,'country-list')]//li"));
		System.out.println(list.size());
		
		for(int i=0 ; i<list.size();i++) {
			if(list.get(i).getText().contains("United States")) {
				list.get(i).click();
				break;
			}
		}
		phoneNumber.sendKeys("703-618-7180");
		
	}
	
	
	public void billingAddress() {
		
		companyName.sendKeys("Kimo_Entertainment");
		addess1.sendKeys("12496 Skipper Cir");
		city.sendKeys("Woodbridge");
		state.sendKeys("Virginia");
		postCode.sendKeys("22192");
	
		
		Select objSelect =new Select(inputCounty);
			objSelect.selectByVisibleText("United States");
			
			mailingList.click();
			password.sendKeys("123456");
			confirmPassword.sendKeys("123456");
			
		
			
			Actions actions=new Actions(driver);
			actions.moveToElement(register);
			actions.perform();
		//	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(recaptchIframe));
			 wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.recaptcha-checkbox-checkmark")));
		//	element.click();
			 //  new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(recaptch)).click();
			recaptch.click();
			driver.switchTo().defaultContent();
			register.click();
			String actualText = textMuted.getText();
			String expectedTitle = "Please complete the captcha and try again.";
			Assert.assertEquals(actualText, expectedTitle);
	
		
		
	}
	
	

}
