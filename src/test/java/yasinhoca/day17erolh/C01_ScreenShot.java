package yasinhoca.day17erolh;

import com.aventstack.extentreports.utils.FileUtil;
import org.junit.Test;
import yasinhoca.utilities.TestBase;

public class C01_ScreenShot extends TestBase {
    @Test
    public void screenShotTest1() {
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //Sayfanın resmini alalım
        tumSayfaResmi();

        //Sonra amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //Amazon sayfasının ekran görüntüsünü alalım
        tumSayfaResmi();//Method kullanarak tüm ekran resmini aldık


    }
}
