package day_04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FilesDownload extends TestBase {

    // 'https://the-internet.herokuapp.com/download' adresine gidiniz
    // some-file.txt dosyasini indirelim
    // dosyanin bilgisayarınızda Downloads(indirilenler)'a basariyla indirilip indirilmedigini test ediniz


    @Test
    public void test01() {
        // 'https://the-internet.herokuapp.com/download' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/download");

        // some-file.txt dosyasini indirelim
        driver.findElement(By.xpath("//*[text()='some-file.txt']")).click();

        // dosyanin bilgisayarınızda Downloads(indirilenler)'a basariyla indirilip indirilmedigini test ediniz

        //      C:\Users\Administrator         \Downloads\some-file.txt

        String farkliKisim = System.getProperty("user.home");

        String ortakKisim = "\\Downloads\\some-file.txt" ;



        String dosyaYolu = farkliKisim + ortakKisim;

        bekle(3);


        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


    }
}
