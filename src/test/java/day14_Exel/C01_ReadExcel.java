package day14_Exel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {
    @Test
    public void readExcelTest() throws IOException {
        // 7. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler (1).xlsx";
        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);
        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook = WorkbookFactory.create(fis);
        //10. WorkbookFactory.create(fileInputStream)


        //11. Sheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet = workbook.getSheet("Sayfa1");
        //12. Row objesi olusturun sheet.getRow(index)
        Row row = sheet.getRow(3);//3.satiri getir
        //13. Cell objesi olusturun row.getCell(index)
        Cell cell = row.getCell(3);
        System.out.println(cell);//(3,3)=Cezayir yazdirir

        //3.index'deki satirin 3.indexindeki datanin Cezayir oldugunu test edin
        String expectedData="Cezayir";
        String actualData=cell.toString();
        System.out.println("actualData : "+actualData);
        Assert.assertEquals(expectedData,actualData);
        //Assert.assertEquals(expectedData,cell.getStringCellValue());
        //33. 34. e 35. satir yerine 36. tek satirlada (3,3) de Cezayir varmi diye bakilabilir
    }
}
