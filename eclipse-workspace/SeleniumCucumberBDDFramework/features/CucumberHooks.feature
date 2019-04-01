@CucumberHooks
Feature: Youtube channel name validation

@TestCase1
Scenario: Youtube channel name validations
	Given Open chrome browser with url
	When Search selenium tutorial
	And Click on channel name 
	Then Validate channel name
	
	
@TestCase2
Scenario: Channel validations
	Given Open chrome browser with url
	When Search selenium tutorial
	And Click on channel name 
	Then Validate channel name