package pageobject;

import element.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utility.WaitUtils;
import webdriver.WebDriverUtils;

import java.util.List;
import java.util.stream.Collectors;

public class SearchPage extends BaseForm {

    private final static Wrapper searchPageWrapper = new Wrapper(By.id("search"), "Search Page Header");

    private final Label searchQueryText = new Label(By
            .xpath("//*[@data-component-type='s-result-info-bar']//*[contains(@class, 'a-text-bold')]"), "Search Query Text");
    private final Button expandBrandFilterButton = new Button(By.xpath("//*[@id='brandsRefinements']//a[contains(@class, 'expander')]"),
            "Expand Brand Filter Button");
    private final SelectElement searchSortSelect = new SelectElement(By.id("s-result-sort-select"), "Search Sort Select");
    private final Label searchItemTitle = new Label(By.xpath("//*[@class = 'sg-row']//*[contains(@class, 'title')]//a"), "Search Item Title");
    private final Label searchItemPrice = new Label(By.xpath("//*[@class='a-price']//*[@class='a-price-whole']"), "Search Item Price");
    private final Label searchItemRate = new Label(By.className("a-declarative"), "Item Star Rate");
    private final Wrapper itemRatePopoverWindow = new Wrapper(By.xpath("//*[contains(@class, 'a-popover')][@role='dialog']"), "Star Popover Window");

    private final String brandCheckBoxXpathBase = "//*[@id = 'brandsRefinements']//*[@aria-label = '%s']//i[contains(@class, 'checkbox')]";

    public SearchPage() {
        super(searchPageWrapper);
    }

    public String getActualSearchQueryText() {
        String actualSearchQueryText = searchQueryText.getElement().getText();
        return actualSearchQueryText.substring(1, actualSearchQueryText.length() - 1);
    }

    public void expandBrandFilter() {
        expandBrandFilterButton.clickButton();
    }

    public void selectBrandCheckBox(String brandName) {
        String brandCheckBoxFullXPath = String.format(brandCheckBoxXpathBase, brandName);
        WebDriverUtils.getDriver().findElement(By.xpath(brandCheckBoxFullXPath)).click();

    }

    public List<String> getItemsTitles() {
        WaitUtils.waitForElementDisplayed(searchItemTitle.getElementLocator());
        return searchItemTitle.getElements()
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<Integer> getItemsPrices() {
        WaitUtils.waitForElementDisplayed(searchItemPrice.getElementLocator());
        return searchItemPrice.getElements()
                .stream()
                .map(x -> Integer.parseInt(x.getText().replaceAll(",", "")))
                .collect(Collectors.toList());
    }

    public void sortByPriceFromLowToHigh() {
        Select select = new Select(searchSortSelect.getElement());
        select.selectByValue("price-asc-rank");
    }

    public void hoverOverStarPopupWindow() {
        new Actions(WebDriverUtils.getDriver())
                .moveToElement(searchItemRate.getElement())
                .click()
                .perform();
    }

    public boolean isRatePopupWindowOpened() {
        itemRatePopoverWindow.getElement().isDisplayed();
        return !itemRatePopoverWindow.getElement().getAttribute("style").contains("auto");
    }
}
