package JunitUnterrichten.day15_FileUpload_Waits;

import JunitUnterrichten.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C02_ExplicitWait extends TestBase {
    /*
    https://the-internet.herokuapp.com/dynamic_loading/1
    Start buttonuna tıklayın
    Hello World! Yazının sitede oldugunu test edin
     */


    @Test
    public void explicitWaitTest() {

//        https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

//        Start buttonuna tıklayın
        driver.findElement(By.xpath("//div[@id='start']/button")).click();

//        Hello World! Yazının sitede oldugunu test edin

//       assertTrue( driver.findElement(By.xpath("//div[@id='finish']//h4")).isDisplayed());
//       Burada implcit wait kullanıldı

        //Implicit wait ile test geçmedi. Explicit wait kullanacağız:
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement helloWorldText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));

       /* Bu kod, belirli bir XPath ifadesi ile belirtilen bir web sayfasındaki bir elementi (HTML etiketi)temsil eden

        bir WebElement
        nesnesi oluşturur.ExpectedConditions.visibilityOfElementLocated ifadesi, belirli bir By
        nesnesine(XPath, ID, vb.) göre web sayfasındaki bir elementin görünür hale gelmesini bekler.Eğer element
        görünür hale gelirse, bu metod bir WebElement nesnesi döndürür.

                Bu nesne daha sonra helloWorldText adlı değişkene atanır ve bu şekilde elementi daha
        kolay kullanabilirsiniz.
        Örneğin, bu WebElement nesnesi üzerinden elementin metin içeriğini veya diğer özelliklerini elde edebilirsiniz.

                Bu işlem, Selenium gibi web otomasyonu araçlarıyla web sayfaları üzerinde işlem yaparken oldukça
        yaygın bir şekilde kullanılır.


        */
                 Assert.assertTrue(helloWorldText.isDisplayed());

    }
}
