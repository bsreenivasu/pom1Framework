package com.qa.hrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	public WebDriver driver;

	By pageHeader = By.xpath("//h2[text()='Gtpl Bank']");
	By linkManager = By.xpath("//a[text()='Manager']");
	By homeBtn  = By.xpath("//a[text()='Home']");
	
	//consutructor to initialise webDriver
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Get HomePage title
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	//Verify page Header
	public String verifyPageHeader() {
		return driver.findElement(pageHeader).getText();
	}
	
	//Verify Manager link in home page
	public boolean verifyLinkManager() {
		return driver.findElement(linkManager).isDisplayed();
	}
	
	//Verify home button appeared on home page.
	public boolean verifyHomeButton() {
		return driver.findElement(homeBtn).isDisplayed();
	}
	
	
}
