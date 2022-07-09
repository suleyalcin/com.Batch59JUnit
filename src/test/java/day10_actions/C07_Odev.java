package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C07_Odev extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //facebook anasayfaya gidip
        //yeni kayit olustur butonuna basalim
        //isim kutusunu locate edip
        //geriye kalan alanlari tab ile dolasarak
        //formu doldurun

        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
        WebElement firstnameElement=driver.findElement(By.name("firstname"));
        Actions actions=new Actions(driver);
        actions.click(firstnameElement)
                .sendKeys("Ahmet"+ Keys.TAB)
                .sendKeys("Kaya"+Keys.TAB)
                .sendKeys("3235353535"+Keys.TAB)
                .sendKeys("sfdsdf@dfdfg.com"+Keys.TAB+Keys.TAB)

                .sendKeys("12"+Keys.TAB)
                .sendKeys("May"+Keys.TAB)
                .sendKeys("1987"+Keys.TAB+Keys.TAB)
                .sendKeys(Keys.RIGHT).moveToElement(driver.findElement(By.xpath("(//button[@type='submit'])[2]")))
                .click()


                .perform();



        Thread.sleep(3000);
    }
}
