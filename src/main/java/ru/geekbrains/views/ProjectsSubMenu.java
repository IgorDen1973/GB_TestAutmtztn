package ru.geekbrains.views;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import ru.geekbrains.base.BaseView;
import ru.geekbrains.base.SubMenu;
import ru.geekbrains.base.SubMenuButtons;
import ru.geekbrains.enums.ProjectSubMenuButtons;
import ru.geekbrains.pages.ProjectsPage;

public class ProjectsSubMenu extends SubMenu {

    public ProjectsSubMenu(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step(value = "Кликнуть на элемент сабменю из 'Проекты'")
    public BaseView clickSubMenuButton(SubMenuButtons buttons) {
        if (buttons instanceof ProjectSubMenuButtons) {
            switch ((ProjectSubMenuButtons) buttons) {
                case PROJECT:
                    driver.findElement(((ProjectSubMenuButtons) buttons).getBy()).click();
                    return new ProjectsPage(driver);
                case PROJECT_MY:
                    driver.findElement(((ProjectSubMenuButtons) buttons).getBy()).click();
                    return new ProjectsPage(driver);
                case VALUE_CHANGE_REQUEST:
                    driver.findElement(((ProjectSubMenuButtons) buttons).getBy()).click();
                    return new ProjectsPage(driver);
                default:
                    throw new IllegalArgumentException("Not implemented yet");
            }
        } else {
            throw new IllegalArgumentException("Incorrect button type");
        }
    }
}
