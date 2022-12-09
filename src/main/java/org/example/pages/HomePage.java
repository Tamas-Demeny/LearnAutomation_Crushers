package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import org.example.BasePage;
import org.example.HelperMethods.SupportMethods;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

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


}