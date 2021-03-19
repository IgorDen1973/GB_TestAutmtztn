package ru.geekbrains.views;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import ru.geekbrains.base.BaseView;
import ru.geekbrains.base.SubMenu;
import ru.geekbrains.base.SubMenuButtons;
import ru.geekbrains.enums.CounterPartiesSubMenuButtons;
import ru.geekbrains.pages.CounterPartiesPage;


public class CounterPartiesSubMenu extends SubMenu {

    public CounterPartiesSubMenu(WebDriver driver) {

        super(driver);
    }

    @Override
    @Step(value = "Кликнуть на элемент сабменю из 'Контрагенты'")
    public BaseView clickSubMenuButton(SubMenuButtons buttons) {
        if (buttons instanceof CounterPartiesSubMenuButtons) {
            switch ((CounterPartiesSubMenuButtons) buttons) {
                case COMPANY:
                    driver.findElement(((CounterPartiesSubMenuButtons) buttons).getBy()).click();
                    return new CounterPartiesPage(driver);
                case CONTACT:
                    driver.findElement(((CounterPartiesSubMenuButtons) buttons).getBy()).click();
                    return new CounterPartiesPage(driver);
                default:
                    throw new IllegalArgumentException("Not implemented yet");
            }
        } else {
            throw new IllegalArgumentException("Incorrect button type");
        }
    }
}
