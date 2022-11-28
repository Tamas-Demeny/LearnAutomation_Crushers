package helpSupportTests;

import basetests.BaseTest;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.conditions.Visible;
import com.codeborne.selenide.impl.WebDriverContainer;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
public class HStest extends BaseTest {

    @Test
    public void openHS() throws InterruptedException {
        WebElement hsButton = $(".inAppHelpButton img");
        Thread.sleep(5000);
        hsButton.click();
        Thread.sleep(5000);
    }

    @Test
    public void sendEmailAndMessageHS() throws InterruptedException {
        WebElement iframe = $("[src=\"https://menu.epam.com/inapphelp/PublicMode?app=learn-public&lang=en\"]");
        WebElement hsButton = $(".inAppHelpButton img");
        Thread.sleep(5000);
        hsButton.click();
        Thread.sleep(5000);
        WebDriverRunner.getWebDriver().switchTo().frame(iframe);
        SelenideElement emailField = $("input[placeholder='Your email']");
        emailField.click();
        emailField.sendKeys("andrapurcarea@gmail.com");
        SelenideElement messageField = $( "textarea[maxlength='2000']");
        messageField.click();
        messageField.sendKeys("I can't access something");
    }

    @Test
    public void verifyHomeTabHS() throws InterruptedException {
        WebElement iframe = $("[src=\"https://menu.epam.com/inapphelp/PublicMode?app=learn-public&lang=en\"]");
        WebElement hsButton = $(".inAppHelpButton img");
        Thread.sleep(5000);
        hsButton.click();
        Thread.sleep(5000);
        WebDriverRunner.getWebDriver().switchTo().frame(iframe);
        WebElement homeTab = $("a[class='wZhsh3W inapphelp-tab']");
        Thread.sleep(5000);
        homeTab.click();
        WebElement contactSupportMessage = $(".inapphelp-card__description");
        Assert.assertEquals(contactSupportMessage.getText(),"Encountered a bug or got a question? We're here to help.");
    }

    @Test
    public void contactSupportAppears() throws InterruptedException {
        WebElement iframe = $("[src=\"https://menu.epam.com/inapphelp/PublicMode?app=learn-public&lang=en\"]");
        WebElement hsButton = $(".inAppHelpButton img");
        Thread.sleep(5000);
        hsButton.click();
        Thread.sleep(5000);
        WebDriverRunner.getWebDriver().switchTo().frame(iframe);
        WebElement homeTab = $("a[class='wZhsh3W inapphelp-tab']");
        Thread.sleep(5000);
        homeTab.click();
        WebElement ContactSupportTab = $("p[class='_2R20rIA inapphelp-card__description']");
        ContactSupportTab.click();
        SelenideElement emailField = $("input[placeholder='Your email']");
        Thread.sleep(5000);
        SelenideElement messageField = $( "textarea[maxlength='2000']");
        Thread.sleep(5000);
        Assert.assertTrue(emailField.isDisplayed()&messageField.isDisplayed());

    }
}
