package com.hrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(name="username")
	WebElement Username;
	
	@FindBy(name="password")
	WebElement Password;
	
	@FindBy(css="button.oxd-button")
	WebElement lgnbtn;
	
	@FindBy(css="div.orangehrm-login-branding")
	WebElement logo;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validatePageTitle() {
		return driver.getTitle();
	}
	
	public boolean checkLogo() {
		boolean flag = logo.isDisplayed();
		return flag;
	}
	
	public DashboardPage checkLogin(String user, String pwd) {
		Username.sendKeys(user);
		Password.sendKeys(pwd);
		lgnbtn.click();
		return new DashboardPage();
	}

}
