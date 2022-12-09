package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.WebDriverRunner;
import org.example.BasePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import org.testng.Assert;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.*;

public class ContactUsPage extends BasePage {

    private SelenideElement contactUsLabel = $(By.xpath("//h1[contains(@class,'title-ui')]"));
    private SelenideElement contactUsForm = $(By.xpath("//div[@class='form']"));


    public String getWelcomeLabel(){
        return contactUsLabel.getText();
    }

   public boolean contactUsFormVisible(){
        return contactUsForm.isDisplayed();
    }
    SelenideElement titlePage = $(By.xpath("//h1[contains(@class,\"title-ui\")]"));
    SelenideElement formTitle = $(By.xpath("(//h2[contains(@class,\"title-ui\")])[1]"));
    public SelenideElement inquiryDropDownList = $(By.xpath("(//b[@role=\"presentation\"])[1]"));
    public ElementsCollection inquiryListElements = $$x("//li[contains(@id,\"who-we-are\")]");
    public SelenideElement firstNameField = $(By.name("user_first_name"));
    public SelenideElement lastNameField = $(By.name("user_last_name"));
    public SelenideElement emailField = $(By.name("user_email"));
    public SelenideElement phoneField = $(By.name("user_phone"));
    public SelenideElement companyField = $(By.name("user_company"));
    public SelenideElement cityDropDownButton = $(By.xpath("//span[contains(text(),'City')]/parent::span"));
    public SelenideElement bucharestCityOption = $(By.xpath("//li[contains(text(),'Bucharest')]"));
    public SelenideElement positionDropDownButton = $(By.xpath("//span[contains(text(),'Position')]/parent::span"));
    public SelenideElement hearAboutEpamDropDownButton = $(By.xpath("//span[contains(text(),'How')]/parent::span"));
    public SelenideElement locationDropDownButton = $(By.xpath("(//span[contains(@class,'select2-selection__arrow')])[3]"));
    public SelenideElement careersInquiryOption = $(By.xpath("//li[contains(@class,'select')][contains(text(),'Careers')]"));
    public SelenideElement otherPositionOption = $(By.xpath("//li[contains(@class,'select')][contains(text(),'Other')]"));
    public SelenideElement romaniaLocationOption = $(By.xpath("//li[contains(@class,'select')][contains(text(),'Romania')]"));
    public SelenideElement partnerHearAboutOption = $(By.xpath("//li[contains(@class,'select')][contains(text(),'Partner')]"));
    public SelenideElement missingFieldErrorMessage = $(By.xpath("//em[@class='is-a11y-only']/following-sibling::span"));
    public SelenideElement submitButton = $(By.xpath("//button[@class='button-ui']"));
    public ElementsCollection allErrorMessages = $$(By.xpath("//em[@class='is-a11y-only']"));
    public SelenideElement cookiesPoliciesLink = $(By.xpath("//a[contains(text(),'Cookie')]"));
    public SelenideElement eventHearAboutOption = $(By.xpath("//li[contains(@class,'select')][contains(text(),'Event')]"));
    public SelenideElement incorrectEmail = $(By.xpath("//span[@class='validation-text'][contains(text(),'email')]"));
    public SelenideElement incorrectPhoneNUmber = $(By.xpath("//span[@class='validation-text'][contains(text(),'Only')]"));

    public void contactUsPageValidation() {
        String expectedUrl = "https://www.epam.com/about/who-we-are/contact";

        Assert.assertEquals(getUrl(), expectedUrl);
        Assert.assertEquals(getTitle(), "contact us");
        Assert.assertEquals(getFormTitle(), "just ask us anything");
    }

    public String getUrl() {
        return WebDriverRunner.url();
    }

    public String getTitle() {
        return titlePage.getText().trim().toLowerCase();
    }

    public String getFormTitle() {
        return formTitle.getText().trim().toLowerCase();
    }


    public ArrayList<String> inquiryListElements() {

        ArrayList<String> informationTitleList = new ArrayList<>();
        for (SelenideElement inquiryListElement : inquiryListElements) {
            informationTitleList.add(inquiryListElement.getText().toLowerCase());
        }
        return informationTitleList;
    }

    public void sendKeys(SelenideElement field, String text) {
        field.sendKeys(text);
    }

    public void clickButton(SelenideElement button) {
        button.click();
    }
}
