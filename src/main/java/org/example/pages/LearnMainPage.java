package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

public class LearnMainPage {
    private WebElement logInButton = $(By.xpath("//div[text()='Log In']"));
    private WebElement emailField = $("#username");
    private WebElement continueButton = $("#kc-login-next");
    private WebElement passwordField = $("#password");
    private WebElement signInButton = $("#kc-login");

    public LearnLoginPage goToLoginPage(){
        return new LearnLoginPage();
    }
}
