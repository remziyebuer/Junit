package yasinhoca.day14;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

public class C03_FileExist {
    /*
Masaüstünde "logo.jpeg" dosyası oluşturun.
Bu dosyanın varlığını doğrulayın.
 */

    @Test
    public void fileExistTest() {

        String userDIR = System.getProperty("user.dir");//C:\Users\TechProEd\IdeaProjects\B129SeleniumMavenJunit
        //IDE proje yolunu dinamik olarak verir

        String userHOME = System.getProperty("user.home");//C:/Users/TechProEd(kullanıcı adı)
        //Kullanıcı adı yolunu dinamik olarak verir

        //boolean isExist = Files.exists(Paths.get("C:/Users/Zbook/Desktop/logo.jpeg"));
        // System.out.println("isExist = " + isExist);

        String userHome = System.getProperty("user.home");//kullanici adi kismi olan adresi almama yardimci olur.
        boolean isExist = Files.exists(Paths.get(userHome + "/Desktop/logo.jpeg"));
        System.out.println("isExist = " + isExist);
        assertTrue(isExist);
        //var olmasini istiyorum o yüzden true yoksa olmamasini isteseydim assertfalse kullanirdim


             /*
        Fail ise: Dosya masaüstünde değil, dosya adı yanlış, yada arada onedrive gibi ekstra dosyalar olabilir.
         */
    }
}
