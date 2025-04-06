package stepDefinitions;

import BaseClasses.TestBase;
import Pages.PageManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static BaseClasses.TestBase.driver;
import static utils.extentReports.ExtentTestManager.startTest;

public class LoginSteps {

    //    static AndroidDriver driver = TestBase.getDriver();
    PageManager pageManager = new PageManager(driver);

    @When("The user launches the app the appActivity should be {string}")
    public void theUserLaunchesTheAppTheAppActivityShouldBe(String activity) {
        startTest("theUserLaunchesTheAppTheAppActivityShouldBe", "The user launches the app the appActivity should be ", "");
        Assert.assertEquals(driver.currentActivity(), activity);
    }

    @And("User should be able to navigate to the login page")
    public void userShouldBeAbleToNavigateToTheLoginPage() {
        startTest("userShouldBeAbleToNavigateToTheLoginPage", "User should be able to navigate to the login page ", "");
        pageManager.getHomePage().clickHamburgerMenu();
        pageManager.getHomePage().clickLoginLink();
    }


    @Then("There should be an error message {string} on the screen")
    public void thereShouldBeAnErrorMessageOnTheScreen(String errorMsg) {
        startTest("thereShouldBeAnErrorMessageOnTheScreen", "There should be an error message {string} on the screen", "");
        WebElement element;
        element = pageManager.getLoginPage().getLoginError();
        Assert.assertEquals(element.getText(), errorMsg);
    }

    @And("The user tries to login with username as {string} and password as {string}")
    public void theUserTriesToLoginWithAnd(String username, String password) {
        pageManager.getLoginPage().enterUsername(username);
        pageManager.getLoginPage().enterPassword(password);
        pageManager.getLoginPage().clickLoginBtn();
    }

    @When("the user tries to login to a locked out account")
    public void theUserTriesToLoginToALockedOutAccount() {
        pageManager.getLoginPage().clearUsernameField();
        pageManager.getLoginPage().clearPasswordField();
        pageManager.getLoginPage().clickLockedOutAccount();
        pageManager.getLoginPage().clickLoginBtn();
    }

    @Then("there should be an error message {string} error")
    public void thereShouldBeAnErrorMessageError(String errorMsg) {
        Assert.assertEquals(pageManager.getLoginPage().getLockOutErrorMsg().getText(), errorMsg);
    }

    @When("the user tries to login with a valid username as {string} and valid password as {string}")
    public void theUserTriesToLoginWithAValidUsernameAsAndValidPasswordAs(String username, String password) {
        pageManager.getLoginPage().enterUsername(username);
        pageManager.getLoginPage().enterPassword(password);
        pageManager.getLoginPage().clickLoginBtn();
    }

    @Then("the should be directed to the home page of the application")
    public void theShouldBeDirectedToTheHomePageOfTheApplication() {
        TestBase.sleep(10);
    }
}
