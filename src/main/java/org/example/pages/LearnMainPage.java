package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

public class LearnMainPage {
    private WebElement logInButton = $(By.xpath("//div[text()='Log In']"));
    private WebElement profileDropdown = $(By.xpath("//div[@id='global_menu_toggle']/preceding-sibling::div[1]"));
    private WebElement signOutButton = $(By.xpath("//div[@class='uui-caption' and text()='Sign out']"));

    public LearnLoginPage goToLoginPage(){
        logInButton.click();
        return new LearnLoginPage();
    }

    public boolean checkIsLoggedIn(){
        profileDropdown.click();
        return signOutButton.isDisplayed();
    }

    public LearnMainPage signOut(){
        signOutButton.click();
        return this;
    }
}
