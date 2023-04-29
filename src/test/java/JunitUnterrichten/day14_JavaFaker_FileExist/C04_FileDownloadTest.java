package JunitUnterrichten.day14_JavaFaker_FileExist;

import org.junit.Test;
import org.openqa.selenium.By;
import JunitUnterrichten.utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.Assert.assertTrue;

public class C04_FileDownloadTest extends TestBase {
    /*
 "https://testcenter.techproeducation.com/index.php?page=file-download"   adresine gidin
 "b10 all test cases" dosyasını indirin
  Dosyanın başarıyla indirilip indirilmediğini test edin.
 */

    @Test
    public void fileDownloadTest(){
//        "https://testcenter.techproeducation.com/index.php?page=file-download"   adresine gidin
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");

//        "b10 all test cases" dosyasını indirin
        driver.findElement(By.linkText("b10 all test cases, code.docx")).click();
        bekle(2);//indirmesi icin zaman verdik yoksa fail alabiliriz

//        Dosyanın başarıyla indirilip indirilmediğini test edin.
        String filePath = System.getProperty("user.home")+"/Downloads/b10 all test cases, code.docx";
        //C:\Users\TechProEd

        boolean isExist = Files.exists(Path.of(filePath));
        assertTrue(isExist);


       /*
        "Path.of()" ve "Path.get()" metotları aynı amaca hizmet eder, yani dosya yolunu temsil eden

       bir "Path" nesnesi oluştururlar. Ancak kullanım açısından bazı farklılıkları vardır.

      "Path.get()" metodu, bir dosya yolu parçasını temsil eden bir dizeyi parametre olarak alır ve
       bu dizeyi kullanarak bir "Path" nesnesi oluşturur. Bu yöntem, JDK 7'de tanıtıldı ve önceden
       mevcut olan "File" sınıfından daha esnek bir yol oluşturmak için geliştirildi.

        "Path.of()" metodu ise JDK 11'de tanıtıldı ve "Path.get()" metoduyla aynı işlevi yerine getirir.
      Ancak, "Path.of()" metodu, dosya yolu dizesinin doğruluğunu kontrol eder ve dize boş veya null
      ise hata fırlatır. Bu sayede, hatalı dosya yolu belirtilmesi durumunda hemen hata mesajı
      alınabilir.

      Sonuç olarak, "Path.get()" ve "Path.of()" metotları birbirine benzer şekilde kullanılabilir,
     ancak "Path.of()" metodu daha güvenli bir kullanım sağlar ve önerilen metottur.
   */

    }
}
