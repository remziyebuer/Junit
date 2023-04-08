package yasinhoca.day13erolh;

import yasinhoca.utilities.TestBase;

public class C02_Actions extends TestBase {
     /*
    https://the-internet.herokuapp.com/context_menu  sitesine gidin
    Kutuya sağ tıklayın
    Alert’te cikan yazinin “You selected a context menu” oldugunu test edin
    Tamam diyerek alert’i kapatın
     */

    @Test
    public void actionsTest() {
//        https://the-internet.herokuapp.com/context_menu  sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

//        Kutuya sağ tıklayın
        //Sağ tık işlemi için contextClick() methoduna ihtiyacımız var. Bunun için Actions objesi oluşturulmalıdır.

        //1. adım: Actions objesi oluşturun
        Actions actions = new Actions(driver);

        //2. adım: Üzerinde işlem yapılacak WebElement'i locate edin
        WebElement kutu = driver.findElement(By.id("hot-spot"));

        //3. adım: İşlemi uygulayın
        actions.contextClick(kutu).perform();//perform() methodu son olarak uygulanmalıdır.

//        Alert’te cikan yazinin “You selected a context menu” oldugunu test edin
        String alertYazisi = driver.switchTo().alert().getText();
        assertEquals("You selected a context menu", alertYazisi);

//        Tamam diyerek alert’i kapatın
        driver.switchTo().alert().accept();

    }
}
