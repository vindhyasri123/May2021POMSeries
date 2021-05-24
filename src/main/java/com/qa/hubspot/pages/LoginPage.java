package com.qa.hubspot.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.basepage.BasePage;



public class LoginPage extends BasePage {


	private WebDriver driver;
	
	
	By login= By.linkText("Login");
	By id= By.id("memberId");
	By password = By.id("mobilePass");
	By indigologo= By.cssSelector(".hide-on-sticky");
	
	
	// 1)Create constructor of page class
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		
	}
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean doGetLogo() {
		//return driver.findElement(SignUp).isDisplayed();
		return driver.findElement(indigologo).isDisplayed();
	}
	public HomePage doLogin(String id,String pasword) {
		
		driver.findElement(login).click();
		driver.findElement(this.id).sendKeys(id);
		driver.findElement(this.password).sendKeys(pasword);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return new HomePage(driver);
		
		
}
}