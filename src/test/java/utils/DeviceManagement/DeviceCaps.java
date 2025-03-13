package utils.DeviceManagement;

import config.TestBase;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DeviceCaps extends TestBase {

    public static void SamsungA32() {
        caps = new DesiredCapabilities();
        caps.setCapability("udid", "RZ8T30532KZ");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "13.0");
        caps.setCapability("deviceName", "samsung SM-A325F");
        caps.setCapability("appPackage", "com.saucelabs.mydemoapp.rn");
        caps.setCapability("appActivity", "com.saucelabs.mydemoapp.rn.MainActivity");
        caps.setCapability("noReset", false);
    }

    public static void Emulator() {
        caps = new DesiredCapabilities();
        caps.setCapability("udid", "emulator-5554");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "13.0");;
        caps.setCapability("appPackage", "com.saucelabs.mydemoapp.rn");
        caps.setCapability("appActivity", "com.saucelabs.mydemoapp.rn.MainActivity");
        caps.setCapability("noReset", false);
        caps.setCapability("autoGrantPermissions", true);
    }
}
