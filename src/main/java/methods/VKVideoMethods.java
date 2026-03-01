package methods;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static locators.VKVideoLocators.*;

public class VKVideoMethods {

    private AndroidDriver driver;

    public VKVideoMethods(AndroidDriver driver) {
        this.driver = driver;
    }

    public void closeAdIfExists(WebDriverWait shortWait) {
        try {
            shortWait.until(ExpectedConditions.elementToBeClickable(By.id(CLOSE_AD))).click();
            System.out.println("Ad closed");
        } catch (Exception ignored) {
            System.out.println("No ad found");
        }
    }

    public void skipLoginIfExists(WebDriverWait shortWait) {
        try {
            shortWait.until(ExpectedConditions.elementToBeClickable(By.id(SKIP_LOGIN))).click();
            System.out.println("Login skipped");
        } catch (Exception ignored) {
            System.out.println("No login screen");
        }
    }

    public void clickSearchButton(WebDriverWait wait) {
        wait.until(ExpectedConditions.elementToBeClickable(By.id(SEARCH_BUTTON))).click();
        System.out.println("Search button clicked");
    }

    public void enterSearchText(WebDriverWait wait, String searchText) {
        wait.until(ExpectedConditions.elementToBeClickable(By.id(SEARCH_INPUT)))
                .sendKeys(searchText);

        driver.executeScript("mobile: performEditorAction",
                java.util.Map.of("action", "search"));
        System.out.println("Search performed");
    }

    public void selectFirstVideo(WebDriverWait wait) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SEARCH_RESULTS)));
        System.out.println("Search results loaded");

        driver.findElement(By.xpath(FIRST_SEARCH_VIDEO)).click();
        System.out.println("First video clicked");
    }

    public void ensureVideoIsPlaying(WebDriverWait wait) {
        System.out.println("Checking if video started playing automatically");

        try {
            By pauseButton = AppiumBy.xpath(PAUSE_BUTTON);
            if (wait.until(ExpectedConditions.presenceOfElementLocated(pauseButton)).isDisplayed()) {
                System.out.println("Video started playing automatically");
            }
        } catch (Exception e) {
            try {
                By playButton = AppiumBy.xpath(PLAY_BUTTON);
                if (driver.findElement(playButton).isDisplayed()) {
                    System.out.println("Video did not start automatically - clicking Play button");
                    driver.findElement(playButton).click();
                    System.out.println("Play button clicked");
                }
            } catch (Exception ex) {
                System.out.println("Could not find Play or Pause button");
            }
        }
    }

    public void skipPreRollAdIfExists() {
        try {
            WebDriverWait adWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            By skipButton = By.xpath(SKIP_AD);

            if (adWait.until(ExpectedConditions.elementToBeClickable(skipButton)).isDisplayed()) {
                driver.findElement(skipButton).click();
                System.out.println("Ad skipped");
            }
        } catch (Exception e) {
            System.out.println("No pre-roll ad");
        }
    }

    public void waitForVideoPlayer(WebDriverWait wait) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(VIDEO_SUBTITLES)));
        System.out.println("Video player loaded (video_subtitles found)");
    }

    public void clickVideoToShowControls() {
        try {
            driver.findElement(By.id(VIDEO_SUBTITLES)).click();
            System.out.println("Clicked on video to show controls");
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Failed to click on video: " + e.getMessage());
        }
    }

    public boolean checkVideoPlaybackStatus() {
        System.out.println("Checking video playback status...");

        try {
            By pauseButton = AppiumBy.xpath(PAUSE_BUTTON);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

            if (wait.until(ExpectedConditions.presenceOfElementLocated(pauseButton)).isDisplayed()) {
                System.out.println("Found Pause button - video IS PLAYING");
                return true;
            }
        } catch (Exception e) {
            System.out.println("Pause button NOT found");
        }

        try {
            By playButton = AppiumBy.xpath(PLAY_BUTTON);

            if (driver.findElement(playButton).isDisplayed()) {
                System.out.println("Found Play button - video IS PAUSED");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Play button NOT found either");
        }

        System.out.println("Could not determine playback status - neither button found");
        return false;
    }
}