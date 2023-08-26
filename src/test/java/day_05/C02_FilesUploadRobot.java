package day_05;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_FilesUploadRobot extends TestBase {

    // https://www.ilovepdf.com/compress_pdf adrese gidelim
    // Dosya sec butonuna tıklayalım
    // Dosya yuklemek icin robot class'ını kullanalım


    @Test
    public void test01() {
        // 1-) https://www.ilovepdf.com/compress_pdf adrese gidelim
        driver.get("https://www.ilovepdf.com/compress_pdf");

        // 2-) Dosya sec butonuna tıklayalım
        WebElement dosyaSec = driver.findElement(By.xpath("//span[text()='Select PDF files']"));
        dosyaSec.click();

        // 3-) Dosya yuklemek icin robot class'ını kullanalım
           //-->robotclassi kullanarak gonderecegim dosyayi upload edecegim
           //sayfaya mauel gidip bakinca siteye pdf yuklendigi yaziyor bizde pdf yukluyoruz
        // pdf dosyasinin yolu --> C:\Users\Administrator\Desktop\PDF.pdf

        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\Desktop\\PDF.pdf";
        String dosyaYolu = farkliKisim + ortakKisim; //suan benim elimde dinamik bir dosya yolum var simdi testbase e gidiyoum
                                                     //testbase classinin icine robotclass i yapistiriyorum
        uploadFilePath(dosyaYolu);  //dinamik dosyayolunu parametre olarak uploadFilePath classina gonderdim


    }
}
