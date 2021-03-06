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
}
