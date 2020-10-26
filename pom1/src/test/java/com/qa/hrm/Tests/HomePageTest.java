package com.qa.hrm.Tests;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import com.qa.hrm.base.BasePage;
import com.qa.hrm.pages.HomePage;
import com.qa.hrm.pages.LoginPage;
import com.qa.hrm.utils.Constants;

public class HomePageTest {
	
	Properties prop;
	WebDriver driver;
	BasePage basepage;
	LoginPage loginpage;
	HomePage homepage;
	
	
	//logs configured in this file to generate logs
	private static Logger log = Logger.getLogger(HomePageTest.class);
	
	
	@BeforeTest
	public void launchBrowser() throws IOException {
		  basepage = new BasePage();
		  prop = basepage.config_prop();
		    driver =  basepage.init_browser(prop);
		  loginpage = new LoginPage(driver);
		  homepage = new HomePage(driver);
		  homepage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	   public void verifyHomePageTitle() throws InterruptedException {
		Thread.sleep(3000);
		String title = homepage.getHomePageTitle();
		log.info("Homepage Title captured as " + title);
		log.debug("Homepage Title captured as " + title);
		System.out.println(title);
		Assert.assertEquals(title, Constants.MANAGER_HOME_PAGE);
		
		
	}
	
	@Test(priority=2)
	public void verifyManagerLink() {
		Assert.assertTrue(homepage.verifyLinkManager());
	}
	
	@Test(priority=3)
	public void verifyPageHeader() {
		String header = homepage.verifyPageHeader();
		System.out.println(header);
		Assert.assertEquals(header, "Gtpl Bank");
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
