package com.testautomation.StepDef;

import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.IGherkinFormatterModel;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.testautomation.Listeners.ExtentReportListener;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class TestHooks
{
	
	public static String Current_Scenario_Name = null;
	
	//Hooks are nothing but the Pre-Conditions & Post-Conditions
	//@Before --> Will be executed before each scenario
	//@After --> Will be executed after each scenario
	
	@Before
	public void beforeScenario(Scenario scenario) 
	{
		System.out.println("Started Execution for the Scenario :"+scenario.getName());
		Current_Scenario_Name = scenario.getName();
	}
	
	//Tagged Hook --> When we are specifying the Pre Conditions for a Particular Scenario
	@Before("@TestCase2")
	public void beforeTestCase2(Scenario scenario)
	{
		System.out.println("---------------------------------------------------------");
		System.out.println("Executing Before TestCase2 :"+scenario.getName());
		System.out.println("---------------------------------------------------------");
	}
	
	@After
	public void afterScenario(Scenario scenario)
	{
		System.out.println("Completed Execution for the Scenario :"+scenario.getName());
	}
	
}
