package ru.geekbrains.enums;

import org.openqa.selenium.By;
import ru.geekbrains.base.SubMenuButtons;

public enum CounterPartiesSubMenuButtons implements SubMenuButtons {
    COMPANY("//ul/li[3]/a/span[@class='title' and text()='Организации']"),
    PAYER("//span[@class='title' and text()='Плательщики']"),
    CONTACT("//span[@class='title' and text()='Контактные лица']");

    private final By by;

    CounterPartiesSubMenuButtons(String xpath) {
        this.by = By.xpath(xpath);
    }

    public By getBy() {

        return by;
    }

}
