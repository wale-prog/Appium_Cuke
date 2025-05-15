package stepDefinitions;

import BaseClasses.TestContext;
import Pages.CartPage;
import Pages.HomePage;
import Pages.PageManager;
import Pages.ProductDetailPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static BaseClasses.TestBase.*;

public class PurchaseSteps {

    private final ProductDetailPage detailPage;
    private final HomePage homePage;
    private final CartPage cartPage;

    public PurchaseSteps(TestContext context) {
        this.detailPage = context.getDetailPage();
        this.homePage = context.getHomePage();
        this.cartPage = context.getCartPage();
    }
//    static PageManager pageManager = new PageManager(driver);

    @Given("user is already logged in")
    public void userIsAlreadyLoggedIn() {
//        Login user = new Login();
//        user.login();
    }

    @And("user clicks on the Sauce Labs Backpack item on the home page")
    public void userClicksOnTheSauceLabsBackpackItemOnTheHomePage() {
        homePage.selectBackPack();
    }

    @When("user clicks on the Add To Cart button")
    public void userClicksOnTheAddToCartButton() {
        detailPage.clickAddToCart();
        Assert.assertEquals(detailPage.getCartItemNumber().getText(), "1");
    }

    @Given("user is on the product page")
    public void userIsOnTheProductPage() {
        driver.navigate().back();
        driver.navigate().back();
    }

    @Then("the the item is added to cart")
    public void theTheItemIsAddedToCart() {
        detailPage.clickCartBadge();
        Assert.assertEquals(cartPage.getCartItems().size(), 1);
    }

    @And("user clicks on the Bolt t-Shirt")
    public void userClicksOnTheBoltTShirt() {
        homePage.clickBoltTShirt();
        detailPage.clickAddToCart();
        waitForElement(20).until(ExpectedConditions.textToBePresentInElement(detailPage.getCartItemNumber(), "2"));
        Assert.assertEquals(detailPage.getCartItemNumber().getText(), "2");
    }

    @Then("the item is added to cart two items are confirmed in cart")
    public void theItemIsAddedToCartTwoItemsAreConfirmedInCart() {
        detailPage.clickCartBadge();
        Assert.assertEquals(cartPage.getCartItems().size(), 2);
    }
}
