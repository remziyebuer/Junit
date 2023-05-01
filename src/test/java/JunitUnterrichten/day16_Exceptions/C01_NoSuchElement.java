package JunitUnterrichten.day16_Exceptions;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import JunitUnterrichten.utilities.TestBase;

public class C01_NoSuchElement extends TestBase{
    @Test
    public void NoSuchElementException() {
        /*
        NoSuchElementException;
            -Sayfada bulunmayan bir elemente erişim sağlamaya çalışıldığında karşılaşılır
         */
        //techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        bekle(5);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();//Reklam kapatmak için

        //SearchBox elementini locate edelim
        driver.findElement(By.xpath("//*[@type='ssearch']")).sendKeys("java", Keys.ENTER);
        //org.openqa.selenium.NoSuchElementException: Web element bulunamadığında alınır.
        // Webelementin locatini değiştirdiğimiz için 21. satırda
        //NoSuchElementException hatası aldık
        //SearchBox'ın locatini yeniden almamız gerekir
        //burda imp. wait kullandigimiz icin bu ex.  verdi eger özel bir durum olsa ve explicit. wait kullansaydik
        //no suchh degil time out ex. alirdik ikinci class ta bunu görecegiz.
    }
}
