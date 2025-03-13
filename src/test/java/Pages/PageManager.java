package Pages;

import io.appium.java_client.android.AndroidDriver;

public class PageManager {

    private HomePage homePage;
    private LoginPage loginPage;
    private final AndroidDriver driver;

    public PageManager(AndroidDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return  (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }

    public LoginPage getLoginPage() {
        return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
    }
}
