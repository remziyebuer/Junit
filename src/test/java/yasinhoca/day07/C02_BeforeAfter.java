package yasinhoca.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforeAfter {

    @Before
    public void setUp(){
        System.out.println("Her test metodu öncesi bir kere calisir");
    }
    @Test
    public void test01(){
        System.out.println(" ilk test metodu");
    }

    @Test
    public void test02(){
        System.out.println(" ikinci test metodu");
    }

    @After
    public void teardown(){
        System.out.println("Her test metodu sonrasi bir kere calisir");
    }

}
