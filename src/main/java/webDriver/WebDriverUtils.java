package webDriver;

import org.openqa.selenium.WebDriver;

public class WebDriverUtils {
    private static WebDriverUtils instance = null;

    private static WebDriver driver;

    private WebDriverUtils() {
        driver = BrowserFactory.getDriverFromFactory();
    }

    public static WebDriverUtils getInstance() {
        if (instance == null) {
            instance = new WebDriverUtils();
        }
        return instance;
    }

    public static WebDriver getDriver() {
        getInstance();
        if (driver == null) {
            driver = BrowserFactory.getDriverFromFactory();
        }
        return driver;
    }

    public static void quitDriver() {
        getInstance();
        getDriver().quit();
        instance = null;
        if (driver != null) {
            getDriver().quit();
            driver = null;
        }
    }

}
