package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BaseTest;

public class LoginPage extends BaseTest {

	@FindBy(className = "login")
	WebElement loginButton;

	@FindBy(className = "logout")
	WebElement logoutButton;

	@FindBy(id = "email_create")
	WebElement newEmailField;
	
	@FindBy(id = "SubmitCreate")
	WebElement createAccountButton;

	@FindBy(id = "email")
	WebElement emailField;

	@FindBy(id = "passwd")
	WebElement passwordField;

	@FindBy(id = "SubmitLogin")
	WebElement submitButton;

	private static final String baseUrl = "http://automationpractice.com/index.php";

	public LoginPage() {
		super();
		PageFactory.initElements(driver, this);
	}

	public void getLoginPage() {
		getDriver();
		driver.get(baseUrl);
	}

	public void fillEmail() {
		waitToClick(loginButton).click();
		loginButton.click();
		sendText(newEmailField, getEmail());
		createAccountButton.click();
	}

	public void login() {
		waitToClick(loginButton).click();
		sendText(emailField, getEmail());
		sendText(passwordField, getPassword());
		waitToClick(submitButton).click();
	}
	
	public void login(String user, String pass) {
		waitToClick(loginButton).click();
		sendText(emailField, user);
		sendText(passwordField, pass);
		waitToClick(submitButton).click();
	}
	
	public void logout() {
		waitToClick(logoutButton).click();
	}
	
}
