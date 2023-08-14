package element;

import org.openqa.selenium.By;
import utility.LogUtils;
import utility.WaitUtils;

public class Button extends BaseElement {

    public Button(By locator, String name) {
        super(locator, name);
    }

    public void clickButton() {
        LogUtils.getLogger().debug("Click on button: " + getElementName());
        WaitUtils.waitForElementClickable(getElementLocator());
        getElement().click();
    }
}
