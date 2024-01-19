package com.hrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.hrm.qa.base.TestBase;
import com.hrm.qa.pages.DashboardPage;
import com.hrm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	DashboardPage dashboardPage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginTitleCheck() {
		String flag = loginPage.validatePageTitle();
		Assert.assertEquals(flag, "OrangeHRM");
	}
	
	@Test(priority=2)
	public void logoCheck() {
		Assert.assertTrue(loginPage.checkLogo());
	}
	
	@Test(priority=3)
	public void loginCheck() {
		dashboardPage = loginPage.checkLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void end() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
}
