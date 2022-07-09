package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class C05_KeyBoardActions extends TestBase {
    @Test

    public void test01() {

        driver.get("https://www.amazon.com");
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));

        //once arama Kutusuna click yapip sonra harf harf Nutella yazisini yazdiralim
        //sonrada Enter tusuna basalim
        Actions actions = new Actions(driver);
        actions.click(aramaKutusu)
                .keyDown(Keys.SHIFT)//ilk harfi buyuk yazmamizi saglar
                .sendKeys("n").
                keyUp(Keys.SHIFT).//elimizi shift ten cekip kucuk harf devam ediyoruz
                sendKeys("u").
                sendKeys("t").
                sendKeys("e").
                sendKeys("l").
                sendKeys("l").
                sendKeys("a").
                sendKeys(Keys.ENTER).
                perform();


    }


}
