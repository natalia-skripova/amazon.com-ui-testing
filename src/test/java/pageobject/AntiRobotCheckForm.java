package pageobject;

import element.Wrapper;
import org.openqa.selenium.By;

public class AntiRobotCheckForm extends BaseForm {

    private static final Wrapper antiRobotCheckWrapper = new Wrapper(By.id("cvf-page-content"), "Anti Robot Check Wrapper");

    public AntiRobotCheckForm() {
        super(antiRobotCheckWrapper);
    }


}
