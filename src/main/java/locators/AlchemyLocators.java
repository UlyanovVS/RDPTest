package locators;

public class AlchemyLocators {
    // XPath
    public static final String PLAY_BUTTON = "//android.widget.TextView[@text='Играть']";
    public static final String ADD_HINT_BUTTON = "//x2.f1/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View[2]";
    public static final String HINTS_COUNT = "//android.widget.TextView[@text='Ваши подсказки']/following-sibling::android.view.View//android.widget.TextView";
    public static final String WATCH_AD_BUTTON = "//android.widget.TextView[@text='Смотреть']";

    // Handle сase 1
    public static final String REWARD_TIMER = "//android.widget.TextView[ends-with(@text, 'left to be rewarded')]";
    public static final String M_PLAYABLE_SKIP = "//android.view.View[@resource-id='m-playable-skip']";
    public static final String M_PLAYABLE_CLOSE = "//android.view.View[@resource-id='m-playable-close']";

    // Handle сase 2
    public static final String COUNTDOWN = "countdown";
    public static final String MBRIDGE_CLOSE = "com.ilyin.alchemy:id/mbridge_windwv_close";

    // Handle сase 3
    public static final String GOOGLE_PLAY_TEXT = "//android.widget.TextView[@text='Google Play']";
    public static final String AGE_RESTRICTION_TEXT = "//android.widget.TextView[@text='РЕКЛАМА · 16+']";
    public static final String REMAINING_TEXT = "//android.widget.TextView[@text='Осталось']";
    public static final String PAGE_INDEX_2_SKIP = "//android.widget.RelativeLayout[@content-desc='pageIndex: 2']/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.ImageView";
    public static final String PAGE_INDEX_3_CLOSE = "//android.widget.RelativeLayout[@content-desc='pageIndex: 3']/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView";

    // Handle сase 4
    public static final String VIDEO_PROGRESS = "com.ilyin.alchemy:id/video_progress_control";
    public static final String BIDEASE_TEXT = "//android.widget.TextView[@text='РЕКЛАМА · Bidease']";
    public static final String PAGE_INDEX_1_SKIP = "//android.widget.RelativeLayout[@content-desc='pageIndex: 1']/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.ImageView";
    public static final String PAGE_INDEX_2_CLOSE = "//android.widget.RelativeLayout[@content-desc='pageIndex: 2']/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.ImageView";

    // Handle сase 5 and 6
    public static final String BIGO_CLOSE_BUTTON = "com.ilyin.alchemy:id/bigo_ad_btn_close";
    public static final String INTER_TEXT_COUNTDOWN = "com.ilyin.alchemy:id/inter_text_countdown";
}