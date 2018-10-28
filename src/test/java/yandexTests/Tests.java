package yandexTests;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import pages.YandexPage;
import selenium.Driver;

public class Tests {
    int a =0 ;

    @Test
    public void NavigationOnPage () {
        YandexPage yandexPage = PageFactory.initElements(Driver.getInstance().getDriver(), YandexPage.class);
        yandexPage.openPage();
        yandexPage.navigation();
    }
    @Test
    public void LogIn() {
        YandexPage yandexPage = PageFactory.initElements(Driver.getInstance().getDriver(), YandexPage.class);
        yandexPage.openPage();
        yandexPage.logInButtonClick();
        yandexPage.setLoginAndPassword( "AutotestUser", "AutotestUser123");
        yandexPage.verifyUser();
        yandexPage.logOut();
        a = 1;
    }
   // @Test
   // public void IncorrectLoginAndPassword() {
    //    YandexPage yandexPage = PageFactory.initElements(Driver.getInstance().getDriver(), YandexPage.class);
    //    yandexPage.openPage();
    //    yandexPage.logInButtonClick();
    //    //if (a==1)
     //   yandexPage.choiseOtherAccount();
      //  yandexPage.setLoginAndPassword("AutotestUser", "NoAutotestUser123");
      //  yandexPage.verifyErrorPasswordMessage();
      //  yandexPage.setLoginAndPassword( "NoAutotestUser", "AutotestUser123");
       // yandexPage.verifyErrorLoginMessage();
   // }


  //  @Test
 //   public void ChangeLanguage() throws InterruptedException {
      //  YandexPage yandexPage = PageFactory.initElements(Driver.getInstance().getDriver(), YandexPage.class);
      //  yandexPage.openPage();
       // yandexPage.clickOnLanguage();
        //yandexPage.goToChangeLanguagePage();
       //// yandexPage.changeLanguage();
    //}

}
