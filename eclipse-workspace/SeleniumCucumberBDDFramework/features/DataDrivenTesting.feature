@DataDrivenTesting
Feature: Youtube channel name validation
	Scenario Outline: Youtube channel name validations
	Given Open chrome browser with url
	When Search selenium tutorial "<SearchString>"
	And Click on channel name 
	Then Validate channel name
	
	Examples:
		|SearchString|
		|selenium by bakappa n|
		|selenium webdriver by bakappa n|
	
	 
