package yasinhoca.day08;
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
import java.util.List;
public class C02_YasinH_DropDown {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
    @Test
    public void selectByIndex() throws InterruptedException {
        //1. Locate Dropdown Element
        Thread.sleep(3000);
        WebElement ddm01 = driver.findElement(By.xpath("//select[@id = 'year']"));
        Select optionYear = new Select(ddm01);
        optionYear.selectByIndex(22);
        Thread.sleep(3000);
        WebElement ddm02 = driver.findElement(By.xpath("//select[@id='month']"));
        Select optionMonth = new Select(ddm02);
        optionMonth.selectByVisibleText("June");
        Thread.sleep(3000);
        WebElement ddm03 = driver.findElement(By.xpath("//select[@id='day']"));
        Select optionDay = new Select(ddm03);
        optionDay.selectByValue("25");

    }

    @Test //tüm eyalet isimlerini yazdiralim
    public void printAll() {
        WebElement ddm04 = driver.findElement(By.xpath("//select[@id='state']"));
        Select optionState = new Select(ddm04);
        List<WebElement>stateList = optionState.getOptions();

        for (WebElement w: stateList){
            System.out.println(w.getText());
        }
        //Tavsiye Edilen lambda

      //  stateList.stream().forEach(t-> System.out.println(t.getText()));
    }
}
