package element;

import org.openqa.selenium.By;

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

}
