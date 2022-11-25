package org.example.pages;

import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

public class LearnLoginPage {

    private WebElement emailField = $("#username");
    private WebElement continueButton = $("#kc-login-next");
    private WebElement passwordField = $("#password");
    private WebElement signInButton = $("#kc-login");

    public LearnMainPage loginViaEmail(String email, String password){
        emailField.sendKeys(email);
        continueButton.click();
        passwordField.sendKeys(password);
        signInButton.click();
        return new LearnMainPage();
    }
}
