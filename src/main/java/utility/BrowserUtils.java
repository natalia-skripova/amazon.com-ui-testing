package utility;

import webDriver.WebDriverUtils;

public class BrowserUtils {

    public static void goToWebPage(String url) {
        WebDriverUtils.getDriver().get(url);
    }

    public static void refreshWebPage() {
        WebDriverUtils.getDriver().navigate().refresh();
    }
}
