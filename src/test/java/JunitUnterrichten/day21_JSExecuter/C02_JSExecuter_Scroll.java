package JunitUnterrichten.day21_JSExecuter;
import JunitUnterrichten.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
public class C02_JSExecuter_Scroll extends TestBase {

      /*
    Techpro education ana sayfasına git
    "We Offer" elementi görünür olacak şekilde üzerine scroll et ve ekran görüntüsünü al
    Aynı sayfada "Enroll Free "elementi görünür olacak sekilde scroll et ve ekran görüntüsünü al
    Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
    Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
    Kaydirma icin Action classida kullanilir am abu daha garanti.****
     */

    @Test
    public void jSExecuterScrollTest() {
//        Techpro education ana sayfasına git
        driver.get("https://techproeducation.com/");
        try {
            driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

//        "We Offer" elementi görünür olacak şekilde üzerine scroll et ve ekran görüntüsünü al
        WebElement weOffer = driver.findElement(By.xpath("//span[.='we offer']"));

        bekle(3);

        scroll(weOffer);//scroll() ==> TestBase classındaki method(biz olusturduk yukardaki kod ile)
        tumSayfaResmi();
        bekle(3);

//        Aynı sayfada "Enroll Free" elementi görünür olacak sekilde scroll et ve ekran görüntüsünü al
        WebElement enrollFree = driver.findElement(By.xpath("//span[.='Enroll Free Course']"));
        scroll(enrollFree);
        tumSayfaResmi();
        bekle(3);

//        Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        WebElement whyUs = driver.findElement(By.xpath("//h3[.='WHY US?']"));
        scroll(whyUs);
        tumSayfaResmi();
        bekle(3);

//        Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        scroll(enrollFree);
        tumSayfaResmi();
        bekle(3);

        //Sayfayı en alta kaydır:
        scrollEnd();
        bekle(3);

        //Sayfayı en üste kaydır:
        scrollTopJS();

    }

}
