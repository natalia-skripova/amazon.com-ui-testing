package pageobject;

import element.BaseElement;
import utility.LogUtils;
import webDriver.WebDriverUtils;

public class BaseForm {

    private final BaseElement uniqueFormElement;

    public BaseForm(BaseElement formElement) {
        uniqueFormElement = formElement;
    }

    public boolean isPageOpened() {
        LogUtils.getLogger().debug("Opening " + uniqueFormElement.getElementName());
        return WebDriverUtils.getDriver().findElement(uniqueFormElement.getElementLocator()).isDisplayed();
    }
}
