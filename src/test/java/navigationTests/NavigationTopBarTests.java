package navigationTests;

import basetests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class NavigationTopBarTests extends BaseTest {

    pages.HomePage homePage = new HomePage();


    @Test
    public void checkLandingPage() {
        Assert.assertTrue(homePage.isHomePageDisplayed());
    }

    @Test
    public void checkCatalogPage() throws InterruptedException {
        homePage.clickOnTopNavBarLink("Catalog");

    }
}
