package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //amazondan==> Account&List menusunden==> create a list linkine tikla
        driver.get("https://www.amazon.com");
        Actions actions=new Actions(driver);
        WebElement accountLinki=driver.findElement(By.xpath("//*[text()='Account & Lists']"));
        actions.moveToElement(accountLinki).perform();//moveToElement=su elemente yanas
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Create a List']")).click();
        Thread.sleep(2000);


    }
}
