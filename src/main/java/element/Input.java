package element;

import org.openqa.selenium.By;
import utility.LogUtils;

public class Input extends BaseElement {

    public Input(By locator, String name) {
        super(locator, name);
    }

    public void sendKeysToInput(String data) {
        LogUtils.getLogger().debug(String.format("Send keys '%s' to: '%s'", data, getElementName()));
        getElement().clear();
        getElement().sendKeys(data);
    }
}
