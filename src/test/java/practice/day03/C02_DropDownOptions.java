package practice.day03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_DropDownOptions {

    // https://www.amazon.com/ sayfasina gidin
    // dropdown'dan "Baby" secenegini secin
    // sectiginiz option'i yazdirin
    // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
    // dropdown'daki optionların tamamını yazdırın

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @After
    public void tearDown(){
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

    @Test
    public void optionSayisi() {
        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");

        // dropdown'dan "Baby" secenegini secin
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Baby");


        // sectiginiz option'i yazdirin
        String sectigimOption = select.getFirstSelectedOption().getText();
        System.out.println("sectigimOption = " + sectigimOption);

        // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
      //  System.out.println(select.getOptions().stream().count());___tarik bey
        List<WebElement> optionlarList = select.getOptions();

        int expectedOptionSayisi = 28;
        int actuelOptionSayisi = optionlarList.size();

        Assert.assertEquals(expectedOptionSayisi,actuelOptionSayisi);

       // dropdown'daki optionların tamamını yazdırın
        int sayac=1;

        for (WebElement each:optionlarList) {
            System.out.println(sayac + ". option: " + each.getText());
            sayac++;
        }


    }
}
