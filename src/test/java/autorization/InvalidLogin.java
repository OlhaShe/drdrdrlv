package autorization;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)

public class InvalidLogin extends ParentTest {
    String login;
    String password;

    public InvalidLogin(String login, String password) {
        this.login = login;
        this.password = password;

    }


    @Parameterized.Parameters(name = "Paremeters are {0} and {1}")
    public static Collection testData() {
        return Arrays.asList(new Object[][]{
                {"testlog@gmail.com", "$%^$%^$%^99Kk"},
                {"useub2cemail@alpha-web.net", "$%^$%^$%^99Il"}
        });
    }

    @Test
    public void invalidLoginB2C () {
        loginPage.openLoginPage();
        loginPage.enterLoginB2C(login);
        loginPage.enterPasswordForB2C(password);
        loginPage.clickOnEnterButtonB2C ();

        checkExpectedResult("User's profile shouldn't be opened",
                !myProfilePage.sectionMyProfilepresent());
    }

    @Test
    public void invalidLoginB2B () {
        loginPage.openLoginPage();
        loginPage.enterLoginB2B (login);
        loginPage.enterPasswordForB2B(password);
        loginPage.clickOnEnterButtonB2B();

        checkExpectedResult("User's profile shouldn't be opened", !myProfilePage.sectionMyProfilepresent());


    }


}




