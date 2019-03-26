package libs;


import org.apache.http.util.Asserts;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsWithElements {

    Logger logger = Logger.getLogger(getClass());
    WebDriver webDriver;

    WebDriverWait wait10, wait15;

    public ActionsWithElements(WebDriver webDriver) {

        this.webDriver = webDriver; // ЭТО ЧТО!!!!
        wait10 = new WebDriverWait(webDriver, 10);
        wait15 = new WebDriverWait(webDriver, 15);
    }

    public void linkTothePage(String pageLink) {
        try {
            webDriver.get(pageLink);
            logger.info("The page was opened");
        } catch (Exception e) {
            logger.error("The page wasn't opened" + e);
        }
    }

    public void openSiteRU() {
        try {
            webDriver.get("https://www.drogas.lv/ru/");
            logger.info("The site has been opened");
        } catch (Exception e) {
            logger.error("The site wasn't opened" + e);
            //тут должен быть вссерт, но он не добавдяетс
        }
    }

    public void openSiteLV() {
        try {
            webDriver.get("https://www.drogas.lv/lv/");
            logger.info("Tha site has been opened in LV language");
        } catch (Exception e) {
            logger.error("Tha site wasn't open" + e);
        }
    }

    public void click(WebElement element) {
        try {
            wait10.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            logger.info("The element " + element + " was clicked");
        } catch (Exception e) {
            logger.error("The element " + element + " WASN'T CLICKED");

        }
    }


    public void clickOnElementWithKeys(WebElement element, String textToEnter) {
        try {
            wait10.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            element.sendKeys(textToEnter);
            logger.info("The element --" + element + " -- was clicked");
        } catch (Exception e) {
            logger.error("The element --" + element + " -- WASN'T clicked");
        }
    }


    public boolean isElementPresent(WebElement element) {
        try {
            wait10.until(ExpectedConditions.elementToBeClickable(element));
            boolean isDisplayed = element.isDisplayed();
            logger.info("Element -- " + element + " --is displayed");
            return isDisplayed;

        } catch (Exception e) {
            logger.error("Element -- " + element + " -- IS NOT displayed");
            return false;
        }
    }


    public void switchLanguage(WebElement element, String needToBecome, WebElement languageButton, WebElement privacyPopupButton) {
        if ("RU".equals(needToBecome) || "LV".equals(needToBecome)) {
            try {
                if (element.isDisplayed() && "RU".equals(needToBecome)) {
                    logger.info("Mandatory is already  selected");
                } else if (!element.isDisplayed() && "RU".equals(needToBecome)) {
                    wait10.until(ExpectedConditions.elementToBeClickable(languageButton));
                    languageButton.click();
                    wait10.until(ExpectedConditions.elementToBeClickable(privacyPopupButton));
                    click(privacyPopupButton);
                    logger.info("We clicked on Change language button because we need another language");
                } else if (element.isDisplayed() && "LV".equals(needToBecome)) {
                    logger.info("Mandatory element is already selected ");
                } else if (!element.isDisplayed() && "LV".equals(needToBecome)) {
                    wait10.until(ExpectedConditions.elementToBeClickable(languageButton));
                    languageButton.click();
                    wait10.until(ExpectedConditions.elementToBeClickable(privacyPopupButton));
                    click(privacyPopupButton);
                    logger.info("We clicked on Change language button because we need another language");
                }
            } catch (Exception e) {
                logger.error("Something with language change" + e);
            }
        } else {
            logger.error("Language need to be RU or LV");

        }
    }
}
