package StepDefinitions;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		format = {"pretty", "html:target/html", "json:target/cucumber.json"},
		features = {"src/test/resource/InterviewTest.feature"}
		)
public class RunnerTest {
	
}
