package linkedInCucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features={"./src/test/features"}, glue = {"linkedInCucumber.stepDefinition"})
public class Runner extends AbstractTestNGCucumberTests {
}
