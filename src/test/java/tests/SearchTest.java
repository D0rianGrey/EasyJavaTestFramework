package tests;

import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test(dataProvider = "dataProvider")
    public void openGoogleComInChromeTest1(String name) throws InterruptedException {
        steps.executeSearchByKeyword(name)
                .verifyThatTopResultContainsCorrectText("Пишем автотест с использованием Selenium Webdriver ...")
                .verifyThatTopResultContainsPropterAttributeText("LC20lb DKV0Md");
    }
}
