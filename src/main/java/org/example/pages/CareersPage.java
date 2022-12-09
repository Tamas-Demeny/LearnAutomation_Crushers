package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.example.BasePage;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.Random;

import static com.codeborne.selenide.Selenide.$;

public class CareersPage extends BasePage {
    SelenideElement keywordField =
            $(By.xpath("//input[@id=\"new_form_job_search_1445745853_copy-keyword\"]"));
    SelenideElement keywordFieldWithAutocomplete =
            $(By.xpath("//div[@class=\"autocomplete-suggestion\"]"));
    SelenideElement locationField =
            $(By.xpath("//span[@class=\"select2-selection__rendered\"]"));
    SelenideElement findButton =
            $(By.xpath("//button[@class=\"recruiting-search__submit button-ui \"]"));
    SelenideElement searchResultHeading =
            $(By.xpath("//h1[@class=\"search-result__heading\"]"));
    SelenideElement searchResultErrorMessage =
            $(By.xpath("//div[@class=\"search-result__error-message\"]"));
    ElementsCollection countries =
            Selenide.$$x("(//strong[@class=\"select2-results__group\"])");
    ElementsCollection jobsByCountry =
            Selenide.$$x("//strong[@class=\"search-result__location\"]");
    SelenideElement selectedLocation =
            $(By.xpath("//span[@title[contains(.,\"All Cities\")]]"));
    SelenideElement skillsField =
            $(By.xpath("//div[@class=\"default-label\"]"));
    ElementsCollection skillOption =
            Selenide.$$x("(//span[@class=\"checkbox-custom-label\"])");

    public void sendKeysToKeywordField(String keyword) {
        keywordField.click();
        keywordField.sendKeys(keyword);
    }

    public void sendKeysWithAutocompleteSuggestions(String keyword) {
        sendKeysToKeywordField(keyword);
        keywordFieldWithAutocomplete.shouldBe(Condition.visible).click();
    }

    public void clickFind() {
        findButton.click();
    }

    public String searchResultsContainKeyword(String keyword) {
        searchResultHeading.shouldBe(Condition.visible);
        return searchResultHeading.getText().toLowerCase();
    }

    public String searchResultErrorMessage() {
        searchResultErrorMessage.shouldBe(Condition.visible,Duration.ofMillis(10000));
        return searchResultErrorMessage.getText();
    }

    public void clickLocationField() {
        locationField.shouldBe(Condition.visible);
        locationField.click();
    }

    public void clickLocationFieldAllLocations() {
        clickLocationField();
        SelenideElement locationFieldAllLocations =
                $(By.xpath("//li[@title=\"All Locations\"]"));
        locationFieldAllLocations.shouldBe(Condition.interactable);
        locationFieldAllLocations.click();
    }

    public void clickOnCountry() {
        clickLocationField();
        Random random = new Random();
        int countryNumber = random.nextInt(59) + 1;
        SelenideElement country = countries
                .get(countryNumber)
                .shouldBe(Condition.visible, Duration.ofMillis(10000));
        country.click();
        SelenideElement city =
                $(By.xpath("//li[@title=\"All Cities in " + country.getText() + "\"]"));
        city.shouldBe(Condition.exist, Duration.ofMillis(5000));
        //System.out.println(city.getText());
        city.shouldBe(Condition.visible, Duration.ofMillis(5000)).click();

    }

    public boolean returnJobsByCountry() {
        selectedLocation.shouldBe(Condition.visible,Duration.ofMillis(5000));
        String country = selectedLocation.getText().substring(14).toLowerCase();
        if (country.equals("United Arab Emirates")) {
            country = "UAE";
        }
        if (country.equals("United Kingdom")) {
            country = "UK";
        }
        if (country.equals("United States")) {
            country = "USA";
        }
        SelenideElement allCitiesRendered = $(By.xpath(" //span[@class=\"select2-selection__rendered\"]"));
        allCitiesRendered.shouldBe(Condition.exist,Duration.ofMillis(5000));
        allCitiesRendered.shouldBe(Condition.visible,Duration.ofMillis(5000));
        int numberOfJobsInCountry = jobsByCountry.size();
        //System.out.println("jobsByCountry.size() = " + numberOfJobsInCountry);
        String finalCountry = country;
        long i = jobsByCountry.stream()
                .map(x -> x.getText().toLowerCase())
                .filter(x -> x.contains(finalCountry) || x.contains("remote"))
                .count();

        return i == numberOfJobsInCountry;
    }

    public void clickSkillsField() {
        skillsField.click();
    }

    public void chooseSkillOption() {
        Random random = new Random();
        int currentOption = random.nextInt(5);
        skillOption.get(currentOption).click();
    }

    public String searchResultsAfterSkillSelection() {
        searchResultHeading.shouldBe(Condition.visible);
        return searchResultHeading.getText().toLowerCase();
    }
}
