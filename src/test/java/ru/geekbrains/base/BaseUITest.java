package ru.geekbrains.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import ru.geekbrains.listener.CustomLogger;
import static ru.geekbrains.common.Configuration.BASE_URL;
import static ru.geekbrains.common.Configuration.LOGIN_PATH;

public abstract class BaseUITest {
//    protected WebDriver driver;  // создаем объект класса WebDriver  // **

    protected EventFiringWebDriver driver; //** EventFiringWebDriver - класс "обертка", следящая за работой драйвера

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void beforeTest() {       //  инициализируем базовые настройки  драйвера
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        //стенд тормозит, лучше использовать стратегию NORMAL
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        // Конфигурирование логгирования драйвера через интерфейс RemoteWebDriver
        RemoteWebDriver chromeDriver = new ChromeDriver(options);  //** вместо этих двух строк
        chromeDriver.setLogLevel(Level.INFO);     // **  можно взять обычное WebDriver chromeDriver = new ChromeDriver(options);
        // ----------------------------------------------------------------------
        // RemoteWebDriver - для дополнительного логгирования

        // Обертка драйвера в EventFiringWebDriver, умеющего регистрировать кастомные листенеры
        driver = new EventFiringWebDriver(chromeDriver);  // **
        driver.register(new CustomLogger());              // ** подключаем объекту логгер
        // ----------------------------------------------------------------------
//        driver = new ChromeDriver(options);    // **
        // Остальная часть может быть использована без изменений
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(BASE_URL + LOGIN_PATH);

    }

    @AfterEach
    public void tearDown() {
        // Вывод всех ошибок браузера после каждого теста
        driver                                   // **
                .manage()                        // **
                .logs()                           // **
                .get(LogType.BROWSER)              // **
                .getAll()                          // **
                .forEach(System.out::println);      // **
        // -------------------------------
        driver.quit();
    }
}
