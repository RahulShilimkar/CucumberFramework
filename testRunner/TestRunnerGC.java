package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
		features="src/test/java/features",
		glue="stepDefinitions",				//package name
		dryRun=true,
		monochrome=true,
		plugin= {
				"pretty",
				"html:target/cucumber.html"}
		)

public class TestRunnerGC extends AbstractTestNGCucumberTests{


	}

