package JunitUnterrichten.day21_JSExecuter;

import JunitUnterrichten.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
public class C03_JSExecuter_Type extends TestBase {
    /*
 Techpro education ana sayfasina git
 Arama kutusuna QA yaz
  */
    @Test
    public void sendKeysWithJSTest() {
//        Techpro education ana sayfasina git
        driver.get("https://techproeducation.com/");
//
//        try {
//            driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        bekle(3);

//        Arama kutusuna QA yaz
        WebElement searchBox = driver.findElement(By.xpath("//input[@type='search']"));

//        sendKeysJS(searchBox , "QA");
//        bekle(3);

        sendAttributeJS(searchBox, "Tester");
        bekle(3);

    }
}
