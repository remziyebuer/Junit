package JunitUnterrichten.day16_Exceptions;

import JunitUnterrichten.utilities.TestBase;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
public class C03_NullPointerException extends TestBase {
    /*
       NullPointerException:
               Değişken yada obje oluşturup bu değişkene atama yapmadığımızda yada eşitlemediğimizde
           NullPointerException hatası alırız
    */
    WebDriver driver;
    Faker faker;
    Actions actions;
    Integer sayi;
    int number;
    Integer number2;
    String isim;

    @Test
    public void NullPointerExceptionTest1() {
        //driver=new ChromeDriver(); bu atamayı yapmadığım için(null degere sahip obje) bu hatayı aldık
        driver.get("https://amazon.com");//java.lang.NullPointerException
        //driver obje'mize atama yapmadığım için java.lang.NullPointerException hatası alırız
        //cte hatasi alinnmaz cun ki java kutuph degil
    }

    @Test
    public void NullPointerExceptionTest2() {
        //faker = new Faker(); bu atamayı yapmadığım için bu hatayı aldık
        System.out.println(faker.number().numberBetween(1, 10));//java.lang.NullPointerException
    }

    @Test
    public void NullPointerExceptionTest3() {
        //actions = new Actions(driver); bu atamayı yapmadığım için bu hatayı aldık
        actions.doubleClick().perform();//java.lang.NullPointerException
    }

    @Test
    public void NullPointerExceptionTest4() {
        //sayi değişkenine atama yapılmadığı için java.lang.NullPointerException hatasını aldık
        //sayi=5;
        System.out.println(sayi+5);

        //bu ve sonrasi cte  alinir java kut. ait
    }

    @Test
    public void NullPointerExceptionTest5() {
        //isim değişkenine atama yapılmadığı için java.lang.NullPointerException hatasını aldık
        //isim="Erol";
        System.out.println(isim.charAt(0));
    }

    @Test
    public void NullPointerExceptionTest6() {
        System.out.println(number + 6);
    }
    //null ex. almayiz toplamanin sonucu olarak 6 verir
    // cun ki  primitive datalarin degeri atanmazsa '0' olur


    @Test
    public void NullPointerExceptionTest7() {
        System.out.println(number2 +6);
    }//null ex. aliriz cun ki non primitive datalarin degeri atanmazsa null olur
}
