package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownLoad extends TestBase {
    @Test

    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");

        //1. Tests packagenin altina bir class oluşturalim
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //3. dummy.txt dosyasını indirelim
        WebElement dummyLinki= driver.findElement(By.xpath("//a[text()='dummy.txt']"));
        dummyLinki.click();
        Thread.sleep(5000);
        //4. dosyanın başarıyla indirilip indirilmediğini test edelim
        // dosya downloads'a indirilecektir, bize downloads'un dosya yolu lazim

        String farkliKisim= System.getProperty("user.home");
        System.out.println("farkli kisim : "+farkliKisim);//farkli kisim : C:\Users\Şule YALÇIN
        String ortakKisim = "\\Downloads\\dummy.txt";
        System.out.println("ortak kisim : "+ortakKisim);//ortak kisim : \Downloads\dummy.txt

        String arananDosyaYolu= farkliKisim+ortakKisim;
        System.out.println("aranan dosya yolu : "+arananDosyaYolu);//aranan dosya yolu : C:\Users\Şule YALÇIN\Downloads\dummy.txt

        // geriye o dosya yolundaki dosyanin var oldugunu assert edelim
        Assert.assertTrue(Files.exists(Paths.get(arananDosyaYolu)));//passed doner

    }
}