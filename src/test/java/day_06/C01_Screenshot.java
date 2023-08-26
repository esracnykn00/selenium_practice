package day_06;

import org.apache.commons.io.FileUtils;
import org.bouncycastle.jcajce.provider.drbg.DRBG;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C01_Screenshot extends TestBase {

    // https://www.amazon.com/ adresine gidin
    // arama kutusuna Nutella yazip aratın
    // ilk ürüne tıklayın
    // tüm sayfanın fotografını cekin


    @Test
    public void test01() throws IOException {
        // https://www.amazon.com/ adresine gidin
        driver.get("http://amazon.com");

        // arama kutusuna Nutella yazip aratın
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Nutella", Keys.ENTER);

        // ilk ürüne tıklayın
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();




        // tüm sayfanın fotografını cekin

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih = date.format(dtf);


        TakesScreenshot ts = (TakesScreenshot) driver; //-->tum ekranin fotografini cek dedigi icin bu objeyi olusturdum

       // File kaydet = new File("target/ekranGoruntusu/tumSayfa.jpeg");  //-->nereye kaydedecegimizi soyluyoruz, trget a kaydet diyoruz burda

        //File geciciDosya = ts.getScreenshotAs(OutputType.FILE);

        //FileUtils.copyFile(geciciDosya,kaydet);

        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("target/ekranGoruntusu/tumSayfa.jpeg"));

        //NOT: Bu sekilde her calistirdigimda ekran resminin yenisini o saate gore alacak ama ben local date time alirsam bu sekilde bir method olusturarak
        //o zaman her calistirdigim dk saat sn tarih belli olmus olacak

    }

    @Test
    public void test02() throws IOException {
        // https://www.amazon.com/ adresine gidin
        driver.get("http://amazon.com");

        // arama kutusuna Nutella yazip aratın
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Nutella", Keys.ENTER);

        // ilk ürüne tıklayın
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();

        // tüm sayfanın fotografını cekin
        tumSayfaEkranGoruntusu();


    }
}
