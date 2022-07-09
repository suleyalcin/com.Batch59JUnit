package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Q3 {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // http://the-internet.herokuapp.com/add_remove_elements/
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        // click on the "Add Element" button 100 times   1.method==> createButtons(100)
        createButtons(driver, 100);//100 kez add elementine tiklayan method yaptk

        // write a function that takes a number, and clicks the "Delete" button  2.method==>deleteButtonsAndValidate()
        deleteButtonsAndValidate(driver, 60);

        // given number of times, and then validates that given number of
        // buttons was deleted


    }

    private static void deleteButtonsAndValidate(WebDriver driver, int number) {
        List<WebElement> buttonsDelete = driver.findElements(By.xpath("//*[text()='Delete']"));
        int sizeBeforeDelete = buttonsDelete.size();


        int sayac = 0;
        for (WebElement each : buttonsDelete) {
            sayac++;
            if (sayac > number) {
                break;
            }
            each.click();

        }
        List<WebElement> elementsAfter = driver.findElements(By.xpath("//*[text()='Delete']"));//nekadar element kaldi

        System.out.println("***********************************************************");
        int sizeAfterDelete = elementsAfter.size();

        if (sizeBeforeDelete - number == sizeAfterDelete) {
            System.out.println("size after delete :" + sizeAfterDelete + " Success");
        } else {
            System.out.println("Failed");
        }
    }

    private static void createButtons(WebDriver driver, int eklenecekSayi) {
        WebElement addButton = driver.findElement(By.xpath("//*[text()='Add Element']"));
        for (int i = 0; i < eklenecekSayi; i++) {
            addButton.click();

        }

    }

}
