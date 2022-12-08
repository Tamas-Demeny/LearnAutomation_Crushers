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
        var dropDownMenu = new HomePage()
                .clickLanguageDropDown()
                .checkLanguageDropDownVisible();
    }

    @Test
    public void selectEnglishLanguage(){
        var englishLanguage = new HomePage()
                .clickLanguageDropDown()
                .clickGlobalEnglish()
                .checkLanguageDropDownNotVisible();

        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assert.assertEquals("https://www.epam.com/", currentUrl);
    }

    @Test
    public void selectHungaryLanguage(){
        var hungaryLanguage = new HomePage()
                .clickLanguageDropDown()
                .clickHungary();


        webdriver().shouldHave(url("https://careers.epam.hu/"));
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assert.assertEquals( currentUrl, "https://careers.epam.hu/");
    }

    @Test
    public void selectGermanLanguage(){
        var germanLanguage = new HomePage()
                .clickLanguageDropDown()
                .clickDach();

        webdriver().shouldHave(url("https://www.epam.de/"));
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.epam.de/" );
    }

    @Test
    public void selectPolishLanguage(){
        var polishLanguage = new HomePage()
                .clickLanguageDropDown()
                .clickPolska()
                .checkIfElementIsPolish();

        webdriver().shouldHave(url("https://careers.epam-poland.pl/"));
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://careers.epam-poland.pl/" );
    }
}
