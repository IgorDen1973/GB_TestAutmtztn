package ru.geekbrains.features.expences;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.geekbrains.base.BaseUITest;
import ru.geekbrains.base.SubMenu;
import ru.geekbrains.common.Configuration;
import ru.geekbrains.enums.ExpenseSubMenuButtons;
import ru.geekbrains.enums.NavigationBarTabs;
import ru.geekbrains.pages.AllExpensesPage;
import ru.geekbrains.pages.HomePage;
import ru.geekbrains.pages.LoginPage;
import ru.geekbrains.pages.NewExpensePage;
import ru.geekbrains.views.NavigationBar;

@Feature("New Expenses Creation")
public class NewExpensesTest extends BaseUITest {

    @Story("Создание заявки на расход")
    @Test
    public void createNewExpensePositiveTest() {
        AllExpensesPage expensesScreen = (AllExpensesPage) new LoginPage(driver) // создали объект loginPage
                .authoriseScenario(Configuration.STUDENT_LOGIN, Configuration.STUDENT_PASSWORD) // авторизовались и попали на HomePage
                .getPageNavigation()     // создали объект менюшки верхней
                .moveCursorToNavigationTab(NavigationBarTabs.EXPENSES)  // мышкой на "Расходы"
                .clickSubMenuButton(ExpenseSubMenuButtons.EXPENSE_REQUEST); // кликнули на "Заявки на расходы"

        expensesScreen
                .clickOnCreateNewExpenseButton()
                .enterDescription("test 1234")
                .selectBusinessUnit(1)
                .selectExpenditure(87)
                .setExpenseSum(10000)
                .clickNotifyDateChangedCheckBox()
                .selectDateInDatePicker(20)
                .clickSubmit()
                .checkNewExpensePopUp();
    }

    @Test
    @Disabled
    public void createNewExpensePositiveTest2() {  // альтернативное написание
        LoginPage lp = new LoginPage(driver);
        HomePage hp = lp.authoriseScenario(Configuration.STUDENT_LOGIN, Configuration.STUDENT_PASSWORD);
        NavigationBar nb = hp.getPageNavigation();
        SubMenu sm = nb.moveCursorToNavigationTab(NavigationBarTabs.EXPENSES);
        sm.clickSubMenuButton(ExpenseSubMenuButtons.EXPENSE_REQUEST);

        AllExpensesPage expensesScreen = new AllExpensesPage(driver);

        NewExpensePage nep = expensesScreen.clickOnCreateNewExpenseButton();
        nep.enterDescription("test 1234");
        nep.selectBusinessUnit(1);
        nep.selectExpenditure(87);
        nep.setExpenseSum(10000);
        nep.clickNotifyDateChangedCheckBox();
        nep.selectDateInDatePicker(20);
        nep.clickSubmit();

        expensesScreen.checkNewExpensePopUp();
    }

//    @Test
//    @Disabled
//    public void createNewBContractExpensePositiveTest() {
//        AllExpensesPage expensesScreen = (AllExpensesPage) new LoginPage(driver)
//                .authoriseScenario(Configuration.STUDENT_LOGIN, Configuration.STUDENT_PASSWORD)
//                .getPageNavigation()
//                .moveCursorToNavigationTab(NavigationBarTabs.EXPENSES)
//                .clickSubMenuButton(ExpenseSubMenuButtons.BUSINESS_CONTRACTS);
//
//        try {
//            Thread.sleep(9000);
//
//        }catch (Exception e){
//        }
//    }

}
