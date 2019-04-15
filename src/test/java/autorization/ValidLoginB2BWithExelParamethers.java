package autorization;

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

public class ValidLoginB2BWithExelParamethers extends ParentTest {
    String login;
    String password;

    public ValidLoginB2BWithExelParamethers(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Parameterized.Parameters(name = "Parameters are {0} and {1}")
    public static Collection testData() throws IOException {
        InputStream spreadsheet //apreadsheet - peremennaya kyda zapisivayoutsia dannue
                = new FileInputStream(configProperties.DATA_FILE_PATH() + "dataForUserLogin.xls");
        return new SpreadsheetData(spreadsheet, "validLoginB2B").getData();
    }

    @Test
    public void validLoginB2B () {
        loginPage.loginB2B(login, password);

        checkExpectedResult("Login as B2C user wasn't executed",
                myProfilePage.sectionMyProfilepresent());
    }



}
