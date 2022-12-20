package searchtests;

import basetests.BaseTest;
import org.example.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.example.utils.TypesOfData.INVALID_INPUT;
import static org.example.utils.TypesOfData.VALID_INPUT;

public class SearchTest extends BaseTest {
    SearchPage searchPage = new SearchPage();

    //first
    @Test
    public void openCatalogPageTest() {
        Assert.assertTrue( searchPage.clickSearch().checkCurrentUrl(), "The catalog page is not displayed !");
    }

    //second
    @Test
    public void searchValidInputTest() {
        boolean checkValidInput = searchPage
                .clickSearch()
                .enterSearchInput(VALID_INPUT)
                .checkAtLeastOneResultFound();
        Assert.assertTrue(checkValidInput, "There is no course available according to your search!");
    }

    //third
    @Test
    public void searchInvalidInputTest() {
        boolean checkInvalidInput = searchPage
                .clickSearch()
                .enterSearchInput(INVALID_INPUT)
                .checkErrorMessageIsDisplayed();
        Assert.assertTrue(checkInvalidInput, "The application displays wrong courses !");
    }

    //fourth
    @Test
    public void counterTest() {
        boolean checkCounter = searchPage
                .acceptCookies()
                .clickSearch()
                .enterSearchInput(VALID_INPUT)
                .scrollToFooter(2)
                .checkIfResultsCounterMatches();
        Assert.assertTrue( checkCounter,"The counter doesn't work as expected !");
    }

    //fifth
    @Test
    public void clearingResultsReturnsAllItemsTest() {
        boolean validation = searchPage
                .acceptCookies()
                .clickSearch()
                .enterSearchInput(INVALID_INPUT)
                .clearSearch()
                .scrollToFooter(6)
                .checkCounterMatchesResultsListSize();

        Assert.assertTrue(validation, "The counter doesn't work as expected or not all available courses are displayed!");
    }

}