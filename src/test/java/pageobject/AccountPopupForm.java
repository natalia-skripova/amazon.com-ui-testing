package pageobject;

import element.Button;
import element.Wrapper;
import org.openqa.selenium.By;
import utility.LogUtils;

public class AccountPopupForm extends BaseForm {

    private static final Wrapper accountPopupWrapper = new Wrapper(By.id("nav-flyout-accountList"), "Account Popup Wrapper");

    private final Button signUpButton = new Button(By.className("nav-a"), "SignUp Button");

    public AccountPopupForm() {
        super(accountPopupWrapper);
    }

    @Override
    public boolean isPageOpened() {
        LogUtils.getLogger().debug("Opening " + accountPopupWrapper.getElementName());
        return accountPopupWrapper.getElement().getAttribute("style").contains("block");
    }

    public void clickOnSignUpButton() {
        signUpButton.clickButton();
    }
}
