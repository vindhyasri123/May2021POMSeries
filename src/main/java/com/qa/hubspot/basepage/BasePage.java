package com.qa.hubspot.basepage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BasePage {
	WebDriver driver;
	Properties prop;
	
	public WebDriver init_browser(Properties prop) {
		String browser=prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/lib/chromedriver.exe");
			driver = new ChromeDriver();
			
					}
		else if(browser.equalsIgnoreCase("firefox")) {
			//some code for firefox i donno
			driver= new FirefoxDriver();
		}
		
		else if(browser.equalsIgnoreCase("safari")) {
			//some code for safari
			driver = new SafariDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	
		return driver;
	}
	/**
	 * this method is used to initialise config.properties method
	 * @return prop
	 */
	
	public Properties init_prop() {
		prop = new Properties();
		try {
			//we have to add. before config file path and sould give forward slash
			FileInputStream ip = new FileInputStream("./src/main/java/com/qa/hubspot/config/Config_properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	
	
	
}
