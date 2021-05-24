package com.qa.hubspot.tests;



import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.basepage.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.utils.ConstantsUtil;

public class HomePageTest  {
	WebDriver driver;
	BasePage basepage;
	LoginPage loginpage;
	HomePage homepage;//
	Properties prop;
	
	@BeforeTest
	public void setUp() {
	basepage=new BasePage();
	prop=basepage.init_prop();
	driver=basepage.init_browser(prop);
	loginpage=new LoginPage(driver);
	homepage=loginpage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	@Test(priority=2)
	public void verifyHomePageTitleTest() {
		String title=homepage.homePageTitle();
		Assert.assertEquals(title, ConstantsUtil.HOME_PAGE_TITLE,"Home Page title is not matched");
	}
	
	@Test(priority=1)
	public void verifyManageLinkTest() {
		String header= homepage.verifyManageLink();
		Assert.assertEquals(header, ConstantsUtil.MANAGE_LINK,"Link is not found");
	}
//	@Test(priority=3)
//		public void verifyLoggedInUserTest() {
//		String accountName=homepage.verifyAccountName();
//		System.out.println(accountName);
//		Assert.assertEquals(accountName, "vindhya chow","Account name is not matched");
//	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	//under testng_regression
	//we can  give suite name, test name as per applicaton name, but class name should be class name as per its corresponding
	//package
	//execute with 2 threadcount and execte it in parallely, it will execiute in parallel only when we give parallel="tests"

}
