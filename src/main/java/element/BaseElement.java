package element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.LogUtils;
import utility.WaitUtils;
import webdriver.WebDriverUtils;

import java.util.List;

public class BaseElement {

    private final By uniqueLocator;
    private final String elementName;

    public BaseElement(By locator, String name) {
        uniqueLocator = locator;
        elementName = name;
    }

    public String getElementName() {
        return elementName;
    }

    public By getElementLocator() {
        return uniqueLocator;
    }

    public WebElement getElement() {
        LogUtils.getLogger().debug("Getting " + elementName + " element");
        WaitUtils.waitForElementDisplayed(uniqueLocator);
        return WebDriverUtils.getDriver().findElement(uniqueLocator);
    }

    public List<WebElement> getElements() {
        LogUtils.getLogger().debug("Getting " + elementName + " elements");
        WaitUtils.waitForElementDisplayed(uniqueLocator);
        return WebDriverUtils.getDriver().findElements(uniqueLocator);
    }
}
