package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06_KeyBoardActions extends TestBase {

    @Test

    public void test01() throws InterruptedException {
        // facebook ana sayfaya gidip
        driver.get("https://www.facebook.com");

// yeni kayit olustur butonuna basin
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

// isim kutusunu locate edip,
        WebElement yeniKayit=driver.findElement(By.xpath("//input[@name='firstname']"));

// geriye kalan alanlari TAB ile dolasarak formu doldurun
        Actions actions=new Actions(driver);
        actions.click(yeniKayit)
                .sendKeys("Yale")
                .sendKeys(Keys.TAB)
                .sendKeys("NERDE")
                .sendKeys(Keys.TAB)
                .sendKeys("ghfdfh@gmail.com")
                .perform();
        Thread.sleep(5000);

        WebElement tekrarMail=driver.findElement(By.xpath("(//input[@type='text'])[5]"));
        actions.click(tekrarMail)
                .sendKeys("ghfdfh@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("5645646")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("21")
                .sendKeys(Keys.TAB)
                .sendKeys("Ocak")
                .sendKeys(Keys.TAB)
                .sendKeys("2000")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .perform();
        WebElement cinsiyet=driver.findElement(By.xpath("//label[text()='Kadın']"));
        cinsiyet.click();
        actions.sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .perform();
         WebElement kaydol=driver.findElement(By.xpath("(//*[text()='Kaydol'])[3]"));
         kaydol.click();
         WebElement dahaFazlaBilgi=driver.findElement(By.xpath("//div[@class='bp9cbjyn j83agx80 taijpn5t c4xchbtz by2jbhx6 a0jftqn4']"));

    }

}
