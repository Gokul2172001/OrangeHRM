package com.hrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.base.TestBase;

public class DashboardPage extends TestBase {

	@FindBy(css = "div.oxd-grid-3>div.oxd-grid-item:first-child>div:first-child")
	WebElement timeAtWorkGrid;

	@FindBy(css = "div.orangehrm-todo-list>div:first-child")
	WebElement LeaveRequestToApprove;

	@FindBy(css = "div.orangehrm-todo-list>div:nth-child(2)")
	WebElement TimeSheetToApprove;

	@FindBy(css = "div.orangehrm-todo-list>div:nth-child(3)")
	WebElement PendingOfSelfReview;

	@FindBy(css = "div.orangehrm-todo-list>div:nth-child(4)")
	WebElement CandidateToInterview;

	@FindBy(css = "ul.oxd-main-menu>li:first-child")
	WebElement Menu1;

	@FindBy(css = "ul.oxd-main-menu>li:nth-child(2)")
	WebElement Menu2;

	@FindBy(css = "ul.oxd-main-menu>li:nth-child(3)")
	WebElement Menu3;

	@FindBy(css = "ul.oxd-main-menu>li:nth-child(4)")
	WebElement Menu4;

	@FindBy(css = "ul.oxd-main-menu>li:nth-child(5)")
	WebElement Menu5;

	@FindBy(css = "ul.oxd-main-menu>li:nth-child(6)")
	WebElement Menu6;

	@FindBy(css = "ul.oxd-main-menu>li:nth-child(7)")
	WebElement Menu7;

	@FindBy(css = "ul.oxd-main-menu>li:nth-child(8)")
	WebElement Menu8;

	@FindBy(css = "ul.oxd-main-menu>li:nth-child(9)")
	WebElement Menu9;

	@FindBy(css = "ul.oxd-main-menu>li:nth-child(10)")
	WebElement Menu10;

	@FindBy(css = "ul.oxd-main-menu>li:nth-child(11)")
	WebElement Menu11;
	
	@FindBy(css="div.orangehrm-header-container>button[type='button']")
	WebElement AddRecordAdmin;

	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean TimeAtWorkCheck() {
		return timeAtWorkGrid.isDisplayed();
	}

	public String MyActionsMenuClick(String action) {
		if (action == "Leave Request to Approve") {
			LeaveRequestToApprove.click();
			return driver.getCurrentUrl();
		} else if (action == "Timesheet to Approve") {
			TimeSheetToApprove.click();
			return driver.getCurrentUrl();
		} else if (action == "Pending Self Review") {
			PendingOfSelfReview.click();
			return driver.getCurrentUrl();
		} else if (action == "Candidate to Interview") {
			CandidateToInterview.click();
			return driver.getCurrentUrl();
		} else
			return "error";
	}

	public String CheckMenuList(String menu) {
		if (menu == "Admin") {
			String check1 = Menu1.getText();
			System.out.println(check1);
			return check1;
		}
		if (menu == "PIM") {
			String check2 = Menu2.getText();
			System.out.println(check2);
			return check2;
		}
		if (menu == "Leave") {
			String check3 = Menu3.getText();
			System.out.println(check3);
			return check3;
		}
		if (menu == "Time") {
			String check4 = Menu4.getText();
			System.out.println(check4);
			return check4;
		}
		if (menu == "Recruitment") {
			String check5 = Menu5.getText();
			System.out.println(check5);
			return check5;
		}
		if (menu == "My Info") {
			String check6 = Menu6.getText();
			System.out.println(check6);
			return check6;
		}
		if (menu == "Performance") {
			String check7 = Menu7.getText();
			System.out.println(check7);
			return check7;
		}
		if (menu == "Dashboard") {
			String check8 = Menu8.getText();
			System.out.println(check8);
			return check8;
		}
		if (menu == "Directory") {
			String check9 = Menu9.getText();
			System.out.println(check9);
			return check9;
		}
		return "Null";
	}

	public void ClickMenuList(String menu) {
		if (menu == "Admin") 
			Menu1.click();
		if (menu == "PIM") 
			Menu2.click();
		if (menu == "Leave") 
			Menu3.click();
		if (menu == "Time") 
			Menu4.click();
		if (menu == "Recruitment") 
			Menu5.click();
		if (menu == "My Info") 
			Menu6.click();
		if (menu == "Performance") 
			Menu7.click();
		if (menu == "Dashboard") 
			Menu8.click();
		if (menu == "Directory") 
			Menu9.click();
	}

	public void AddRecordAdmin() {
		AddRecordAdmin.click();
		
		
		
	}
}
