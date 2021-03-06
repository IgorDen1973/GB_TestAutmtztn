package ru.geekbrains.features.expences;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import ru.geekbrains.base.BaseUITest;
import ru.geekbrains.common.Configuration;
import ru.geekbrains.enums.ExpenseSubMenuButtons;
import ru.geekbrains.enums.NavigationBarTabs;
import ru.geekbrains.pages.AllExpensesPage;
import ru.geekbrains.pages.LoginPage;

@Feature("New HouseHold Agreement Creation")
public class NewAgreementsTest extends BaseUITest {

    @Story("Создание хозяйственного договора")
    @Test
    public void createNewAgrementPositiveTest() {
        AllExpensesPage agreementFrame = (AllExpensesPage) new LoginPage(driver)
                .authoriseScenario(Configuration.STUDENT_LOGIN, Configuration.STUDENT_PASSWORD).getPageNavigation()     // создали объект менюшки верхней
                .moveCursorToNavigationTab(NavigationBarTabs.EXPENSES)
                .clickSubMenuButton(ExpenseSubMenuButtons.BUSINESS_CONTRACTS);

        agreementFrame
                .clickOnCreateNewHouseAgreementButton()
                .enterHouseAgreementName()
                .enterHouseAgreementNumber("789/01.03")
                .enterHouseAgreementComment("Срочные работы по ликвидации последствий снегопада в Анголе")
                .chooseNewAgreementDate()
                .selectContractor(151)
                .selectExpenditure(10)
                .clickSubmit()
                .checkNewHouseAgreementPopUp();
    }
}
