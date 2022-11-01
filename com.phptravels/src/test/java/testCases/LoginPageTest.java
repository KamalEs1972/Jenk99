package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		homePage= new HomePage ();
		loginPage = new LoginPage();	
	}
	
	@Test(priority=1)
	public void loginPageTest(){
		homePage.clickOnLoginBtn();
		switchToWindow();
		
		loginPage.enteringLoginCredentials();
	}
	
//	@Test(priority=2)
//	public void crmLogoImageTest(){
//		boolean flag = loginPage.validateCRMImage();
//		Assert.assertTrue(flag);
//	}
//	
//	@Test(priority=3)
//	public void loginTest(){
//		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
//	}
//	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}


