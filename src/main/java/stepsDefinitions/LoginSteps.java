package stepsDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class LoginSteps {

	LoginPage login = new LoginPage();
	MyAccountPage myAccount = new MyAccountPage();
	
	@When("^I log with user <\"([^\"]*)\"> and <\"([^\"]*)\">$")
	public void i_log_with_user_and(String user, String pass) {
		login.login(user, pass);
	}

	@Then("^I should see my account page$")
	public void i_should_see_my_account_page() {
		myAccount.successfullyLogin();
	}
}
