
package com.ecommerce.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.ecommerce.config.ConfigLoader;

public class DriverFactory {

    // Create browser instance
    public static WebDriver createDriver() {

        String browser = ConfigLoader.getBrowser();

        WebDriver driver;

        switch (browser.toLowerCase()) {

            case "chrome":
                driver = new ChromeDriver();
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;

            case "edge":
                driver = new EdgeDriver();
                break;

            default:
                throw new IllegalArgumentException(
                        "Invalid browser name: " + browser);
        }

        return driver;
    }
}
