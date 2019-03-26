package languageSwitch;

import org.junit.Test;
import parentTest.ParentTest;

public class GuestSwitchesLanguage extends ParentTest {

    @Test
    public void guestSwitchLanguageToLV () {
        mainPage.openMainPage();
        mainPage.checkSiteLanguageIsRU();
        mainPage.clickOnLanguageButton();


        checkExpectedResult("The Language was NOT changed by guest user to LV", mainPage.languageWasChangedToLV());


    }

    @Test

    public void guestSwitchLanguageToRU () {
        mainPage.openMainPageInLV ();
        mainPage.checkSiteLanguageIsLV();
        mainPage.clickOnLanguageButton();

        checkExpectedResult("The language was NOT changed by guest user to RU", mainPage.languageWasChangedToRU());

    }


}
