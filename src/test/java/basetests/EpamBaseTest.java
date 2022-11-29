package basetests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.example.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class EpamBaseTest {

   @Test
    public void openHomePage() throws InterruptedException {
       InsightsPage sp = new HomePage().openInsightsPage();
    }

}
