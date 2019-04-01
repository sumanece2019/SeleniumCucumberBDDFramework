package com.testautomation.TestRunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions (
	        features = "./features/"
	        ,glue = {"com.testautomation.StepDef"}
	        //,tags = {"@UATTesting,
	        //,tags = {"@UATTesting2"}
	        //,tags = {"@DataDrivenTesting"}
	        //,tags = {"@TestDataReading"}
	        //,tags = {"@ExtentReport"})
			//,tags = {"@TestngTest"})
			,tags = {"@ParallelTestingwithCucumber"})
			//,tags = {"@Module1"})
			//,tags = {"@RegressionTesting","@SmokeTesting"})//For AND logic separated with quotes("")
			//,tags = {"@RegressionTesting,@SmokeTesting"})//Logical OR
			//,tags = {"@CucumberTags","~@SmokeTesting"})//Logical Not
			//,tags = {"@TestCase1"})
			//,tags = {"@CucumberHooks"})
			/*,plugin= { "pretty",
	                "html:target/site/cucumber-pretty",
	        "json:target/cucumber.json" },
	        monochrome = true)*/

public class TestRunner {
	    private TestNGCucumberRunner testNGCucumberRunner;
	    
	    @BeforeClass(alwaysRun = true)
	    public void setUpClass() throws Exception {    	
	        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	    }

	    @Test(dataProvider = "features")    
	    public void feature(PickleEventWrapper eventwrapper,CucumberFeatureWrapper cucumberFeature) throws Throwable {
	   	//public void feature(CucumberFeatureWrapper cucumberFeature) {
	    	//testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	    	testNGCucumberRunner.runScenario(eventwrapper.getPickleEvent());
	    }
	    
	    @DataProvider//(parallel=false)
	    public Object[][] features() {
	       //return testNGCucumberRunner.provideFeatures();    	
	       return testNGCucumberRunner.provideScenarios();
	    }
	    
	    @AfterClass(alwaysRun = true)
	    public void tearDownClass() throws Exception {    	
	        testNGCucumberRunner.finish();        
	    }
}
