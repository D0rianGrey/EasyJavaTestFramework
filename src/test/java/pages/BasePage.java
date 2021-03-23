package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.time.Duration;
import java.util.List;

import static tests.BaseTest.getDriver;

public abstract class BasePage {

    //Here we are creating common functionality for all pages

    WebDriver driver;
    WebDriverWait wait;
    Actions builder;
    JavascriptExecutor executor;

    public BasePage() {
        this.driver = getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
        builder = new Actions(driver);
        executor = (JavascriptExecutor) driver;
    }

    boolean isElementFound(By by, int timeout) {
        List<WebElement> elements = driver.findElements(by);
        for (int i = 0; (i < timeout) && (elements.size() == 0); i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return elements.size() > 0;
    }

    void pasteTextToElementFromClipboard(WebElement element, String text) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        StringSelection stringSelection = new StringSelection(text);
        clipboard.setContents(stringSelection, null);
        element.sendKeys(Keys.CONTROL, "v");
    }

    void clickWithJavaScript(WebElement element) {
        executor.executeScript("arguments[0].click()", element);
    }
}