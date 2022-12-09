package epamcomautomation.contactus;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

public class ContactUsPage /*extends BasePage*/ {

    static final SelenideElement PAGE_TITLE =
                        $(By.xpath("//h1[contains(@class,\"title-ui\")]"));
    private static final SelenideElement UNCOMPLETED_FIELD_ERROR =
                        $(By.xpath("//span[contains(text(),\"required\")]"));

}
