@CucumberTags
Feature: Youtube channel name validation


@Module1  @RegressionTesting @SmokeTesting
Scenario: Youtube channel name validations1
	Given Open chrome browser with url
	When Search selenium tutorial
	And Click on channel name 
	Then Validate channel name
	
@Module1 @SmokeTesting
Scenario: Youtube channel name validations2
	Given Open chrome browser with url
	When Search selenium tutorial
	And Click on channel name 
	Then Validate channel name
	
@Module1 @RegressionTesting
Scenario: Youtube channel name validations3
	Given Open chrome browser with url
	When Search selenium tutorial
	And Click on channel name 
	Then Validate channel name