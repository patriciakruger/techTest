package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utils.BaseTest;

public class MyAccountPage extends BaseTest {

	@FindBy(xpath = "//p[contains(text(), 'Welcome to your account.')]")
	WebElement notificationAccount;
	
	public MyAccountPage() {
		super();
		PageFactory.initElements(driver, this);
	}

	public void successfullyLogin() {
		String notification = notificationAccount.getText();
		Assert.assertTrue(notification.contains("Welcome to your account."));
	}
}
