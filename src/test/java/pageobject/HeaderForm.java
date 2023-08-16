package pageobject;

import element.Button;
import element.Input;
import element.Wrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utility.WaitUtils;
import webdriver.WebDriverUtils;

public class HeaderForm extends BaseForm {

    private final static Wrapper headerFormWrapper = new Wrapper(By.id("nav-belt"), "Header Form Wrapper");

    private final Input headerSearchInput = new Input(By.id("twotabsearchtextbox"), "Header Search Field");
    private final Button headerSearchSubmitButton = new Button(By.id("nav-search-submit-button"), "Header Search Submit Button");
    private final Wrapper searchPopupWindow = new Wrapper(By.className("autocomplete-results-container"), "Search Popup Window");
    private final Button accountPopupMenuButton = new Button(By.id("nav-link-accountList"), "Account Popup Menu Button");

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

    public void hoverOverAccountPopupMenuButton() {
        new Actions(WebDriverUtils.getDriver())
                .moveToElement(accountPopupMenuButton.getElement())
                .perform();
    }
}