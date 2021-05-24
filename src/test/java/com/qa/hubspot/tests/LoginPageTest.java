package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.basepage.BasePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.utils.ConstantsUtil;

public class LoginPageTest {
	WebDriver driver;
	BasePage basepage;
	LoginPage loginpage;
	Properties prop;
	
	
	@BeforeTest
	public void setUp() {
		basepage= new BasePage();
		prop=basepage.init_prop();
		driver=basepage.init_browser(prop);
		loginpage=new LoginPage(driver);
		
		}
	
	@Test(priority=2)
	public void verifyLoginPageTitleTest() {
		String title=loginpage.getLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, ConstantsUtil.LOGIN_PAGE_TITLE,"Login Page title is not matched");
	}
	@Test(priority=1)
	public void verifyLogoTest() {
		Assert.assertTrue(loginpage.doGetLogo());
	}
	@Test(priority=3)
	public void loginTest() {
		loginpage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
