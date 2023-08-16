package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.*;
import utility.BrowserUtils;
import utility.LogUtils;
import utility.RandomUtils;
import webDriver.WebDriverUtils;

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

        String mobileNumber = RandomUtils.generateRandomMobileNumber();
        registrationPage.sendKeysToEmailOrMobileNumberInput(mobileNumber);
        registrationPage.clickOnChangeMobilePhoneCountryButton();
        //Поменять код страны на другой и проверить замену
        Assert.assertTrue(registrationPage.isChangeMobilePhoneCountryPopoverFormOpened());
        Assert.assertTrue(registrationPage.isAuthContinueButtonNameChangedToVerifyMobileNumber());

        String email = RandomUtils.generateRandomEmail();
        registrationPage.sendKeysToEmailOrMobileNumberInput(email);
        String name = RandomUtils.generateRandomName();
        registrationPage.sendKeysToNameInput(name);
        Assert.assertTrue(registrationPage.isAuthContinueButtonNameChangedToVerifyEmail());

        String password = RandomUtils.generateRandomPassword();
        registrationPage.sendKeysToPasswordInput(password);
        registrationPage.sendKeysToCheckPasswordInput(password);
        registrationPage.clickOnAuthContinueButton();
        AntiRobotCheckForm antiRobotCheckForm = new AntiRobotCheckForm();
        Assert.assertTrue(antiRobotCheckForm.isPageOpened());

        String registrationPageTab = WebDriverUtils.getDriver().getWindowHandle();
        int openTabsAmountBeforeClicking = BrowserUtils.getOpenTabsAmount();
        FooterForm footerForm = new FooterForm();
        footerForm.clickOnConditionsOfUseButton();
        int openTabsAmountAfterClicking = BrowserUtils.getOpenTabsAmount();
        Assert.assertEquals(openTabsAmountAfterClicking, openTabsAmountBeforeClicking + 1, "New page didn't open in new tab");
        BrowserUtils.switchWindowHandle(registrationPageTab);
        ConditionsOfUsePage conditionsOfUsePage = new ConditionsOfUsePage();
        Assert.assertTrue(conditionsOfUsePage.isPageOpened());
    }
}
