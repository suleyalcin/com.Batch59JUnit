package day14_Exel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C04_ReadExcel {
    @Test
    public void readExcelTesti() throws IOException {

        String dosyaYolu="src/resources/ulkeler (1).xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);

        //Ingilizce baskentler sutununu yazdiralim
        int sonSatir=workbook.getSheet("Sayfa1").getLastRowNum();//son satirin numarasini getirir.

        // Boylece for i de son satira kadar yazdir diyebiliriz
        System.out.println("Son satir : "+sonSatir);
        String satirdakiData="";

        for (int i = 0; i <=sonSatir ; i++) {
            satirdakiData=C03_ReadExcel.banaDataGetir(i,1);//bir onceki classsdan method kullandik
            System.out.println(satirdakiData);
        }

    }
}
