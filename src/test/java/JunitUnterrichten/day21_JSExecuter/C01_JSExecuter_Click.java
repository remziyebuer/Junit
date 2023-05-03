package JunitUnterrichten.day21_JSExecuter;

import JunitUnterrichten.utilities.TestBase;
import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


import static org.junit.Assert.assertEquals;

public class C01_JSExecuter_Click extends TestBase {
     /*
    http://www.uitestpractice.com/Students/Form sayfasına git
    Formu doldur
    Submit tuşuna tıkla
    Sayfa adresinin "http://www.uitestpractice.com/Students/Form?optradio=on" olduğunu doğrula.
    */
     @Test
     public void clickByJSTest(){
//        http://www.uitestpractice.com/Students/Form sayfasına git
         driver.get("http://www.uitestpractice.com/Students/Form");

         //        Formu doldur
         driver.findElement(By.id("firstname")).sendKeys(Faker.instance().name().firstName());
         driver.findElement(By.id("lastname")).sendKeys(Faker.instance().name().lastName());
         driver.findElement(By.id("email")).sendKeys(Faker.instance().internet().emailAddress());
         //Gerisi ödev...//burda instance kullandigimiz icin obje olusturmaya gerek yok ama
         // isterseniz obje olusturupta yapabilirsiniz.

//        Submit tuşuna tıkla
         WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']"));
         //submitButton.click(); //ElementClickInterceptedException ==> Selenium click() çalışmadı,manuel yaptim
         // ama sorun yok yani submit calisiyor otmasyonum bunu yapamiyor.bunu Selenium ile yapamiyorum. Bu yüzden
         // JS Executer deniyorum(baska yollarla da olur enter ve scroll arastir?):

        //Driver'ı JavascriptExecutor classına "cast" ediyoruz:

        JavascriptExecutor jsExecuter = (JavascriptExecutor) driver;

        //executeScript() metodu ile uygun script'i çalıştırıyoruz:
        jsExecuter.executeScript("arguments[0].click();",submitButton);
        //"arguments[0].click();" bu baska bir dilden gelen bir syntax bir karakter unutulursa hata verir.

         //click metodu oluşturarak gerekli yerlerde tıklama yapabiliriz:
         //click(submitButton);//TestBase classında click() methodu olusturduk ve kullandik.

//        Sayfa adresinin "http://www.uitestpractice.com/Students/Form?optradio=on" olduğunu doğrula.
         assertEquals("http://www.uitestpractice.com/Students/Form?",driver.getCurrentUrl());





     }

}
