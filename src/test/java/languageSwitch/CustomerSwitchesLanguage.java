package languageSwitch;

import org.junit.Test;
import parentTest.ParentTest;

public class CustomerSwitchesLanguage extends ParentTest {

    @Test

    public void customerSwitchLanguage () { //TODO ask about test case if language is LV
        loginPage.openLoginPage();
        loginPage.clickOnEnterButtonB2C();
        loginPage.enterLoginB2C("useub2cemail@alpha-web.net");
        loginPage.enterPasswordForB2C("$%^$%^$%^99Kk");
        loginPage.clickOnEnterButtonB2C();
        myProfilePage.clickOnPrivacyPopupOKAYbutton();
        myProfilePage.languageInProfileIsRU();
        myProfilePage.languageSwiftFromRUtoLV();

        checkExpectedResult("The B2C user has NOT changed the language to LV", myProfilePage.languageInProfileIsLV());

        myProfilePage.languageSwiftFromLVtoRU();
        myProfilePage.clickOnPrivacyPopupOKAYbutton();

        checkExpectedResult("The B2C user has NOT changed the language back to RU", myProfilePage.languageInProfileIsRU());



    }

}
