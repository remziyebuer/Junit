package practice.day03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_CheckBox {

    // https://demo.guru99.com/test/radio.html adresine gidin
    // checkbox elementlerini locate edin
    // checkbox1 ve checkbox3  secili degil ise secin
    // checkbox1 ve checkbox3 elementlerinin secili oldugunu Test edin
    // checkbox2 elementinin secili olmadıgını test edin


    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

//    @After
//    public void tearDown(){
//        try {
//            Thread.sleep(3000);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        driver.quit();
//    }

    @Test
    public void optionSayisi() {
        // https://demo.guru99.com/test/radio.html adresine gidin
        driver.get("https://demo.guru99.com/test/radio.html");

        driver.switchTo().frame(3);
        driver.findElement(By.xpath("//*[@id='save']")).click();
        driver.switchTo().defaultContent();

        // checkbox elementlerini locate edin
        WebElement ch1=driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));
        WebElement ch2=driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));
        WebElement ch3=driver.findElement(By.xpath("(//*[@type='checkbox'])[3]"));

        // checkbox1 ve checkbox3  secili degil ise secin
        if(!ch1.isSelected()){
            ch1.click();
        }
        if (!ch3.isSelected()){
            ch3.click();
        }
        // checkbox1 ve checkbox3 elementlerinin secili oldugunu Test edin
        Assert.assertTrue(ch1.isSelected());
        Assert.assertTrue(ch3.isSelected());

        // checkbox2 elementinin secili olmadıgını test edin
        Assert.assertFalse(ch2.isSelected());

    }
}
