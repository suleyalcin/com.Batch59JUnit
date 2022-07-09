package day06_radyoButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_CheckBox {
    //1. Bir class oluşturun : CheckBoxTest
    //2.Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    WebDriver driver;

    @Before//testten once hazirlik olarak calistir
    public void setUp() {//tek bir gorev var static ile ugrasmamak icin BeforeClass ile ugrasmadik
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After//test bitiyor
    public void tearDown() {
        // driver.close();
    }

    //a. Verilen web sayfasına gidin.


    //https://the-internet.herokuapp.com/checkboxes
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        //b. Checkbox1 ve checkbox2 elementlerini locate edin.

        WebElement checkBox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));

        //c. Checkbox1 seçili değilse onay kutusunu tıklayın
        Thread.sleep(3000);
        if (checkBox2.isSelected()) {//!checkBox1.isSelected
            checkBox1.click();       //checkBox1.click() de yazilabilir
        }
        Thread.sleep(3000);


        //d. Checkbox2 seçili değilse onay kutusunu tıklayın
        if (!checkBox2.isSelected()) {
            checkBox2.click(); //checkBox2.
            Thread.sleep(3000);
        }
        driver.close();
    }
}