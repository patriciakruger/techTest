@Firefox
Feature: Login

Scenario: Login with valid data
	Given I am in the homepage
	When I log with user <"natalie.welch@gmail.com"> and <"lmhn9rhgi">
	Then I should see my account page