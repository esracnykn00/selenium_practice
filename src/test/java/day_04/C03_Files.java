package day_04;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_Files {

    // Desktop(masaustu)'da bir text dosyası olusturun
    // Desktop(masaustu)'da text dosyasının olup olmadıgını test edin


    @Test
    public void test01() {
        // Desktop(masaustu)'da bir text dosyası olusturun


        // Desktop(masaustu)'da text dosyasının olup olmadıgını test edin

        //"C:\Users\Administrator   \Desktop\text.txt"  -->Dosya Yolu(sag click properties-security) bu sekilde ayirdigim yerde herkesin bilgisayainda farkli olan kisim sol taraf

        //String farkliKisim = "C:\\Users\\Administrator";  --> baska birin bilg.inde calisirken bu sekilde calismak istemem daha dinamik yapiyorum asagida:

        String farkliKisim = System.getProperty("user.home"); //user.home kullanarak daha dinamik hale getirmis oldum
        System.out.println("Farkli Kisim = " + farkliKisim);
        String ortakKisim = "\\Desktop\\text.txt";
        System.out.println("Ortak Kisim = " + ortakKisim);

        String dosyaYolu = farkliKisim + ortakKisim;
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu))); //-->Files.exist derken dosya mevcut mu dedim hangi dosya ?dosyaYolu.



    }
}
