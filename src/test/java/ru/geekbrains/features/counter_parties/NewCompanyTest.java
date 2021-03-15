package ru.geekbrains.features.counter_parties;

import org.junit.jupiter.api.Test;
import ru.geekbrains.base.BaseUITest;
import ru.geekbrains.common.Configuration;
import ru.geekbrains.enums.CounterPartiesSubMenuButtons;
import ru.geekbrains.enums.NavigationBarTabs;
import ru.geekbrains.pages.CounterPartiesPage;
import ru.geekbrains.pages.LoginPage;

public class NewCompanyTest extends BaseUITest {
    @Test
    public void createNewCompanyPositiveTest() {
        CounterPartiesPage companyFrame = (CounterPartiesPage) new LoginPage(driver)
                .authoriseScenario(Configuration.STUDENT_LOGIN, Configuration.STUDENT_PASSWORD)
                .getPageNavigation()
                .moveCursorToNavigationTab(NavigationBarTabs.COUNTER_PARTIES)
                .clickSubMenuButton(CounterPartiesSubMenuButtons.COMPANY);

        companyFrame
                .clickOnCreateNewCompanyButton()
                .enterNewCompanyName() // сделал рандомное значение
                .enterNewCompanyShortName("BigMac Co.")
                .selectOwnershipType(5)
                .selectCompanyStatus(1)
                .defineOfNewCompanyType()
                .selectIndustryType(10)
                .addressNewCompanyFieldActivation()
                .enterNewCompanyStreetAddress("Большая Полянка")
                .enterNewCompanyBuildingAddress("20к4")
                .telephoneNewCompanyFieldActivation()
                .selectPhoneType("mobile")
                .enterNewCompanyPrefixCode("925")
                .enterNewCompanyPhone("654")
                .enterNewCompanyInternalCode("9087")
                .enterNewCompanyEmail("info@bigmac.com")
                .selectNewCompanyManager(6)
                .clickSubmit()
                .checkNewCompanyPopUp();


    }

}
