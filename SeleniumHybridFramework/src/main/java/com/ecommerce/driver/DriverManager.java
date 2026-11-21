package com.ecommerce.driver;



import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Store the WebDriver instance
    public static void setDriver(WebDriver driverInstance) {
        driver.set(driverInstance);
    }

    // Get the WebDriver instance
    public static WebDriver getDriver() {
        return driver.get();
    }

    // Close and remove the WebDriver instance
    public static void unload() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
