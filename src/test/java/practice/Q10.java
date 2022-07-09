package practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Q10 extends TestBase {
    @Test
    public void test01() throws InterruptedException {

        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='emoojis']"));
        driver.switchTo().frame(iframe);
        WebElement ikinciEmoji = driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]"));
        ikinciEmoji.click();
        List<WebElement> emojiler = driver.findElements(By.xpath("//div[@id='nature']"));
        //emojiler.stream().forEach(t->t.click());
        for (WebElement each : emojiler
        ) {
            each.click();
        }
        driver.switchTo().parentFrame();


        // formu doldurun,(Formu istediğiniz metinlerle doldurun)
        //  apply button a basin
        driver.findElement(By.xpath("//button[text()='Apply']")).click();
    }
}