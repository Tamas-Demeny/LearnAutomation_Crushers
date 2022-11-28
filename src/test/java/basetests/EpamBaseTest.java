package basetests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.example.pages.HomePage;
import org.example.pages.HowWeDoItPage;
import org.example.pages.OurWorkPage;
import org.example.pages.ServicesPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class EpamBaseTest {

   @Test
    public void openHomePage() {
        OurWorkPage howWeDoItPage = new HomePage().open().openOurWorkPage();
        //Assert.assertEquals(hp.getWelcomLabel(),"Engineering the Future");
    }

 /*   @Test
    public void openHowWeDoItPageTest(){
        HowWeDoItPage howWeDoItPage = new HowWeDoItPage();
    }*/
}
