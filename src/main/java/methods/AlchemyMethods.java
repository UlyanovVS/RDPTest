package methods;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static locators.AlchemyLocators.*;

public class AlchemyMethods {

    private AndroidDriver driver;
    private WebDriverWait wait;
    private WebDriverWait shortWait;
    private WebDriverWait watchButtonWait;

    public AlchemyMethods(AndroidDriver driver, WebDriverWait wait, WebDriverWait shortWait, WebDriverWait watchButtonWait) {
        this.driver = driver;
        this.wait = wait;
        this.shortWait = shortWait;
        this.watchButtonWait = watchButtonWait;
    }

    public void clickPlayButton() {
        By playButton = By.xpath(PLAY_BUTTON);
        wait.until(ExpectedConditions.elementToBeClickable(playButton)).click();
        System.out.println("'Play' button clicked");
    }

    public void clickAddHintButton() {
        By addHintButton = By.xpath(ADD_HINT_BUTTON);
        wait.until(ExpectedConditions.elementToBeClickable(addHintButton)).click();
        System.out.println("Add hint button clicked");
    }

    public int getCurrentHintsCount() {
        By hintsLocator = By.xpath(HINTS_COUNT);
        String hintsText = wait.until(ExpectedConditions.presenceOfElementLocated(hintsLocator)).getText();
        return extractNumber(hintsText);
    }

    public void clickWatchButton() {
        By watchButton = By.xpath(WATCH_AD_BUTTON);
        watchButtonWait.until(ExpectedConditions.elementToBeClickable(watchButton)).click();
        System.out.println("'Watch' button clicked");
    }

    //В этом месте пытался победить множество форматов рекламы
    public void handleAds() {
        System.out.println("Handling ads");

        if (handleCase1()) return;
        if (handleCase2()) return;
        if (handleCase3()) return;
        if (handleCase4()) return;
        if (handleCase5()) return;
        if (handleCase6()) return;

        System.out.println("No known ad pattern detected");
    }

