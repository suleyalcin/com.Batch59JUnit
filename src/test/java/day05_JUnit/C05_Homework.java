package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_Homework {
    public static void main(String[] args) {


        //1.Yeni bir class olusturalim (Homework)
        //2.ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title)
        //“facebook” oldugunu dogrulayin (verify), degilse dogru basligi konsolda  yazdirin.
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.facebook.com");

        String  actualTitle=driver.getTitle();
        String arananTitle="facebook";

        if ((arananTitle.equals(actualTitle))){
            System.out.println("title testi PASSED");
        }else {
            System.out.println("Title testi FAILED.Title: " + actualTitle);//degilmis Facebook - Giriş Yap veya Kaydol
        }


        //3.Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa
        //“actual” URL’i yazdirin.
        String  actualUrl=driver.getCurrentUrl();
        String arananUrl="facebook";

        if ((actualUrl.contains(arananUrl))){
            System.out.println("Url 'facebook iceriyor' PASSED");
        }else {
            System.out.println("facebook actual Url: " + actualUrl);//degilmis Facebook - Giriş Yap veya Kaydol
        }



        //4.https://www.walmart.com/ sayfasina gidin.
        driver.get("https://www.walmart.com/ ");


        //5. Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        String actualTitle2=driver.getTitle();
        String beklenenTitle="Walmart.com";
        if(actualTitle2.contains(beklenenTitle)) {
            System.out.println("Title 'Walmart.com iceriyor'PASSED");
        }else {
            System.out.println("Title 'Walmart.com icermiyor' FAILED");
        }



        //6. Tekrar “facebook” sayfasina donun
    driver.navigate().back();


        //7. Sayfayi yenileyin
        driver.navigate().refresh();


        //8. Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();

    }
}