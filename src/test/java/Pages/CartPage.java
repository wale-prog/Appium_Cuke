package Pages;

import BaseClasses.PageBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends PageBase {
    public CartPage(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"product row\"])")
    private List<WebElement> cartItems;

    public List<WebElement> getCartItems() {
        return  cartItems;
    }
}
