package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyProfilePage extends ParentPage {

    public MyProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//button[@class='privacy_notification_popup__btn']")
    WebElement popupPrivacyButton;

    @FindBy(xpath = "//button[@class='privacy_notification_popup__btn']")
    WebElement popupPrivacyButtonByXpath;

    @FindBy(xpath = "//h1[@class='account_page__header']")
    WebElement profileNameSection;

    @FindBy(xpath = "//div[@class='wrapper']//a[@href='/ru/' ]")
    WebElement languageIS_RU;

      @FindBy(xpath = "//div[@class='wrapper']//a[@href='/lv/' ]")
     WebElement languageIS_LV;

    @FindBy(xpath = "/html/body/header/div/div[1]/div/ul[2]/li[5]")
    WebElement languageButton;

  //  @FindBy (xpath = "")

     @FindBy(xpath = "//span[@itemprop = 'name' and contains (text(), 'Мой профиль')]")
     WebElement languageInProfileIsRU;

      @FindBy(xpath = "//span[@itemprop = 'name' and contains (text(), 'Mans profils')]")
     WebElement languageInProfileIsLV;

    // @FindBy(xpath = "//div[@class='privacy_notification_popup__text']")
    // WebElement popupPrivacyText;


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



    @Step
    public String checkLanguageOfMyProfileByPopupLanguage() {
        try {
            if (actionsWithElements.toGetTextValue(popupPrivacyButton).equals("ХОРОШО, Я ПОНЯЛ/-А!")) {
                return "RU";
            }
            if (actionsWithElements.toGetTextValue(popupPrivacyButton).equals("LABI, ES SAPRATU!")) {
                return "LV";
            } else {
                return "The language of users account is not detected";
            }
        } catch (Exception e) {
            logger.error("Exception during defining users language " + e);
        }
        return "how to return from try?";


    }
    //     return actionsWithElements.toGetTextValue(popupPrivacyButton);

    @Step
    public boolean switchingLanguageProfile() {
        return actionsWithElements.switchLanguageTest2(checkLanguageOfMyProfileByPopupLanguage(),
                languageButton, popupPrivacyButton, profileNameSection);


    }

    @Step
    public void clickOnPrivacyPopupOKAYbutton() {
        actionsWithElements.isElementPresent(popupPrivacyButton);
        actionsWithElements.click(popupPrivacyButton);
    }


}
