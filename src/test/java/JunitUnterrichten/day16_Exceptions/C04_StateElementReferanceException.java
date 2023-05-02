package JunitUnterrichten.day16_Exceptions;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import JunitUnterrichten.utilities.TestBase;

import java.util.List;

public class C04_StateElementReferanceException extends TestBase {
    /*
        StaleElementReferanceException:
               Bir web sayfasındaki bir webelementin geçerliliğinin kaybolduğu durumlarda oluşur.
            Yani bir webelementi locate ettikten sonra sayfada refresh yada back-forward kullanıyorsak
            yeniden o elemente ulaşmak istediğimizde bu hatayı alırız. Bunu handle edebilmek için
            webelemente yeniden aynı locate'i atamalıyız.(Webelementin locate'ini hatırlatma gibi diyebiliriz)
     */

    @Test
    public void staleElementExceptionTest() {

        driver.get("https://www.techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        driver.navigate().refresh();

        WebElement lmsLogin = driver.findElement(By.linkText("LMS LOGIN"));
        lmsLogin.click();//Çalıştı

    }

    @Test
    public void staleElementExceptionTest2() {

        driver.get("https://www.techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        WebElement lmsLogin = driver.findElement(By.linkText("LMS LOGIN"));
        driver.navigate().refresh();
        lmsLogin.click();//org.openqa.selenium.StaleElementReferenceException
        //Locator doğru fakat adres refresh sonrası silindiği için "lmsLogin" container'ı artık kullanılamaz. Yeniden locate gerekir.
    }

    @Test
    public void staleElementExceptionTest3() {

        driver.get("https://www.techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        WebElement lmsLogin = driver.findElement(By.linkText("LMS LOGIN"));
        lmsLogin.click();

        driver.navigate().back();//techproeducation.com sayfasına geri döndüm ==> Sayfa yeniden yüklendiği için locator adresi silindi.
        lmsLogin.click();//org.openqa.selenium.StaleElementReferenceException
    }

    @Test
    public void staleElementExceptionTest4() {

        driver.get("https://www.techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        WebElement lmsLogin = driver.findElement(By.linkText("LMS LOGIN"));
        lmsLogin.click();

        driver.navigate().back();//techproeducation.com sayfasına geri döndüm ==> Sayfa yeniden yüklendiği için locator adresi silindi.
        driver.navigate().refresh();

        lmsLogin = driver.findElement(By.linkText("LMS LOGIN"));//Tekrar locate işlemi yaparak lmsLogin objesine yeni adres veriliyor.
        lmsLogin.click();//Çalıştı

    }

    @Test
    public void staleElementExceptionTest5() {

        driver.get("https://www.techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        driver.get("https://www.techproeducation.com");

        WebElement lmsLogin = driver.findElement(By.linkText("LMS LOGIN"));
        lmsLogin.click();

        driver.get("https://www.techproeducation.com");//LMS'e gittikten sonra techproeducation sayfasına geri dönerek sayfayı yenilemiş oluyorum.

        try {//Reklamın çıkma yada çıkmamam ihtimali üzerine try-cath yaparak oluşabilecek noSuchElementException'ı handle ediyoruz.
            driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        } catch (Exception ignored) {
        }

        lmsLogin.click();//org.openqa.selenium.StaleElementReferenceException

    }


    @Test
    public void staleElementReferanceExceptionTest6odev() {
        /*
         NOT:StaleElementReferanceException hatası almamız gerekiyor
         //Amazon sayfasına gidelim
         //iphone aratalım
         //Çıkan sonuclardan ilk 5'ine tıklayıp sayfa başlıklarını alalım konsola yazdıralım
         //Sayfayı kapatalım
         */

        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //Çıkan sonuclardan ilk 5'ine tıklayıp sayfa başlıklarını alalım konsola yazdıralım
        List<WebElement> urunler = driver.findElements(By.xpath("//h2"));
        for (int i = 0; i < urunler.size(); i++) {
            urunler.get(i).click();
            bekle(3);
            driver.navigate().back();
            bekle(3);
            if (i == 4) {
                break;
            }
        }
    }
        @Test
        public void staleElementReferanceExceptionTest7odev () {//erolh.
        /*
        NOT:Exception almadan doğru şekilde yapalım
        //Amazon sayfasına gidelim
        //iphone aratalım
        //Çıkan sonuclardan ilk 5'ine tıklayıp sayfa başlıklarını alalım konsola yazdıralım
        //Sayfayı kapatalım
         */

            //Amazon sayfasına gidelim
            driver.get("https://amazon.com");

            //iphone aratalım
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

            //Çıkan sonuclardan ilk 5'ine tıklayıp sayfa başlıklarını alalım konsola yazdıralım
            List<WebElement> urunler = driver.findElements(By.xpath("//h2"));
            for (int i = 0; i < urunler.size(); i++) {
                urunler.get(i).click();
                bekle(3);
                driver.navigate().back();
                bekle(3);
                if (i == 4) {
                    break;
                }
                urunler = driver.findElements(By.xpath("//h2"));
            }
        }
    }