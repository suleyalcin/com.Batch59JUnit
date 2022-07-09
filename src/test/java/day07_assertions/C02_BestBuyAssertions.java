package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BestBuyAssertions {
    //1) Bir class oluşturun: BestBuyAssertions
    //2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/");

    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    //        ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
    @Test
    public void test01() {
        String beklenenUrl = "https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(beklenenUrl, actualUrl);
    }


    //        ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    @Test
    public void test02() {
        String istenmeyenKelime = "Rest";
        String actualTitle = driver.getTitle();
        Assert.assertFalse(actualTitle.contains(istenmeyenKelime));

    }

    //        ○ logoTest => BestBuy logosunun görüntülendigini test edin
    @Test
    public  void test03() {
        WebElement logoElementi = driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logoElementi.isDisplayed());
    }

    @Test
    public void test04() {
        //        ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        WebElement francaisElementi = driver.findElement(By.xpath("//*[text()='Français']"));
        Assert.assertTrue(francaisElementi.isDisplayed());


    }
}

