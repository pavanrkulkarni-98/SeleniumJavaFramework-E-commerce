package com.ecommerce.constants;


public class FrameworkConstants {

    // Project Configuration
    public static final String CONFIG_FILE_PATH =
            System.getProperty("user.dir") + "/src/test/resources/config.properties";

    // Browser Configuration
    public static final String BROWSER = "chrome";

    // Timeout Configuration
    public static final int EXPLICIT_WAIT = 10;
    public static final int PAGE_LOAD_TIMEOUT = 30;
    public static final int IMPLICIT_WAIT = 0;

    // Directory Paths
    public static final String SCREENSHOT_PATH =
            System.getProperty("user.dir") + "/screenshots/";

    public static final String REPORT_PATH =
            System.getProperty("user.dir") + "/reports/";

    private FrameworkConstants() {
        // Prevent object creation
    }
}

