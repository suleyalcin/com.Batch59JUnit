package day13_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C04_WebTablesHomework extends TestBase {
    @Test
    public void test01() {
//Bir Class olusturun D19_WebtablesHomework
        //  1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");
        //  2. Headers da bulunan department isimlerini yazdirin
        System.out.println("Headers da bulunan department isimlerini");
        List<WebElement> headers=driver.findElements(By.xpath("//div[@class='rt-tr-group']//div[@class='rt-td'][6]"));


        int Index = 0;
        for (int i = 0; i < headers.size(); i++) {
            if (headers.get(i).getText().equals("Department")) {
                Index = i;
            }
        }
        Index++;


        //  3. sutunun basligini yazdirin
        System.out.println("sutun başlıkları");
        List<WebElement> basliklarListesi=driver.findElements(By.xpath("//div[@class='rt-resizable-header-content']"));
        for (WebElement each: basliklarListesi
        ) {
            System.out.println(each.getText());
        }
        //  4. Tablodaki tum datalari yazdirin
        System.out.println("tüm datalar");
        List<WebElement> tumData=driver.findElements(By.xpath("//div[@class='rt-td']"));
        for (WebElement each: tumData
        ) {
            if (!(each.equals(""))){
                System.out.println(each.getText());
            }
        }
        System.out.println("bitti");

    //  5. Tabloda kac cell (data) oldugunu yazdirin
    //  6. Tablodaki satir sayisini yazdirin
    //  7. Tablodaki sutun sayisini yazdirin
    //  8. Tablodaki 3.kolonu yazdirin
    //  9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
    //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin



    }
}
