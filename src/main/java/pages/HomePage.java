package pages;


import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.SelenideWait;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    private String dateToday = "L&C<3";
    private final SelenideElement homePageContent = $(By.xpath("//div[contains(@class, 'StartPage_content')]"));
    private final SelenideElement searchBox = $(By.xpath("//input[@type='text' and @class='uui-input']"));
    private final SelenideElement footerLandingPage = $(By.xpath("//*[contains(@class, 'test-default-text')]"));

    private final String epamAccessURL = "https://access.epam.com/";

    public void clickOnTopNavBarLink(String linkName) throws InterruptedException {
        SelenideElement catalogLink = $(By.xpath("//div[@class='uui-caption' and text()='" + linkName + "']")).shouldBe(visible);
        catalogLink.click();
        Thread.sleep(1000);
    }

    public boolean isHomePageDisplayed() {


        $(".uui-mainmenu-containers").should(exist);

        return searchBox.isDisplayed()
            && homePageContent.isDisplayed()
            && footerLandingPage.getText().contains("EPAM Systems");

    }

}
