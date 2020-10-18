package com.qa.hrm.Tests;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hrm.base.BasePage;
import com.qa.hrm.pages.HomePage;
import com.qa.hrm.pages.LoginPage;
import com.qa.hrm.utils.Constants;



public class LoginPageTest {
	Properties prop;
	WebDriver driver;
	BasePage basepage;
	LoginPage loginpage;

	
	@BeforeTest
	public void launchBrowser() throws IOException {
		  basepage = new BasePage();
		  prop = basepage.config_prop();
		    driver =  basepage.init_browser(prop);
		  loginpage = new LoginPage(driver);
	}
	
	@Test(priority=1)
	public void verifyLoginPageTitle() {
		String loginPageTitle = loginpage.getLoginPageTitle();
		System.out.println("Login Page Title =" + loginPageTitle);
		Assert.assertEquals(loginPageTitle, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void verifyResetButton() {
		Assert.assertTrue(loginpage.checkResetButton());
		
	}
	@Test(priority=3)
	public void doLoginTest() {
		HomePage homepage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	

	
	


}
