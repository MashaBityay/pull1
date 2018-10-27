package yandexTests;

import org.openqa.selenium.WebDriver;
import selenium.Driver;
import org.junit.Test;
import pageFactory.Google;
import pages.YandexPage;

public class TestNew {

    @Test
    public void test() {
        YandexPage yandexPage = new YandexPage();
        yandexPage.openPage();
        Driver.getInstance().getDriver().get("https://www.google.ru/");
        Google.createPage().search("text");
    }
}
