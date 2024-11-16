package com.Dalvkot.Vims_GenericUtility;

import java.io.File;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains All WebDriver Actions
 * 
 * @author Sudarshan palla
 *
 */
public class WebDriverUtility extends JavaUtility {

	WebDriver driver;
	WebDriverWait wait;

	/**
	 * This method is used to implicitly wait till page load
	 *
	 * @param driver
	 */
	public void waitTillPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/**
	 * used to wait for element to be clickable in GUI ,&check for specific element
	 * for every 500 milli seconds
	 *
	 * @throws Throwable
	 *
	 */
	public void waitForElementWithCustomTimeOut(WebDriver driver, WebElement element, int pollingTime)
			throws Throwable {
		FluentWait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(pollingTime))
				.pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(StaleElementReferenceException.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	/**
	 * This method is used to wait the control till the Particulr element in visible
	 *
	 * @param element
	 */
	public void waitUntilElementVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
	}

	public void scrollByUsingActions(WebDriver driver, WebElement element, int yOffset) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).clickAndHold().moveByOffset(0, yOffset).release().perform();
	}

	/**
	 * it is used to handle the scroll down/up Handling
	 */
	public void scrollHandling(WebDriver driver, int value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,value)", "");
	}

	/**
	 * it is used to take the Screen Shot of the Faield Test Scripts
	 *
	 * @throws Throwable
	 */
	public String takeScreenShot(WebDriver driver, String screenshotName) throws Throwable {
		TakesScreenshot ts = (TakesScreenshot) driver;
		String dateandtime = Calendar.getInstance().getTime().toString().replace(":", "_");
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/" + screenshotName + dateandtime + ".PNG");
		FileUtils.copyFile(src, dest);
		return dest.getAbsolutePath();
	}

	/**
	 * This method is used to mouse over on the element
	 *
	 * @param driver
	 * @param element
	 */
	public void movetoElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	/**
	 * This method is used to Double click on WebElement
	 *
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}

	/**
	 * This method is used to move the mouse over action on Particular element
	 *
	 * @param driver
	 * @param element
	 */
	public void moveToTheParticularElementAndClick(WebDriver driver, WebElement element) {
		Actions ac = new Actions(driver);
		ac.moveToElement(element).click(element).build().perform();
	}

	/**
	 * This method is used to Move the mouse action in particular element and Pass
	 * the data.
	 *
	 * @param driver
	 * @param element
	 * @param department
	 */
	public void moveToElementAndEnterTheData(WebDriver driver, WebElement element, String dropdownText) {
		Actions act = new Actions(driver);
		act.moveToElement(element).sendKeys(dropdownText, Keys.ARROW_DOWN, Keys.ENTER).build().perform();

	}

	/**
	 * This method is used to Switch Back to main Page
	 *
	 * @param driver
	 */
	public void switchBackToHomeWebPage() {
		driver.switchTo().defaultContent();
	}

	public void enterDataThroughJs(WebElement element, String data) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value=arguments[1]", element, data);
	}

	public void scrollDownTheStillEndOfThePage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}

	public void scroll_Up_FullPage_UsingJavaScriprExecuter(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
	}

	/**
	 * This method is used to click on the element through javascript executor
	 *
	 * @param driver
	 * @param element
	 */
	public void clickOnTheElementUsedToJavascriptExecuter(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void scroolToSpecifiedHeight(WebDriver driver, int height) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + height + ")");
	}

	/**
	 * This method is used to scroll till the bottom of the page
	 */
	public void scrollToBottom(WebDriver driver) {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void explicityWaitForElemenToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
	}

	/**
	 * To Wait Until Element to be Clickable
	 */
	public static void explicitWaitElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
	}

	public static void explicitWaitElementToBeClickabl(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void doubleClickOnTheElementUsedToJavascriptExecuter(WebDriver driver, WebElement element) {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].doubleClick();", element);
	}

	/**
	 * This method is used to scroll till the element is aligned to top
	 *
	 * @param element
	 */
	public void scrollTillVisibleElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}

	public void scrollDownThePageUntilElementIsVisible(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoViewIfNeeded()", element);
	}

	public void scrollDownByUsingJavascriptExecuter(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,420)", "");
	}

	public void clickOnTheElementByUsingJavascriptExecuter(WebDriver driver, WebElement element) {
		waitForElementToBeVisible(driver, element);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	/* To ZoomOut */
	public void zoomOutUsingActions(WebDriver driver) throws Exception {
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.SUBTRACT).keyUp(Keys.CONTROL).perform();
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.SUBTRACT).keyUp(Keys.CONTROL).perform();
	}

	/*
	 * To ZoomIn
	 * 
	 */
	public void zoomInUsingActions(WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.ADD).keyUp(Keys.CONTROL).perform();
	}

	/*
	 * Scroll up using the ACTION class
	 */
	public void scrollUpUsingActions(WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_UP).perform();
		actions.sendKeys(Keys.PAGE_UP).perform();
	}

	/* To Open a Page in New Tab */
	public void rightClick(WebElement element) {
		Actions ac = new Actions(driver);
		ac.contextClick(element);
		ac.build().perform();
	}

	/* To Perform Click and Hold Action */
	public void doubleClickOnTheElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}

	/* To Switch To Frame By Index */
	public void switchToFrameByIndex(int index) throws Exception {
		driver.switchTo().frame(index);
	}

	/* To Switch To Frame By Frame Name */
	public void switchToFrameByFrameName(String frameName) throws Exception {
		driver.switchTo().frame(frameName);
	}

	/* To Switch To Frame By Web Element */
	public void switchToFrameByWebElement(WebElement element) throws Exception {
		driver.switchTo().frame(element);
	}

	/* To Switch out of a Frame */
	public void switchOutOfFrame() throws Exception {
		driver.switchTo().defaultContent();
	}

	public void scrollDownByUsingActionClass(WebDriver driver) {
		Actions a = new Actions(driver);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
	}

	public void explictWaitForElementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
	}

	public void explictWaitForElementToBeVisible_ForPartcilur_Seconds(WebDriver driver, WebElement element, int value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
	}

	public void explicityWaitForElemenToBeClickable_ForSeconds(WebDriver driver, WebElement element, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
	}

	public void dropdown_Handling(WebDriver driver, int maxRetries, WebElement dropdownTrigger, WebElement droddownText,
			String inputText) {
		for (int retries = 0; retries < maxRetries; retries++) {
			try {
				explicityWaitForElemenToBeClickable(driver, dropdownTrigger);
				dropdownTrigger.click();
				moveToElementAndEnterTheData(driver, droddownText, inputText);
				return;
			} catch (Exception e) {
			}
		}

	}

	public void clickElementWithRetries(WebDriver driver, int maxRetries, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		for (int retries = 0; retries < maxRetries; retries++) {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(element)).click();
				return;
			} catch (Exception e) {
			}
		}
	}

	public static void scrollToTop(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollTo(0, 0);");
	}

	public void waitForElementToBeVisibleWithRetries(WebDriver driver, WebElement element, int maxRetries,
			int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		for (int retries = 0; retries < maxRetries; retries++) {
			try {
				wait.until(ExpectedConditions.visibilityOf(element));
				return;
			} catch (Exception e) {
			}
		}
	}

	public void waitForElementToBeVisible(WebDriver driver, WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
		}
	}

	public void clickElementWhenVisible(WebDriver driver, WebElement element, int maxAttempts) throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		for (int attempts = 0; attempts < maxAttempts; attempts++) {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(element)).click();
				break;
			} catch (Exception e) {
			}
		}
	}

	public void clickOn_Element_If_Visible(WebDriver driver, WebElement element) {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebElement okBtn = null;
		try {
			okBtn = element;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println(" button not found. Skipping clicking the button.");
		}
		if (okBtn != null) {
			okBtn.click();
		}
	}

	public void wait_For_Invisibilty_Of_Loader(WebDriver driver, int value) {
		try {
			WebElement llll = driver.findElement(By.xpath("//div[@class='inside-circle']"));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.refreshed(ExpectedConditions.invisibilityOf(llll)));
		} catch (Exception e) {
		}

	}

	public void wait_For_Invisibilty_OfElement_ForLoader(WebDriver driver) {
		// div[@class='inside-circle']
		try {
			WebElement llll = driver.findElement(By.xpath("//div[@class='circle-wrap ng-star-inserted']"));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
			wait.until(ExpectedConditions.refreshed(ExpectedConditions.invisibilityOf(llll)));
		} catch (Exception e) {
		}
	}

	public void invisibiltyOf_Element_ThreeDots(WebDriver driver) {
		try {
			WebElement llll = driver.findElement(By.xpath("//div[@class='spinner-three-bounce ng-star-inserted']"));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.refreshed(ExpectedConditions.invisibilityOf(llll)));
		} catch (Exception e) {
		}
	}

	public void dropdown(WebDriver driver, WebElement element, WebElement Text, String str) {
		explicitWaitElementToBeClickable(driver, element);
		element.click();
		moveToElementAndEnterTheData(driver, Text, str);
	}

	public void getWindowHandles(WebDriver driver) {

		String mainWindowHandle1 = driver.getWindowHandle();
		Set<String> allWindowHandles2 = driver.getWindowHandles();
		Iterator<String> iterator2 = allWindowHandles2.iterator();
		while (iterator2.hasNext()) {
			String ChildWindow2 = iterator2.next();
			if (!mainWindowHandle1.equalsIgnoreCase(ChildWindow2)) {
				driver.switchTo().window(ChildWindow2);
				driver.close();
			}
		}
		driver.switchTo().window(mainWindowHandle1);

	}

	public void wait_For_InvisibiltyOfElement(WebDriver driver, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.invisibilityOf(ele)));
	}

	public void select_DatePicker(WebDriver driver, WebElement element, String month, String date, String year)
			throws Throwable {
		wait_For_Invisibilty_OfElement_ForLoader(driver);
		invisibiltyOf_Element_ThreeDots(driver);
		element.click();
		for (int i = 0; i <= 12; i++) {
			if (!driver.findElements(By.xpath("//td[@aria-label='" + month + " " + date + "," + year + "']//div[1]"))
					.isEmpty()
					|| !driver
							.findElements(
									By.xpath("//td[@aria-label='" + month + " " + date + ", " + year + "']//div[1]"))
							.isEmpty()) {
				try {
					element = driver.findElement(
							By.xpath("//td[@aria-label='" + month + " " + date + ", " + year + "']//div[1]"));
				} catch (Exception e) {
					element = driver.findElement(
							By.xpath("//td[@aria-label='" + month + " " + date + "," + year + "']//div[1]"));
				}
				element.click();
				break;
			} else {
				Thread.sleep(800);
				driver.findElement(
						By.xpath("//button[contains(@class,'mat-focus-indicator mat-calendar-previous-button')]"))
						.click();
			}
		}
	}

	public void selectDatePicker_MinusDate(int days, WebElement element) throws Throwable {
		String date = generateDateForDatePicker_MinusDate(days);
		String[] date1 = date.split(" ");
		String month = date1[0];
		String day = date1[1];
		String year = date1[2];
		select_DatePicker(driver, element, month, day, year);
	}

	public static List<LocalDate> generateDatesBetween(LocalDate startDate, LocalDate endDate) {
		List<LocalDate> datesInRange = new ArrayList<>();
		LocalDate currentDate = startDate;

		while (!currentDate.isAfter(endDate)) {
			datesInRange.add(currentDate);
			currentDate = currentDate.plusDays(1);
		}

		return datesInRange;
	}

	public String generateRandomMobileNumber1() throws Throwable {
		Random ran = new Random();
		long mobile = 7000000000L + ran.nextInt(800000000);
		String ph = Long.toString(mobile);
		return ph;
	}

}
