package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_TekrarTesti {
    public static void main(String[] args) {


        //1. Yeni bir class olusturun (TekrarTesti)
        //2. Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını
        //doğrulayın (verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.Youtube.com");
        String actualTitle=driver.getTitle();
        String beklenenTitle="youtube";

        if(actualTitle.equals(beklenenTitle)) {
            System.out.println("Title PASSED");
        }else{
            System.out.println("Title FAILED 'Sayfa Basligi Youtube icermiyor' "+actualTitle+ " iceriyor");
            //Title 'Sayfa Basligi Youtube icermiyor' FAILED YouTube iceriyor
        }

        //3. Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın,
        //içermiyorsa doğru URL'yi yazdırın.
        String actualUrl =driver.getCurrentUrl();
        String beklenenUrl="youtube";
        if(actualUrl.contains(beklenenUrl)){
            System.out.println("Url testi PASSED URL 'youtube' iceriyor");
        }else{
            System.out.println("URL testi FAILED .Dogru URL ("+actualUrl+" ) iceriyor");
        }

        //4. Daha sonra Amazon sayfasina gidin https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //5. Youtube sayfasina geri donun
        driver.navigate().back();
        //6. Sayfayi yenileyin
        driver.navigate().refresh();
        //7. Amazon sayfasina donun
        driver.navigate().forward();
        //8. Sayfayi tamsayfa yapin
        driver.manage().window().maximize();
        //9. Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın,
        //Yoksa doğru başlığı(Actual Title) yazdırın.
        String actualTitle2 = driver.getTitle();
        String beklenenTitle2="Amazon";
        if(actualTitle2.contains(beklenenTitle2)){
            System.out.println("Title PASSED.Baslik 'Amazon' iceriyor");
        }else{
            System.out.println("60.SATIR Amazondayiz ama Ne hikmetse : Title FAILED.Baslik 'Amazon' icermiyor ("+actualTitle+" )iceriyor");
            //Title FAILED.Baslik 'Amazon' icermiyor (YouTube )iceriyor
        }

        //10.Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse
        //doğru URL'yi yazdırın
        String actualUrl3=driver.getCurrentUrl();
        String beklenenUrl3="https://www.amazon.com/";

        if(actualUrl3.equals(beklenenUrl3)){
            System.out.println("Url PASSED ");
        }else{
            System.out.println("URL FAILED.Dogru URl : "+actualUrl3);
        }

        //11.Sayfayi kapatin
        driver.close();
    }
}