package practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Q7 extends TestBase {
    @Test
    public void test01() {


        // go to url : https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/
        driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
        //-->Task1 Find Dropdown on Multi Selection
        WebElement multiSelection=driver.findElement(By.xpath("//input[@id='justAnInputBox']"));
        multiSelection.click();
        //-->Task2 Find  all Dropdown Elements on page
        List<WebElement>dropList=driver.findElements(By.xpath("//span[@class ='comboTreeItemTitle']"));

        //-->Task3 printout DropDown Elements' number
        System.out.println("dropListteki Elementlerin Sayisi : "+dropList.size());
        System.out.println("************");
        //-->Task4 choose dropdown elements and printout dropdown elements' name  until choise 6
        for (int i = 0; i <dropList.size() ; i++) {
            String text=dropList.get(i).getText();
            System.out.println("text : "+text);

            if(text.equals("choice 6")){
                dropList.get(i).click();
                break;
            }
        }
    }
}