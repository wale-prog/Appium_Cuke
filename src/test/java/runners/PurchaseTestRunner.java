package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions", "BaseClasses"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","pretty", "html:report/cucumber-reports.html"},
        tags = "@purchaseTest"
)
public class PurchaseTestRunner extends AbstractTestNGCucumberTests {
}
