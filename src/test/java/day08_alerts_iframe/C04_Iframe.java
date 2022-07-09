package day08_alerts_iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Iframe {
    // ● Bir class olusturun: IframeTest
    //   ● https://the-internet.herokuapp.com/iframe adresine gidin.
    //   ● Bir metod olusturun: iframeTest
    //        ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda    yazdirin.
    //        ○ Text Box’a “Merhaba Dunya!” yazin.
    //        ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu     dogrulayin ve  konsolda yazdirin.


    WebDriver driver;
    @Before
    public  void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown() {
        // driver.quit();
    }
    //● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/iframe");
    }

    //   ● Bir metod olusturun: iframeTest
    //        ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda    yazdirin.

   @Test
  public void iframeTest() throws InterruptedException {
       WebElement baslikElementi = driver.findElement(By.xpath("//h3"));
       Assert.assertTrue(baslikElementi.isEnabled());
       System.out.println(baslikElementi.getText());


       //  ○ Text Box’a “Merhaba Dunya!” yazin.
       WebElement textKutusu = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
       textKutusu.sendKeys("merhaba");
       Thread.sleep(5000);

   }

}
