package basetests;
import org.apache.commons.lang3.RandomStringUtils;
import org.example.pages.HelpAndSupportModule;
import org.example.pages.LearnMainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HelpAndSupportTests extends BaseTest {

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
        Assert.assertTrue(page.CheckEmailandMessage("andrapurcarea@gmail.com","I can't access something"));

    }

    @Test
    public void verifyHomeTabHS() {
        HelpAndSupportModule page = new LearnMainPage()
                .goHelpAndSupportModule()
                .switchToIframe()
                .HomeTab();
        Assert.assertEquals(page.GetContactSupportMessage(), "Encountered a bug or got a question? We're here to help.");
    }

    @Test
    public void contactSupportAppears() {
        HelpAndSupportModule page = new LearnMainPage()
                .goHelpAndSupportModule()
                .switchToIframe()
                .HomeTab()
                .ContactSupportMessage();
        Assert.assertTrue(page.IsDisplayEmailandMessage());

    }

    @Test
    public void numberOfCharactersMessage1() {
        HelpAndSupportModule page = new LearnMainPage()
                .goHelpAndSupportModule()
                .switchToIframe()
                .sendMessage(getUniqueString(5));
        Assert.assertEquals(page.GetTextCharacterNumber(), getUniqueString(5).chars().count()+" / 2000");
    }

    @Test
    public void numberOfCharactersMessage2() {
        HelpAndSupportModule page = new LearnMainPage()
                .goHelpAndSupportModule()
                .switchToIframe()
                .sendMessage(getUniqueString(2006));
        Assert.assertEquals(page.GetTextCharacterNumber(), "2000 / 2000");
    }

    @Test
    public void sendMessageHS() {
        HelpAndSupportModule page = new LearnMainPage()
                .goHelpAndSupportModule()
                .switchToIframe()
                .sendMessage(getUniqueString(6))
                .switchToIframe1()
                .CaptchaVerification()
                .returnToIframe()
                .SendButton();
        Assert.assertEquals(page.InputAlertGetText(), "Input your email");

    }
    public static String getUniqueString(int length) {
        return RandomStringUtils.random(length,"abcdefgh");
    }
}
