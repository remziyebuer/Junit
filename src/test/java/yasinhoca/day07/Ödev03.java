package yasinhoca.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Ödev03 {
    /*

    1.“https://www.saucedemo.com” Adresine gidin
2.Username kutusuna “standard_user” yazdirin
3.Password kutusuna “secret_sauce” yazdirin
4.Login tusuna basin
5.Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
6.Add to Cart butonuna basin
7.Alisveris sepetine tiklayin
8.Sectiginiz urunun basarili olarak sepete eklendigini control edin
9.Sayfayi kapatin
     */
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();//bu poliformizmdir?
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }


}
