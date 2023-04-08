package yasinhoca.day13erolh;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import yasinhoca.utilities.TestBase;

public class C02_Actions extends TestBase {

     /*
    Amazon anasayfasına gidin
    "Account & List" üzerinde bekleyin (mouse over - hover over)
    Açılan menüde "Account" linkine tıklayın
    Açılan sayfanın başlığının "Your Account" içerdiğini doğrulayın
     */

    @Test
    public void actionsTest() {
//        Amazon anasayfasına gidin
        driver.get("https://www.amazon.com");

//        "Account & List" üzerinde bekleyin (mouse over - hover over)
        WebElement accountAndList = driver.findElement(By.id("nav-link-accountList"));

        Actions actions = new Actions(driver);
        actions.moveToElement(accountAndList).perform();//moveToElement() methodu "hover over" işlemini gerçekleştirir.

//        Açılan menüde "Account" linkine tıklayın
        driver.findElement(By.linkText("Account")).click();

//        Açılan sayfanın başlığının "Your Account" içerdiğini doğrulayın
        String sayfaBasligi = driver.getTitle();
        Assert.assertEquals("Your Account", sayfaBasligi);

    }

}
