package basetests;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.example.HelperMethods.SupportMethods;
import org.example.pages.CareersPage;
import org.example.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CareersTest {
    CareersPage careersPage;
    @BeforeMethod
    public void setUp() {
        careersPage = new HomePage().openCareersPage();
        SupportMethods.dismissCookiesPopUp();
    }
    /**
     * test 1 from epam jobs test cases -  the user can access https://www.epam.com/careers
     */
    @Test
    public void openCareersPage() {
        String url = WebDriverRunner.url();
        Assert.assertEquals(url, "https://www.epam.com/careers",
                "Expected: https://www.epam.com/careers, actual: " + url);
    }
    /**
     * test 2 from epam jobs test cases -  the user can search for jobs according to keyword
     */
    @Test
    public void testKeywordFunctionality() {

        careersPage.clickLocationFieldAllLocations();
        careersPage.sendKeysToKeywordField("java");
        careersPage.clickFind();
        Assert.assertTrue(careersPage
                .searchResultsContainKeyword("java")
                .contains("java"));
    }
    /**
     * test 3 from epam jobs test cases -
     * the user will not receive a list of jobs if the keyword does not exist
     */
    @Test
    public void testKeywordFunctionalityWithInexistingKeyword() {

        careersPage.clickLocationFieldAllLocations();
        careersPage.sendKeysToKeywordField("qwe");
        careersPage.clickFind();
        Assert.assertEquals(careersPage.searchResultErrorMessage(),
                "Sorry, your search returned no results. Please try another combination.",
                "the actual message is: " + careersPage.searchResultErrorMessage());
    }
    /**
     * test 4 from epam jobs test cases -
     * the user will not receive a list of suggestions for the keyword after starting to type
     * and after choosing one of the given suggestions a list of jobs according to that keyword
     */
    @Test
    public void testKeywordFunctionalityWithFirstLettersOfKeyword() {

        careersPage.clickLocationFieldAllLocations();
        careersPage.sendKeysWithAutocompleteSuggestions("dev");
        Assert.assertTrue(careersPage
                .searchResultsContainKeyword("dev")
                .contains("dev"));
    }
    /**
     * test 5 from epam jobs test cases -
     * the user will choose a country and a city from the location field
     * then will receive a list of jobs available for that location
     */
    @Test
    public void testLocationFunctionality() {

        careersPage.clickOnCountry();
        careersPage.clickFind();
        careersPage.returnJobsByCountry();
        Assert.assertTrue(careersPage.returnJobsByCountry());

    }
    /**
     * test 6 from epam jobs test cases -
     * the user will choose a skill option
     * then will receive a list of jobs available for that skill
     */
    @Test
    public void testSkillFunctionality() {

        careersPage.clickLocationFieldAllLocations();
        careersPage.clickSkillsField();
        careersPage.chooseSkillOption();
        careersPage.clickFind();
        String x = careersPage.searchResultsAfterSkillSelection();
        Assert.assertTrue(x.contains("job openings for you"), "expected job openings for you, but got" + x);

    }
    @AfterTest
    public void tearDown() {
        Selenide.closeWindow();
    }
}
