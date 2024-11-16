package com.Dalvkot.Vims_ObjectRepositary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class LogOutPage extends WebDriverUtility {
	public LogOutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='zmdi zmdi-account-box-phone']/ancestor::ul[@class='nav navbar-nav navbar-left']/descendant::b")
	private WebElement signOutBtn;

	@FindAll({ @FindBy(xpath = "//img[@alt='User']/following-sibling::b"),
			@FindBy(xpath = "//i[@class='zmdi zmdi-chevron-down']") })
	private WebElement userNameBtn;

	@FindBy(xpath = "//i[@class='zmdi zmdi-power']")
	private WebElement logoutBtn;

	@FindBy(xpath = "//img[@alt='User']/following-sibling::b[1]")
	private WebElement userNameHeader;

	/*
	 * 
	 *
	 * Business Logics
	 * 
	 * 
	 */
	public void SignOutToApplication(WebDriver driver) {
		WebDriverWait mywait = new WebDriverWait(driver, 250);
		WebElement ele = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//i[@class='zmdi zmdi-account-box-phone']/ancestor::ul[@class='nav navbar-nav navbar-left']/descendant::b")));
		Actions act1 = new Actions(driver);
		act1.doubleClick(ele).perform();
		logoutBtn.click();
	}

	public void logoutTheApplication(WebDriver driver) {
		explicityWaitForElemenToBeClickable_ForSeconds(driver, userNameBtn, 5);
		doubleClick(driver, userNameBtn);
		clickOnTheElementByUsingJavascriptExecuter(driver, logoutBtn);
	}

	public void logoutTheApplication_NewTab(WebDriver driver) {
		explicityWaitForElemenToBeClickable_ForSeconds(driver, userNameBtn, 5);
		doubleClick(driver, userNameBtn);
		clickOnTheElementByUsingJavascriptExecuter(driver, logoutBtn);
	}

	public String takeTheCurrentUserName(WebDriver driver) {
		String userName = userNameHeader.getText();
		return userName;
	}
}
