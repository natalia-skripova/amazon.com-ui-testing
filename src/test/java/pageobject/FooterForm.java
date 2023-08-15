package pageobject;

import element.Button;
import element.Wrapper;
import org.openqa.selenium.By;

public class FooterForm extends BaseForm {

    private static final Wrapper footerFormWrapper = new Wrapper(By.id("footer"), "Footer Form Wrapper");

    private final Button conditionsOfUseButton = new Button(By.xpath("//*[@id = 'footer']//*[contains(@href, 'cou')]"),
            "Conditions Of Use Button");

    public FooterForm() {
        super(footerFormWrapper);
    }

    public void clickOnConditionsOfUseButton() {
        conditionsOfUseButton.clickButton();
    }
}
