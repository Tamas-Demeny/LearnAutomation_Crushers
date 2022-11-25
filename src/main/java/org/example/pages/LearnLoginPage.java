package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class LearnLoginPage {

    private WebElement emailField = $("#username");
    private SelenideElement continueButton = $("#kc-login-next");
    private WebElement passwordField = $("#password");
    private WebElement signInButton = $("#kc-login");
    private SelenideElement accountDetailsMessage = $("#header2");
    private SelenideElement logInOptionMessage = $("#chooseContainer");

    public LearnMainPage loginViaEmail(String email, String password){
        logInFlow(email, password);
        return new LearnMainPage();
    }
    public String logInWithWrongPassword(String email, String password){
        logInFlow(email, password);
        WebElement checkYourCredentialsMessage = $(".error-text").shouldBe(Condition.visible);
        return checkYourCredentialsMessage.getText();
    }

    public String logInWithNonexistentEmail(String email){
        emailField.sendKeys(email);
        continueButton.click();
        accountDetailsMessage.should(Condition.appear, Duration.ofSeconds(10));
        return accountDetailsMessage.getText();

    }

    public SelenideElement checkContinueButtonIsDisabled(){
        return continueButton.shouldBe(Condition.visible);
    }

    public boolean checkIsOnLoginPage(){
        logInOptionMessage.shouldBe(Condition.appear);
       return logInOptionMessage.isDisplayed();
    }
    private void logInFlow(String email, String password){
        emailField.sendKeys(email);
        continueButton.click();
        passwordField.sendKeys(password);
        signInButton.click();
    }


}
