package BaseClasses;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDefinitions.LoginSteps;
import utils.DeviceManagement.DeviceCaps;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
    public static AndroidDriver driver;
    public static DesiredCapabilities caps;
    private static FileInputStream fis;
    public static Properties configProp;
    LoginSteps loginSteps;

    private static final Logger log = LogManager.getLogger(TestBase.class);

//    public TestBase() {
//
//    }

    private static void loadPropFile() {
        configProp = new Properties();
        try{
            fis = new FileInputStream("src/test/resources/config.properties");
            configProp.load(fis);
        }catch (IOException e) {
            log.error("config.properties file does not exist");
        }
    }

    @BeforeAll
    public static void setUp() {

//        System.out.println("The os name is " + osName);
        loadPropFile();
        String device = configProp.getProperty("device1");
        switch(device) {
            case "SamsungA32":
                log.info("Starting Samsung A32");
                DeviceCaps.SamsungA32();
                break;
            case "Emulator":
                log.info("Starting Emulator");
                DeviceCaps.Emulator();
                break;
            default: throw new IllegalArgumentException("The device (" + device + ") selected is not configured");
        }
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        }catch (MalformedURLException e) {
            log.error("The server URL is malformed or invalid");
        }
    }

    public static AndroidDriver getDriver() {
        return driver;
    }

    public static void sleep(int seconds) {
        try{
            Thread.sleep(1000L * seconds);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void manageImplicitWait(int seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    public static WebDriverWait waitForElement(int seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds));
    }


    @AfterAll
    public static void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }
}
