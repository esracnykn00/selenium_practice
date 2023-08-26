package day_06;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C02_Screenshot extends TestBase {

    // https://www.teknosa.com/ adresine gidin
    // arama cubuguna oppo yazip enter'a basınız
    // sonuc yazısını yazdiriniz
    // ilk urunun fotografını cekin
    // cikan ilk urune tiklayiniz
    // sepete ekleyiniz butonu gorununceye kadar bir PAGE_DOWN sayfayı asagiya kaydirabilirin
    // sepete ekleyiniz
    // sepetim'e git tilayiniz
    // "Siparis Ozeti" webelementinin text'ini yazdiriniz
    // Alisverisi tamamlayiniz
    // "Teknosa'ya hos geldiniz" webelementinin text'ini yazdiriniz


    @Test
    public void test01() throws IOException {

        // https://www.teknosa.com/ adresine gidin
        driver.get("https://www.teknosa.com/");

        // arama cubuguna oppo yazip enter'a basınız
        try {
            driver.findElement(By.xpath("//div[@id='ins-editable-button-1580496494']")).click();
        } catch (Exception e) {
            System.out.println("cookies cikmadi");
        }
        //NOT:cookies bazen cikiyor bazen cikmiyor ama cikmazsa da dogru locate alamiyorum dolayisiyla
        //bir  try catch blogu olusturdum ki ciksa da cikmazsa da tedbir olsun ve ben dogru locate alabileyim diger islemler icin
        //--> simdi arama cubugunun locate ini aliyorum
        driver.findElement(By.xpath("//input[@id='search-input']")).sendKeys("oppo", Keys.ENTER);

        // sonuc yazısını yazdiriniz
        WebElement sonucYazisi = driver.findElement(By.xpath("//div[@class='plp-panel-block1']"));
        System.out.println("Sonuc Yazisi = " + sonucYazisi.getText());
        bekle(2);

        // ilk urunun fotografını cekin
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih = date.format(dtf);

        WebElement ilkUrun = driver.findElement(By.xpath("(//a[@class=' prd-link '])[1]"));
        File kayit = new File("src/test/java/utilities/ekranGoruntusu/ilkUrun.png"); //fotografi cektim
        File gecici = ilkUrun.getScreenshotAs(OutputType.FILE); //gecici bir dosyaya kaydettim
        FileUtils.copyFile(gecici,kayit); //gecici dosyayi gercek dosyay kaydet diyoruz
        bekle(3);

        // cikan ilk urune tiklayiniz
        ilkUrun.click();

        // sepete ekleyiniz butonu gorununceye kadar bir PAGE_DOWN sayfayı asagiya kaydirabilirin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        // sepete ekleyiniz

        driver.findElement(By.xpath("//button[@id='addToCartButton']")).click();

        bekle(3);


        // sepetim'e git tilayiniz

        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();

        bekle(3);


        // "Siparis Ozeti" webelementinin text'ini yazdiriniz

        WebElement siparisOzeti = driver.findElement(By.xpath("//div[text()='Sipariş Özeti']"));
        System.out.println(siparisOzeti.getText());


        bekle(3);

        // Alisverisi tamamlayiniz

        driver.findElement(By.xpath("//a[@class='btn btn-primary js-checkout-controls']")).click();


        bekle(3);


        // "Teknosa'ya hos geldiniz" webelementinin text'ini yazdiriniz

        WebElement teknosayaHosgeldiniz = driver.findElement(By.xpath("//div[text()='Teknosa'ya Hoş Geldiniz']"));

        System.out.println(teknosayaHosgeldiniz.getText());

    }
}
