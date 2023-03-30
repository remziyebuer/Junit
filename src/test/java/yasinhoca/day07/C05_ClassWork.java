package yasinhoca.day07;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
public class C05_ClassWork {
    /*
   Verilen web sayfasına gidin.
   https://the-internet.herokuapp.com/checkboxes
   Checkbox1 ve checkbox2 elementlerini locate edin.
   Checkbox1 seçili değilse onay kutusunu tıklayın
   Checkbox2 seçili değilse onay kutusunu tıklayın
    */
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();//bu poliformizmdir?
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.techproeducation.com/");

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.close();
    }


    @Test
    public void test01() {
//        Verilen web sayfasına gidin.
//        https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");

//        Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement checkbox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));


//        Checkbox1 seçili değilse onay kutusunu tıklayın
        if (!checkbox1.isSelected()) {
            checkbox1.click();
        }

//        Checkbox2 seçili değilse onay kutusunu tıklayın
        if (!checkbox2.isSelected()) {
            checkbox2.click();
        }

    }


}