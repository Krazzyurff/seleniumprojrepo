package test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class LoginTest extends Base {
	
	public WebDriver driver ;
	Logger log;
	
	@Test(dataProvider="getLoginData")
	public void login(String email,String password,String expectedresult) throws IOException, InterruptedException {
		
		LandingPage lpage=new LandingPage(driver);
		
		lpage.myAccountDropdown().click();
		log.debug("Clicked on My Account dropdown");

		lpage.loginOption().click();
		log.debug("Clicked on login option");
		
		Thread.sleep(3000);
		
		
		LoginPage loginpage=new LoginPage(driver);
		
		loginpage.emailfield().sendKeys(email);
		log.debug("Email addressed got entered");
		
		loginpage.passwordfield().sendKeys(password);
		log.debug("Password got entered");
		
		loginpage.loginbutton().click();
		log.debug("Clicked on Login Button");
		
		Thread.sleep(3000);
		
		
		AccountPage accountpage=new AccountPage(driver);
		
		String actualresult=null;
		
		try {
			
			if(accountpage.editYourAccount().isDisplayed())
				 log.debug("User got logged in");
				actualresult="Success";
			
		}catch(Exception e) {
			log.debug("User didn't log in");
			actualresult="Failure";
		}
		
		AssertJUnit.assertEquals(actualresult,expectedresult);
		
	}
	@BeforeMethod
	public void AplicationOpen() throws IOException {

		log = LogManager.getLogger(LoginTest.class.getName());
	    driver = intializeDriver();
	    log.debug("Browser got launched");
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to application URL");
		
	}
	
	@AfterMethod
	public void browserClose() {
		driver.close();
		log.debug("Browser got closed");
	}
	
	@DataProvider
	public Object[][] getLoginData() {
		
		Object[][] data= {{"Kumarashish270899@gmail.com","Ashish@123","Success"}};
		
		return data;
	}

}
//,{"Demo@gmail.com","Demo@123","Failure"}
