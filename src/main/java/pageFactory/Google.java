package pageFactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.YandexPage;
import selenium.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.Waits;

public class Google {
    @FindBy( id = "q")
    private WebElement search ;

    public void search(String text) {
        new Waits().afterClicable(search).sendKeys(text);
    }

    public static Google createPage () {
        return PageFactory.initElements(Driver.getInstance().getDriver(), Google.class);
    }

}
