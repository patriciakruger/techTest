# TechTest 
This is a simple project with functional and API testing. 

**Tools:**
* Cucumber
* Selenium WebDriver
* REST Assured
* Maven
* Java
* Java Faker

**Tested functionalities:**
* Create new account
* Login
* Display the content of HTTP Response Body with REST Assured

See `../features` for the features files with description of the tests.

# Getting started
**Instructions**<br>
Clone the repo:
```
$ git clone https://github.com/patriciakruger/techTest.git
```

**Prerequisites**<br>
In order to run browser tests, Selenium will need to be able to drive a browser.<br>
To give permission on linux type from the command line: 
```
$ cd src/test/resources/drivers
$ chmod 777 chromedriver geckodriver
```

The project is preconfigured to execute Cucumber tests with TestNG. You can run the tests from the command line with:
```
$ mvn test
```

**Cucumber Reports**<br>
Reports can be found:<br>
* JSON report:   `target/cucumber.json`
* HTML Report:   `target/cucumber/index.html`
* ExtentReports: `output/report.html`

**Specify a different browser**<br>
To set a different browser change the tag above the Feature in the feature file.<br>
`@Chrome` - available in OS Windows and Linux<br>
`@Firefox` - only linux<br>
Without tag test will run chrome in headless mode.