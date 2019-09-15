package pageObjects;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BaseTest;

public class CreateAccountPage extends BaseTest {

	@FindBy(id = "account-creation_form")
	WebElement form;
	
	@FindBy(id = "customer_firstname")
	WebElement firstNameField;

	@FindBy(id = "customer_lastname")
	WebElement lastNameField;

	@FindBy(id = "email")
	WebElement emailField;

	@FindBy(id = "passwd")
	WebElement passwordField;

	@FindBy(id = "days")
	WebElement days;

	@FindBy(id = "months")
	WebElement months;

	@FindBy(id = "years")
	WebElement years;

	@FindBy(id = "firstname")
	WebElement firstnameAdress;

	@FindBy(id = "lastname")
	WebElement lastnameAdress;

	@FindBy(id = "company")
	WebElement companyField;

	@FindBy(id = "address1")
	WebElement addressField;

	@FindBy(id = "city")
	WebElement cityField;

	@FindBy(id = "id_state")
	WebElement stateField;

	@FindBy(id = "postcode")
	WebElement postcodeField;

	@FindBy(id = "id_country")
	WebElement countryField;

	@FindBy(id = "phone_mobile")
	WebElement phoneField;

	@FindBy(id = "alias")
	WebElement addressAliasField;

	@FindBy(id = "submitAccount")
	WebElement submitButton;

	Random rand = new Random();
	String firstName = faker.name().firstName();
	String lastName = faker.name().lastName();

	public CreateAccountPage() {
		super();
		PageFactory.initElements(driver, this);
	}

	public WebElement getRandomGender() {
		Random rand = new Random();
		int randomInt = rand.nextInt(2) + 1;
		WebElement gender = driver.findElement(By.id("uniform-id_gender" + randomInt));
		return gender;
	}

	public CreateAccountPage fillPersonalInformation() {
		waitVisible(By.id("account-creation_form"));
		sendText(waitToClick(firstNameField), firstName);
		sendText(waitToClick(lastNameField), lastName);
		sendText(waitToClick(passwordField), getPassword());
		selectField(days, rand.nextInt(30) + 2);
		selectField(months, rand.nextInt(11) + 2);
		selectField(years, rand.nextInt(28) + 2);
		waitToClick(getRandomGender()).click();
		return new CreateAccountPage();
	}

	public CreateAccountPage fillAddress() {
		sendText(waitToClick(companyField), faker.company().name());
		sendText(waitToClick(addressField), faker.address().streetName());
		sendText(waitToClick(cityField), faker.address().city());
		selectField(stateField, rand.nextInt(52) + 2);
		sendText(waitToClick(postcodeField), faker.bothify("#####"));
		sendText(waitToClick(phoneField), faker.phoneNumber().cellPhone());
		sendText(waitToClick(addressAliasField), faker.harryPotter().character());
		submitButton.click();
		return new CreateAccountPage();
	}

	public CreateAccountPage fillForm() {
		fillPersonalInformation();
		fillAddress();
		return new CreateAccountPage();
	}
	
}