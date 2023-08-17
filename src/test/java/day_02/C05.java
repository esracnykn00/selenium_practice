package day_02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.awt.*;
import java.util.List;

public class C05 extends TestBase {

        // https://www.amazon.com/ adresine gidin
        // arama motorunda nutella yazip aratınız
        // sayfada karsınıza cıkan tum urunlere tıklayın ve title'ını yazdırın



    @Test
    public void test01() {

        // https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");



        // arama motorunda nutella yazip aratınız
        driver.findElement(By.xpath("(//input)[4]")).sendKeys("nutella" + Keys.ENTER);




        // sayfada karsınıza cıkan tum urunlere tıklayın ve title'ını yazdırın
        List<WebElement> nutellaUrunleri = driver.findElements(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']"));


        for (int i = 0; i < nutellaUrunleri.size(); i++) {

            nutellaUrunleri = driver.findElements(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']"));

            nutellaUrunleri.get(i).click();

            System.out.println(i + "URUN TİTLE : " + driver.getTitle());

            driver.navigate().back();


        }





    }
}