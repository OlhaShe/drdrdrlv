package parentTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.MainPage;
import pages.MyProfilePage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {

    WebDriver webDriver;
   protected LoginPage loginPage;
   protected MyProfilePage myProfilePage;
   protected MainPage mainPage;

    @Before //test

    public void setWebDriver (){
        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);


        loginPage = new LoginPage(webDriver);
        myProfilePage = new MyProfilePage(webDriver);
        mainPage = new MainPage(webDriver);

    }

    protected void checkExpectedResult (String message, boolean actualResult) {
        Assert.assertEquals(message, true, actualResult);
    }




    @After
    public void quitBrowser(){
        webDriver.quit();
    }
}
