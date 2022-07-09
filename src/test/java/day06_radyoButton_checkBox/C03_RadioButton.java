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

public class C03_RadioButton {
    //1. Bir class oluşturun : RadioButtonTest
    //2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
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
       driver.close();
    }
    @Test
    public void test01() throws InterruptedException {
        //https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");
        //Cookies'i kabul edin bende cikmadi bu adimi atladik

        Thread.sleep(3000);
        //“Create an Account” button’una basin
        //driver.findElement(By.xpath("//*[text()='Create new account']")).click();
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();


        //“radio buttons” elementlerini locate edin
        WebElement kadinButonu=driver.findElement(By.xpath("(//label[@class='_58mt'])[1]"));
        WebElement erkekButonu=driver.findElement(By.xpath("(//label[@class='_58mt'])[2]"));
        WebElement ozelButonu=driver.findElement(By.xpath("(//label[@class='_58mt'])[3]"));

        //Secili degilse cinsiyet butonundan size uygun olani secin
        Thread.sleep(3000);
        if(!kadinButonu.isSelected()){
            kadinButonu.click();
        }

        Thread.sleep(3000);
    }
}
