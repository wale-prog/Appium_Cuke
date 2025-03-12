package config;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumDriverManager {
    private static AndroidDriver driver;


    public static void initializeDriver() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("udid", "RZ8T30532KZ");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "13.0");
        caps.setCapability("deviceName", "samsung SM-A325F");
        caps.setCapability("appium:disableIdLocatorAutocompletion", true);
        caps.setCapability("autoGrantPermissions", true);
        caps.setCapability("appPackage", "com.saucelabs.mydemoapp.rn");
        caps.setCapability("appActivity", "com.saucelabs.mydemoapp.rn.MainActivity");
        caps.setCapability("noReset", true);

        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        }catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static AndroidDriver getDriver() {
        return driver;
    }


    public static void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }
}
