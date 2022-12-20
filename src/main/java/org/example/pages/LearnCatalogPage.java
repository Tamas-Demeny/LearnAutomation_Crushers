package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class LearnCatalogPage {

    private final SelenideElement searchField = $(".uui-input");
    private final SelenideElement firstSearchResult = $("div[class*='BigCard_content']");

    private final SelenideElement logInToStudyButton = $(By.xpath("//div[text()='Log in to study']"));

    public LearnLoginPage goToWebdriverCourse() {
        searchField.sendKeys("webdriver" + Keys.ENTER);
        firstSearchResult.click();
        logInToStudyButton.shouldBe(Condition.appear);
        logInToStudyButton.click();
        return new LearnLoginPage();

    }
}
