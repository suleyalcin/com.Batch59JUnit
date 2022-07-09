package day06_radyoButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Assertions {
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
    public void test01(){
        //Eger test metodumuzda hic bir test yoksa ; test calistiktan sonra hic bir problemle
        // karsilasilmadigini raporlamak icin "tests passed" yazisi cikar

        //eGER TESTLERI IF ILE YAPARSAK TEST failed OLSA BILE CODE LAR PROBLEMSIZ CALISTIGI
        // ICIN KOD CALISMASI BITTIGINDE EKRANIN SOL ALT KISMINDA TEST passed YAZICAKTIR
        driver.get("https://www.amazon.com");
        //amazona gittik url in https://www.facebook.com oldugunu test edin======>FAILED cikmasi lazim


       /* if(driver.getCurrentUrl().equals("https://www.facebook.com ")) {///bu yuyzden yoruma aldik if else
            System.out.println("Url Testi PASSED");
        }else{
            System.out.println("Url Testi FAILED");*/


        String expectedUrl="https://www.facebook.com";
        String actualUrl="https://www.amazon.com";
        Assert.assertEquals(" Url Beklenenden Farkli Sulecim:)",expectedUrl, actualUrl);
        /*Assert ile yaptigimiz testlerde assertiion failed olursa java kodlarin calismasini durdurur
        ve Assert Classi bizi hata konusunda bilgilendirir
        org.junit.ComparisonFailure:  Url Beklenenden Farkli Sulecim:)
        Expected :https://www.facebook.com
        Actual   :https://www.amazon.com
        <Click to see difference>
       Boylece hatanin ne olduguu arastirmamiza gerrek kalmadan JUnit bize raporlamis olacak
         */
        }
    }

