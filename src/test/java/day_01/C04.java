package day_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.WatchEvent;

public class C04 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

         // maximize iken pencere konumunu ve pencere olcusunu yazdiriniz
        // fullscreen iken pencere konumunu ve pencere olcusunu yazdiriniz
        // sayfayi kapatiniz

        System.out.println("Pencerenin Konumu : "+driver.manage().window().getPosition());
        System.out.println("Pencerenin Olcusu :"+driver.manage().window().getSize());

        driver.manage().window().fullscreen();
        System.out.println(driver.manage().window().getPosition());
        System.out.println(driver.manage().window().getSize());

        driver.close();


    }
}
