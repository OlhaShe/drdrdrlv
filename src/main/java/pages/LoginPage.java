package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {


    public LoginPage(WebDriver webDriver) { // 1.1. СОздался конструктор
        super(webDriver);
    }

    @FindBy(xpath = "//a[@href='/ru/login' and @title='Мой профиль']")
    WebElement linkToLoginPage;

    @FindBy(id = "private-customer-account-login-username")
    WebElement inputEmailB2C;

    @FindBy(id = "private-customer-account-login-password")
    WebElement inputPasswordB2C;

    @FindBy(id = "business-customer-account-login-email")
    WebElement inputFieldEmailB2B;

    @FindBy(id = "business-customer-account-login-password")
    WebElement inputPasswordB2B;

    @FindBy(xpath = "//button[@class='private_customer__btn' and contains (text(), 'Войти' )]")
    WebElement enterButtonB2C;

    @FindBy(xpath = "//button[@class='business_customer__btn' and contains (text(), 'Войти')]")
    WebElement enterButtonB2B;

    @FindBy(xpath = "//span[@itemprop='name' and contains (text(), 'Мой профиль')]")
    WebElement myProfileSection;


    @Step
    public void openLoginPage() {
        actionsWithElements.openSiteRU();
        actionsWithElements.click(linkToLoginPage);
    }

    @Step
    public void enterLoginB2C(String loginData) {
        actionsWithElements.clickOnElementWithKeys(inputEmailB2C, loginData);
    }

    @Step
    public void enterPasswordForB2C(String passwordData) {
        actionsWithElements.clickOnElementWithKeys(inputPasswordB2C, passwordData);
    }

    @Step
    public void clickOnEnterButtonB2C() {
        actionsWithElements.click(enterButtonB2C);
    }

    @Step
    public void enterLoginB2B(String loginData) {
        actionsWithElements.clickOnElementWithKeys(inputFieldEmailB2B, loginData);
    }

    @Step
    public void enterPasswordForB2B(String passwordData) {
        actionsWithElements.clickOnElementWithKeys(inputPasswordB2B, passwordData);
    }

    @Step
    public void clickOnEnterButtonB2B() {
        actionsWithElements.click(enterButtonB2B);
    }

    @Step
    public void loginB2C(String login, String password) {
        openLoginPage();
        enterLoginB2C(login);
        enterPasswordForB2C(password);
        clickOnEnterButtonB2C();
    }

    @Step
    public void loginB2B(String login, String password) {
        openLoginPage();
        enterLoginB2B(login);
        enterPasswordForB2B(password);
        clickOnEnterButtonB2B();
    }
}

