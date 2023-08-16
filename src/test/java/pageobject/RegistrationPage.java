package pageobject;

import element.Button;
import element.Input;
import element.Wrapper;
import org.openqa.selenium.By;
import webdriver.WebDriverUtils;

public class RegistrationPage extends BaseForm {

    private static final Wrapper RegistrationForm = new Wrapper(By.id("ap_register_form"), "Registration Form");

    private final Button changeMobilePhoneCountryButton = new Button(By.xpath("//*[@data-action = 'show-countries']"),
            "Change Mobile Phone Country Button");
    private final Button authContinueButton = new Button(By.id("auth-continue"), "Continue Registration Button");

    private final Input nameInput = new Input(By.id("ap_customer_name"), "Name Input");
    private final Input emailOrMobileNumberInput = new Input(By.id("ap_email"), "Email Input");
    private final Input passwordInput = new Input(By.id("ap_password"), "Password Input");
    private final Input checkPasswordInput = new Input(By.id("ap_password_check"), "Password Check Input");

    private final Wrapper changeMobilePhoneCountryPopoverForm = new Wrapper(By.id("a-popover-1"), "Change Mobile Phone Country Popover Form");

    private final String authContinueButtonTextBaseXpath = "//*[@id='auth-continue-announce']//*[contains(@class, '%s')]";

    public RegistrationPage() {
        super(RegistrationForm);
    }

    public void clickOnChangeMobilePhoneCountryButton() {
        changeMobilePhoneCountryButton.clickButton();
    }

    public boolean isChangeMobilePhoneCountryPopoverFormOpened() {
        return !changeMobilePhoneCountryPopoverForm.getElement().getAttribute("style").contains("none");
    }

    public void clickOnAuthContinueButton() {
        authContinueButton.clickButton();
    }

    public void sendKeysToNameInput(String name) {
        nameInput.sendKeysToInput(name);
    }
    public void sendKeysToEmailOrMobileNumberInput(String email) {
        emailOrMobileNumberInput.sendKeysToInput(email);
    }

    public void sendKeysToPasswordInput(String password) {
        passwordInput.sendKeysToInput(password);
    }

    public void sendKeysToCheckPasswordInput(String password) {
        checkPasswordInput.sendKeysToInput(password);
    }

    private boolean isAuthContinueButtonNameChanged(String query) {
        return !WebDriverUtils.getDriver().findElement(By.xpath(String.format(authContinueButtonTextBaseXpath, query)))
                .getAttribute("style")
                .contains("none");
    }

    public boolean isAuthContinueButtonNameChangedToVerifyEmail() {
        return isAuthContinueButtonNameChanged("email");
    }

    public boolean isAuthContinueButtonNameChangedToVerifyMobileNumber() {
        return isAuthContinueButtonNameChanged("phone");
    }
}
