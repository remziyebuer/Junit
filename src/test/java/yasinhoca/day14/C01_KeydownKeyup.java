package yasinhoca.day14;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import yasinhoca.utilities.TestBase;

public class C01_KeydownKeyup extends TestBase {

   /*
"https://techproeducation.com/" gidin
İlk kelime SHIFT tuşuna basılı şekilde, ikinci kelime basılmadan "TECHPRO education" araması yapın.
 */

    @Test
    public void actionsTest() {
      //"https://techproeducation.com/" gidin
      driver.get("https://techproeducation.com/");
      driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//reklami kapatiyorum
//        İlk kelime SHIFT tuşuna basılı şekilde, ikinci kelime basılmadan "TECHPRO education" araması yapın.
       WebElement searchbox = driver.findElement(By.xpath("//input[@name='s']"));
       Actions action = new Actions(driver);
       action.
               keyDown(searchbox, Keys.SHIFT).//
               sendKeys("techpro").//
               keyUp(searchbox,Keys.SHIFT).//
               sendKeys("education" + Keys.ENTER).//
               build().perform();


    }
}
