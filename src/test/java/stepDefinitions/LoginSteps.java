package stepDefinitions;

import Pages.PageManager;
import config.TestBase;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static config.TestBase.driver;

public class LoginSteps {

//    static AndroidDriver driver = TestBase.getDriver();
    PageManager pageManager = new PageManager(driver);

    @When("The user launches the app the appActivity should be {string}")
    public void theUserLaunchesTheAppTheAppActivityShouldBe(String activity) {
        Assert.assertEquals(driver.currentActivity(), activity);
    }

    @And("User should be able to navigate to the login page")
    public void userShouldBeAbleToNavigateToTheLoginPage() {
        pageManager.getHomePage().clickHamburgerMenu();
        pageManager.getHomePage().clickLoginLink();
    }

    @When("The user tries to login with blank credentials")
    public void theUserTriesToLoginWithBlankCredentials() {
        pageManager.getLoginPage().clickLoginBtn();
    }

    @Then("There should be an error message {string} on the screen")
    public void thereShouldBeAnErrorMessageOnTheScreen(String errorMsg) {
        Assert.assertEquals(pageManager.getLoginPage().getUsernameErrorMsg().getText(), errorMsg);
    }

}
