package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class LearnLoginPage {

    private final SelenideElement emailField = $("#username");
    private final SelenideElement continueButton = $("#kc-login-next");
    private final SelenideElement passwordField = $("#password");
    private final SelenideElement signInButton = $("#kc-login");
    private final SelenideElement accountDetailsMessage = $("#header2");
    private final SelenideElement logInOptionMessage = $("#chooseContainer");

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
        emailField.shouldBe(Condition.enabled);
        emailField.sendKeys(email);
        continueButton.shouldBe(Condition.enabled);
        continueButton.click();
        passwordField.shouldBe(Condition.enabled);
        passwordField.sendKeys(password);
        signInButton.shouldBe(Condition.enabled);
        signInButton.click();
    }


}
