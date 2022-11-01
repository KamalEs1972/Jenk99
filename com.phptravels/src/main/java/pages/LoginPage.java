package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(css="#inputEmail")
	WebElement email1;
	
	@FindBy(css="#inputPassword")
	WebElement password1;
	
	@FindBy(css="#login")
	WebElement loginBtn;
	
	@FindBy(css=".form-check-input")
	WebElement remebermeCheckBox;
	
	@FindBy(css="#header > div.topbar > div > div > div.ml-auto > div > div.input-group-prepend.d-none.d-md-inline > span")
	WebElement loggedInAs;
	
	@FindBy(css="div[class='recaptcha-checkbox-border']")
	WebElement recaptch1;
	
	@FindBy(css="#\\#divDynamicRecaptcha1 > div > div > iframe")
	WebElement recaptchIframe1;
	
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void enteringLoginCredentials () {
		
		email1.sendKeys("djkimo94@yahoo.com");
		password1.sendKeys("123456");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(recaptchIframe1));
		 wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.recaptcha-checkbox-checkmark")));
		 recaptch1.click();
		 driver.switchTo().defaultContent();
		// WebElement element = driver.findElement(By.id("gbqfd"));
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
		 executor.executeScript("arguments[0].click();", loginBtn);
		// loginBtn.click();
		 
		 
		
		
	}
	

}
