package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import java.nio.file.Files;
import java.nio.file.Paths;


public class C03_FileExist {

    @Test
    public void test01() {
        System.out.println(System.getProperty("user.dir"));
        // bana icinde oldugum projenin dosya yolunu(path) verir
        // C:\Users\Şule YALÇIN\IdeaProjects\com.Batch59JUnit
        System.out.println(System.getProperty("user.home"));
        //C:\Users\Şule YALÇIN  yani benim bilgisayarimin bana ozel kismini verdi

        // Masa ustumuzdeki text dosyasinin varligini test edin
        // "C:\Users\Lenovo\Desktop\text.txt"
        String dosyaYolu= System.getProperty("user.home")+ "\\Desktop\\text.txt";
        System.out.println("Dosya Yolum : "+dosyaYolu);
        //Dosya Yolum : C:\Users\Şule YALÇIN\Desktop\text.txt
        /*
        Bilgisayarimizdaki bir dosyanin varligini test etmek icin
        once o dosyaya ulasmamiz gerekir
        Java'da dosyaya erisim icin dosya yoluna (path) ihtiyac vardir
        Her bilgisayarin kullanici adi farkli olacagindan
        masaustu dosya yolu da birbirinden farkli olacaktir
        Testlerimizin tum bilgisayarlarda calismasi icin dosya yolunu DINAMIK yapmak zorundayiz
        Bunun icin
         her bilgisayarin birbirinden farkli olan yolunu bulmak icin
         */
        String farkliKisim= System.getProperty("user.home");
        System.out.println("farkli Kisim : "+farkliKisim);
        //farkli Kisim : C:\Users\Şule YALÇIN

        // herkesin bilgisayarinda ortak olan kisim ise
        String ortakKisim="\\OneDrive\\Masaüstü\\text.txt";
        System.out.println("ortak Kisim : "+ortakKisim);
        //ortak Kisim : \OneDrive\Masaüstü\text.txt



        String masaustuDosyaYolu=farkliKisim+ortakKisim ;
        System.out.println("masaustu dosya yolu : "+masaustuDosyaYolu);
       // System.out.println(Files.exists(Paths.get(masaustuDosyaYolu)));///boolean sonuc dondurur var mi yok mu?
        //masaustu dosya yolu : C:\Users\Şule YALÇIN\Desktop\text.txt
        Assert.assertTrue(Files.exists(Paths.get(masaustuDosyaYolu)));
    }
}
