package epamcomautomation.languagechange;

import basetests.EpamBaseTest;
import com.codeborne.selenide.WebDriverRunner;
import org.example.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class LanguageChangeTests extends EpamBaseTest {

    @Test
    public void dropDownMenuAppears() {
        HomePage hp = new HomePage()
                .clickLanguageDropDown()
                .checkLanguageDropDownVisible();

        Assert.assertEquals(hp.numberOfLanguages(), 11);
    }

    @Test
    public void selectEnglishLanguage(){
        HomePage hp = new HomePage();

        hp.clickLanguageDropDown()
                .clickGlobalEnglish()
                .checkLanguageDropDownNotVisible();

        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assert.assertEquals("https://www.epam.com/", currentUrl);
    }

    @Test
    public void selectHungaryLanguage(){
        HomePage hp = new HomePage();

        hp.clickLanguageDropDown()
                .clickHungary();

        webdriver().shouldHave(url("https://careers.epam.hu/"));
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assert.assertEquals( currentUrl, "https://careers.epam.hu/");
    }

    @Test
    public void selectGermanLanguage(){
        HomePage hp = new HomePage();

        hp.clickLanguageDropDown()
                .clickDach();

        webdriver().shouldHave(url("https://www.epam.de/"));
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.epam.de/" );
    }

    @Test
    public void selectPolishLanguage(){
        HomePage hp = new HomePage();

        hp.clickLanguageDropDown()
                .clickPolska()
                .checkIfElementIsPolish();

        webdriver().shouldHave(url("https://careers.epam-poland.pl/"));
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://careers.epam-poland.pl/" );
    }
}
