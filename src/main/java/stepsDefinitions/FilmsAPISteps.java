package stepsDefinitions;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FilmsAPISteps {

	RequestSpecification httpRequest;
	Response response;
	String responseBody;

	@Given("^swapi endpoint is up$")
	public void swapiEndpointIsUp() {
		RestAssured.baseURI = "http://swapi.co/api/";
		httpRequest = RestAssured.given();
	}

	@When("^I send a get request to films$")
	public void iSendAGetRequestToFilms() {
		responseBody = "";
		response = httpRequest.request(Method.GET, "/films/");
		responseBody = response.getBody().asString();
		System.out.println("Response Body:: " + responseBody);
	}

	@Then("^Status code should be \"([^\"]*)\"$")
	public void status_code_should_be(String statusCode) {
		Assert.assertEquals(response.getStatusCode(), Integer.parseInt(statusCode));
	}
	
	@Then("^Returned JSON object should have film titles$")
	public void returnedJSONObjectShouldHaveFilmTitles() {
		Assert.assertTrue(responseBody.contains("A New Hope"));
		Assert.assertTrue(responseBody.contains("The Phantom Menace"));
		Assert.assertTrue(responseBody.contains("Return of the Jedi"));
		Assert.assertTrue(responseBody.contains("The Empire Strikes Back"));
		
		System.out.println("\n**********************************************");
		System.out.println("Films titles: ");
		System.out.println(response.path("results.title").toString());
	}

}
