package yasinhoca.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

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
//
////    @After
////    public void tearDown() throws Exception {
////        driver.quit();
////    }
//
//
    @Test
    public void test01() throws InterruptedException {
////
////
////        // Web sitesini aç ve ürün sayfasına git
////        driver.get("http://www.example.com/product");
////
////        // Ürünü seç ve sepete ekle
////        WebElement addToCartButton = driver.findElement(By.cssSelector("button.add-to-cart"));
////        addToCartButton.click();
////
////        // Sepet sayfasına git ve doğru ürünün eklenip eklenmediğini kontrol et
////        WebElement cartLink = driver.findElement(By.cssSelector("a.cart-link"));
////        cartLink.click();
////        WebElement productInCart = driver.findElement(By.xpath("//td[contains(text(),'Product Name')]"));
////        if (productInCart.isDisplayed()) {
////            System.out.println("Ürün sepete başarıyla eklenmiştir.");
////        } else {
////            System.out.println("Ürün sepete eklenirken bir hata oluştu.");
////        }
////        System.out.println("*************************");
//        // Web sitesini aç ve sepet sayfasına git
           driver.get("https://www.saucedemo.com");
//        Thread.sleep(3000);
//
//        // Sepetin içindeki tüm ürünleri listele
//        List<WebElement> productsInCart = driver.findElements(By.cssSelector("tr.product"));
//
//        // Ayakkabı var mı diye kontrol et
//        boolean hasShoes = false;
//        for (WebElement product : productsInCart) {
//            WebElement productName = product.findElement(By.cssSelector("td.product-name"));
//            if (productName.getText().equals("Ayakkabı")) {
//                hasShoes = true;
//                break;
//            }
//        }
//

    }
}
