package com.hrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.qa.base.TestBase;
import com.hrm.qa.pages.DashboardPage;
import com.hrm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

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

	// TC-07:- Verify the title of the page is expected or not
	@Test(priority = 1)
	public void loginTitleCheck() {
		String flag = loginPage.validatePageTitle();
		Assert.assertEquals(flag, "OrangeHRM");
	}

	// TC-08:- Verify the page has a company logo at the beginning
	@Test(priority = 2)
	public void logoCheck() {
		Assert.assertTrue(loginPage.checkLogo());
	}

	// TC-1:- Verify the user can able to login with perfect username and password
	@Test(priority = 3)
	public void loginCheck() {
		dashboardPage = loginPage.checkLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	// TC02:- Verify the user cannot able to login with wrong username and password
	@Test(priority = 4)
	public void loginCheckNegative() {
		dashboardPage = loginPage.checkLogin("userName", "Password");
	}

	@Test(priority = 5)
	public void InvlidLoginCheck() {
		String flag = loginPage.validatePageTitle();
		Assert.assertNotEquals(flag, "OrangeHRM");
	}

	@Test(priority = 6)
	public void InvlalidPasswordCheck() {
		DashboardPage InvalidPasswordError = loginPage.checkLogin("UserName", "InvalidPassword");
		Assert.assertEquals("", InvalidPasswordError);
	}

	@AfterMethod
	public void end() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
}
