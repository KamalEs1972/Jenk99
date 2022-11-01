package testCases;

import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;


public class HomePageTest extends TestBase {
	
	HomePage homePage;
//	LoginPage loginPage;
	//TestUtil testUtil;
//	ContactsPage contactsPage;
//
	public HomePageTest() {
		super();
	}
	

	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
	@BeforeMethod
	public void setUp() {
		initialization();
	System.out.println(driver.getTitle());
		 homePage= new HomePage ();
		
		System.out.println("pass2");
	
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		homePage= new HomePage ();
		homePage.verifyPageTitle();
		
//		String TitleTxt = ((HomePage) homePage).verifyPageTitle();
//		Assert.assertEquals(TitleTxt,"Book Your Free Demo Now - Phptravels", "Head Text Not matching");
		
		System.out.println("pass3");
		
	}
	
	@Test(priority=2)
	public void clickOnLoginBtnTest(){
		
		homePage.clickOnLoginBtn();
	}
		@Test(priority=3)
		public void verifyloginTextTest() {
		HomePage.clickOnLoginBtn()	;
		homePage.verifyloginText();
		
		
		//String actualText = driver.getTitle();
//		boolean actualText = homePage.verifyloginText();
//		String expectedTitle = "Login";
//		//boolean loginTxt = homePage.verifyloginText();
//		Assert.assertEquals(actualText, expectedTitle);
		
		
		
		System.out.println("pass4");
	
		}

	
	@Test(priority=4)
	public void clickOnSignBtnTest(){
		homePage.clickOnSignUpBtn();
		
//		testUtil.switchToFrame();
//		contactsPage = homePage.clickOnContactsLink();
	}
	@Test(priority=5)
	public void verifySignUpPageTest() {
	homePage.clickOnSignUpBtn();
	homePage.verifySignUpText();

	
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	}
