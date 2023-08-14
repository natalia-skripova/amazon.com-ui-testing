package pageobject;

import element.BaseElement;
import utility.LogUtils;

public class BaseForm {

    private final BaseElement uniqueFormElement;

    public BaseForm(BaseElement formElement) {
        uniqueFormElement = formElement;
    }

    public boolean isPageOpened() {
        LogUtils.getLogger().debug("Opening " + uniqueFormElement.getElementName());
        return uniqueFormElement.getElement().isDisplayed();
    }
}
