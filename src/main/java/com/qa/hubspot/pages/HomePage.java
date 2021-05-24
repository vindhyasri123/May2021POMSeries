package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.basepage.BasePage;

public class HomePage extends BasePage {
	
	private WebDriver driver;
	
	By manage=By.linkText("Manage");
	By accoutlogo=By.xpath("(//span[@class='avatar-text'])[1]");
	By accountName= By.xpath("(//span[text()='vindhya chow'])[1]");
	

	public HomePage(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public String homePageTitle() {
		return driver.getTitle();
	}
	public String verifyManageLink() {
		if(driver.findElement(manage).isDisplayed()) {
			return driver.findElement(manage).getText();
		}
	return null;
	}
	public String verifyAccountName() {
		driver.findElement(accoutlogo).click();
		if(driver.findElement(accountName).isDisplayed()) {
			return driver.findElement(accountName).getText();
		}
		return null;
	}
}
