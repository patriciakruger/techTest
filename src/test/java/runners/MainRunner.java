package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)

@CucumberOptions (
	features = {"src/test/java/features/"},
	glue = {"stepsDefinitions/"},
	monochrome = true,
//	tags = {"@Firefox"},
	plugin = {"pretty", "html:target/cucumber",
			"json:target/cucumber.json",
			"com.cucumber.listener.ExtentCucumberFormatter:output/report.html"},
	snippets = SnippetType.CAMELCASE
)

public class MainRunner extends AbstractTestNGCucumberTests {

}