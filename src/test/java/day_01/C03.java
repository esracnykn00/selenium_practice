package day_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // https://www.amazon.com/ adresine gidin
        // Kaynak Kodlarini konsola yazdiriniz
        // Kaynak Kodlarinda "window" yazdigini test edin
        // sayfayi kapatiniz


        driver.get("https://www.amazon.com/");
        String sayfaKaynakKodlari = driver.getPageSource(); //bu bize bulundugumuz sayfanin kaynak kodlarini verir
        System.out.println("Sayfa Kaynak Kodlari : "+sayfaKaynakKodlari);

        if (sayfaKaynakKodlari.contains("window")){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }

        driver.close();





















    }
}
