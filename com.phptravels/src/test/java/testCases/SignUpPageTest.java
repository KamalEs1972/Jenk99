package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.SignUpPage;

public class SignUpPageTest extends TestBase {
	
	HomePage homePage;
	SignUpPage signUpPage;
	
	
	
	public SignUpPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
	System.out.println(driver.getTitle());
		 homePage= new HomePage ();
		  signUpPage = new SignUpPage (); 
		
		System.out.println("pass2");
	
	}
	
	
	@Test(priority=1)
	public void enterPersonalInfoTest(){
		homePage.clickOnSignUpBtn();
		switchToWindow();
		signUpPage.enterPersonalInfo();
		
		signUpPage.billingAddress();
		
		
		
		
		
		
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}