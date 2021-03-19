package ru.geekbrains.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.geekbrains.base.BaseView;

public class LoginPage extends BaseView {   // описание страницы Login

    @FindBy(css = "input[id='prependedInput']")
    private WebElement inputLogin;  // inputLogin - это св-во класса LoginPage, это вэб-элемент, который
    // при помощи PageFactory Selenium и аннотации FindBy

    @FindBy(css = ".span2[name='_password']")
    private WebElement inputPassword;

    @FindBy(xpath = ".//button[@name='_submit']")
    private WebElement buttonSignIn;

    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement inputCheck;


    @Step(value = "Поставить флажок на чекбокс 'Запомнить меня на этом компьютере'")
    public LoginPage ckeckYes(){
        inputCheck.click();
        return this;
    }

    public LoginPage(WebDriver driver) {  // любая страничка начинается с запуска вебдрайвера

        super(driver);
    }

    @Step(value = "Ввести данные в поле 'Имя пользователя или Email'")
    public LoginPage enterLogin(String login) {
        inputLogin.sendKeys(login);  // инициализируеися вэбЭлемент inputLogin, и к нему sendKeys
        return this;
    }

    @Step(value = "Ввести данные в поле 'Пароль'")
    public LoginPage enterPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    @Step(value = "Нажать на кнопку 'Войти'")
    public HomePage clickLoginButton() {
        buttonSignIn.click();
        return new HomePage(driver);  // создается на выходе новый объект класса HomePage (другой страницы)
    }


    // Для использования в других тестах
    @Step(value = "Авторизоваться на сайте'")
    public HomePage authoriseScenario(String login, String password) {
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        buttonSignIn.click();
        return new HomePage(driver);
    }
}
