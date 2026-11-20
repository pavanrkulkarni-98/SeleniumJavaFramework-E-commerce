
package com.ecommerce.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.ecommerce.constants.FrameworkConstants;

public class ConfigLoader {

    private static Properties properties;

    // Static block to load configuration file
    static {
        properties = new Properties();

        try (FileInputStream fis =
                new FileInputStream(FrameworkConstant.CONFIG_FILE_PATH)) {

            properties.load(fis);

        } catch (IOException e) {
            throw new RuntimeException(
                    "Failed to load config.properties file", e);
        }
    }

    // Generic method to read property values
    public static String getProperty(String key) {

        String value = properties.getProperty(key);

        if (value == null || value.trim().isEmpty()) {
            throw new RuntimeException(
                    "Property '" + key + "' not found in config.properties");
        }

        return value.trim();
    }

    // Get browser name
    public static String getBrowser() {
        return getProperty("browser");
    }

    // Get application URL
    public static String getApplicationUrl() {
        return getProperty("url");
    }

    // Get explicit wait
    public static int getExplicitWait() {
        return Integer.parseInt(getProperty("explicitWait"));
    }

    // Get page load timeout
    public static int getPageLoadTimeout() {
        return Integer.parseInt(getProperty("pageLoadTimeout"));
    }

    // Get implicit wait
    public static int getImplicitWait() {
        return Integer.parseInt(getProperty("implicitWait"));
    }
}
