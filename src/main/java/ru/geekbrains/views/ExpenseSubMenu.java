package ru.geekbrains.views;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import ru.geekbrains.base.BaseView;
import ru.geekbrains.base.SubMenu;
import ru.geekbrains.base.SubMenuButtons;
import ru.geekbrains.enums.ExpenseSubMenuButtons;
import ru.geekbrains.pages.AllExpensesPage;

public class ExpenseSubMenu extends SubMenu {

    public ExpenseSubMenu(WebDriver driver) {

        super(driver);
    }

    @Override
    @Step(value = "Кликнуть на элемент сабменю из 'Расходы'")
    public BaseView clickSubMenuButton(SubMenuButtons buttons) {
        if (buttons instanceof ExpenseSubMenuButtons) {
            switch ((ExpenseSubMenuButtons) buttons) {
                case EXPENSE_REQUEST:
                    driver.findElement(((ExpenseSubMenuButtons) buttons).getBy()).click();
                    return new AllExpensesPage(driver);
                case BUSINESS_TRIPS:
                    driver.findElement(((ExpenseSubMenuButtons) buttons).getBy()).click();
                    return new AllExpensesPage(driver);
                case BUSINESS_CONTRACTS:
                    driver.findElement(((ExpenseSubMenuButtons) buttons).getBy()).click();
                    return new AllExpensesPage(driver);
                default:
                    throw new IllegalArgumentException("Not implemented yet");
            }
        } else {
            throw new IllegalArgumentException("Incorrect button type");
        }
    }
}
