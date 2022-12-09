package org.example.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.example.BasePage;
import org.example.HelperMethods.SupportMethods;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.example.BasePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HomePage extends BasePage {

    private SelenideElement welcomeLabel = $(By.xpath("//span[contains(text(),\"Engineering the Future\")]"));
    private SelenideElement leadingTechnologiesLabel = $(By.xpath("//span[contains(text(),'leading technology companies')]"));

    private SelenideElement servicesPageButton = SupportMethods.getPage("Services");
    private SelenideElement howWeDoItPageButton = SupportMethods.getPage("How We Do It");
    private SelenideElement ourWorkPageButton = SupportMethods.getPage("Our Work");
    private SelenideElement insightsPageButton = SupportMethods.getPage("Insights");
    private SelenideElement aboutPageButton = SupportMethods.getPage("About");
    private SelenideElement careersPageButton = SupportMethods.getPage("Careers");
    private SelenideElement contactUsPageButton = $(By.xpath("//span[contains(text(),\"CONTACT US\")  and @class=\"cta-button__text\"]"));
    private SelenideElement changeLanguagePageButton = $(By.xpath("//*[contains(text(),\"Global\")  and @class=\"location-selector__button\"]"));
    private SelenideElement searchPageButton = $(By.xpath("//button[@class=\"header-search__button header__icon\"]"));

    SelenideElement dropDownMenu = $(By.xpath("//div[@class=\"location-selector-ui header__control\"]/button"));
    SelenideElement locationSelectorTitle = $(By.xpath("//strong[@class=\"location-selector__title\"]"));
    SelenideElement globalEnglishLink = $(By.xpath("//a[@class=\"location-selector__link active\"]"));
    SelenideElement hungaryLink = $(By.xpath("//li[@class=\"location-selector__item\"][2]/a"));
    SelenideElement germanLink = $(By.xpath("//li[@class=\"location-selector__item\"][10]/a"));
    SelenideElement polandLink = $(By.xpath("//li[@class=\"location-selector__item\"][11]/a"));
    ElementsCollection languagesList = $$(By.xpath("//li[@class=\"location-selector__item\"]"));
    public HomePage(){
        openBasePage();
    }
    public HomePage open(){
        welcomeLabel.shouldBe(visible);
        return this;
    }

    public String getWelcomLabel(){
        return welcomeLabel.getText();
    }
    public String getleadingTechnologiesLabel() { return  leadingTechnologiesLabel.getText();}


    public ServicesPage openServicesPage(){
        servicesPageButton.click();
        return new ServicesPage();
    }
    public HowWeDoItPage openHowWeDoItPage(){
        howWeDoItPageButton.click();
        return new HowWeDoItPage();
    }

    public OurWorkPage openOurWorkPage(){
        ourWorkPageButton.click();
        return new OurWorkPage();
    }

    public InsightsPage openInsightsPage(){
        insightsPageButton.click();
        return new InsightsPage();
    }

    public AboutPage openAboutPage(){
        aboutPageButton.click();
        return new AboutPage();
    }

    public CareersPage openCareersPage(){
        careersPageButton.click();
        return new CareersPage();
    }

    public ContactUsPage openContactUsPage(){
        contactUsPageButton.click();
        return new ContactUsPage();
    }

    public ChangeLanguagePage openChangeLanguagePage(){
        changeLanguagePageButton.click();
        return new ChangeLanguagePage();
    }

    public SearchPage openSearchPage(){
        searchPageButton.click();
        return new SearchPage();
    }

    public HomePage clickLanguageDropDown() {
        dropDownMenu.click();
        return this;
    }

    public HomePage checkLanguageDropDownVisible() {
        locationSelectorTitle.shouldBe(Condition.visible);
        return this;
    }

    public HomePage checkLanguageDropDownNotVisible() {
        locationSelectorTitle.shouldBe(Condition.hidden);
        return this;
    }

    public HomePage clickGlobalEnglish() {
        globalEnglishLink.click();
        return this;
    }

    public HungaryHomePage clickHungary() {
        hungaryLink.click();
        return new HungaryHomePage();
    }

    public GermanHomePage clickDach(){
        germanLink.click();
        return new GermanHomePage();
    }

    public PolandHomePage clickPolska(){
        polandLink.click();
        return new PolandHomePage();
    }

    public int numberOfLanguages(){
        return languagesList.size();
    }
}