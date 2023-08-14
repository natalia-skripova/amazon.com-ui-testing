package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webDriver.WebDriverUtils;
import java.time.Duration;

import static constant.FilePathConstants.PROPERTIES;
import static constant.JsonPropertiesConstants.TIMEOUT;

public class WaitUtils {

    private static final WebDriver driver = WebDriverUtils.getDriver();
    private static final int timeout = Integer.parseInt(ParseUtils.getValueFromJson(TIMEOUT, PROPERTIES));
    private static final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

    public static void waitForElementDisplayed(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static void waitForElementClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
