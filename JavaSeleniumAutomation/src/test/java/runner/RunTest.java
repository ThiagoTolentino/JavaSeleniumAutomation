package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features",
        glue = {"stepDefinition", "hooks"},
        tags = {},

        plugin = {"pretty","html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.Json",
                "rerun:target/cucumber-reports/rerun.txt",
                "junit:target/cukes/junit.xml"
        })


public class RunTest {

}
