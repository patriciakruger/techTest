@APITest
Feature: Swapi API

Scenario: Get films title
	Given swapi endpoint is up
	When I send a get request to films
	Then Status code should be "200"
	And Returned JSON object should have film titles