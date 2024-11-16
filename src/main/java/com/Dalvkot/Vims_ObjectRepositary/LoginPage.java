package com.Dalvkot.Vims_ObjectRepositary;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class LoginPage extends WebDriverUtility {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Users List Button
	@FindBy(xpath = "//button[@class='btn dropdown-toggle btn-round btn-simple']")
	private WebElement clickOnButton;

	// Selecting System Users inn Users List
	@FindBy(xpath = "//span[text()='Doctor']")
	private WebElement doctorOpt;

	// Selecting Doctor in Users List
	@FindBy(xpath = "//span[text()='System Users']")
	private WebElement systemUsersOpt;

	@FindBy(xpath = "//input[@placeholder='Email or Phone Number']")
	private WebElement userNameText;

	@FindBy(xpath = "//input[@formcontrolname='password']")
	private WebElement passwordText;

	@FindBy(xpath = "//button[text()='Log in']")
	private WebElement loginBtn;

	@FindBy(xpath = "//small[text()='Username / Password Wrong']")
	private WebElement userAndPasswordWrong;

	@FindBy(xpath = "//input[@placeholder='Email or Phone Number']/ancestor::div[@class='content']/descendant::div[text()=' Email is required. ']")
	private WebElement emailErrorMsg;

	@FindBy(xpath = "//div[text()=' Password is required. ']")
	private WebElement passwordWrongMsg;

	@FindBy(xpath = "//button[text()='Login Anyway']")
	private WebElement loginAnywayButton;

	@FindBy(xpath = "//img[@class='swal2-image']/following-sibling::h2[1]")
	private WebElement pleaseEnterYourPasswordMsg;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement okBtnPopupMsg;

	@FindBy(xpath = "//div[@class='swal2-content']//div[1]")
	private WebElement pleaseProvideValisEmailOrPhoneNumberMsg;

	@FindBy(xpath = "//div[text()='Your userName or Password do not match.']")
	private WebElement yourUserNameOrPasswordDoNotMatch;

	@FindBy(xpath = "//u[text()=' Terms and Conditions']")
	private WebElement termsAndConditionsBtn;

	@FindBy(xpath = "//button[text()='I accept']")
	private WebElement iAcceptBtn;

	@FindBy(xpath = "//a[contains(text(),'Forgot Password ?')]")
	private WebElement forgetPasswordBtn;

	@FindBy(xpath = "//button[text()='Send Reset Link']")
	private WebElement sendResetLinkBtn;

	@FindBy(xpath = "//div[text()='reset password request has been sent for verification.']")
	private WebElement resetpasswordRequestHasBeenSentForVerificationMsg;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement okBtn;

	@FindBy(xpath = "//button[text()='Login Anyway']")
	private WebElement loginAnywayBtn;

	@FindBy(xpath = "//button[text()='Next']")
	private WebElement nextBtn;

	@FindBy(xpath = "//button[text()=' REMIND LATER ']")
	private WebElement remindLaterButton;

	@FindBy(xpath = "//div[@id='showNot']//button[text()=' SIGN REPORT ']")
	private WebElement signReportNote;

	@FindBy(xpath = "//div[@id='pendingList']//table/tbody/tr[2]/td[last()]//i")
	private WebElement eyeButtonInThePendingList;

	@FindBy(xpath = "(//span[@title='Doctor Name']/following-sibling::span)[3]")
	private WebElement assignedByDropdownBtn;

	@FindBy(xpath = "(//button[text()='Submit '])[2]")
	private WebElement submitButton;

	@FindBy(xpath = "//button[text()='REJECT']/ancestor::div[@class='modal-content']/descendant::button[@aria-label='Close']")
	private WebElement closeButton;

	@FindBy(xpath = "//a[contains(text(),'Back')]")
	private WebElement backButton;

	@FindBy(xpath = "//input[@class='select2-search__field']")
	private WebElement searchBoxFieldForDropDown;

	@FindBy(xpath = "//div[@class='swal2-actions swal2-loading']")
	private WebElement popupLoader;

	public void ifRemindLaterVisibleClose_Or_SignReportClose(WebDriver driver) throws Throwable {
		// Wait for loader to disappear
		wait_For_Invisibilty_Of_Loader(driver, 200);
		try {
			wait_For_Invisibilty_Of_Loader(driver, 200);
			if (isElementVisible(remindLaterButton)) {
				remindLaterButton.click();
				System.out.println("Clicked on the remind later button");
			} else if (isElementVisible(signReportNote)) {
				signReportNote.click();
				wait_For_Invisibilty_Of_Loader(driver, 200);
				eyeButtonInThePendingList.click();

			}
			try {
				wait_For_Invisibilty_Of_Loader(driver, 200);
				closeButton.click();
			} catch (

			NoSuchElementException e) {
				System.out.println("Element not found: " + e.getMessage());
			}
			wait_For_Invisibilty_Of_Loader(driver, 200);
			backButton.click();
			System.out.println("Back from the doctor's desk has been done");
		} catch (

		NoSuchElementException e) {
			System.out.println("Element not found: " + e.getMessage());
		}
	}

	public void ifRemindLaterVisibleClose_Or_SignReportCloseForPGAndIMO(WebDriver driver, String doctorName)
			throws Throwable {
		wait_For_Invisibilty_Of_Loader(driver, 200);
		try {
			wait_For_Invisibilty_Of_Loader(driver, 200);
			if (isElementVisible(remindLaterButton)) {
				remindLaterButton.click();
				System.out.println("Clicked on the remind later button");
			} else if (isElementVisible(signReportNote)) {
				signReportNote.click();
				wait_For_Invisibilty_Of_Loader(driver, 200);
				eyeButtonInThePendingList.click();

			}
			try {
				wait_For_Invisibilty_Of_Loader(driver, 200);
				if (isElementVisible(assignedByDropdownBtn)) {
					dropdown(driver, assignedByDropdownBtn, searchBoxFieldForDropDown, doctorName);
					submitButton.click();
				}
			} catch (

			NoSuchElementException e) {
				System.out.println("Element not found: " + e.getMessage());
			}
			try {
				explicitWaitElementToBeClickable(driver, closeButton);
				closeButton.click();
			} catch (

			NoSuchElementException e) {
				System.out.println("Element not found: " + e.getMessage());
			}

			explicitWaitElementToBeClickable(driver, backButton);
			backButton.click();
			System.out.println("Back from the doctor's desk has been done");
		} catch (

		NoSuchElementException e) {
			System.out.println("Element not found: " + e.getMessage());
		}
	}

	// Function to check if an element is visible
	public static boolean isElementVisible(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (NoSuchElementException | StaleElementReferenceException e) {
			return false;
		}
	}

	// Business logic

	// Login into the Application
	public void loginToApplication(String url, String username, String password, WebDriver driver) throws Throwable {
		driver.get(url);
		waitTillPageLoad(driver);
		userNameText.sendKeys(username);
		nextBtn.click();
		passwordText.sendKeys(password);
		loginBtn.click();
		clickOnLoginAnywayBtnIfDisplays(driver);
	}

	public void loginToApplicationUsingDoctorLogin(String un, String pw, WebDriver driver) throws Throwable {
		waitTillPageLoad(driver);
		userNameText.sendKeys(un);
		nextBtn.click();
		passwordText.sendKeys(pw);
		loginBtn.click();
		clickOnLoginAnywayBtnIfDisplays(driver);
		ifRemindLaterVisibleClose_Or_SignReportClose(driver);
	}

	public void loginToApplicationUsingDoctorLoginForPgAndHIMO(String un, String pw, WebDriver driver,
			String doctorName) throws Throwable {
		waitTillPageLoad(driver);
		userNameText.sendKeys(un);
		nextBtn.click();
		passwordText.sendKeys(pw);
		loginBtn.click();
		clickOnLoginAnywayBtnIfDisplays(driver);
		ifRemindLaterVisibleClose_Or_SignReportClose(driver);
	}

	public boolean isVisible(WebDriver driver, String Locator) throws InterruptedException {
		int timer = 5;
		int counter = 0;
		while (true) {
			try {
				driver.findElement(By.xpath(Locator));
				return true;
			} catch (NoSuchElementException e) {
				if (counter == timer) {
					break;
				}
				if (counter < timer) {
					Thread.sleep(1000);
					counter += 1;
					continue;
				}
			}
		}
		return false;

	}

	public void loginToApplicationToApp(String url, String username, String password, WebDriver driver)
			throws InterruptedException {
		userNameText.sendKeys(username);
		passwordText.sendKeys(password);
		loginBtn.click();

		String loginAnyWay = "//button[text()='Login Anyway']";
		if (isVisible(driver, loginAnyWay)) {
			driver.findElement(By.xpath(loginAnyWay)).click();
		}

	}

	public void enterTheUserName(WebDriver driver, String userName) {
		userNameText.sendKeys(userName);
	}

	// userAndPassword Wrong
	public String userNameAndPasswordWrong(WebDriver driver) {
		String errormsg = userAndPasswordWrong.getText();
		return errormsg;

	}

	public String emailErrorMessage(WebDriver driver) {
		String emailMsg = emailErrorMsg.getText();
		return emailMsg;
	}

	public String passwordErrorMesseage(WebDriver driver) {
		String passwordMsg = passwordWrongMsg.getText();
		return passwordMsg;
	}

	public String pleaseEnterYourPasswordMessage() throws Throwable {
		Thread.sleep(2000);
		String msg = pleaseEnterYourPasswordMsg.getText();
		Thread.sleep(2000);
		return msg;

	}

	public String pleaseProvideValidEmailOrPhoneNumber() throws InterruptedException {
		Thread.sleep(2000);
		String msg = pleaseProvideValisEmailOrPhoneNumberMsg.getText();
		Thread.sleep(2000);
		return msg;
	}

	public void clickOnOkButton(WebDriver driver) {
		explictWaitForElementToBeVisible(driver, okBtnPopupMsg);
		explicityWaitForElemenToBeClickable(driver, okBtnPopupMsg);
		clickOnTheElementByUsingJavascriptExecuter(driver, okBtnPopupMsg);
	}

	public String yourUserNameOrPasswordDoNotMatch() {
		String msg = yourUserNameOrPasswordDoNotMatch.getText();
		return msg;

	}

	public void clickOnTheTermsAndConditions(WebDriver driver) {
		explictWaitForElementToBeVisible(driver, termsAndConditionsBtn);
		explicityWaitForElemenToBeClickable(driver, termsAndConditionsBtn);
		termsAndConditionsBtn.click();
	}

	public void clickOnFogetPasswordButton(WebDriver driver) {
		explictWaitForElementToBeVisible(driver, forgetPasswordBtn);
		explicityWaitForElemenToBeClickable(driver, forgetPasswordBtn);
		forgetPasswordBtn.click();
	}

	public void clickOnSendResetLink(WebDriver driver) {
		explictWaitForElementToBeVisible(driver, sendResetLinkBtn);
		explicityWaitForElemenToBeClickable(driver, sendResetLinkBtn);
		sendResetLinkBtn.click();
	}

	public void clickOnIAcceptButton(WebDriver driver) {
		explictWaitForElementToBeVisible(driver, iAcceptBtn);
		scrollDownThePageUntilElementIsVisible(driver, iAcceptBtn);
		explicityWaitForElemenToBeClickable(driver, iAcceptBtn);
		iAcceptBtn.click();
	}

	public String resetpasswordRequestHasBeenSentForVerification() {
		String msg = resetpasswordRequestHasBeenSentForVerificationMsg.getText();
		return msg;
	}

	public void clickOnLoginAnywayBtnIfDisplays(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebElement loginAnywayBtn = null;
		try {
			loginAnywayBtn = driver.findElement(By.xpath("//button[text()='Login Anyway']"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
		}
		if (loginAnywayBtn != null) {
			loginAnywayBtn.click();
		}
	}
}
