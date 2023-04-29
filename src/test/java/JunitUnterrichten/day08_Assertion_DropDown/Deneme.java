package JunitUnterrichten.day08_Assertion_DropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Deneme {

    /*
   -Amazon sayfasına gidelim
    -Arama Kutusundaki Dropdown menuyu yazdıralım
    -Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
    başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım
    Not: Select Class'ı kullanalım
     */

    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
       driver.quit();
  }

    @Test
    public void selectTest() throws InterruptedException {

   WebElement ddm =  driver.findElement(By.xpath
    ("//select[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']"));

        for (int i =0 ; i<6; i++) {
           Thread.sleep(3000);
            Select alinacakElement = new Select(ddm);
             alinacakElement.selectByIndex((int)i);
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
           driver.findElement(By.xpath("//input[@value ='Go']")).click();

            System.out.println(driver.getTitle());
        }

    }


}
