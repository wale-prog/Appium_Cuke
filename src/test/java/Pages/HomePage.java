package Pages;

import BaseClasses.PageBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.cucumber.java.bs.A;
import org.openqa.selenium.WebElement;

public class HomePage extends PageBase {
    public HomePage(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(accessibility = "open menu")
    private WebElement hamburgerMenu;

    @AndroidFindBy(accessibility = "menu item log in")
    private WebElement loginLink;

    @AndroidFindBy(accessibility = "container header")
    private WebElement pageHeader;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(4)")
    private WebElement backpack;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(2)")
    private WebElement cartIcon;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(6)")
    private WebElement boltTShirt;

    // Methods
    public void clickHamburgerMenu() {
        click(hamburgerMenu);
    }
    public void clickLoginLink() {
        click(loginLink);
    }

    public WebElement getPageHeader() {
        return pageHeader;
    }

    public void selectBackPack() {
        click(backpack);
    }
    public void clickCartIcon() {
        click(cartIcon);
    }
    public void clickBoltTShirt() {
        click(boltTShirt);
    }
}

