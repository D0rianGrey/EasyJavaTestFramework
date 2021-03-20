package steps;

import pages.SearchResultPage;

public class SearchResultSteps {

    private final SearchResultPage searchResultPage = new SearchResultPage();

    public SearchResultSteps verifyThatTopResultContainsCorrectText(String text) {
        searchResultPage.assertThatTopResultContainsText(text);
        return this;
    }

    public SearchResultSteps verifyThatTopResultContainsPropterAttributeText(String text) {
        searchResultPage.assertThatTopResultContainsProperAttributeText(text);
        return this;
    }
}
