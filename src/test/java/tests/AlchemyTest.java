package tests;

import core.BaseTest;
import methods.AlchemyMethods;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static constants.AlchemyConstants.APP_ACTICITY;
import static constants.AlchemyConstants.APP_PACKAGE;

public class AlchemyTest extends BaseTest {

    private WebDriverWait wait;
    private WebDriverWait shortWait;
    private WebDriverWait watchButtonWait;
    private AlchemyMethods alchemyMethods;
    private int initialHintsCount;
    private int finalHintsCount;

    @BeforeMethod
    public void setUp() {
        appPackage = APP_PACKAGE;
        appActivity = APP_ACTICITY;
        super.setUp();

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        shortWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        watchButtonWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        alchemyMethods = new AlchemyMethods(driver, wait, shortWait, watchButtonWait);
    }

    @Test(description = "Check hints increase after watching ad")
    public void checkHintsIncrease() {

        System.out.println("1. Click 'Play' button in main menu");
        alchemyMethods.clickPlayButton();

        System.out.println("2. Click add hint button");
        alchemyMethods.clickAddHintButton();

        System.out.println("3. Remember current hints count");
        initialHintsCount = alchemyMethods.getCurrentHintsCount();
        System.out.println("Current hints count: " + initialHintsCount);

        System.out.println("4. Wait for 'Watch' button to appear (up to 60 seconds) and click it");
        alchemyMethods.clickWatchButton();

        System.out.println("5. Handle ads according to the specified sequence");
        alchemyMethods.handleAds();

        System.out.println("6. Check new hints count");
        finalHintsCount = alchemyMethods.getCurrentHintsCount();
        System.out.println("New hints count: " + finalHintsCount);

        System.out.println("7. Verify hints count increased");
        System.out.println("Initial count: " + initialHintsCount);
        System.out.println("Current count: " + finalHintsCount);

        if (finalHintsCount > initialHintsCount) {
            System.out.println("TEST PASSED: Hints count increased from " + initialHintsCount + " to " + finalHintsCount);
            Assert.assertTrue(finalHintsCount > initialHintsCount, "Hints count should increase. Was: "
                    + initialHintsCount + ", now: " + finalHintsCount);
        } else {
            System.out.println("TEST FAILED: Hints count did not increase");
            Assert.fail("Hints count did not increase. Was: " + initialHintsCount + ", now: " + finalHintsCount);
        }
    }
}