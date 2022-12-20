package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LearnMainPage {
    private final SelenideElement logInButton = $(By.xpath("//div[text()='Log In']"));
    private final SelenideElement profileDropdown = $(By.xpath("//div[@id='global_menu_toggle']/preceding-sibling::div[1]"));
    private final SelenideElement signOutButton = $(By.xpath("//div[@class='uui-caption' and text()='Sign out']"));
    private final SelenideElement searchField = $(".uui-input");
    private final SelenideElement acceptAllCookiesButton = $("#onetrust-accept-btn-handler");
    private final SelenideElement hsButton = $(".inAppHelpButton img").shouldBe(visible, Duration.ofMillis(5000));

    public HelpAndSupportModule goHelpAndSupportModule() {
        hsButton.click();
        return new HelpAndSupportModule();
    }

    public LearnLoginPage goToLoginPage() {
        logInButton.click();
        return new LearnLoginPage();
    }

    public boolean checkIsLoggedIn(){
        profileDropdown.click();
        return signOutButton.isDisplayed();
    }

    public void signOut() {
        signOutButton.click();
    }

    public LearnCatalogPage clickSearchField(){
        searchField.click();
        return new LearnCatalogPage();
    }

    public LearnMainPage dealWithCookies(){
        acceptAllCookiesButton.click();
        return new LearnMainPage();
    }
}
