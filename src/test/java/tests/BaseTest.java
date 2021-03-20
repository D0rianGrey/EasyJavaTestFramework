package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import steps.SearchSteps;
import utils.Browser;
import utils.DriverFactory;
import utils.PropertyReader;

import java.io.File;

import static utils.PropertyReader.getBrowser;
import static utils.PropertyReader.getUrl;

public abstract class BaseTest {

    //Here we are creating common functionality for all tests

    private static WebDriver driver;

    SearchSteps steps;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void setUp() {
        driver = DriverFactory.getDriver(getBrowser());
        driver.get(getUrl());
        steps = new SearchSteps();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @AfterMethod
    public void goBack() {
        driver.navigate().back();
    }

    @DataProvider(name = "dataProvider")
    public Object[][] dataProviderMethod() {
        return new Object[][]{{"selenium java"}, {"selenium javascript"}};
    }
}
