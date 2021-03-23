package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//h3[@class='LC20lb DKV0Md'][1]")
    private WebElement resultRow;

    @FindBy(xpath = "//h3[@class='LC20lb DKV0Md']")
    private List<WebElement> resultRows;

    public SearchResultPage() {
        super();
    }

    public void assertThatTopResultContainsText(String expectedText) {
        wait.until(ExpectedConditions.visibilityOfAllElements(resultRows));
        //assertThat(resultRow.isDisplayed()).as("Element has not been displayed!").isTrue();
        assertThat(resultRows
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList()).toString())
                .as("Wrong text has been displayed!")
                .contains(expectedText);
    }

    public void assertThatTopResultContainsProperAttributeText(String expectedText) {
        assertThat(resultRow.getAttribute("class")).as("Wrong attribute text!").contains(expectedText);
    }

}
