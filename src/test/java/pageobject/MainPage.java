package pageobject;

import element.Button;
import element.Label;
import element.Wrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utility.BrowserUtils;
import webdriver.WebDriverUtils;

import java.util.List;
import java.util.stream.Collectors;

public class MainPage extends BaseForm {

    private final static Wrapper mainFormWrapper = new Wrapper(By.id("navbar-main"), "Main Form");

    private final Wrapper shortMainFormWrapper = new Wrapper(By.id("navbar-backup-backup"), "Short Main Form Wrapper");
    private final Button excitingDealsPreviousSlideArrow = new Button(By.xpath("//*[@id = 'desktop-1']//*[@aria-label = 'Carousel previous slide']"),
            "Exciting Deals Previous Slide Arrow");
    private final Button excitingDealsNextSlideArrow = new Button(By.xpath("//*[@id = 'desktop-1']//*[@aria-label = 'Carousel next slide']"),
            "Exciting Deals Next Slide Arrow");
    private final Button excitingDealsScrollbarButton = new Button(By.xpath("//*[@id = 'desktop-1']//*[contains(@class, 'feed-scrollbar-thumb')]"),
            "Exciting Deals Scrollbar Track");
    private final Label goodDealsBlockPriceText = new Label(By.xpath("//*[@id = 'desktop-3']//*[@data-a-size = 'm']//*[contains(@class, 'offscreen')]"),
            "Good Deals Block Price Text");

    public MainPage() {
        super(mainFormWrapper);
    }

    public void getFullMainPageOpened() {
        while (shortMainFormWrapper.getElement().isDisplayed()) {
            BrowserUtils.refreshWebPage();
        }
    }

    public List<String> getGoodDealBlockPriceText() {
        return goodDealsBlockPriceText.getElements()
                .stream()
                .map(x -> x.getAttribute("innerHTML"))
                .collect(Collectors.toList());
    }

    public boolean isExcitingDealsPreviousSlideArrowDisabled() {
        return excitingDealsPreviousSlideArrow.getElement()
                .getAttribute("class")
                .contains("feed-control-disabled");
    }

    public void moveExcitingDealScrollBarButtonToTheRight() {
        new Actions(WebDriverUtils.getDriver())
                .scrollToElement(excitingDealsScrollbarButton.getElement())
                .scrollByAmount(0, 300)
                .dragAndDropBy(excitingDealsScrollbarButton.getElement(), 1300, 0)
                .perform();
    }

    public boolean isExcitingDealsNextSlideArrowDisabled() {
        return excitingDealsNextSlideArrow.getElement()
                .getAttribute("class")
                .contains("feed-control-disabled");
    }
}