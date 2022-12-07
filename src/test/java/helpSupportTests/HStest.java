package helpSupportTests;

import basetests.BaseTest;
import com.codeborne.selenide.*;
import com.codeborne.selenide.commands.ShouldBe;
import com.codeborne.selenide.conditions.Visible;
import com.codeborne.selenide.impl.WebDriverContainer;
import org.apache.commons.lang3.RandomStringUtils;
import org.example.Main;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class HStest extends BaseTest {

    @Test
    public void openHS() throws InterruptedException {
        WebElement hsButton = $(".inAppHelpButton img").shouldBe(visible, Duration.ofMillis(5000));
        hsButton.click();
    }

    @Test
    public void sendEmailAndMessageHS() throws InterruptedException {
        WebElement iframe = $("[src=\"https://menu.epam.com/inapphelp/PublicMode?app=learn-public&lang=en\"]");
        WebElement hsButton = $(".inAppHelpButton img").shouldBe(visible, Duration.ofMillis(5000));;
        hsButton.click();
        WebDriverRunner.getWebDriver().switchTo().frame(iframe);
        SelenideElement emailField = $("input[placeholder='Your email']").shouldBe(visible, Duration.ofMillis(5000));;
        emailField.click();
        emailField.sendKeys("andrapurcarea@gmail.com");
        SelenideElement messageField = $( "textarea[maxlength='2000']").shouldBe(visible, Duration.ofMillis(5000));;
        messageField.click();
        messageField.sendKeys("I can't access something");
    }

    @Test
    public void verifyHomeTabHS() throws InterruptedException {
        WebElement iframe = $("[src=\"https://menu.epam.com/inapphelp/PublicMode?app=learn-public&lang=en\"]");
        WebElement hsButton = $(".inAppHelpButton img").shouldBe(visible, Duration.ofMillis(5000));
        hsButton.click();
        WebDriverRunner.getWebDriver().switchTo().frame(iframe);
        WebElement homeTab = $("a[class='wZhsh3W inapphelp-tab']").shouldBe(visible, Duration.ofMillis(5000));
        homeTab.click();
        WebElement contactSupportMessage = $(".inapphelp-card__description").shouldBe(visible, Duration.ofMillis(5000));
        Assert.assertEquals(contactSupportMessage.getText(),"Encountered a bug or got a question? We're here to help.");
    }

    @Test
    public void contactSupportAppears() throws InterruptedException {
        WebElement iframe = $("[src=\"https://menu.epam.com/inapphelp/PublicMode?app=learn-public&lang=en\"]");
        WebElement hsButton = $(".inAppHelpButton img").shouldBe(visible, Duration.ofMillis(5000));
        hsButton.click();
        WebDriverRunner.getWebDriver().switchTo().frame(iframe);
        WebElement homeTab = $("a[class='wZhsh3W inapphelp-tab']").shouldBe(visible, Duration.ofMillis(5000));
        homeTab.click();
        WebElement ContactSupportTab = $("p[class='_2R20rIA inapphelp-card__description']").shouldBe(visible, Duration.ofMillis(5000));
        ContactSupportTab.click();
        SelenideElement emailField = $("input[placeholder='Your email']").shouldBe(visible, Duration.ofMillis(5000));
        SelenideElement messageField = $( "textarea[maxlength='2000']").shouldBe(visible, Duration.ofMillis(5000));
        Assert.assertTrue(emailField.isDisplayed()&messageField.isDisplayed());
    }

    @Test
    public void attachFile() throws InterruptedException {
        WebElement iframe = $("[src=\"https://menu.epam.com/inapphelp/PublicMode?app=learn-public&lang=en\"]");
        WebElement hsButton = $(".inAppHelpButton img").shouldBe(visible, Duration.ofMillis(5000));
        hsButton.click();
        WebDriverRunner.getWebDriver().switchTo().frame(iframe);
        WebElement attachFile = $(By.xpath("//*[@class='RvKo0zJ']")).shouldBe(visible, Duration.ofMillis(5000));
        attachFile.click();
        Thread.sleep(5000);
        Selenide.closeWindow();
    }

    @Test
    public void numberOfCharactersMessage1() throws  InterruptedException {

        WebElement iframe = $("[src=\"https://menu.epam.com/inapphelp/PublicMode?app=learn-public&lang=en\"]");
        WebElement hsButton = $(".inAppHelpButton img").shouldBe(visible, Duration.ofMillis(5000));
        hsButton.click();
        WebDriverRunner.getWebDriver().switchTo().frame(iframe);
        SelenideElement messageField = $( "textarea[maxlength='2000']").shouldBe(visible, Duration.ofMillis(5000));
        messageField.click();
        messageField.sendKeys(getUniqueString(5));
        SelenideElement charactersNumbers = $(By.xpath("//*[@class='PN66Kz+ inapphelp-textarea-counter']")).shouldBe(visible, Duration.ofMillis(5000));
        Assert.assertEquals( charactersNumbers.getText(), getUniqueString(5).chars().count()+" / 2000");
    }

    @Test
    public void numberOfCharactersMessage2() throws  InterruptedException {

        WebElement iframe = $("[src=\"https://menu.epam.com/inapphelp/PublicMode?app=learn-public&lang=en\"]");
        WebElement hsButton = $(".inAppHelpButton img");
        hsButton.click();
        WebDriverRunner.getWebDriver().switchTo().frame(iframe);
        SelenideElement messageField = $( "textarea[maxlength='2000']");
        messageField.click();
        messageField.sendKeys(getUniqueString(2006));
        SelenideElement charactersNumbers = $(By.xpath("//*[@class='PN66Kz+ inapphelp-textarea-counter']"));
        Assert.assertEquals(charactersNumbers.getText(),"2000 / 2000");
    }

    public static String getUniqueString(int length) {
        return RandomStringUtils.random(length,"abcdefgh");
    }

    @Test
    public void sendMessageHS() throws InterruptedException {
        WebElement iframe = $("[src=\"https://menu.epam.com/inapphelp/PublicMode?app=learn-public&lang=en\"]");
        WebElement hsButton = $(".inAppHelpButton img").shouldBe(visible, Duration.ofMillis(5000));;
        hsButton.click();
        WebDriverRunner.getWebDriver().switchTo().frame(iframe);
        SelenideElement messageField = $( "textarea[maxlength='2000']").shouldBe(visible, Duration.ofMillis(5000));
        messageField.click();
        messageField.sendKeys("efsesEFsdsd");
        WebElement iframe1 = $(By.xpath("(*//div[@class='xlvBa4A CIIo+ZN']//*)[4]")).shouldBe(visible, Duration.ofMillis(5000));
        WebDriverRunner.getWebDriver().switchTo().frame(iframe1);
        SelenideElement captchaVerification = $(By.xpath("(//div[@class='rc-anchor-center-container']//*)[3]"));
        captchaVerification.click();
        Thread.sleep(5000);
        WebElement iframe2 = $(By.xpath("(*//div[@id='modal-sidebar-frame-container']/*)[2]"));
        WebDriverRunner.getWebDriver().switchTo().frame(iframe2);
        SelenideElement sendButton = $(By.xpath("*//div[@class='xlvBa4A CIIo+ZN']/following-sibling::*")).shouldBe(visible, Duration.ofMillis(5000));
        sendButton.click();
        SelenideElement inputAlert = $(By.xpath("//div[contains(text(), 'Input your email')]")).shouldBe(visible, Duration.ofMillis(5000));
        Assert.assertEquals(inputAlert.getText(), "Input your email");
    }


}
