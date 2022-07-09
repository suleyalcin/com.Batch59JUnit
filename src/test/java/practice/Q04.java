package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q04 {
    /*
    ...Exercise4...
    https://www.teknosa.com/ adresine gidiniz
    arama cubuguna oppo yazip enter deyiniz
    sonuc sayisini yazdiriniz
    cikan ilk urune tiklayiniz
    sepete ekleyiniz
    sepetime git e tiklayiniz
    consol da "Sipariş Özeti" webelementinin text ini yazidiriniz
    Alisverisi tamamlayiniz
    son alarak da "Teknosa'ya hoş geldiniz"  webelementinin text ini yazidiriniz
    driver i kapatiniz

*/
    /*
    note :
    JavaScriptExecutor nedir?
    JavaScriptExecutor, JavaScript'i Selenium Web sürücüsü aracılığıyla çalıştırmaya yardımcı olan bir Arayüzdür.
    JavaScriptExecutor, javascript'i seçilen pencerede veya geçerli sayfada çalıştırmak için "executescript" ve "executeAsyncScript"
    olmak üzere iki yöntem sunar.
    JavaScriptExecutor'a neden ihtiyacımız var?
    Selenium Webdriver'da, bir web sayfasındaki işlemleri tanımlamak ve gerçekleştirmek için
    XPath, CSS vb. gibi konum belirleyiciler kullanılır.
    Bu konum belirleyicilerin çalışmaması durumunda JavaScriptExecutor'ı kullanabilirsiniz.
    Bir web öğesinde istenen bir işlemi gerçekleştirmek için JavaScriptExecutor'ı kullanabilirsiniz.
    Selenium, javaScriptExecutor'ı destekler. Ekstra bir eklenti veya eklentiye gerek yoktur.
    JavaScriptExecutor kullanmak için komut dosyasında (org.openqa.selenium.JavascriptExecutor) içe aktarmanız yeterlidir.
            executeScript aracılığıyla sayfayı 1000 piksel kaydırın.
            Javascript yöntemi ScrollBy(), web sayfasını belirli piksel sayısına kaydırır.
            ScrollBy() yöntemlerinin sözdizimi şöyledir:
            executeScript("window.scrollBy(x-piksel,y-piksel)");  ya da js.executeScript("scroll(x,y);");
            x-piksel x eksenindeki sayıdır, sayı pozitifse sola, sayı negatifse sağa hareket eder.
            y-piksel y eksenindeki sayıdır, sayı pozitifse ise aşağı doğru,sayı negatif ise yukarı doğru hareket eder.
            Örnek:
            js.executeScript("window.scrollBy(0,1000)"); // Dikey olarak 1000 piksel aşağı kaydır
     */

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.close();

    }

    @Test
    // https://www.teknosa.com/ adresine gidiniz
    public void test01() throws InterruptedException {
        driver.get("https://www.teknosa.com/");


        //    arama cubuguna oppo yazip enter deyiniz
        WebElement aramaCubugu = driver.findElement(By.xpath("//input[@id='search-input']"));
        aramaCubugu.sendKeys("oppo" + Keys.ENTER);
        Thread.sleep(2000);
        //    sonuc sayisini yazdiriniz
        System.out.println( driver.findElement(By.xpath("//body/div[@id='wrapper']/main[@id='site-main']" +
                "/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")).getText());

        Thread.sleep(2000);

        //    cikan ilk urune tiklayiniz
         driver.findElement(By.xpath("//body/div[@id='wrapper']/main[@id='site-main']" +
                "/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/a[1]")).click();
                Thread.sleep(2000);


        //    sepete ekleyiniz
         driver.findElement(By.xpath("//button[@id='addToCartButton']")).click();
         Thread.sleep(2000);


        //    sepetime git e tiklayiniz
        driver.findElement(By.xpath("//body/div[@id='colorbox']/div[@id='cboxWrapper']" +
                "/div[2]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[3]/a[2]")).click();
        Thread.sleep(2000);



        //    consol da "Sipariş Özeti" webelementinin text ini yazidiriniz
        System.out.println("Siparis Ozeti : "+driver.findElement(By.xpath("//div[contains(text(),'Sipariş Özeti')]")).getText());
        Thread.sleep(2000);
        //    Alisverisi tamamlayiniz
        driver.findElement(By.xpath("//body/div[@id='wrapper']/main[@id='site-main']" +
                "/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/a[1]")).click();
        Thread.sleep(2000);
        //    son alarak da "Teknosa'ya hoş geldiniz"  webelementinin text ini yazidiriniz
        System.out.println("Hosgeldiniz Yazisi : "+driver.findElement(By.xpath("//div[contains(text(),'Teknosa’ya hoş geldiniz')]")).getText());
        //    driver i kapatiniz

    }
}
