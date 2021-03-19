package ru.geekbrains.features.counter_parties;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import ru.geekbrains.base.BaseUITest;
import ru.geekbrains.common.Configuration;
import ru.geekbrains.enums.CounterPartiesSubMenuButtons;
import ru.geekbrains.enums.NavigationBarTabs;
import ru.geekbrains.pages.CounterPartiesPage;
import ru.geekbrains.pages.LoginPage;

@Feature("New Counterpartie Creation")
public class NewCounterPartiesTest extends BaseUITest {

    @Story("Создание нового контрагента")
    @Test
    public void createNewCounterPartiesPositiveTest() {
        CounterPartiesPage counterPartiesFrame = (CounterPartiesPage) new LoginPage(driver)
                .authoriseScenario(Configuration.STUDENT_LOGIN, Configuration.STUDENT_PASSWORD)
                .getPageNavigation()
                .moveCursorToNavigationTab(NavigationBarTabs.COUNTER_PARTIES)
                .clickSubMenuButton(CounterPartiesSubMenuButtons.CONTACT);

        counterPartiesFrame
                .clickOnCreateNewCounterPartiesButton()
                .enterNewLastNameCounterParties("John")
                .enterNewFirstNameCounterParties("Smith")
                .selectOrganizationOfProject()
                .enterNewJobTitleCounterParties("Detective")
                .clickSubmit()
                .checkNewCounterPartiesPopUp();

    }
}
