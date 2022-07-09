package day14_Exel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C07_WebTablesHomework {
    @Test
    public Object readExcel2() throws IOException {

        //Yeni bir test method olusturalim readExcel2( )

        //- 1.satirdaki 2.hucreye gidelim ve yazdiralim
        int satirNo=1;
        int sutunNo=2;

        String dosyaYolu="src/resources/ulkeler (1).xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        Object istenenData = workbook
                .getSheet("Sayfa1")
                .getRow(satirNo)
                .getCell(sutunNo)
                .toString();

        return istenenData;

        //- 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        //- 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
        //- Satir sayisini bulalim
        //- Fiziki olarak kullanilan satir sayisini bulun
        //- Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
    }
}