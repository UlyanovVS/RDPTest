package tests;

import core.BaseTest;
import methods.VKVideoMethods;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static constants.VKVideoConstants.*;

public class VKVideoTest extends BaseTest {

    private WebDriverWait wait;
    private WebDriverWait shortWait;
    private VKVideoMethods vkVideoMethods;

    @BeforeMethod
    public void setUp() {
        appPackage = APP_PACKAGE;
        appActivity = APP_ACTICITY;
        super.setUp();

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        vkVideoMethods = new VKVideoMethods(driver);
    }

    @Test(description = "Check video play")
    public void checkVideoPlay() {

        System.out.println("1. Close ad if exists");
        vkVideoMethods.closeAdIfExists(shortWait);

        System.out.println("2. Skip login if exists");
        vkVideoMethods.skipLoginIfExists(shortWait);

        System.out.println("3. Click search");
        vkVideoMethods.clickSearchButton(wait);

        System.out.println("4. Enter text and search");
        vkVideoMethods.enterSearchText(wait, TEXT_FOR_SEARCH);

        System.out.println("5. Select first video from search results");
        vkVideoMethods.selectFirstVideo(wait);

        System.out.println("6. Ensure video is playing");
        vkVideoMethods.ensureVideoIsPlaying(shortWait);

        System.out.println("7. Handle pre-roll ad if exists");
        vkVideoMethods.skipPreRollAdIfExists();

        System.out.println("8. Wait for video player to load");
        vkVideoMethods.waitForVideoPlayer(wait);

        System.out.println("9. Click on video to show playback controls");
        vkVideoMethods.clickVideoToShowControls();

        System.out.println("10. Check video playback status");
        boolean isPlaying = vkVideoMethods.checkVideoPlaybackStatus();

        System.out.println("11. Test result");
        if (isPlaying) {
            System.out.println("TEST PASSED: Video is playing");
            Assert.assertTrue(true, "Video is playing correctly");
        } else {
            System.out.println("TEST FAILED: Video is not playing (paused)");
            Assert.fail("Video is paused - found Play button instead of Pause button");
        }
    }
}