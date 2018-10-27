package pages;

import org.openqa.selenium.support.FindBy;
import selenium.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.junit.Assert;
import selenium.Waits;

public class YandexPage {
    @FindBy(xpath = "//*[@class=\"button desk-notif-card__login-enter-expanded button_theme_gray i-bem\"]")
    private WebElement mainlogInButton;

    @FindBy(xpath = "//*[@name=\"login\"]")
    private WebElement loginField;
    @FindBy(xpath = "//*[@name=\"passwd\"]")
    private WebElement passwordField;
    @FindBy(xpath = "//*[@class=\"passport-Button\"]")
    private WebElement loginButton;
    @FindBy(xpath = "//*[@class=\"mail-User-Name\"]")
    private WebElement user;
    @FindBy(xpath = "//*[@class=\"passport-Domik-Form-Error passport-Domik-Form-Error_active\"]")
    private WebElement errorMessage;
    @FindBy(xpath = "//*[@id=\"nb-4\"]/div/div/div[7]")
    private WebElement logOutButton;
    @FindBy(xpath = "//*[@data-id=\"video\"]")
    private WebElement videoButton;
    @FindBy(xpath = "//div[3]/div[1]/div[2]/div/div[1]/div[1]")
    private WebElement freshVideo;
    @FindBy(xpath = "//*[@data-id=\"images\"]")
    private WebElement picturesButton;
    @FindBy(xpath = "//*/div[1]//div[2]/div[2]//div/a[2]")
    private WebElement myCollections;
    @FindBy(xpath = "//*[@data-id=\"news\"]")
    private WebElement newsButton;
    @FindBy(xpath = "//*[@id=\"page\"]/div[2]//div[1]/a[2]")
    private WebElement newsLogo;
    @FindBy(xpath = "//*[@data-id=\"maps\"]")
    private WebElement mapsButton;
    @FindBy(xpath = "//*[@class=\"input_air-search-large__control\"]")
    private WebElement searchPlace;
    @FindBy(xpath = "//*[@data-id=\"market\"]")
    private WebElement marketButton;
    @FindBy(xpath = "/html//div[1]//div[1]/noindex/div[2]/div/div[1]/a[2]/span")
    private WebElement marketLogo;
    @FindBy(xpath = "//*[@data-id=\"translate\"]")
    private WebElement tranclateButton;
    @FindBy(xpath = "//*[@id=\"header\"]/div[1]/a[2]/span")
    private WebElement tranclateLogo;
    @FindBy(xpath = "//*[@data-id=\"music\"]")
    private WebElement musicButton;
    @FindBy(xpath = "//*[@id=\"nb-1\"]/body/div[1]/div[3]//div[1]/input")
    private WebElement musicSearch;
    @FindBy(xpath = "/html/body/div[1]/div[2]//div[3]//div[1]/div/a")
    private WebElement languageButton;
    @FindBy(xpath = "/html/body/div[4]/div[2]/div/ul/li[4]/div/a")
    private WebElement moreLanguage;
    @FindBy(xpath = "//*[@id=\"form__a11y\"]/div[1]/div/div[1]/div[1]")
    private WebElement languageListButton;
    @FindBy(xpath = "//*[@value=\"en\"]")
    private WebElement EN;
    @FindBy(xpath = "//*[@id=\"form__a11y\"]/div[2]/div/button")
    private WebElement saveButton;

    private WebDriver driver = Driver.getInstance().getDriver();

    public void openPage() {
        driver.get("https://yandex.by/");
    }

    public void logInButtonClick() {
         Waits.afterClicable(mainlogInButton).click();
    }

    public void setLoginAndPassword(String login, String password) {
        Waits.afterClicable(loginField).click();
        loginField.clear();
        loginField.sendKeys(login);
        passwordField.clear();
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void verifyUser() {
        new Waits().afterClicable(user).click();
        Assert.assertEquals(user.getText(), "AutotestUser");
    }

    public void logOut() {
        user.click();
        new Waits().afterClicable(logOutButton).click();
        new Waits().afterClicable(mainlogInButton);
        Assert.assertTrue(mainlogInButton.isDisplayed());
    }

    public void verifyErrorPasswordMessage() {
        new Waits().afterPresent(errorMessage);
        System.out.println(errorMessage.getText());
        Assert.assertTrue(errorMessage.getText().equals("Неверный пароль"));
    }

    public void verifyErrorLoginMessage() {
        new Waits().afterPresent(errorMessage);
        System.out.println(errorMessage.getText());
        Assert.assertTrue(errorMessage.getText().equals("Такого аккаунта нет"));
    }

    public void navigation() {
        new Waits().afterClicable(videoButton).click();
        new Waits().afterPresent(freshVideo);
        Assert.assertTrue(freshVideo.getText().equals("Свежее видео"));
        driver.navigate().back();

        new Waits().afterClicable(picturesButton).click();
        new Waits().afterClicable(myCollections);
        Assert.assertTrue(myCollections.getText().equals("Мои коллекции"));
        driver.navigate().back();

        new Waits().afterClicable(newsButton).click();
        new Waits().afterPresent(newsLogo);
        Assert.assertTrue(newsLogo.getAttribute("title").equals("Новости"));
        driver.navigate().back();

        new Waits().afterClicable(mapsButton).click();
        new Waits().afterPresent(searchPlace);
        Assert.assertTrue(searchPlace.getAttribute("placeholder").equals("Поиск мест и адресов"));
        driver.navigate().back();

        new Waits().afterClicable(marketButton).click();
        new Waits().afterPresent(marketLogo);
        Assert.assertTrue(marketLogo.getText().equals("Маркет"));
        driver.navigate().back();

        new Waits().afterClicable(tranclateButton).click();
        new Waits().afterPresent(tranclateLogo);
        Assert.assertTrue(tranclateLogo.getText().equals("Переводчик"));
        driver.navigate().back();

        new Waits().afterClicable(musicButton).click();
        new Waits().afterPresent(musicSearch);
        Assert.assertTrue(musicSearch.getAttribute("placeholder").equals("Трек, альбом, исполнитель"));
    }

    public void clickOnLanguage() {
        new Waits().afterClicable(languageButton).click();
    }

    public void goToChangeLanguagePage() {
        new Waits().afterClicable(moreLanguage).click();
    }

    public void changeLanguage() throws InterruptedException {
        new Waits().afterClicable(languageListButton).click();
        new Waits().afterPresent(EN);
        System.out.println(EN.isDisplayed());
        Thread.sleep(2000);

        Select CompanyOptions = new Select(driver.findElement(By.xpath("//*[@id=\"form__a11y\"]/div[1]/div/div[1]/div[1]/select")));
        CompanyOptions.selectByVisibleText("English");
        //ENButton.click();
        //WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(saveButtonLocator));
        //saveButton.click();
    }


}
