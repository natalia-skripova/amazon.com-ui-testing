package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.HeaderForm;
import pageobject.MainPage;
import pageobject.SearchPage;
import utility.LogUtils;
import utility.ParseUtils;

import java.util.List;
import java.util.stream.Collectors;

import static constant.SearchPageDataConstants.BRAND;
import static constant.SearchPageDataConstants.SEARCH_WORD;
import static constant.TestDataPathConstants.SEARCH_PAGE_TEST_DATA;

public class SearchPageTest extends BaseTest {

    @Test
    public void searchPageTest() {
        LogUtils.getLogger().info("Checking that Brand filter works correctly");
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpened(), "Main Page didn't open");

        HeaderForm headerForm = new HeaderForm();
        String queryText = ParseUtils.getValueFromJson(SEARCH_WORD, SEARCH_PAGE_TEST_DATA);
        headerForm.sendKeysToHeaderSearchInput(queryText);
        headerForm.clickHeaderSearchSubmitButton();

        SearchPage searchPage = new SearchPage();
        Assert.assertTrue(searchPage.isPageOpened(), "Search Page didn't open");
        Assert.assertEquals(searchPage.getActualSearchQueryText(), queryText, "The querys don't match");

        String testBrand = ParseUtils.getValueFromJson(BRAND, SEARCH_PAGE_TEST_DATA);
        searchPage.expandBrandFilter();
        searchPage.selectBrandCheckBox(testBrand);
        List<String> searchItemTitlesList = searchPage.getItemsTitles();
        Assert.assertFalse(searchItemTitlesList.isEmpty(), "Search Items' Titles List is empty");
        Assert.assertTrue(searchItemTitlesList.stream().allMatch(title -> title.contains(testBrand)), "At least one of Item Titles doesn't contain sought-for query");

        searchPage.sortByPriceFromLowToHigh();
        List<Integer> searchItemPricesList = searchPage.getItemsPrices();
        Assert.assertFalse(searchItemPricesList.isEmpty(), "Getting Items' Prices failed");
        List<Integer> sortedSearchItemPricesList = searchItemPricesList.stream().sorted().collect(Collectors.toList());
        Assert.assertEquals(searchItemPricesList, sortedSearchItemPricesList, "Price sorting doesn't work");
    }
}