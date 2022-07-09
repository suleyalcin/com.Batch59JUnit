package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C07_LoginText {
    public static void main(String[] args) throws InterruptedException {
        //1. Bir class oluşturun: LoginTest
        //2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
        //a. http://a.testaddressbook.com adresine gidiniz.
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("http://a.testaddressbook.com ");
        Thread.sleep(3000);

        //b. Sign in butonuna basin
        driver.findElement(By.xpath("//a[@id='sign-in']")).click();
        //c. email textbox,password textbox, and signin button elementlerini locate
        //ediniz..
        driver.findElement(By.xpath("//input[@type='email']"));
        driver.findElement(By.xpath("(//input[@class='form-control'])[2]"));
        driver.findElement(By.xpath("//input[@type='submit']"));

        // d. Kullanıcı adını ve şifreyi aşağıdaki bilgilerle girin ve oturum aç (sign
        //in)buttonunu tıklayın:
        // i. Username : testtechproed@gmail.com
        //ii. Password : Test1234!
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("testtechproed@gmail.com");
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//input[@class='form-control'])[2]")).sendKeys("Test1234!");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@type='submit']")).click();


        //e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
        WebElement actualUserId = driver.findElement(By.xpath("//span[@class='navbar-text']"));
        String expectedUserId = "testtechproed@gmail.com";
        System.out.println(actualUserId.getText() );
        if(actualUserId.equals(expectedUserId)){
            System.out.println("ExpectedUserId PASSED");
        }else{
            System.out.println("ExpectedUserrId FAILED");
        }

        //f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
        WebElement Adresses=driver.findElement(By.xpath("//a[@class='nav-item nav-link']"));
        WebElement SignOut=driver.findElement(By.xpath("//a[@data-method='delete']"));

        if(Adresses.isDisplayed()){
            System.out.println("Adresses Testi PASSED");
        }else{
            System.out.println("Adresses Testi FAILED");
        }

        if(SignOut.isDisplayed()){
            System.out.println("SignOut Testi PASSED");
        }else{
            System.out.println("SignOut Testi FAILED");
        }

        //3. Sayfada kac tane link oldugunu bulun.
        List<WebElement>linklerListesi=driver.findElements(By.tagName("a"));
        System.out.println("Sayfadaki Link Sayisi :"+linklerListesi.size());
        //linkleri yazdiralim
        //Listemiz Webelementlerinden olustugu icin ,direk yazdirirsakreferanslari yazdirir
        for (WebElement each:linklerListesi
             ) {
            System.out.println(each.getText());

        }
        driver.close();
        }
        
    }


