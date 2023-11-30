package com.hrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.qa.base.TestBase;
import com.hrm.qa.pages.DashboardPage;
import com.hrm.qa.pages.LoginPage;

public class DashboardPageTest extends TestBase {
	
	LoginPage loginPage;
	DashboardPage dashboardPage;
	
	public DashboardPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
		loginPage.checkLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void checkTimeAtWork() {
		boolean flag = dashboardPage.TimeAtWorkCheck();
		Assert.assertTrue(flag, "Time at work isn't showing");
	}
	
	@Test(priority=2)
	public void navigateLeaveRequestToApprove() {
		String check = dashboardPage.MyActionsMenuClick("Leave Request to Approve");
		Assert.assertEquals(check, "https://opensource-demo.orangehrmlive.com/web/index.php/leave/viewLeaveList");
	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}
}
