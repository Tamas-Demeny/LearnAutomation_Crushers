package navigationTests;

import basetests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LogInPage;

public class NavigationTopBarTests extends BaseTest {

    pages.HomePage homePage = new HomePage();
    pages.LogInPage logInPage = new LogInPage();


    @Test
    public void checkLandingPage() {
        logInPage.logInGoogleUserPassword("cezarepam13@gmail.com", "Parola13?");
        Assert.assertTrue(homePage.isHomePageDisplayed());
    }

    @Test
    public void checkCatalogPage() throws InterruptedException {
        homePage.clickOnTopNavBarLink("Catalog");

    }
}
