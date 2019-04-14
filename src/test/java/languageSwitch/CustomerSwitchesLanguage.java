package languageSwitch;

import libs.SpreadsheetData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

@RunWith(Parameterized.class)

public class CustomerSwitchesLanguage extends ParentTest {
    String login;
    String password;

    public CustomerSwitchesLanguage(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Parameterized.Parameters(name = "Parameters are {0} and {1}")
    public static Collection testData() throws IOException {
        InputStream spreadsheet //apreadsheet - peremennaya kyda zapisivayoutsia dannue
                = new FileInputStream(configProperties.DATA_FILE_PATH() + "dataForUserLogin.xls");
        return new SpreadsheetData(spreadsheet, "validLoginB2C").getData();
    }

    @Test
    public void customerB2CSwitchLanguage() {
        loginPage.loginB2C(login, password);
        myProfilePage.switchingLanguageProfile();

        checkExpectedResult("The B2C user has NOT changed the language to LV",
                myProfilePage.switchingLanguageProfile());


    }
/*
    @Test
    public void customerSwitchLanguage () {
        loginPage.openLoginPage();
        loginPage.clickOnEnterButtonB2C();
        loginPage.enterLoginB2C("useub2cemail@alpha-web.net");
        loginPage.enterPasswordForB2C("$%^$%^$%^99Kk");
        loginPage.clickOnEnterButtonB2C();
        myProfilePage.clickOnPrivacyPopupOKAYbutton();
        myProfilePage.languageInProfileIsRU();
        myProfilePage.languageSwiftFromRUtoLV();// i am trying to make push

        checkExpectedResult("The B2C user has NOT changed the language to LV",
                myProfilePage.languageInProfileIsLV());

        myProfilePage.languageSwiftFromLVtoRU();
        myProfilePage.clickOnPrivacyPopupOKAYbutton();

        checkExpectedResult("The B2C user has NOT changed the language back to RU",
                myProfilePage.languageInProfileIsRU());



    }
*/
/*
    @Test
    public void customerSwitchLanguageTest2() { //TODO ask about test case if language is LV
        loginPage.openLoginPage();
        loginPage.clickOnEnterButtonB2C();
        loginPage.enterLoginB2C("useub2cemail@alpha-web.net");
        loginPage.enterPasswordForB2C("$%^$%^$%^99Kk");
        loginPage.clickOnEnterButtonB2C();
        myProfilePage.switchingLanguageProfile();


        checkExpectedResult("The language wasn't switched by user", myProfilePage.switchingLanguageProfile());



    }

*/
}
