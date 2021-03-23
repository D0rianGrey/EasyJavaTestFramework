package steps;

import pages.SearchPage;

public class SearchSteps {

    private final SearchPage searchPage = new SearchPage();

    public SearchResultSteps executeSearchByKeyword(String keyword) {
        searchPage.pasteToSearchField(keyword);
        //searchPage.clickSearchButtonOrPressEnter();
        searchPage.clickSearchButtonWithJavaScriptOrPressEnter();
        return new SearchResultSteps();
    }

    public SearchSteps openToolTip() {
        searchPage.moveToVoiceSearchButton();
        return this;
    }

    public SearchSteps verifyThatToolTipContainsProperText(String text) {
        searchPage.assertThatVoiceSearchTooltipContainsText(text);
        return this;
    }
}
