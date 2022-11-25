package basetests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class EpamBaseTest {

    @BeforeMethod
    public void openStartPage() {
        String startPage = "https://www.epam.com/";

        Configuration.browserSize = "1920x1080";
        Configuration.browserPosition = "0x0";

        open(startPage);

        String url = WebDriverRunner.url();

        Assert.assertEquals(startPage, url,
                "We did not get to the expected page. We arrived to " + url);
    }
}
