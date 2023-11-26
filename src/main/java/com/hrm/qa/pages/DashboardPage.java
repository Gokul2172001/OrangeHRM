package com.hrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.base.TestBase;

public class DashboardPage extends TestBase {
	
	
	@FindBy(css="div.oxd-grid-3>div.oxd-grid-item:first-child>div:first-child")
	WebElement timeAtWorkGrid;
	
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}

}
