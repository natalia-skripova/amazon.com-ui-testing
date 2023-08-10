package webDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import model.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utility.ParseUtils;

import java.util.List;

import static constant.JsonPropertiesConstants.BROWSER_NAME;
import static constant.JsonPropertiesConstants.BROWSER_OPTIONS;
import static constant.FilePathConstants.PROPERTIES;

public class BrowserFactory {

    public static WebDriver getDriverFromFactory() {
        String browserName = ParseUtils.getValueFromJson(BROWSER_NAME, PROPERTIES);
        Browser browser = Browser.valueOf(browserName.toUpperCase());

        switch (browser) {
            case CHROME: {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                getOptions().forEach(options::addArguments);
                return new ChromeDriver(options);
            }
            case FIREFOX: {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions();
                getOptions().forEach(options::addArguments);
                return new FirefoxDriver();
            }
            default:
                throw new RuntimeException("Browser name is wrong - " + browserName);
        }
    }

    private static List<String> getOptions() {
        return ParseUtils.getConfigDataFromJson(BROWSER_OPTIONS, PROPERTIES);
    }
}