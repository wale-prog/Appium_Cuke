package runners;

import config.AppiumDriverManager;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(
        features = "src/test/resources/features",
        tags = "@FirstTest",
        glue = "stepDefinitions",
        plugin = {"pretty", "html:report/cucumber-reports.html"}
)

public class TestRunner extends AbstractTestNGCucumberTests {

    @BeforeClass
    public void setup() {
        AppiumDriverManager.initializeDriver();
    }

    @AfterClass
    public void tearDown() {
        AppiumDriverManager.tearDown();
    }

}
