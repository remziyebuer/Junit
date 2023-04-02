package yasinhoca.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class DENEME2 {
    public static void main(String[] args) {
        remziyeMethod();
    }
    public static void remziyeMethod() { //265-285
        WebDriverManager.chromedriver().setup();
       WebDriver chromeDriver= new ChromeDriver();
        //https://www.bestbuy.com adresine gidin.
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        chromeDriver.get("https://www.bestbuy.com ");

        //sayfada kac adet buton bulundugunu yazdirin
        List<WebElement> butonListesi = chromeDriver.findElements(By.tagName("button"));
        System.out.println(butonListesi.size());//listenin size'ini aldim

        //sayfa da ki herbir buton üzerinde ki yazilari yazdirin
        for (WebElement w:butonListesi) {
            System.out.println(w.getText());
        }
        chromeDriver.quit();
    }

}
