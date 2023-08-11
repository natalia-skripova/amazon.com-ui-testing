package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utility.BrowserUtils;
import utility.ParseUtils;
import webDriver.WebDriverUtils;

import static constant.FilePathConstants.PROPERTIES;
import static constant.JsonPropertiesConstants.MAIN_PAGE_URL;

abstract public class BaseTest {

    @BeforeClass
    public void setup() {
        BrowserUtils.goToWebPage(ParseUtils.getValueFromJson(MAIN_PAGE_URL, PROPERTIES));
    }

    @AfterClass
    public void tearDown() {
        WebDriverUtils.quitDriver();
    }
}
