package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {

    public static WebDriverWait get () {
        WebDriverWait wait = new WebDriverWait(Driver.getInstance().getDriver(),15);
       return wait;
    }

    public WebElement afterClicable (By locator) {
       return get().until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static WebElement afterClicable (WebElement element) {
        return get().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement afterPresent (WebElement element) {
        return get().until(ExpectedConditions.visibilityOf(element));
    }
}
