package pageobject;

import element.Button;
import element.Input;
import element.Wrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utility.WaitUtils;
import webDriver.WebDriverUtils;

public class HeaderForm extends BaseForm {

    private final static Wrapper headerFormWrapper = new Wrapper(By.id("nav-belt"), "Header Form Wrapper");

    private final Input headerSearchInput = new Input(By.id("twotabsearchtextbox"), "Header Search Field");
    private final Button headerSearchSubmitButton = new Button(By.id("nav-search-submit-button"), "Header Search Submit Button");
    private final Wrapper searchPopupWindow = new Wrapper(By.xpath("//*[@class='autocomplete-results-container']"), "Search Popup Window");

    public HeaderForm() {
        super(headerFormWrapper);
    }

    public void clickOnHeaderSearchInput() {
        new Actions(WebDriverUtils.getDriver())
                .moveToElement(headerSearchInput.getElement())
                .click()
                .perform();
    }

    public boolean isSearchPopupWindowOpened() {
        WaitUtils.waitForElementClickable(searchPopupWindow.getElementLocator());
        return searchPopupWindow.getElement().isDisplayed();
    }

    public void sendKeysToHeaderSearchInput(String query) {
        headerSearchInput.sendKeysToInput(query);
    }

    public void clickHeaderSearchSubmitButton() {
        headerSearchSubmitButton.clickButton();
    }
}