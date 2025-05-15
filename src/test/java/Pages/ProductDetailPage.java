package Pages;

import BaseClasses.PageBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ProductDetailPage extends PageBase {
    public ProductDetailPage(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Add To Cart button\")")
    private WebElement addToCartBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"cart badge\")")
    private WebElement cartBadge;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"cart badge\"]/android.widget.TextView")
    private WebElement cartItemNumber;

    public void clickAddToCart() {
        click(addToCartBtn);
    }

    public void clickCartBadge() {
        click(cartBadge);
    }

    public WebElement getCartItemNumber() {
        return cartItemNumber;
    }
}
