package com.lab.testrunner;



import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features= "src\\test\\resources\\lab.feature",
glue= {"com.lab.stepdefinition","com.lab.hooks"},monochrome=true,
plugin= {"json:target/cucumber-reports/Cucumber.json","junit:target/cucumber-reports/Cucumber.xml",
		"html:target/cucumber-reports","pretty","rerun:/Rerun/failed-scenarios.txt"},dryRun=false)


public class TestRunner {

}
