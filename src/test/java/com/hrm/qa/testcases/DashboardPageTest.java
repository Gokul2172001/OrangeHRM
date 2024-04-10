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
	
	@Test(priority=3)
	public void checkMenuList() {
		Assert.assertEquals(dashboardPage.CheckMenuList("Admin"),"Admin");
		Assert.assertEquals(dashboardPage.CheckMenuList("PIM"),"PIM");
		Assert.assertEquals(dashboardPage.CheckMenuList("Leave"),"Leave");
		Assert.assertEquals(dashboardPage.CheckMenuList("Time"),"Time");
		Assert.assertEquals(dashboardPage.CheckMenuList("Recruitment"),"Recruitment");
		Assert.assertEquals(dashboardPage.CheckMenuList("My Info"),"My Info");
		Assert.assertEquals(dashboardPage.CheckMenuList("Performance"),"Performance");
		Assert.assertEquals(dashboardPage.CheckMenuList("Dashboard"),"Dashboard");
		Assert.assertEquals(dashboardPage.CheckMenuList("Directory"),"Directory");
	}
 	@AfterMethod
	public void teardown() {
		driver.close();
	}
}
