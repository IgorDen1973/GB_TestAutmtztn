package ru.geekbrains.features.login;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import io.qameta.allure.Story;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import ru.geekbrains.base.BaseUITest;
import ru.geekbrains.helpers.ScreenshotMaker;
import ru.geekbrains.pages.HomePage;
import ru.geekbrains.pages.LoginPage;

import static ru.geekbrains.common.Configuration.*;

@Feature("Positive Login Test")
@Severity(SeverityLevel.BLOCKER)
public class PositiveLoginTest extends BaseUITest {

    @Story("Авторизация на сайте")
    @Test
    public void loginWithBaseUserTest() {
            new LoginPage(driver)
                    .enterLogin(STUDENT_LOGIN)
                    .enterPassword(STUDENT_PASSWORD)
                    .clickLoginButton()
                    .checkUrl(BASE_URL);
        }

}
