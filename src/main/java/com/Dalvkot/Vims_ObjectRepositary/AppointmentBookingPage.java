package com.Dalvkot.Vims_ObjectRepositary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.Dalvkot.Vims_GenericUtility.WebDriverUtility;

public class AppointmentBookingPage extends WebDriverUtility {

	public AppointmentBookingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "(//span[text()=' Appointment Booking '])[1]")
	private WebElement appointmentBookingBtn;

	@FindBy(xpath = "//span[@title='Appointment Type']/following-sibling::span[1]")
	private WebElement appointmentTypeDropdownBtn;

	@FindBy(xpath = "//td[@aria-label='July 2, 2023']//div[1]")
	private WebElement bookingDate;

	@FindBy(xpath = "//input[@formcontrolname='bookingTime']")
	private WebElement bookingTimeText;

	@FindBy(xpath = "//input[@placeholder='Name']")
	private WebElement nameText;

	@FindBy(xpath = "//span[@title='MALE']/following-sibling::span[1]")
	private WebElement genderDropdownBtn;

	@FindBy(xpath = "//td[@aria-label='February 3, 1981']//div[1]")
	private WebElement dateOfBirth;

	@FindBy(xpath = "(//span[@class='mat-button-wrapper'])[2]")
	private WebElement dateOfBirthBtn;

	@FindBy(xpath = "//input[@placeholder='Phone Number']")
	private WebElement mobileNumberText;

	@FindBy(xpath = "//input[@placeholder='Email Id']")
	private WebElement emailIdText;

	@FindBy(xpath = "//span[@title='Department']/following-sibling::span[1]")
	private WebElement departmentDropdownBtn;

	@FindBy(xpath = "//input[@aria-label='Search']")
	private WebElement dropdownText;

	@FindBy(xpath = "//span[@title='Doctor Name']/following-sibling::span[1]")
	private WebElement doctorNameDropdownBtn;

	@FindBy(xpath = "//button[text()=' Book Now ']")
	private WebElement bookNowBtn;

	@FindBy(xpath = "(//button[text()=' Cancel '])[2]")
	private WebElement cancelBtn;

	@FindBy(xpath = "//table[contains(@class,'table table-responsive-md')]/tbody/tr[1]/td[2]")
	private WebElement appointmentType_Table;

	@FindBy(xpath = "//table[contains(@class,'table table-responsive-md')]/tbody/tr[1]/td[3]")
	private WebElement appointmentNumber_Table;

	@FindBy(xpath = "//table[contains(@class,'table table-responsive-md')]/tbody/tr[1]/td[4]")
	private WebElement bookingTimeAndDate_Table;

	@FindBy(xpath = "//table[contains(@class,'table table-responsive-md')]/tbody/tr[1]/td[5]")
	private WebElement patientName_Table;

	@FindBy(xpath = "//table[contains(@class,'table table-responsive-md')]/tbody/tr[1]/td[6]")
	private WebElement mobileNumber_Table;

	@FindBy(xpath = "//table[contains(@class,'table table-responsive-md')]/tbody/tr[1]/td[6]")
	private WebElement department_Table;

	@FindBy(xpath = "//table[contains(@class,'table table-responsive-md')]/tbody/tr[1]/td[8]")
	private WebElement doctor_Table;

	@FindBy(xpath = "//table[contains(@class,'table table-responsive-md')]/tbody[1]/tr[1]/span[1]")
	private WebElement status_Table;

	@FindBy(xpath = "//table[contains(@class,'table table-responsive-md')]/tbody[1]/tr[1]/td[last()]/descendant::button[text()=' Actions ']")
	private WebElement actionsBtn_Table;

	@FindBy(xpath = "//table[contains(@class,'table table-responsive-md')]/tbody[1]/tr[1]/td[last()]/descendant::button[text()=' Edit']")
	private WebElement edit_ActionsTable;

	@FindBy(xpath = "//table[contains(@class,'table table-responsive-md')]/tbody[1]/tr[1]/td[last()]/descendant::button[text()=' Cancel']")
	private WebElement cancel_ActionsTable;

	@FindBy(xpath = "//div[@role='alertdialog']")
	private WebElement errorMsgPopup;

	/*
	 * Buiness Logics
	 * 
	 */
	public void clickOnAppointmentBooking(WebDriver driver) {
		clickOnTheElementUsedToJavascriptExecuter(driver, appointmentBookingBtn);
	}

	public void selectAppointmentType(WebDriver driver, String appointmentType) throws Throwable {
		waitForElementWithCustomTimeOut(driver, appointmentTypeDropdownBtn, 5);
		appointmentTypeDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, appointmentType);

	}

	public void selectBookingDate(WebDriver driver) throws Throwable {
		driver.findElement(By.xpath("(//span[@class='mat-button-wrapper'])[1]")).click();
		String currentDate = generateCurrentDate();
		String month = currentMonth();
		String year = generateCurrentYear();
		String first = currentDate.substring(0, 1);
		Thread.sleep(2000);
		if (first.equals("0")) {
			String second = currentDate.substring(1);
			driver.findElement(By.xpath("//td[@aria-label='" + month + " " + second + ", " + year + "']//div[1]"))
					.click();
		} else {
			driver.findElement(By.xpath("//td[@aria-label='" + month + " " + currentDate + ", " + year + "']//div[1]"))
					.click();
		}

	}

	public void SelectBookingTime(WebDriver driver, String bookingTime) {
		bookingTimeText.sendKeys(bookingTime);

	}

	public void enterTheName(WebDriver driver, String name) {
		nameText.sendKeys(name);

	}

	public void selectGneder(WebDriver driver, String gender) throws Throwable {
		waitForElementWithCustomTimeOut(driver, genderDropdownBtn, 5);
		genderDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, gender);

	}

	public void selectDateOfBirth(WebDriver driver) {
		dateOfBirthBtn.click();
		String currentDate = generateCurrentDate();
		String month = currentMonth();
		String year = generateCurrentYear();
		String first = currentDate.substring(0, 1);
		if (first.equals("0")) {
			String second = currentDate.substring(1);
			driver.findElement(By.xpath("//td[@aria-label='" + month + " " + second + "," + year + "']//div[1]"))
					.click();
		} else {
			driver.findElement(By.xpath("//td[@aria-label='" + month + " " + currentDate + ", " + year + "']//div[1]"))
					.click();
		}

	}

	public void erterMobileNumber(WebDriver driver, String mobileNumber) {
		mobileNumberText.sendKeys(mobileNumber);
	}

	public void enterEmailId(WebDriver driver, String emailId) {
		emailIdText.sendKeys(emailId);

	}

	public void selectDepartment(WebDriver driver, String department) throws Throwable {
		waitForElementWithCustomTimeOut(driver, departmentDropdownBtn, 2);
		departmentDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, department);
	}

	public void selectDoctorName(WebDriver driver, String doctorName) throws Throwable {
		Thread.sleep(2000);
		explicitWaitElementToBeClickable(driver, doctorNameDropdownBtn);
		doctorNameDropdownBtn.click();
		moveToElementAndEnterTheData(driver, dropdownText, doctorName);
	}

	public void clickOnBooknowButton(WebDriver driver) {
		bookNowBtn.click();
	}

	public void clickOnCancelButto(WebDriver driver) {
		cancelBtn.click();

	}

	public void clickOnActionsButton(WebDriver driver) {
		doubleClickOnTheElement(driver, actionsBtn_Table);
	}

	public void clickOnEditButton(WebDriver driver) {
		edit_ActionsTable.click();
	}

	public void clickOnCancelButton(WebDriver driver) {
		cancel_ActionsTable.click();
	}

	public String takeAppointmentType(WebDriver driver) {
		String appointmentType = appointmentType_Table.getText();
		return appointmentType;
	}

	public String takeAppointmentNumber(WebDriver driver) {
		String appointmentNumber = appointmentNumber_Table.getText();
		return appointmentNumber;
	}

	public String takeBookingDate_And_Time(WebDriver driver) {
		String bookTimeAndDate = bookingTimeAndDate_Table.getText();
		return bookTimeAndDate;
	}

	public String takePatientName(WebDriver driver) {
		String patientName = patientName_Table.getText();
		return patientName;

	}

	public String takeMobileNumber(WebDriver driver) {
		String mobileNumber = mobileNumber_Table.getText();
		return mobileNumber;
	}

	public String takeDepartment(WebDriver driver) {
		String department = department_Table.getText();
		return department;
	}

	public String takeDoctorName(WebDriver driver) {
		String doctorName = doctor_Table.getText();
		return doctorName;
	}

	public String takeStatus(WebDriver driver) {
		String status = status_Table.getText();
		return status;
	}

	public String errorMessage(WebDriver driver) {
		explictWaitForElementToBeVisible(driver, errorMsgPopup);
		String msg = errorMsgPopup.getText();
		errorMsgPopup.click();
		return msg;
	}

}
