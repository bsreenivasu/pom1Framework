package com.qa.hrm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	public WebDriver driver;
	public Properties prop;
	
	/**
	 * Initializing web browser:
	 * @param browser
	 * @return
	 */
	
	public WebDriver init_browser(Properties prop) {

		String browser = prop.getProperty("browser");
		System.out.println("Browser you selected is :: "+ browser);
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			String path = WebDriverManager.chromedriver().globalConfig().getCachePath();
			System.out.println(path);
			driver = new ChromeDriver();
		}
			else if(browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			else {
				System.out.println(browser + "  You entered is wrong. Please enter proper browser name ::" );
					}
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		return driver;
		
	}
	
	/**
	 * return property value from below method
	 * @return
	 * @throws IOException
	 */
	
	public Properties config_prop() throws IOException {
	prop = new Properties();
	FileInputStream fis = new FileInputStream(".\\src\\main\\java\\com\\qa\\hrm\\config\\config.properties");
	prop.load(fis);
	
	return prop;
	
	}
}
