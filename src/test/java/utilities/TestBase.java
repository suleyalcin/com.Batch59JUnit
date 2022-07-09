package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class TestBase {//abstract(soyut)yapmak zorunda degiliz ama yaparsak
    // bu classdan obje olusturulmasinin onune gecmis oluruz.Bu class parent class olarak kalir .
    // baskasi gelipte obje olusturmada kullanamaz.

   protected WebDriver driver;
@Before
    public void setup(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

}
@After
    public void tearDown(){
   //driver.quit();
}

}
