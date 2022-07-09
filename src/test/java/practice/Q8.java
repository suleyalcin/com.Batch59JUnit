package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class Q8 extends TestBase {
    @Test
    public void test() {
        //go to web site : https://www.jqueryscript.net/demo/bootstrap-alert-box/
        //maximize the window//TetBasede zaten yapili
        driver.get("https://www.jqueryscript.net/demo/bootstrap-alert-box/");
        //click on action dialog button
        driver.findElement(By.xpath("//button[@id='action']")).click();

        //if need use explicitly wait
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class = 'modal-body']"))));//beklenen durum gerceklesene kadar bekle
        //Webelement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'modal-body']")));23.satirda 24.satirda olur
        //click on the ok button
        WebElement textMsj=driver.findElement(By.xpath("//div[@class = 'modal-body']"));
        Assert.assertTrue(textMsj.isDisplayed());
        driver.findElement(By.id("dialog-mycodemyway-action")).click();//ok butonuna tikla
        //accept the alert message  ==>allerti kabul et
        driver.switchTo().alert().accept();
    }
}