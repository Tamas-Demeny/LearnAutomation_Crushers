package pages;


import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    private WebElement topNavBar = $(".uui-mainmenu-container");
    private WebElement homePageContent = $(By.xpath("//div[contains(@class, 'StartPage_content')]"));
    private WebElement searchBox = $(By.xpath("//input[@type='text' and @class='uui-input']"));
    private WebElement footerLandingPage = $(By.xpath("//*[contains(@class, 'test-default-text')]"));
    private String homePageURL = "https://learn.epam.com/start";

    public void clickOnTopNavBarLink(String linkName) throws InterruptedException {
        WebElement catalogLink = $(By.xpath("//div[@class='uui-caption' and text()='" + linkName + "']")).shouldBe(visible);
        catalogLink.click();
        Thread.sleep(1000);
    }

    public boolean isHomePageDisplayed() {
        return WebDriverRunner.url().equals(homePageURL)
            && topNavBar.isDisplayed()
            && searchBox.isDisplayed()
            && homePageContent.isDisplayed()
            && footerLandingPage.getText().contains("EPAM Systems");
    }

}
