package org.example.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.example.BasePage;
import org.example.HelperMethods.SupportMethods;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;

public class ContactUsPage extends BasePage {
    SelenideElement titlePage = $(By.xpath("//h1[contains(@class,\"title-ui\")]"));
    SelenideElement formTitle = $(By.xpath("(//h2[contains(@class,\"title-ui\")])[1]"));
    SelenideElement inquiryDropDownList = $(By.xpath("(//b[@role=\"presentation\"])[1]"));
    ElementsCollection inquiryListElements = $$x("//li[contains(@id,\"who-we-are\")]");
    SelenideElement popup = $(By.xpath("//div[@id='onetrust-banner-sdk']"));


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
        SupportMethods.dismissCookiesPopUp();

        inquiryDropDownList.click();

        ArrayList<String> informationTitleList = new ArrayList<>();
        for (SelenideElement inquiryListElement : inquiryListElements) {
            informationTitleList.add(inquiryListElement.getText().trim().toLowerCase());
        }

        return informationTitleList;
    }
}
