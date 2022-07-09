package day15_writeExcel_screenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class C02_TumSayfaScreenShot extends TestBase {
    @Test
    public void tumSayfa() throws IOException {

        //amazon sayfasina gidip tum sayfanin fotografini cekelim

        driver.get("https://www.amazon.com");
        TakesScreenshot ts = (TakesScreenshot) driver;//bir takeScreen objesi olusturdum.driverin ustune yukledim .
        // beraber sayfaya gidecekler ve sayfanin goruntusunu alabilecek
        LocalDateTime date=LocalDateTime.now();
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih = date.format(dtf);
        System.out.println("TARIH : "+tarih);
        File tumSayfaResim= new File("target/ekranGoruntuleri/tumSayfa"+tarih+".jpeg");//her calistirdigimizda eskinin uzerine fotoyu kaydeder
        //dinamik olsun eskisinide silmesin silmek istersem ben silebileyim dedigimiz icin tarih atar
        // farkli farkli kaydetmis oluruz.birbirinin ustune kaydetmez
        //2.asama olusturacagimiz resmi kaydedecegimiz dosyayi olusturduk
        //dosya yolunu gostererk nereye kaydedecegini gosterdim.targetin altinda ekrangoruntuleri klasoru actim
        File geciciDosya= ts.getScreenshotAs(OutputType.FILE);
        //Taekescreenshot objesini kullanarak gecici bir file'a asssign edelim
        FileUtils.copyFile(geciciDosya,tumSayfaResim);//tumSayfaResimi geciciDosyama kopyaladim




    }
}
