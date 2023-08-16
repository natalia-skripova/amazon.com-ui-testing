package pageobject;

import element.Wrapper;
import org.openqa.selenium.By;

public class ConditionsOfUsePage extends BaseForm {

    private static final Wrapper conditionsOfUseContainer = new Wrapper(By.className("cs-help-header"), "Conditions Of Use Container");

    public ConditionsOfUsePage() {
        super(conditionsOfUseContainer);
    }
}
