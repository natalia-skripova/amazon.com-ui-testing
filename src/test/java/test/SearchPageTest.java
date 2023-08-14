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
        LogUtils.getLogger().info("--Search Page test. Step 1. Go to the Main page.--");
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpened(), "Main Page didn't open");

        LogUtils.getLogger().info("--Search Page test. Step 2. Click on the Search input.--");
        HeaderForm headerForm = new HeaderForm();
        headerForm.clickOnHeaderSearchInput();
        Assert.assertTrue(headerForm.isSearchPopupWindowOpened(), "Search Popup Window didn't open");

        LogUtils.getLogger().info("--Search Page test. Step 3. Text 'laptop' in the Search field at the top of the page.--");
        String queryText = ParseUtils.getValueFromJson(SEARCH_WORD, SEARCH_PAGE_TEST_DATA);
        headerForm.sendKeysToHeaderSearchInput(queryText);
        headerForm.clickHeaderSearchSubmitButton();

        SearchPage searchPage = new SearchPage();
        Assert.assertTrue(searchPage.isPageOpened(), "Search Page didn't open");
        Assert.assertEquals(searchPage.getActualSearchQueryText(), queryText, "The querys don't match");

        LogUtils.getLogger().info("--Search Page test. Step 4. Select 'Apple' in the Featured Brands filter.--");
        String testBrand = ParseUtils.getValueFromJson(BRAND, SEARCH_PAGE_TEST_DATA);
        searchPage.expandBrandFilter();
        searchPage.selectBrandCheckBox(testBrand);
        List<String> searchItemTitlesList = searchPage.getItemsTitles();
        Assert.assertFalse(searchItemTitlesList.isEmpty(), "Search Items' Titles List is empty");
        Assert.assertTrue(searchItemTitlesList.stream().allMatch(title -> title.contains(testBrand)), "At least one of Item Titles doesn't contain sought-for query");

        LogUtils.getLogger().info("--Search Page test. Step 5 Hover on the StarRate.--");
        searchPage.hoverOverStarPopupWindow();
        Assert.assertTrue(searchPage.isRatePopupWindowOpened(), "Popup window didn't open");

        LogUtils.getLogger().info("--Search Page test. Step 6. Sort search result by price: low to high in the top-right corner of the page.--");
        searchPage.sortByPriceFromLowToHigh();
        List<Integer> searchItemPricesList = searchPage.getItemsPrices();
        Assert.assertFalse(searchItemPricesList.isEmpty(), "Getting Items' Prices failed");
        List<Integer> sortedSearchItemPricesList = searchItemPricesList.stream().sorted().collect(Collectors.toList());
        Assert.assertEquals(searchItemPricesList, sortedSearchItemPricesList, "Price sorting doesn't work");
    }
}