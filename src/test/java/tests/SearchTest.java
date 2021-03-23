package tests;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test(dataProvider = "dataProvider")
    public void openGoogleComInChromeTest1(String name) {
        steps.executeSearchByKeyword(name)
                .verifyThatTopResultContainsCorrectText("Selenium Webdriver")
                .verifyThatTopResultContainsPropterAttributeText("LC20lb DKV0Md");
    }

    @Ignore
    @Test
    public void verifySearchByVoiceTooltipOnGoogle() {
        steps.openToolTip()
                .verifyThatToolTipContainsProperText("Пошук голосом");

    }
}
