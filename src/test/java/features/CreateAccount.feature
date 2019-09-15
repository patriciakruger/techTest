@Chrome
Feature: Create account

Scenario: Submit valid data to create account
	Given I am in the homepage
	When I create account with valid data
	Then account should successfully be created
	And I can log in the site