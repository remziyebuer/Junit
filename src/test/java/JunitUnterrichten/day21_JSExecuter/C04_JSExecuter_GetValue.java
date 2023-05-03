package JunitUnterrichten.day21_JSExecuter;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import JunitUnterrichten.utilities.TestBase;

public class C04_JSExecuter_GetValue extends TestBase {
    //  1)getValueTest metotu olustur
//	2)https://www.priceline.com/ a git
//  3)Tarih kısmındaki Yazili metinleri al ve yazdır

    @Test
    public void getValueJSTest() {
//	https://www.priceline.com/ a git(bu sitede ben bir robot degilim cikti
//	bunu halledemeyiz site degistirdik)
        driver.get("https://www.carettahotel.com/");
        driver.findElement(By.id("details-button")).click();//advanced tikladik
        driver.findElement(By.id("proceed-link")).click();//altta cikan linki tikladik
        //bunlari güvenlik duvarini asmak icin yaptik

//  Tarih kısmındaki Yazili metinleri al ve yazdır. text olsaydi bu metodu kullanmazdik
//  ama seleniumda ki get text metodu ise yaramadi
        getValueByJS("checkin_date", "name");
    }
}
