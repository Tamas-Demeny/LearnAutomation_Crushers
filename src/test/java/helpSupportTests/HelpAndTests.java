package helpSupportTests;
import basetests.BaseTest;
import org.apache.commons.lang3.RandomStringUtils;
import org.example.pages.HelpAndSupportModule;
import org.example.pages.LearnMainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HelpAndTests extends BaseTest {

    @Test
    public void openHs() {
        HelpAndSupportModule page = new LearnMainPage()
                .goHelpAndSupportModule();
    }

    @Test
    public void sendEmailAndMessageHS()  {
        HelpAndSupportModule page = new LearnMainPage()
                .goHelpAndSupportModule()
                .switchToIframe()
                .sendEmail("andrapurcarea@gmail.com")
                .sendMessage("I can't access something");
        Assert.assertTrue(page.checkEmailandMessage("andrapurcarea@gmail.com","I can't access something"));

    }

    @Test
    public void verifyHomeTabHS() {
        HelpAndSupportModule page = new LearnMainPage()
                .goHelpAndSupportModule()
                .switchToIframe()
                .homeTab();
        Assert.assertEquals(page.getContactSupportMessage(), "Encountered a bug or got a question? We're here to help.");
    }

    @Test
    public void contactSupportAppears() {
        HelpAndSupportModule page = new LearnMainPage()
                .goHelpAndSupportModule()
                .switchToIframe()
                .homeTab()
                .contactSupportMessage();
        Assert.assertTrue(page.isDisplayEmailandMessage());

    }

    @Test
    public void numberOfCharactersMessage1() {
        HelpAndSupportModule page = new LearnMainPage()
                .goHelpAndSupportModule()
                .switchToIframe()
                .sendMessage(getUniqueString(5));
        Assert.assertEquals(page.getTextCharacterNumber(), getUniqueString(5).chars().count()+" / 2000");
    }

    @Test
    public void numberOfCharactersMessage2() {
        HelpAndSupportModule page = new LearnMainPage()
                .goHelpAndSupportModule()
                .switchToIframe()
                .sendMessage(getUniqueString(2006));
        Assert.assertEquals(page.getTextCharacterNumber(), "2000 / 2000");
    }

    @Test
    public void sendMessageHS() {
        HelpAndSupportModule page = new LearnMainPage()
                .goHelpAndSupportModule()
                .switchToIframe()
                .sendMessage(getUniqueString(6))
                .switchToIframe1()
                .captchaVerification()
                .returnToIframe()
                .sendButton();
        Assert.assertEquals(page.inputAlertGetText(), "Input your email");

    }
    public static String getUniqueString(int length) {
        return RandomStringUtils.random(length,"abcdefgh");
    }
}
