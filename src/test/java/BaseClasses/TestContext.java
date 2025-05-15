package BaseClasses;

import Pages.CartPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductDetailPage;
import io.appium.java_client.android.AndroidDriver;

import static BaseClasses.TestBase.getDriver;

public class TestContext {
    private final CartPage cartPage;
    private final HomePage homePage;
    private final LoginPage loginPage;
    private final ProductDetailPage detailPage;

    public TestContext() {
        AndroidDriver driver = getDriver();
        cartPage = new CartPage(driver);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        detailPage = new ProductDetailPage(driver);
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public CartPage getCartPage() {
        return cartPage;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public ProductDetailPage getDetailPage() {
        return detailPage;
    }

}
