package webdriver;

import org.openqa.selenium.WebDriver;
import utility.LogUtils;

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
            LogUtils.getLogger().info("WebDriver has been obtained");
        }
        return driver;
    }

    public static void quitDriver() {
        getDriver().quit();
        instance = null;
        if (driver != null) {
            getDriver().quit();
            driver = null;
            LogUtils.getLogger().info("WebDriver has been quit");
        }
    }

}
