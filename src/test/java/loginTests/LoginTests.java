package loginTests;

import basetests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.*;

public class LoginTests extends BaseTest {

    @Test (dataProvider = "Log In credentials")
    public void loginViaEmail(String email, String password){
        WebElement logInButton = $(By.xpath("//div[text()='Log In']"));
        logInButton.click();
        WebElement emailField = $("#username");
        emailField.sendKeys(email);
        WebElement continueButton = $("#kc-login-next");
        continueButton.click();
        WebElement passwordField = $("#password");
        passwordField.sendKeys(password);
        WebElement signInButton = $("#kc-login");
        signInButton.click();
        WebElement profileDropdown = $(By.xpath("//div[@id='global_menu_toggle']/preceding-sibling::div[1]"));
        profileDropdown.click();
        WebElement signOutButton = $(By.xpath("//div[@class='uui-caption' and text()='Sign out']"));
        assertTrue(signOutButton.isDisplayed(),"Sign out element is not present");
        signOutButton.click();
    }

    @DataProvider (name = "Log In credentials")
    public Object[][] getData(){
        String email ="somesortofstandup@gmail.com";
        String email2 = "deadlinecrushertestemail@gmail.com";
        String password = "SuperSecretPassword1!";
        return new Object[][] {{email, password}};
    }

    @AfterMethod (alwaysRun = true)
    public void tearDown(){
        clearBrowserCookies();
        closeWebDriver();
    }
}
