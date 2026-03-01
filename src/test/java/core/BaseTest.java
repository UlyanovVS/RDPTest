package core;

import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected AndroidDriver driver;
    protected String appPackage;
    protected String appActivity;

    @BeforeMethod
    public void setUp() {
        if (appPackage != null) {
            driver = DriverFactory.createDriver(appPackage, appActivity);
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        System.out.println("Closing application");
        if (driver != null) {
            try {
                if (appPackage != null) {
                    driver.terminateApp(appPackage);
                    System.out.println("Application terminated: " + appPackage);
                }

                Thread.sleep(1000);
                driver.quit();
                System.out.println("Driver closed");
            } catch (Exception e) {
                System.err.println("Error while closing driver: " + e.getMessage());
                try {
                    driver.quit();
                } catch (Exception ignored) {}
            }
        } else {
            System.out.println("Driver was null, nothing to close");
        }
        System.out.println("Application closed");
    }
}