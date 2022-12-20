package basetests;

import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.*;
import static org.example.utils.TypesOfData.LEARN_PAGE;


public class BaseTest {

    @BeforeMethod
    public void openStartPage() {
        open(LEARN_PAGE);

        String url = WebDriverRunner.url();

        Assert.assertEquals(url, LEARN_PAGE, "We did not get to the expected page.");
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        clearBrowserCookies();
        closeWebDriver();
    }
}
