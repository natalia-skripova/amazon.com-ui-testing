package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.MainPage;
import utility.LogUtils;
import utility.ParseUtils;

import java.util.List;
import java.util.stream.Collectors;

import static constant.TestDataConstants.GOOD_DEAL_CURRENCY;
import static constant.TestDataConstants.GOOD_DEAL_PRICE;
import static constant.TestDataPathConstants.MAIN_PAGE_TEST_DATA;

public class MainPageTest extends BaseTest {

    @Test
    public void goodDealBlockPricesTest() {
        LogUtils.getLogger().info("Checking that prices from Good Deal Block are correct");
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpened(), "Main Page didn't open");

        List<String> googDealPricesList = mainPage.getGoodDealBlockPriceText();
        Assert.assertFalse(googDealPricesList.isEmpty(), "Good Deal Block is not showed or getting prices from it failed");

        float setMaxGoodDealPrice = Float.parseFloat(ParseUtils.getValueFromJson(GOOD_DEAL_PRICE, MAIN_PAGE_TEST_DATA));
        String setCurrency = ParseUtils.getValueFromJson(GOOD_DEAL_CURRENCY, MAIN_PAGE_TEST_DATA);
        Assert.assertTrue(googDealPricesList.stream().allMatch(price -> price.startsWith(setCurrency)), "Prices are not in set currency");
        googDealPricesList = googDealPricesList.stream().map(price -> price.substring(1)).collect(Collectors.toList());
        Assert.assertTrue(googDealPricesList.stream().allMatch(num -> Float.parseFloat(num) < setMaxGoodDealPrice), "Prices are over set value");
    }

    @Test
    public void excitingDealsScrollbarTest() {
        LogUtils.getLogger().info("Checking that ScrollBar from Exiting Deals is working correctly");
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpened(), "Main Page didn't open");

        Assert.assertTrue(mainPage.isExcitingDealsPreviousSlideArrowDisabled(), "The Scroll Bar is not in the Left position");
        mainPage.moveExcitingDealScrollBarToTheRight();
        Assert.assertTrue(mainPage.isExcitingDealsNextSlideArrowDisabled(), "The Scroll Bar is not in the Right position");
    }
}
