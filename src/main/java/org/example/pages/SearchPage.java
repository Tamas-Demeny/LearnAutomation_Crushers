package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import org.example.BasePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SearchPage extends BasePage {
    private SelenideElement searchBoxForm = $(By.xpath("//div[@class='search-results__input-holder']"));
    private SelenideElement findButton = $(By.xpath("//button[@class='header-search__submit']"));

    public String findButtonText(){
        return findButton.getText();
    }

    public boolean searchBoxFormVisible(){
        return searchBoxForm.isDisplayed();
    }

}

