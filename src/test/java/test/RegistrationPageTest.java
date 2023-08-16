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
        LogUtils.getLogger().info("--Registration Page Test. STEP 1. Go to the Main page.--");
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpened(), "Main Page didn't open");

        LogUtils.getLogger().info("--Registration Page Test. STEP 2. Hover over Account Popup Menu Button.--");
        HeaderForm headerForm = new HeaderForm();
        headerForm.hoverOverAccountPopupMenuButton();
        AccountPopupForm accountPopupForm = new AccountPopupForm();
        Assert.assertTrue(accountPopupForm.isPageOpened(), "Account Popup Form didn't show");

        LogUtils.getLogger().info("--Registration Page Test. STEP 3. Click on the Start Here Button.--");
        accountPopupForm.clickOnSignUpButton();
        RegistrationPage registrationPage = new RegistrationPage();
        Assert.assertTrue(registrationPage.isPageOpened(), "Registration Page didn't open");

        LogUtils.getLogger().info("--Registration Page Test. STEP 4. Fill in the Mobile Number Input and change the country code.--");
        String mobileNumber = RandomUtils.generateRandomMobileNumber();
        registrationPage.sendKeysToEmailOrMobileNumberInput(mobileNumber);
        registrationPage.clickOnChangeMobilePhoneCountryButton();
        //Поменять код страны на другой и проверить замену
        Assert.assertTrue(registrationPage.isChangeMobilePhoneCountryPopoverFormOpened(), "The Change mobile phone country form didn't open");
        Assert.assertTrue(registrationPage.isAuthContinueButtonNameChangedToVerifyMobileNumber(), "The name of the Continue Button didn't change");

        LogUtils.getLogger().info("--Registration Page Test. STEP 5. Fill in the Email input.--");
        String email = RandomUtils.generateRandomEmail();
        registrationPage.sendKeysToEmailOrMobileNumberInput(email);
        String name = RandomUtils.generateRandomName();
        registrationPage.sendKeysToNameInput(name);
        Assert.assertTrue(registrationPage.isAuthContinueButtonNameChangedToVerifyEmail(), "The name of the Continue Button didn't change");

        LogUtils.getLogger().info("--Registration Page Test. STEP 6. Fill in the Password and CheckPassword Inputs and click on the Continue button.--");
        String password = RandomUtils.generateRandomPassword();
        registrationPage.sendKeysToPasswordInput(password);
        registrationPage.sendKeysToCheckPasswordInput(password);
        registrationPage.clickOnAuthContinueButton();
        AntiRobotCheckForm antiRobotCheckForm = new AntiRobotCheckForm();
        Assert.assertTrue(antiRobotCheckForm.isPageOpened(), "AntiRobot Check Form didn't open");

        LogUtils.getLogger().info("--Registration Page Test. STEP 7. Click on Privacy notice button.--");
        String registrationPageTab = WebDriverUtils.getDriver().getWindowHandle();
        int openTabsAmountBeforeClicking = BrowserUtils.getOpenTabsAmount();
        FooterForm footerForm = new FooterForm();
        footerForm.clickOnConditionsOfUseButton();
        int openTabsAmountAfterClicking = BrowserUtils.getOpenTabsAmount();
        Assert.assertEquals(openTabsAmountAfterClicking, openTabsAmountBeforeClicking + 1, "New page didn't open in new tab");
        BrowserUtils.switchWindowHandle(registrationPageTab);
        ConditionsOfUsePage conditionsOfUsePage = new ConditionsOfUsePage();
        Assert.assertTrue(conditionsOfUsePage.isPageOpened(), "Conditions of Use Page didn't open");
    }
}
