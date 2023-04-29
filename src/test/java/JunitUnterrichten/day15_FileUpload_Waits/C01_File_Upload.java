package JunitUnterrichten.day15_FileUpload_Waits;


import JunitUnterrichten.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import static org.junit.Assert.assertTrue;


public class C01_File_Upload extends TestBase {

    @Test
    public void fileUploadTest() {
    /*
    https://the-internet.herokuapp.com/upload adresine gidin
    logo.jpeg dosyasını yükleyin(upload)
    “File Uploaded!” textinin görüntülendiğini test edin
    */
//herzaman önce manuel test et
        /*
        Bir Web sayfasında upload işlemi yapmamız gerekirse;
            1-Öncelikle upload edeceğimiz webelementi locate ederiz
            2-Upload edeceğimiz dosya yolunu bir string'e assingn ederiz
            3-Locate ettiğimiz webelement'e sendkeys() methodu ile dosyayolunu aldığımız string değişkeni göndeririz
         */

        //https://the-internet.herokuapp.com/upload adresine gidin
        driver.get("https://the-internet.herokuapp.com/upload");
        //b129.txt dosyasını yükleyin(upload)
        WebElement dosyaSecWebElement = driver.findElement(By.id("file-upload"));
        bekle(3);
        String dosyaYolu = "C:\\Users\\Lenovo\\OneDrive\\Masaüstü\\b129.txt";
        //String dosyaYolu = System.getProperty("user.home")+"\\OneDrive\\Masaüstü\\b129.txt";
        dosyaSecWebElement.sendKeys(dosyaYolu);
        //buraya kadar test degil test olmasi icin assertion olmasi lazim
        //"File Uploaded!" textinin görüntülendiğini test edin
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());



    }

}
