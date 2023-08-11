package pageobject;

import element.Button;
import element.Wrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import webDriver.WebDriverUtils;

import java.util.List;
import java.util.stream.Collectors;

public class MainPage extends BaseForm{

    private final static Wrapper mainForm = new Wrapper(By.xpath("//*[@id='gw-card-layout']"), "Main Form");

    private final Button excitingDealsPreviousSlideArrow = new Button(By.xpath("//*[@id = 'desktop-1']//*[@aria-label = 'Carousel previous slide']"),
            "Exciting Deals Previous Slide Arrow");
    private final Button excitingDealsNextSlideArrow = new Button(By.xpath("//*[@id = 'desktop-1']//*[@aria-label = 'Carousel next slide']"),
            "Exciting Deals Next Slide Arrow");
    private final Button excitingDealsScrollbarTrack = new Button(By.xpath("//*[@id = 'desktop-1']//*[contains(@class, 'feed-scrollbar-thumb')]"),
            "Exciting Deals Scrollbar Track");

    private final String goodDealBlockPriceTextXPath = "//*[@id = 'desktop-3']//*[@data-a-size = 'm']//*[contains(@class, 'offscreen')]";

    public MainPage() {
        super(mainForm);
    }

    public List<String> getGoodDealBlockPriceText() {
        return WebDriverUtils.getDriver().findElements(By.xpath(goodDealBlockPriceTextXPath))
                .stream()
                .map(x -> x.getAttribute("innerHTML"))
                .collect(Collectors.toList());
    }

    public boolean isExcitingDealsPreviousSlideArrowDisabled() {
        return excitingDealsPreviousSlideArrow.getElement()
                .getAttribute("class")
                .contains("feed-control-disabled");
    }

    public void moveExcitingDealScrollBarToTheRight() {
        new Actions(WebDriverUtils.getDriver())
                .scrollToElement(excitingDealsScrollbarTrack.getElement())
                .scrollByAmount(0, 300)
                .dragAndDropBy(excitingDealsScrollbarTrack.getElement(), 1300, 0)
                .perform();
    }

    public boolean isExcitingDealsNextSlideArrowDisabled() {
        return excitingDealsNextSlideArrow.getElement()
                .getAttribute("class")
                .contains("feed-control-disabled");
    }

}
