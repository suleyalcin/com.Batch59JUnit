package day15_writeExcel_screenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C03_IstenenWebElementSS  extends TestBase {
    @Test
    public void webElementSS() throws IOException {
        //amazona gidip Nutellla aratalim
        //sonuc sayisinin oldugu web elementinin fotografini cekelim
        driver.get("https://www.amazon.com");
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        WebElement sonucYaziElementi=driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        LocalDateTime date=LocalDateTime.now();
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih = date.format(dtf);
        System.out.println("TARIH : "+tarih);
        File sonucYaziElementSS=new File("target/ekranGoruntuleri/sonucYazisiSS.jpeg");
        File temp=sonucYaziElementi.getScreenshotAs(OutputType.FILE);//gecici temp dosyasi olusturuyoruz
        FileUtils.copyFile(temp,sonucYaziElementSS);//source temp;hedef sonucYaziElementSS.gecici dosyayi hedef dosyayay kaydet
    }
}
