package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
    public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//input[@name=\"email\"]")
	WebElement emailfield;
	
	@FindBy(xpath="//input[@name=\"password\"]")
	WebElement passwordfield;
	
	@FindBy(xpath="//input[@type=\"submit\"]")
	WebElement loginbutton;
	
	
	public WebElement emailfield() {
		return emailfield;
	}
	public WebElement passwordfield() {
		return passwordfield;
	}
	public WebElement loginbutton() {
		return loginbutton;
	}

}
