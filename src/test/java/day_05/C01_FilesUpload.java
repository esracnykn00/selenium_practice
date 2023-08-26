package day_05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_FilesUpload extends TestBase {
    // masaustunde bir deneme dosyası olusturun. İcine Merhaba Dunya yazınız.
    // 'https://cgi-lib.berkeley.edu/ex/fup.html' adresine gidiniz
    // 'Notes about the file' kısmına 'Benim Dosyam' notunu yazınız.
    // 'Dosya Seç' kısmına deneme dosyasını yükleyiniz.
    // 'Press' butonuna basın
    // Dosya notunun 'Benim Dosyam' oldugunu test ediniz
    // Dosya iceriginin 'Merhaba Dunya' icerdigini test ediniz.


    @Test
    public void test01() {
        // masaustunde bir deneme dosyası olusturun. İcine Merhaba Dunya yazınız.

        // 'https://cgi-lib.berkeley.edu/ex/fup.html' adresine gidiniz
        driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
        bekle(2);

        // 'Notes about the file' kısmına 'Benim Dosyam' notunu yazınız.
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Benim Dosyam");
        bekle(2);

        // 'Dosya Seç' kısmına deneme dosyasını yükleyiniz.
            //--> C:\Users\Administrator\Desktop\deneme.txt  benim dosya yolum bu.
        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\Desktop\\deneme.txt";

        String dosyaYolu = farkliKisim+ortakKisim;

        WebElement dosyaSec = driver.findElement(By.xpath("//input[@name='upfile']"));
        dosyaSec.sendKeys(dosyaYolu);

        // 'Press' butonuna basın
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        // Dosya notunun 'Benim Dosyam' oldugunu test ediniz
        WebElement dosyaNotu = driver.findElement(By.tagName("blockquote"));
        Assert.assertEquals("Benim Dosyam", dosyaNotu.getText());

        // Dosya iceriginin 'Merhaba Dunya' icerdigini test ediniz.
        WebElement icerikDosya = driver.findElement(By.tagName("pre"));
        Assert.assertTrue(icerikDosya.getText().contains("merhaba dunya"));

        //ya da
        //Assert.assertEquals("merhaba dunya",icerikDosya.getText());

    }
}
