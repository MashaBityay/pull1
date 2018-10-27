package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    private WebDriver driver;
   private static  Driver instance;
   public static Driver getInstance() {
        if(instance==null) instance = new Driver();
        return  instance;
    }
    private  Driver() {}
    public static  WebDriver create (String brawserName) {
         WebDriver driver = null;
        if ("Chrome".equals(brawserName)) {
              driver = new ChromeDriver();
    } else if ("FireFox".equals(brawserName)) {
             driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        return driver;
    }
    public  WebDriver getDriver (){
        if(driver==null) driver= create("Chrome");
        return driver;

    }
}
