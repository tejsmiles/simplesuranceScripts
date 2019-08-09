package Runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
//import cucumber.api.testng.*;
//import io.cucumber.testng.TestNGCucumberRunner;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources"}
		,glue= {"StepDefs"}
		)

public class testrunner {

}