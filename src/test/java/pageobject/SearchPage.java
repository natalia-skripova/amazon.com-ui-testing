package pageobject;

import element.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utility.WaitUtils;
import webDriver.WebDriverUtils;

import java.util.List;
import java.util.stream.Collectors;

public class SearchPage extends BaseForm {

    private final static Wrapper searchPageWrapper = new Wrapper(By.xpath("//*[@id = 'search']"),
            "Search Page Header");

    private final Label searchQueryText = new Label(By
            .xpath("//*[@data-component-type='s-result-info-bar']//*[contains(@class, 'a-text-bold')]"),
            "Search Query Text");
    private final Button expandBrandFilterButton = new Button(By.xpath("//*[@id='brandsRefinements']//a[contains(@class, 'expander')]"),
            "Expand Brand Filter Button");

    private final String searchItemTitleXpath = "//*[@class = 'sg-row']//*[contains(@class, 'title')]//a";
    private final String searchItemPriceXpath = "//*[@class='a-price']//*[@class='a-price-whole']";
    private final String brandCheckBoxXpathBase = "//*[@id = 'brandsRefinements']";
    private final String sortSelectXpath = "//*[@id= 's-result-sort-select']";

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
        String brandCheckBoxFullXPath = brandCheckBoxXpathBase + String.format("//*[@aria-label = '%s']//i[contains(@class, 'checkbox')]", brandName);
        WebDriverUtils.getDriver().findElement(By.xpath(brandCheckBoxFullXPath)).click();

    }

    public List<String> getItemsTitles() {
        WaitUtils.waitForElementDisplayed(By.xpath(searchItemTitleXpath));
        return WebDriverUtils.getDriver().findElements(By.xpath(searchItemTitleXpath))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<Integer> getItemsPrices() {
        WaitUtils.waitForElementDisplayed(By.xpath(searchItemPriceXpath));
        return WebDriverUtils.getDriver().findElements(By.xpath(searchItemPriceXpath))
                .stream()
                .map(x -> Integer.parseInt(x.getText().replaceAll(",", "")))
                .collect(Collectors.toList());
    }

    public void sortByPriceFromLowToHigh() {
        WebElement selectElement = WebDriverUtils.getDriver().findElement(By.xpath(sortSelectXpath));
        Select select = new Select(selectElement);
        select.selectByValue("price-asc-rank");
    }
}
