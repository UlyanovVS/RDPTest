package locators;

public class VKVideoLocators {
    // ID
    public static final String CLOSE_AD = "com.vk.vkvideo:id/close_btn_left";
    public static final String SKIP_LOGIN = "com.vk.vkvideo:id/fast_login_tertiary_btn";
    public static final String SEARCH_BUTTON = "com.vk.vkvideo:id/search_button";
    public static final String SEARCH_INPUT = "com.vk.vkvideo:id/query";
    public static final String VIDEO_SUBTITLES = "com.vk.vkvideo:id/video_subtitles";

    // XPath
    public static final String SEARCH_RESULTS = "//android.widget.FrameLayout[@resource-id='com.vk.vkvideo:id/content']";
    public static final String FIRST_SEARCH_VIDEO = "(//android.widget.FrameLayout[@resource-id='com.vk.vkvideo:id/content'])[1]";
    public static final String SKIP_AD = "//*[contains(@text, 'Пропустить') or contains(@text, 'Skip')]";

    // Content-desc
    public static final String PLAY_BUTTON = "//android.widget.ImageView[@content-desc='Воспроизведение']";
    public static final String PAUSE_BUTTON = "//android.widget.ImageView[@content-desc='Пауза']";
}