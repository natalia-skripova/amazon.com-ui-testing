package pageobject;

import element.Button;
import element.Input;
import element.Wrapper;
import org.openqa.selenium.By;

public class HeaderForm extends BaseForm {

    private final static Wrapper headerFormWrapper = new Wrapper(By.xpath("//*[@id = 'nav-belt']"),
            "Header Form Wrapper");

    private final Input headerSearchInput = new Input(By.xpath("//*[@id = 'twotabsearchtextbox']"),
            "Header Search Field");
    private final Button headerSearchSubmitButton = new Button(By.xpath("//*[@id = 'nav-search-submit-button']")
            , "Header Search Submit Button");

    public HeaderForm() {
        super(headerFormWrapper);
    }

    public void sendKeysToHeaderSearchInput(String query) {
        headerSearchInput.sendKeysToInput(query);
    }

    public void clickHeaderSearchSubmitButton() {
        headerSearchSubmitButton.clickButton();
    }
}