package day_04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FilesDownload extends TestBase {

    // 'https://the-internet.herokuapp.com/download' adresine gidiniz
    // some-file.txt dosyasini indirelim
    // dosyanin bilgisayarınızda Downloads(indirilenler)'a basariyla indirilip indirilmedigini test ediniz
//      C:\Users\Administrator         \Downloads\some-file.txt

    @Test
    public void test01() {

        // 'https://the-internet.herokuapp.com/download' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/download");


        String farkliKisimm = System.getProperty("user.home");

        String ortakKisimm = "\\Downloads\\some-file.txt";



        String dosyaYoluu = farkliKisimm + ortakKisimm;


        try {
            Files.delete(Paths.get(dosyaYoluu));
        } catch (IOException e) {
            System.out.println("Dosya Bulunamadı");
        }


        // some-file.txt dosyasini indirelim
        driver.findElement(By.xpath("//a[text()='some-file.txt']")).click();



        // dosyanin bilgisayarınızda Downloads(indirilenler)'a basariyla indirilip indirilmedigini test ediniz


        //           "C:\Users\BURAK                   \Downloads\some-file.txt"

        String farkliKisim = System.getProperty("user.home");

        String ortakKisim = "\\Downloads\\some-file.txt";



        String dosyaYolu = farkliKisim + ortakKisim;


        bekle(3);


        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}
