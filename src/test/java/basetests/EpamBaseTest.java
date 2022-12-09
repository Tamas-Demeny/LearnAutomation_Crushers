package basetests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.example.HelperMethods.SupportMethods;
import org.example.pages.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class EpamBaseTest {

   @Test
    public void openHomePage() throws InterruptedException {
       InsightsPage sp = new HomePage().openInsightsPage();
////       HowWeDoItPage hp = new HomePage().openHowWeDoItPage();
////       Assert.assertEquals(hp.getLink(),"https://www.epam.com/");
//
//           String startPage = "https://www.epam.com/";
//           open(startPage);
//           //SelenideElement n = $(By.xpath("//a[contains(text(),\"Insights\") and @class=\"top-navigation__item-link\"]"));
//           // n.click();
//       SelenideElement orice = SupportMethods.getPage("Insights");
//       orice.click();
          String url = WebDriverRunner.url();
           Assert.assertEquals(url,"https://www.epam.com/insights",
                   "We did not get to the expected page.");
    }

}
