package utils;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {

	public static WebDriver driver;
	public static String email = null;
	public static String password = null;
//	public Faker faker = new Faker(new Locale("pt-BR"));
	public Faker faker = new Faker();
	public WebDriverWait wait;

	StringBuilder path = new StringBuilder();

	public BaseTest() {
	}

	public BaseTest(String browser) {
		createDriver(browser);
	}

	public WebDriver createDriver(String browser) {
		if (driver == null) {
			switch (browser) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver", getDriverPath("chromedriver"));
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				break;
			case "firefox":
				System.setProperty("webdriver.gecko.driver", getDriverPath("geckodriver"));
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				break;
			default:
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--headless");
				System.setProperty("webdriver.chrome.driver", getDriverPath("chromedriver"));
				driver = new ChromeDriver(chromeOptions);
				break;
			}
		}
		return driver;
	}

	public String getDriverPath(String driver) {
		path.append("src/test/resources/drivers/").append(driver);
		if (System.getProperty("os.name").contains("Windows")) {
			path.append(".exe");
		}
		return path.toString();
	}

	public WebDriver getDriver() {
		if (driver == null) {
			createDriver("headless");
		}
		return driver;
	}

	public void sendText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	public WebElement waitToClick(WebElement locator) {
		wait = new WebDriverWait(driver, 40);
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public WebElement waitVisible(By locator) {
		wait = new WebDriverWait(driver, 40);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public String getEmail() {
		if (email == null) {
			email = faker.internet().emailAddress();
			System.out.println("Email is: " + email);
		}
		return email;
	}

	public String getPassword() {
		if (password == null) {
			password = faker.internet().password();
			System.out.println("Password is: " + password);
		}
		return password;
	}

	public void selectField(WebElement element, int i) {
		Select select = new Select(element);
		select.selectByIndex(i);
	}
}