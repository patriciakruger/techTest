package stepsDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.CreateAccountPage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utils.BaseTest;

public class CreateAccountSteps extends BaseTest {

	LoginPage login = new LoginPage();
	CreateAccountPage createAccount = new CreateAccountPage();
	MyAccountPage myAccount = new MyAccountPage();
	
	@Given("^I am in the homepage$")
	public void iAmInTheHomepage() {
		login.getLoginPage();
	}

	@When("^I create account with valid data$")
	public void iCreateAccountWithValidData() {
		login.fillEmail();
		createAccount.fillForm();
	}

	@Then("^account should successfully be created$")
	public void accountShouldSuccessfullyBeCreated() {
		myAccount.successfullyLogin();
	}

	@Then("^I can log in the site$")
	public void iCanLogInTheSite() {
		login.logout();
		login.login();
		myAccount.successfullyLogin();
	}
	
}
