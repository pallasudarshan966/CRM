package ObjectRepository_Appium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Android_LogoutPage {

	public Android_LogoutPage(AndroidDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "droid.widget.Button[@content-desc='67']//ancestor::*[@class='android.view.View']//descendant::android.view.View[@content-desc=\"Welcome,\r\n"
			+ "GENERALMEDICINEPG\"]")
	private WebElement profileBtn;

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Log Out']")
	private WebElement logoutBtn;

	public void logoutTheApp(AndroidDriver driver) {
		profileBtn.click();
		logoutBtn.click();
	}

}
