package epamcomautomation.languagechange;

import basetests.EpamBaseTest;
import com.codeborne.selenide.WebDriverRunner;
import org.example.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

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

        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assert.assertEquals("https://careers.epam.hu/", currentUrl);

    }
}
