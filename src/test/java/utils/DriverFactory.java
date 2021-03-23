package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver(Browser browser) {

        switch (browser) {
            case CHROME -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            case EDGE -> {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
            case OPERA -> {
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
            }
            case FIREFOX -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            case SAFARI -> driver = new SafariDriver();
        }
        return driver;
    }
}
