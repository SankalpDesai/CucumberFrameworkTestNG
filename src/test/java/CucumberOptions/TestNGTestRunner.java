package CucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//html reports, xml reports, json reports, junit reports, extent report
@CucumberOptions(features="src/test/java/features", glue="stepDefinition",
 monochrome=true,
 plugin= {"html:target/cucumber.html", "json:target/cucumber.json",
		 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		 "rerun:target/failed_scenarios.txt"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests{

	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios(){
		return super.scenarios();
	}
}
