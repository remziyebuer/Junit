package practice.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BenimClassC02 {

    WebDriver driver ;//null
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();//bu poliformizmdir?
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

//    @After
//    public void tearDown() throws InterruptedException {
//        Thread.sleep(3000);
//        driver.close();
//    }
    @Test
    public void remziyeTest() { //232-272
    /*      1- https://www.google.com/ adresine gidin
            2- cookies uyarisini kabul ederek kapatin
            3.Sayfa basliginin “Google” ifadesi icerdigini test edin
            4. Arama cubuguna “Nutella” yazip aratin
            5. Bulunan sonuc sayisini yazdirin
            6. sonuc sayisinin 10 milyon’dan fazla oldugunu test edin

            */

        //      1- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
        //      2- cookies uyarisini kabul ederek kapatin
        driver.findElement(By.xpath("//*[text()='Alle ablehnen']")).click();
        //      3.Sayfa basliginin “Google” ifadesi icerdigini test edin
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Google"));
        //       4. Arama cubuguna “Nutella” yazip aratin
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@name ='q']"));
        ////input[@class='gLFyf'] --->bu neden olmadi
        aramaKutusu.sendKeys("nutella" + Keys.ENTER);
        //     5. Bulunan sonuc sayisini yazdirin
        String sonucYazisi = driver.
                findElement(By.xpath("//div[@id ='result-stats']")).getText();
        System.out.println("sonucYazisi = " + sonucYazisi);

//       6. sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        sonucYazisi = sonucYazisi.split(" ")[1];
        sonucYazisi = sonucYazisi.replaceAll("\\D", "");
        System.out.println("noktasiz String sonuc" + sonucYazisi);//noktalar sorun olusturur karsilastirmada yokettik
        int sonuc = Integer.parseInt(sonucYazisi);
        System.out.println("int'e dönusmus sonuc; " + sonuc);
        Assert.assertTrue(sonuc > 10000000);

    }
}
