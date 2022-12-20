package basetests;

import com.codeborne.selenide.WebDriverRunner;
import org.example.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.example.utils.TypesOfData.LEARN_PAGE;


public class BaseTest {

    @BeforeMethod
    public void openStartPage() {
        open(LEARN_PAGE);

        String url = WebDriverRunner.url();

        Assert.assertEquals(LEARN_PAGE, url, "We did not get to the expected page.");
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        clearBrowserCookies();
        closeWebDriver();
    }
}
