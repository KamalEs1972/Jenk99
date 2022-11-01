package pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy (css=".jfHeader-logoLink #PHPTRAVELS")
	WebElement headLineText;
	
	@FindBy(css=".jfHeader-menuListLink.jfHeader-dynamicLink.jfHeader-login-action")
	static
		WebElement loginBtn;
	
	@FindBy(css=".jfHeader-menuListLink.jfHeader-dynamicLink.jfHeader-signup-action")
	WebElement signUpbtn;
	
	@FindBy(css=".h3")
	WebElement loginText;
	
	@FindBy(css="#containerNewUserSignup > div:nth-of-type(1) .card-title")
	WebElement SignUpVerificationPage;
	
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void verifyPageTitle(){
	//	return driver.getTitle();
		String actualTitle = driver.getTitle();
		driver.manage().window().maximize();
		String expectedTitle = "Book Your Free Demo Now - Phptravels";
		Assert.assertEquals(actualTitle, expectedTitle);
	

}
	public static  LoginPage clickOnLoginBtn(){
		loginBtn.click();
		return new LoginPage();
}
	public  boolean verifyloginText(){
		switchToWindow();
		

		return loginText.isDisplayed();
	}		
	public SignUpPage clickOnSignUpBtn(){
		signUpbtn.click();
		return new SignUpPage();
}
	public  boolean verifySignUpText(){
		switchToWindow();
		

	return SignUpVerificationPage.isDisplayed();
	
	
	
	}

}
