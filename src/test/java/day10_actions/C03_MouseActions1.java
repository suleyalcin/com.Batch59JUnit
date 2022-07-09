package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C03_MouseActions1 extends TestBase {
//1- Yeni bir class olusturalim: MouseActions1
//2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
    @Test
    public void test010() {
        driver.get("https://the-internet.herokuapp.com/context_menu ");

//3- Cizili alan uzerinde sag click yapalim
        Actions actions = new Actions(driver);
        WebElement ciziliAlan = driver.findElement(By.xpath("//div[@id='hot-spot']"));
        actions.contextClick(ciziliAlan).perform();
//4- Alert’te cikan yazinin “You selected a context menu” oldugunu dogrulayalim
        String expectedYazi="You selected a context menu";
        String actualYazi= driver.switchTo().alert().getText();
        Assert.assertEquals(expectedYazi,actualYazi);
        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
//6- Elemental Selenium linkine tiklayalim
        String ilkSayfaWHDegeri=driver.getWindowHandle();
        System.out.println("ilk sayfa Window handle degeri : "+ilkSayfaWHDegeri);
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        Set<String> handleSeti=driver.getWindowHandles();
        String ikinciSayfaWHDegeri="";

        System.out.println("handleSeti : "+handleSeti);
        for (String each: handleSeti
        ) {
            if (!each.equals(ilkSayfaWHDegeri)){
                ikinciSayfaWHDegeri=each;
            }
        }
        System.out.println("Ikinci Sayfa Window Handle Degeri= "+ikinciSayfaWHDegeri);



//7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        driver.switchTo().window(ikinciSayfaWHDegeri);
        WebElement yaziElementi=driver.findElement(By.tagName("h1"));
        String expectedYazi2="Elemental Selenium";
        String actualYazi2=yaziElementi.getText();
        Assert.assertEquals(expectedYazi2,actualYazi2);

    }
}
