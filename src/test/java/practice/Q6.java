package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Q6 {

    // ...Exercise6...
    static WebDriver driver;

    @BeforeClass
    public static void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    @Test
    public void test() {
        // 1. Amazon.com'a gidelim.
        driver.get("https://www.amazon.com");
        // 2. DropDown üzerinde   //    kategorilerin hepsini konsola yazdiralim
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(dropDown);
        List<WebElement> list = select.getOptions();
        for (WebElement each : list) {
            System.out.println(each.getText());
        }
        // Books secelim.(All yazan yerde)
        select.selectByVisibleText("Books");

        // 3. Arama kutusuna "Les Miserables" yazalım ve arama yapalim.
        WebElement searchBox=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("Les Miserables");
        searchBox.submit();

        // 4. Sonuc sayisini ekrana yazdiralim.
     WebElement sonucSayisi=driver.findElement(By.xpath("//span[text()='1-16 of over 5,000 results for']"));
        System.out.println(sonucSayisi.getText());


        // 5. Sonucların Les Miserables i icerdigini assert edelim
        WebElement lesMiserables=driver.findElement(By.xpath("//span[text()='\"Les Miserables\"']"));

        assertTrue(sonucSayisi.getText().contains("Les Miserables"));
        assertEquals("les Misreables icermez",sonucSayisi.getText().contains("Les Miserables"),true);

    }
    @AfterClass
    public static void tearDown() throws Exception {
         driver.quit();
/*?????????????????????????????????????????????????????????????????????????????????????????*/
    }
}
