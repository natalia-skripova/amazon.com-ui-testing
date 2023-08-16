package webdriver;

import org.openqa.selenium.WebDriver;
import utility.LogUtils;

public class WebDriverUtils {

    private static WebDriver driver;

    private WebDriverUtils() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = BrowserFactory.getDriverFromFactory();
            LogUtils.getLogger().info("WebDriver has been obtained");
        }
        return driver;
    }

    public static void quitDriver() {
        getDriver().quit();
        if (driver != null) {
            getDriver().quit();
            driver = null;
            LogUtils.getLogger().info("WebDriver has been quit");
        }
    }
}
