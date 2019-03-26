package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyProfilePage extends ParentPage {

    public MyProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy (xpath = "//span[@itemprop='name' and contains (text(), 'Мой профиль')]")
    WebElement profileNameSection;

    @FindBy(xpath = "//div[@class='wrapper']//a[@href='/ru/' ]")
    WebElement languageIS_RU;

    @FindBy(xpath = "//div[@class='wrapper']//a[@href='/lv/' ]")
    WebElement languageIS_LV;

    @FindBy(xpath = "//ul[@class='header__account_bar_links header__account_bar_links-desktop']//a[@href='#']")
    WebElement languageButton;

    @FindBy (xpath = "//span[@itemprop = 'name' and contains (text(), 'Мой профиль')]")
    WebElement languageInProfileIsRU;

    @FindBy (xpath = "//span[@itemprop = 'name' and contains (text(), 'Mans profils')]")
    WebElement languageInProfileIsLV;

    @FindBy (xpath = "//div[@class='privacy_notification_popup__text']")
    WebElement popupPrivacyText;

    @FindBy (xpath = "//button[@class='privacy_notification_popup__btn']")
    WebElement popupPrivacyButton;




    public boolean sectionMyProfilepresent() {
        return actionsWithElements.isElementPresent(profileNameSection);
    }

    public void languageSwiftFromRUtoLV() {
        actionsWithElements.switchLanguage(languageIS_RU, "LV", languageButton, popupPrivacyButton);
    }

    public boolean languageInProfileIsLV() {
        return actionsWithElements.isElementPresent(languageInProfileIsLV);
    }
    public void languageSwiftFromLVtoRU() {
        actionsWithElements.switchLanguage(languageIS_LV, "RU", languageButton, popupPrivacyButton);
    }

    public boolean languageInProfileIsRU() {
        return actionsWithElements.isElementPresent(languageInProfileIsRU);
    }


    public boolean clickOnPrivacyPopupOKAYbutton() {
        actionsWithElements.isElementPresent(popupPrivacyText);
        actionsWithElements.click(popupPrivacyButton);
        return true;
    }


}
