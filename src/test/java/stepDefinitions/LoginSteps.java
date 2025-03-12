package stepDefinitions;

import Pages.LoginPage;
import Pages.PageManager;
import config.AppiumDriverManager;
import config.PageBase;
import config.TestBase;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class LoginSteps {
    static AppiumDriverManager appiumDriverManager = new AppiumDriverManager();
    static AndroidDriver driver = AppiumDriverManager.getDriver();
    PageManager pageManager = new PageManager(driver);

    @Given("Appium server has been created and mobile device is ready")
    public void appiumServerHasBeenCreatedAndMobileDeviceIsReady() {
        pageManager.getLoginPage().clickNextBtn();

        Assert.assertEquals(driver.currentActivity(), ".activities.LauncherActivity");
    }

    @Then("The main activity should be <.MainActivity>")
    public void theMainActivityShouldBeMainActivity() {
    }
}
