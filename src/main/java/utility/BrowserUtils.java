package utility;

import webdriver.WebDriverUtils;

public class BrowserUtils {

    public static void goToWebPage(String url) {
        LogUtils.getLogger().debug("Go to the: " + url);
        WebDriverUtils.getDriver().get(url);
    }

    public static void refreshWebPage() {
        LogUtils.getLogger().debug("Refreshing the page");
        WebDriverUtils.getDriver().navigate().refresh();
    }

    public static int getOpenTabsAmount() {
        int openTabsAmount = WebDriverUtils.getDriver().getWindowHandles().size();
        LogUtils.getLogger().debug("Open Tabs amount: " + openTabsAmount);
        return openTabsAmount;
    }

    public static void switchWindowHandle(String originalWindow) {
        for (String windowHandle : WebDriverUtils.getDriver().getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                WebDriverUtils.getDriver().switchTo().window(windowHandle);
                break;
            }
        }
    }
}