    private boolean handleCase1() {
        try {
            By timerText = By.xpath(REWARD_TIMER);
            if (driver.findElements(timerText).size() > 0) {
                System.out.println("Case 1 detected: Timer with 'left to be rewarded'");

                Thread.sleep(20000);

                By skipButton = By.xpath(M_PLAYABLE_SKIP);
                WebDriverWait skipWait = new WebDriverWait(driver, Duration.ofSeconds(10));
                if (skipWait.until(ExpectedConditions.elementToBeClickable(skipButton)).isDisplayed()) {
                    driver.findElement(skipButton).click();
                    System.out.println("'>' button clicked");

                    Thread.sleep(5000);

                    By closeButton = By.xpath(M_PLAYABLE_CLOSE);
                    WebDriverWait closeWait = new WebDriverWait(driver, Duration.ofSeconds(10));
                    if (closeWait.until(ExpectedConditions.elementToBeClickable(closeButton)).isDisplayed()) {
                        driver.findElement(closeButton).click();
                        System.out.println("Close button clicked");
                        return true;
                    }
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    private boolean handleCase2() {
        try {
            By countdownTimer = By.id(COUNTDOWN);
            if (driver.findElements(countdownTimer).size() > 0) {
                System.out.println("Case 2 detected: countdown timer");

                Thread.sleep(60000);

                By closeButton = By.id(MBRIDGE_CLOSE);
                WebDriverWait closeWait = new WebDriverWait(driver, Duration.ofSeconds(10));
                if (closeWait.until(ExpectedConditions.elementToBeClickable(closeButton)).isDisplayed()) {
                    driver.findElement(closeButton).click();
                    System.out.println("Close button clicked");
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    private boolean handleCase3() {
        try {
            By googlePlayText = By.xpath(GOOGLE_PLAY_TEXT);
            By ageRestrictionText = By.xpath(AGE_RESTRICTION_TEXT);
            By remainingText = By.xpath(REMAINING_TEXT);

            if (driver.findElements(googlePlayText).size() > 0 ||
                    driver.findElements(ageRestrictionText).size() > 0 ||
                    driver.findElements(remainingText).size() > 0) {

                System.out.println("Case 3 detected: Double ad with Google Play/16+");

                Thread.sleep(10000);

                By firstSkipButton = By.xpath(PAGE_INDEX_2_SKIP);
                WebDriverWait firstSkipWait = new WebDriverWait(driver, Duration.ofSeconds(10));
                if (firstSkipWait.until(ExpectedConditions.elementToBeClickable(firstSkipButton)).isDisplayed()) {
                    driver.findElement(firstSkipButton).click();
                    System.out.println("First '>|' button clicked");

                    Thread.sleep(10000);

                    if (firstSkipWait.until(ExpectedConditions.elementToBeClickable(firstSkipButton)).isDisplayed()) {
                        driver.findElement(firstSkipButton).click();
                        System.out.println("Second '>|' button clicked");

                        Thread.sleep(2000);

                        By closeButton = By.xpath(PAGE_INDEX_3_CLOSE);
                        WebDriverWait closeWait = new WebDriverWait(driver, Duration.ofSeconds(10));
                        if (closeWait.until(ExpectedConditions.elementToBeClickable(closeButton)).isDisplayed()) {
                            driver.findElement(closeButton).click();
                            System.out.println("Close button clicked after reward");
                            return true;
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    private boolean handleCase4() {
        try {
            By videoProgress = By.id(VIDEO_PROGRESS);
            By bideaseText = By.xpath(BIDEASE_TEXT);

            if (driver.findElements(videoProgress).size() > 0 || driver.findElements(bideaseText).size() > 0) {
                System.out.println("Case 4 detected: Bidease ad");

                By skipButton = By.xpath(PAGE_INDEX_1_SKIP);
                WebDriverWait skipWait = new WebDriverWait(driver, Duration.ofSeconds(40));
                if (skipWait.until(ExpectedConditions.elementToBeClickable(skipButton)).isDisplayed()) {
                    driver.findElement(skipButton).click();
                    System.out.println("'>|' button clicked");

                    Thread.sleep(5000);

                    By closeButton = By.xpath(PAGE_INDEX_2_CLOSE);
                    WebDriverWait closeWait = new WebDriverWait(driver, Duration.ofSeconds(10));
                    if (closeWait.until(ExpectedConditions.elementToBeClickable(closeButton)).isDisplayed()) {
                        driver.findElement(closeButton).click();
                        System.out.println("Close button clicked");
                        return true;
                    }
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    private boolean handleCase5() {
        try {
            By bigoCloseButton = By.id(BIGO_CLOSE_BUTTON);

            if (driver.findElements(bigoCloseButton).size() > 0) {
                System.out.println("Case 5 detected: Bigo ad");

                Thread.sleep(15000);

                WebDriverWait closeWait = new WebDriverWait(driver, Duration.ofSeconds(10));
                if (closeWait.until(ExpectedConditions.elementToBeClickable(bigoCloseButton)).isDisplayed()) {
                    driver.findElement(bigoCloseButton).click();
                    System.out.println("First close button clicked");

                    Thread.sleep(5000);

                    if (closeWait.until(ExpectedConditions.elementToBeClickable(bigoCloseButton)).isDisplayed()) {
                        driver.findElement(bigoCloseButton).click();
                        System.out.println("Second close button clicked");
                        return true;
                    }
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    private boolean handleCase6() {
        try {
            By countdownText = By.id(INTER_TEXT_COUNTDOWN);
            By bigoCloseButton = By.id(BIGO_CLOSE_BUTTON);

            if (driver.findElements(countdownText).size() > 0) {
                System.out.println("Case 6 detected: inter_text_countdown timer");

                Thread.sleep(60000);

                WebDriverWait closeWait = new WebDriverWait(driver, Duration.ofSeconds(10));
                if (closeWait.until(ExpectedConditions.elementToBeClickable(bigoCloseButton)).isDisplayed()) {
                    driver.findElement(bigoCloseButton).click();
                    System.out.println("First close button clicked");

                    Thread.sleep(5000);

                    if (closeWait.until(ExpectedConditions.elementToBeClickable(bigoCloseButton)).isDisplayed()) {
                        driver.findElement(bigoCloseButton).click();
                        System.out.println("Second close button clicked");
                        return true;
                    }
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    private int extractNumber(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        String numberStr = text.replaceAll("[^0-9]", "");
        if (numberStr.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(numberStr);
    }
}