package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions", "config"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","pretty", "html:report/cucumber-reports.html"}
)

public class TestRunner extends AbstractTestNGCucumberTests {

}
