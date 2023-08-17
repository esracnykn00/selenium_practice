package day_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;
import java.util.IllegalFormatCodePointException;

public class C02 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // "https://teknosa.com/" adresine gidiniz
        // Sayfanin Title'ini ve URL'ini aliniz ve yazdiriniz
        // Title'in "Teknoloji" kelimesini icerip icermedigini kontrol ediniz
        // URL'in "teknosa" kelimesini icerip icermedigini kontrol ediniz
        // "https://medunna.com/" adresine gidiniz
        // Sayfanin Title'ini ve URL'ini aliniz ve yazdiriniz
        // Title'in "MEDUNNA" kelimesini icerip icermedigini kontrol ediniz.
        // URL'in "medunna" kelimesini icerip icermedigini kontrol ediniz
        // teknosa adresine geri donunuz
        // Sayfayı yenileyiniz
        // medunna adresine ilerleyiniz
        // Sayfayı yenileyiniz
        // pencereyi kapat

        driver.get("https://teknosa.com");
        Thread.sleep(2000);
        String teknosaTitle = driver.getTitle();
        System.out.println("Sayfanin Basligi :"+driver.getTitle());
        String teknosaUrl = driver.getCurrentUrl();
        System.out.println("Sayfanin URL'i : "+driver.getCurrentUrl());

        if (teknosaTitle.contains("Teknoloji")){
            System.out.println("PASSED");
        }else System.out.println("FAILED");

        if (teknosaUrl.contains("teknosa")){
            System.out.println("PASSED");
        }else System.out.println("FAILED");

        driver.navigate().to("https://medunna.com");
        Thread.sleep(2000);
        String medunnaTitle = driver.getTitle();
        System.out.println("Medunna Title : "+medunnaTitle);
        String medunnaUrl = driver.getCurrentUrl();
        System.out.println("Medunna Url :"+medunnaUrl);

        if (teknosaTitle.contains("MEDUNNA")){
            System.out.println("PASSED");
        }else System.out.println("FAILED");

        if (teknosaUrl.contains("medunna")){
            System.out.println("PASSED");
        }else System.out.println("FAILED");

        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.navigate().forward();
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.close();
















    }
}
