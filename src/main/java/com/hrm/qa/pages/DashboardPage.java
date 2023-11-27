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

}
