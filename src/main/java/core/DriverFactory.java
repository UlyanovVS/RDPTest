package core;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public class DriverFactory {

    public static AndroidDriver createDriver(String appPackage, String appActivity) {
        try {
            DesiredCapabilities caps = new DesiredCapabilities();

            caps.setCapability("platformName", "Android");
            caps.setCapability("appium:platformVersion", "11");
            caps.setCapability("appium:deviceName", "Android Emulator");
            caps.setCapability("appium:automationName", "UiAutomator2");
            caps.setCapability("appium:udid", "emulator-5554");
            caps.setCapability("appium:autoGrantPermissions", true);
            caps.setCapability("appium:newCommandTimeout", 60);
            caps.setCapability("appium:appPackage", appPackage);
            caps.setCapability("appium:appActivity", appActivity);
            caps.setCapability("appium:noReset", true);
            caps.setCapability("appium:fullReset", false);
            caps.setCapability("appium:dontStopAppOnReset", true);
            caps.setCapability("appium:avd", "RDPMobile");
            caps.setCapability("appium:avdLaunchTimeout", 300000);
            caps.setCapability("appium:avdReadyTimeout", 300000);

            return new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);

        } catch (Exception e) {
            throw new RuntimeException("Error when creating the driver: " + e.getMessage(), e);
        }
    }
}