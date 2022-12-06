package basetests;

import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;


public class BaseTest {


    public void openStartPage() {
        String startPage = "https://learn.epam.com/start";

        open(startPage);

        String url = WebDriverRunner.url();

        Assert.assertEquals(startPage, url,
                "We did not get to the expected page.");
    }
}
