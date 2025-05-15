package utils.Helpers;

import BaseClasses.TestBase;
import Pages.PageManager;

public class Login extends TestBase {
    PageManager pageManager = new PageManager(driver);

    public void login() {
        pageManager.getHomePage().clickHamburgerMenu();
        pageManager.getHomePage().clickLoginLink();
        pageManager.getLoginPage().enterUsername("bob@example.com");
        pageManager.getLoginPage().enterPassword("10203040");
        pageManager.getLoginPage().clickLoginBtn();
    }
}
