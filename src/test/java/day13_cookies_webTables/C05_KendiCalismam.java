package day13_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C05_KendiCalismam extends TestBase {

    @Test
    public void webTablesCalismam() {


        login();


    }

    private void login() {
        //● login( ) metodun oluşturun ve oturum açın.
        //● https://www.hotelmycamp.com    admin/HotelRoomAdmin adresine gidin
        driver.get("https://www.hotelmycamp.com");
        //Log in butonuna tiklayin
        driver.findElement(By.xpath("(//*[text()='Log in'])[1]")).click();

        //          ○ Username : manager
        //          ○ Password : Manager1!

        Actions actions = new Actions(driver);
        WebElement userName = driver.findElement(By.xpath("//input[@name='UserName']"));
        actions
                .click(userName)
                .sendKeys("manager")
                .sendKeys(Keys.TAB)
                .sendKeys("Manager1!")
                .sendKeys(Keys.ENTER)
                .perform();


        table();

    }

    private void table() {
        //● table( ) metodu oluşturun//metod olusturmadan devam etti
        //          ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        List<WebElement> sutunSayisi = driver.findElements(By.xpath("//thead//tr[1]//th"));
        System.out.println("Sutun sayisi : " + sutunSayisi.size());//Sutun sayisi : 9
        //          ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        WebElement tumBody = driver.findElement(By.xpath("//tbody"));
        System.out.println("tum body : " + tumBody.getText());
       /* Tum body'i bir String olarak yazdirmak isterseniz
         body webElementini locate edip, getText() method'u ile yazdirabilirsiniz*/
        //● printRows( ) metodu oluşturun //tr
        //
        printRows();


    }

    private void printRows() {
        //○ table body’sinde bulunan toplam satir(row) sayısını bulun.

        List<WebElement> satirSayisi = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Satir Sayisi : " + satirSayisi.size());

        //          ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        for (WebElement each : satirSayisi
        ) {
            System.out.println(each.getText());

        }
        //          ○ 4.satirdaki(row) elementleri konsolda yazdırın.

        List<WebElement> cellelement = driver.findElements(By.xpath("//tr[4]"));

        for (WebElement each : cellelement
        ) {
            System.out.println(each.getText());

        }
        //          Email basligindaki tum elementleri(sutunu) konsolda yazdırın.
        /* once email basliginin kacinci sutunda oldugunu bulalim*/
        List<WebElement> EmailSutunListesi = driver.findElements(By.xpath("//thead//tr[1]//th[3]"));


        int emailSatirNo = 0;
        for (int i = 0; i < EmailSutunListesi.size(); i++) {
            if (EmailSutunListesi.get(i).getText().equals("Email")) {
                emailSatirNo = i;
            }
        }

    }
}

