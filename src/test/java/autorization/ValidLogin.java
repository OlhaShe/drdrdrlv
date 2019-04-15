package autorization;

import org.junit.Test;
import parentTest.ParentTest;

public class ValidLogin extends ParentTest {

    @Test
    public void validLoginB2C() {
        loginPage.openLoginPage();
        loginPage.enterLoginB2C("useub2cemail@alpha-web.net");
        loginPage.enterPasswordForB2C("$%^$%^$%^99Kk");
        loginPage.clickOnEnterButtonB2C();

        checkExpectedResult("Profile section for B2C user was open",
                myProfilePage.sectionMyProfilepresent());
    }

    @Test
    public void validLoginB2B () {
        loginPage.openLoginPage();
        loginPage.enterLoginB2B("b2b_user@alpha-web.net");
        loginPage.enterPasswordForB2B("$%^$%^$%^99Kk");
        loginPage.clickOnEnterButtonB2B();

        checkExpectedResult("Profile section for B2C user was open", myProfilePage.sectionMyProfilepresent());

    }


}

