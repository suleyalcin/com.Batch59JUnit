package day15_writeExcel_screenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_JS_Executor extends TestBase {
//Executer=calistirici yapan icra eden
    @Test
    public void JSExecutorTest() throws InterruptedException {

        //amazon'a gidelim
        driver.get("https://ww.amazon.com");

        //asagidaki sign in butonu gorununceye kadar js ile scrool=ekranda goruntu alma yapalim
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        WebElement signInButonu=driver.findElement(By.xpath("(//span[text()='Sign in'])[2]"));
        Thread.sleep(2000);
        jse.executeScript("arguments[0].scrollIntoView(true);",signInButonu);
        //sign in butonuna js ile click yapalim
        jse.executeScript("arguments[0].click();",signInButonu);
        Thread.sleep(2000);
    }
}
