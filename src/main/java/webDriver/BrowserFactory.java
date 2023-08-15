package webDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import model.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.util.List;
import utility.LogUtils;
import utility.ParseUtils;

import static constant.JsonPropertiesConstants.BROWSER_NAME;
import static constant.JsonPropertiesConstants.BROWSER_OPTIONS;
import static constant.FilePathConstants.PROPERTIES;

public class BrowserFactory {

    public static WebDriver getDriverFromFactory() {
        String browserName = ParseUtils.getValueFromJson(BROWSER_NAME, PROPERTIES);
        Browser browser = Browser.valueOf(browserName.toUpperCase());

        switch (browser) {
            case CHROME: {
                WebDriverManager.chromedriver().browserVersion("115.0.5790.171").setup();
                ChromeOptions options = new ChromeOptions();
                getOptions().forEach(options::addArguments);
                LogUtils.getLogger().info("Browser Chrome was chosen");
                return new ChromeDriver(options);
            }
            case FIREFOX: {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions();
                getOptions().forEach(options::addArguments);
                LogUtils.getLogger().info("Browser Firefox was chosen");
                return new FirefoxDriver(options);
            }
            default:
                LogUtils.getLogger().debug("Browser name is wrong - " + browserName);
                throw new RuntimeException("Browser name is wrong - " + browserName);
        }
    }

    private static List<String> getOptions() {
        return ParseUtils.getConfigDataFromJson(BROWSER_OPTIONS, PROPERTIES);
    }
}