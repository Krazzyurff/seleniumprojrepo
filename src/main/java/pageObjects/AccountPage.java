package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	
	public WebDriver driver;
	
	public AccountPage(WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//*[@id=\"content\"]/ul[1]/li[1]/a")
	WebElement editYourAccount;
	
	public WebElement editYourAccount() {
		return editYourAccount;
	}

}
