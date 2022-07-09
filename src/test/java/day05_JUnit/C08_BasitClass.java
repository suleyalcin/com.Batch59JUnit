package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C08_BasitClass {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());
        driver.navigate().to("https://www.facebook.com");
        System.out.println(driver.getTitle());

    }
}