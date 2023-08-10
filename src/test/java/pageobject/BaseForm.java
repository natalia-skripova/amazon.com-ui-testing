package pageobject;

import element.BaseElement;
import webDriver.WebDriverUtils;

public class BaseForm {

    private final BaseElement uniqueFormElement;

    public BaseForm(BaseElement formElement) {
        uniqueFormElement = formElement;
    }

    public boolean isPageOpened() {
        return WebDriverUtils.getDriver().findElement(uniqueFormElement.getElementLocator()).isDisplayed();
    }
}
