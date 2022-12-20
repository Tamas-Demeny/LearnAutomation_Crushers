package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.*;
import static org.example.utils.TypesOfData.VALID_INPUT;

public class SearchPage{
    private SelenideElement search = $(By.xpath("//input[@type='text' and @class='uui-input']"));
    private final List<SelenideElement> items = $$(By.xpath("//*[contains(@class, '_1jkUn uui-anchor uui-enabled -clickable')]"));
    private List<SelenideElement> allItems =  $$(By.xpath("//div[contains(@class,'languageIcon')]"));
    private SelenideElement errorMessage = $(By.xpath("//div[@class=\"_2Q97x _2CS__ veTRe yezNZ _1c32B _3wIsL gtN2w\"]"));
    private SelenideElement message = $(By.xpath("//*[@class= \"FilteredListPage_foundedItems__1dZNu\"]"));
    private SelenideElement catalogButton = $(By.xpath("//*[contains(@class,'_3oTQO uui-button-box uui-enabled uui-active -clickable _1MJpy')]"));
    private SelenideElement popup = $(By.xpath("//*[contains(@class,'ot-sdk-container')]"));
    private SelenideElement clearButton = $(By.xpath("//*[contains(@class,'_2XWJb uui-icon uui-enabled -clickable uui-icon-cancel -clickable')]"));

    //private WebElement footer = webdriver().object().findElement(By.xpath("//*[contains(@class,'_1aD3T _1UxEF')]"));

    private WebElement footer = $(By.xpath("//*[contains(@class,'_1aD3T _1UxEF')]"));
    public boolean checkCurrentUrl() {
        Pattern r = Pattern.compile("=([^=]*)$");
        Matcher m = r.matcher(WebDriverRunner.url());
        return m.find();
    }

    public SearchPage clickSearch() {
        search.click();
        return this;
    }

    public SearchPage enterSearchInput(String input) {
        search.sendKeys(input);
        return this;
    }

    public boolean checkAtLeastOneResultFound() {
        items.get(1).shouldBe(Condition.visible);
        int counter = 0;
        for (SelenideElement item : items) {
            if (item.getText().toLowerCase().contains(VALID_INPUT)) {
                counter++;
            }
        }
        return counter > 0;
    }

    public boolean checkErrorMessageIsDisplayed(){
        errorMessage.shouldBe(Condition.visible);
        return errorMessage.isDisplayed();
    }

    private int extractCounterFromText(SelenideElement text){
        Pattern p1 = Pattern.compile("\\d+");
        Matcher m1 = p1.matcher(text.getText());

        int result = 0;
        if (m1.find()) {
            result = Integer.parseInt(m1.group());
        }
        return result;
    }

    //waitForResultsToLoad
    //sa verificam daca primul element care e in lista, sa fi disparut

    public boolean checkIfResultsCounterMatches(){
        int result1 = extractCounterFromText(message);
        int result2 = extractCounterFromText(catalogButton);
        return result1 == result2;
    }

    public SearchPage acceptCookies(){
        popup.shouldBe(Condition.visible, Duration.ofSeconds(20));
        if (popup.isDisplayed()) {
            SelenideElement acceptButton = $(By.xpath("//*[@id='onetrust-accept-btn-handler']"));
            acceptButton.click();
        }
        return this;
    }

    public SearchPage clearSearch(){
        clearButton.click();
        return this;
    }

    public SearchPage scrollToFooter(int maxCounter){
        int counter = 0;
        while (counter <= maxCounter) {
            new Actions(webdriver().driver().getWebDriver())
                    .scrollToElement(footer)
                    .perform();
            counter++;
        }
        return this;
        //allItems = $$(By.xpath("//div[contains(@class,'languageIcon')]"));
    }

    public int getResultsListSize(){
        return allItems.size();
    }

    public boolean checkCounterMatchesResultsListSize(){
        int result = extractCounterFromText(message);
        int listSize = getResultsListSize();
        return result == listSize;
    }
}
