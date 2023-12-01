package ui.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Parameters;

import java.util.Optional;

public class BasePage {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static final String baseUrl = "https://www.xm.com/";
    public static final String MAX_RESOLUTION = "maximized";
    public static final String MID_RESOLUTION = "1024x768";
    public static final String MIN_RESOLUTION = "800x600";


    @Parameters({"resolution"})
    public static WebDriver getDriver(final String resolution) {
        return Optional.ofNullable(driver.get()).orElseGet(() -> {
            final ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
            switch (resolution) {
                case MAX_RESOLUTION -> chromeOptions.addArguments("--start-maximized");
                case MID_RESOLUTION -> chromeOptions.addArguments("--window-size=1024,768");
                case MIN_RESOLUTION -> chromeOptions.addArguments("--window-size=800,600");
            }
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver(chromeOptions));
            return driver.get();
        });
    }

    @Parameters({"resolution"})
    public BasePage(final String resolution) {
        WebDriverRunner.setWebDriver(getDriver(resolution));
        Configuration.timeout = 60000;
        Configuration.pageLoadTimeout = 60000;
    }

    protected void open(final String url) {
        Selenide.open(url);
    }

    public static void quitDriver() {
        WebDriverRunner.getWebDriver().quit();
        driver.remove();
    }
}
