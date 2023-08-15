package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.AccountPopupForm;
import pageobject.HeaderForm;
import pageobject.MainPage;
import pageobject.RegistrationPage;
import utility.LogUtils;

public class RegistrationPageTest extends BaseTest {

    @Test
    public void registrationPageTest() {
        LogUtils.getLogger().info("--Go to the Main page.--");
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpened(), "Main Page didn't open");


        LogUtils.getLogger().info("--Hover over Account Popup Menu Button.--");
        HeaderForm headerForm = new HeaderForm();
        headerForm.hoverOverAccountPopupMenuButton();
        AccountPopupForm accountPopupForm = new AccountPopupForm();
        Assert.assertTrue(accountPopupForm.isPageOpened(), "Account Popup Form didn't show");

        LogUtils.getLogger().info("--Click on the Start Here Button.--");
        accountPopupForm.clickOnSignUpButton();
        RegistrationPage registrationPage = new RegistrationPage();
        Assert.assertTrue(registrationPage.isPageOpened(), "Registration Page didn't open");

        String mobileNumber = "156132126";
        registrationPage.sendKeysToEmailOrMobileNumberInput(mobileNumber);
        registrationPage.clickOnChangeMobilePhoneCountryButton();
        Assert.assertTrue(registrationPage.isChangeMobilePhoneCountryPopoverFormOpened());
        Assert.assertTrue(registrationPage.isAuthContinueButtonNameChangedToVerifyMobileNumber());

        String email = "hjbvhj@google.com";
        registrationPage.sendKeysToEmailOrMobileNumberInput(email);
        String name = "bhjbjh";
        registrationPage.sendKeysToNameInput(name);
        Assert.assertTrue(registrationPage.isAuthContinueButtonNameChangedToVerifyEmail());

        String password = "nbjibjihk";
        registrationPage.sendKeysToPasswordInput(password);
        registrationPage.sendKeysToCheckPasswordInput(password);
        registrationPage.clickOnAuthContinueButton();

    }
}
