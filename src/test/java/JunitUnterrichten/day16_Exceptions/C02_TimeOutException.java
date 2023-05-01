package JunitUnterrichten.day16_Exceptions;


import JunitUnterrichten.utilities.TestBase;
import org.junit.Test;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C02_TimeOutException extends TestBase {

    @Test
    public void timeOutExceptionTest() {
        driver.get("https://www.techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//Reklamı kapatıyorum

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("Yanlış Locator")));//org.openqa.selenium.TimeoutException
        //TimeoutException "explicit wait" kullanımında web element bulunamadığı zaman alınır.
    }

    @Test
    public void timeOutExcepitonTest2(){
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.xpath("//div[@id='start']//button")).click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
        boolean isTrue = wait.until(ExpectedConditions.textToBe(By.xpath("//div[@id='finish']//h4"),"Hello World!"));//org.openqa.selenium.TimeoutException
        //Locator doğru ama yeterli bekleme süresi olmadığı için TimeoutException alıyoruz.
        System.out.println(isTrue);

    }


    //EROL HOCANIN ALTERNATIF CLASSI
//    @Test
//    public void TimeOutExceptionTest1() {
//        /*
//        TimeOutException:
//            Sayfada aradığımız elementi wait ile belirlediğimiz max. sürede bulamadığı durumda
//        TimeOutException hatası alırız.
//         */
//        driver.get("https://techproeducation.com");
//        bekle(5);
//        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();//Reklam kapatmak için
//
//        //TimeOutException alabilmek için visibleofelementlocator methodunu kullanarak yanlis bir locate aldık
//        visibleWait(By.id("Yanlis Locate"),15);//org.openqa.selenium.TimeoutException:
//        //Webelementi beklerlerken o webelemtin locati'ni bulamadığı için max. belirttiğimiz süre kadar bekler ve
//        //org.openqa.selenium.TimeoutException hatasını verir
//
//        /*
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@type='ssearch']")));
//         */
//
//    }
//
//    @Test
//    public void TimeOutExceptionTest2() {
//        //https://the-internet.herokuapp.com/dynamic_loading/1 adresine gidelim
//        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
//
//        //start butonuna tıklayalım
//        driver.findElement(By.xpath("//*[.='Start']")).click();
//
//        //Hello World textinin çıktığını doğrulayınız
//        WebElement helloWorldText = driver.findElement(By.xpath("(//h4)[2]"));
//        /*
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
//        wait.until(ExpectedConditions.visibilityOf(helloWorldText));
//         */
//        visibleWait(helloWorldText,2);//org.openqa.selenium.TimeoutException:
//        //HelloWorld yazıdı ortalama 6 saniyede gözüktüğü için explicit waitte max. 2 saniye verdiğimizden dolayı
//        //org.openqa.selenium.TimeoutException hatası aldık
//        Assert.assertTrue(helloWorldText.isDisplayed());
//
//    }
}
