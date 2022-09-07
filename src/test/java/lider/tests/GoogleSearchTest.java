package lider.tests;

import lider.pages.google.GooglePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.testng.Assert.assertTrue;


public class GoogleSearchTest extends BaseWebTest {

    GooglePage googlePage = new GooglePage();
    final static String searchValue = "купить кофемашину bork c804";

    @BeforeClass
    public void searchValue() {
        googlePage.navigateToPage().search(searchValue);
    }

    @Test
    public void googleSearchContainsMVideoTest() {
        String searchValue = "mvideo.ru";
        Optional<String> result = googlePage.getResultsUrl()
                .stream()
                .filter(it -> it.contains(searchValue))
                .findAny();
        assertTrue(result.isPresent(), "Google search doesn't contains '" + searchValue + "'");
    }

    @Test
    public void googleResultsContainsMoreTenResultsTest() {
        assertTrue(googlePage.isNextPageButtonIsDisplayed(), "Google search doesn't contains 10+ results");
    }

}
