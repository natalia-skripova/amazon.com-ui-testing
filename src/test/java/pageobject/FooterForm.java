package pageobject;

import element.BaseElement;
import element.Wrapper;
import org.openqa.selenium.By;

public class FooterForm extends BaseForm {

    private static final Wrapper footerFormWrapper = new Wrapper(By.id("footer"), "Footer Form Wrapper");

    public FooterForm() {
        super(footerFormWrapper);
    }
}
