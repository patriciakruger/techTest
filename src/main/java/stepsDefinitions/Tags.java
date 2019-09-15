package stepsDefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.BaseTest;

import java.io.IOException;

public class Tags extends BaseTest {
	    
    @Before("@Chrome")
    public void setUpChrome() {
    	createDriver("chrome");
    }

    @Before("@Firefox")
    public void setUpFirefox() {
    	createDriver("firefox");
    }
    
    @After("@Chrome, @Firefox")
    public void tearDown(Scenario scenario) throws IOException {
        if(scenario.isFailed()) {
            scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
        }
        driver.quit();
    }

}