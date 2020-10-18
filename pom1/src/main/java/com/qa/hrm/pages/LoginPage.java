package com.qa.hrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import com.qa.hrm.base.BasePage;

public class LoginPage extends BasePage {
	
	public WebDriver driver;
	
	By userId = 	By.name("uid");
	By password =By.name("password");
	By loginBtn  = By.name("btnLogin");
	By resetBtn	= By.name("btnReset");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean checkResetButton() {
		return driver.findElement(resetBtn).isDisplayed();
	}
	
	public HomePage doLogin(String un, String pwd) {
		driver.findElement(userId).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginBtn).click();
		return new HomePage(driver);
		
	}
	
	

}
