package ru.geekbrains.pages;
import org.openqa.selenium.WebDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import ru.geekbrains.base.BaseView;
import ru.geekbrains.views.NavigationBar;

public class HomePage extends BaseView {
    private NavigationBar navigationBar; // объект navigationBar - класс менюшки сверху на всю страницу

    public HomePage(WebDriver driver) {
        super(driver);
        this.navigationBar = new NavigationBar(driver);
    }

    public void checkUrl(String url) {

        assertEquals(driver.getCurrentUrl(), url);
    }

    public NavigationBar getPageNavigation() {

        return navigationBar;
    }
}
