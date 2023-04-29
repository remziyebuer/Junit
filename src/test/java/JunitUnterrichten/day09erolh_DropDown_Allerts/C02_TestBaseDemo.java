package JunitUnterrichten.day09erolh_DropDown_Allerts;

import org.junit.Assert;
import org.junit.Test;
import JunitUnterrichten.utilities.TestBase;

public class C02_TestBaseDemo extends TestBase {
    @Test
    public void test01() {
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        //Başlığın "Bootcamp" içerdiğini test edelim
        String actualTitle = driver.getTitle();
        String expectedTitle = "Bootcamp";
        Assert.assertTrue(actualTitle.contains(expectedTitle));



    }
}
