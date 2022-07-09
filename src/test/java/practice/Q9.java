package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Q9 extends TestBase {
    @Test
    public void test01() throws InterruptedException {

        //    go to url :http://demo.automationtesting.in/Alerts.html
        driver.get("http://demo.automationtesting.in/Alerts.html");
        //    click  "Alert with OK" and click 'click the button to display an alert box:'
        driver.findElement(By.xpath("//a[@href='#OKTab']")).click();
        //    accept Alert(I am an alert box!) and print alert on console

        driver.findElement(By.xpath("driver.findElement(By.xpath(\"(//a[@class='analystic'])[1]\")).click();"));
        //    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        driver.findElement(By.xpath("//*[text()='click the button to display a confirm box ']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();

        driver.findElement(By.xpath("//a[@class='analystic'])[3]")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();

        Thread.sleep(2000);
        driver.switchTo().alert().sendKeys("TechProEducation");
        driver.switchTo().alert().accept();
        String expectedMsj="Hello TechproEducation How are you today";
        String actualMsj=driver.findElement(By.xpath("//p[@id='demo1']")).getText();
        Assert.assertEquals(expectedMsj,actualMsj);
        //    cancel Alert  (Press a Button !)
        //    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
        //    and then sendKeys 'TechProEducation' (Please enter your name)
        //    finally print on console this message "Hello TechproEducation How are you today"
    }
}