package day14_Exel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {
    @Test
    public void readExcelTest() throws IOException {
        //7. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resources/ulkeler (1).xlsx";
        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);
        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim

        //10. WorkbookFactory.create(fileInputStream)
        Workbook workbook= WorkbookFactory.create(fis);
        //11.Sheet objesi olusturun workbook.getSheetAt(index)
        //12. Row objesi olusturun sheet.getRow(index)
        //13. Cell objesi olusturun row.getCell(index)
        String actualData= workbook
                .getSheet("Sayfa1")
                .getRow(3)
                .getCell(3)
                .toString();
        System.out.println("actualdata : "+actualData);//Cezayir
    }
}
