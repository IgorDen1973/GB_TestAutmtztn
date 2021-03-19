package ru.geekbrains.features.navigation;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.geekbrains.base.BaseUITest;
import ru.geekbrains.common.Configuration;
import ru.geekbrains.enums.NavigationBarTabs;
import ru.geekbrains.pages.LoginPage;

@Feature("Navigation Positive Test")
public class NavigationTest extends BaseUITest {

    @Story("Проверка на успешную авторизацию")
    @ParameterizedTest
    @MethodSource("navigationTabProvider")

    public void checkMainNavigationTabsTest(NavigationBarTabs barTab) {
        new LoginPage(driver)
                .authoriseScenario(Configuration.STUDENT_LOGIN, Configuration.STUDENT_PASSWORD)
                .getPageNavigation()
                .checkTabVisibility(barTab);

    }

    static NavigationBarTabs[] navigationTabProvider() {
        return NavigationBarTabs.values();
    }

}
