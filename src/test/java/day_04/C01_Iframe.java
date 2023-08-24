package day_04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class C01_Iframe extends TestBase {

    // https://html.com/tags/iframe sayfasına gidiniz
    // Videoyu görecek kadar asagiya ininiz
    // Videoyu izlemek icin Play tusuna basiniz
    // Videoyu calistirdiginizi test ediniz
    // 'Powerful,but easy to misuse' yazısının gorunur oldugunu test ediniz

    /*
          play'i dogru locate edip click yapmamıza ragmen videoyu calıstırmadı
          bunun üzerine HTML kodlarını inceleyince play'in aslında bir iframe icerisinde oldugunu gorduk
          bu durumda once iframe'i locate edip
          switchTo() ile o iframe'e gecmeliyiz
 */


    @Test
    public void test01() {
        // https://html.com/tags/iframe sayfasına gidiniz
        driver.get("https://html.com/tags/iframe");

        // Videoyu görecek kadar asagiya ininiz
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        /*
        // Videoyu görecek kadar asagiya ininiz
          Actions actions = new Actions(driver);
          WebElement video = driver.findElement(By.xpath("(//*[@class='render'])[1]"));
          actions.scrollToElement(video);
         */

        // Videoyu izlemek icin Play tusuna basiniz
        WebElement iframe = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(iframe);

        WebElement play = driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        play.click();

        /*
        // Videoyu izlemek icin Play tusuna basiniz
          video.click();
         */

        // Videoyu calistirdiginizi test ediniz
        WebElement youTubeYazisi = driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(youTubeYazisi.isDisplayed());




        // 'Powerful,but easy to misuse' yazısının gorunur oldugunu test ediniz

        driver.switchTo().defaultContent();

        WebElement powerYazisi = driver.findElement(By.xpath("//span[@id='Powerful_but_easy_to_misuse']"));

        Assert.assertTrue(powerYazisi.isDisplayed());

    }
}
