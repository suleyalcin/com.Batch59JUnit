package day14_Exel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C05_ReadExcel {
    @Test
    public void readExcelTesti() throws IOException {
      String dosyaYolu="src/resources/ulkeler (1).xlsx";
      FileInputStream fis=new FileInputStream(dosyaYolu);
      Workbook workbook=WorkbookFactory.create(fis);
        //sayfa 2;ye gidip
        //satir sayisinin 14; kullanilan satir sayisiin  ise 7 oldugunu test edin
    int sonSatirIndex=workbook
        .getSheet("Sayfa2")
        .getLastRowNum();

    int expectedSatirSayisi=14;
    Assert.assertEquals(expectedSatirSayisi,sonSatirIndex+1);

        int kullanilanSatirSayisi=workbook
                                          .getSheet("Sayfa2")
                                          .getPhysicalNumberOfRows();//aradaki bosluklari cikararak kullanilan satir sayisini verir
        int expectedKullanilanSatirSayisi=7;
        Assert.assertEquals(expectedKullanilanSatirSayisi,kullanilanSatirSayisi);
    }
}
