package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends ParentPage {

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//div[@class='wrapper']//a[@href='/ru/' ]")
    WebElement languageIS_RU;

    @FindBy(xpath = "//div[@class='wrapper']//a[@href='/lv/' ]")
    WebElement languageIS_LV;

    @FindBy(xpath = "//ul[@class='header__account_bar_links header__account_bar_links-desktop']//a[@href='#']")
    WebElement languageButton;

    @FindBy(xpath = "//a[@title='Mans profils' and contains (text (), 'Ienākt/Reģistrēties')] ")
    WebElement profileInLV;

    @FindBy(xpath = "//a[@title='Мой профиль' and contains (text (), 'Войти/Регистрация')]")
    WebElement profileInRU;


    public void openMainPage() {
        actionsWithElements.openSiteRU();
    }

    public void openMainPageInLV() {
        actionsWithElements.openSiteLV();
    }


    public void checkSiteLanguageIsRU() {
        actionsWithElements.isElementPresent(languageIS_RU);
    }

    public void checkSiteLanguageIsLV() {
        actionsWithElements.isElementPresent(languageIS_LV);
    }


    public void clickOnLanguageButton() {
        actionsWithElements.click(languageButton);
    }


    public boolean languageWasChangedToLV() {
        return actionsWithElements.isElementPresent(profileInLV);
    }


    public boolean languageWasChangedToRU() {
        return actionsWithElements.isElementPresent(profileInRU);
    }





}
