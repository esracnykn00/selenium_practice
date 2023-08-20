package day_03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C01_DropDownMenu extends TestBase {

    // https://www.amazon.com/ sayfasina gidin
    // dropdown'dan "Books" secenegini secin
    // arama cubuguna "Java" aratın
    // arama sonuclarinin Java icerdigini test edin


    @Test
    public void test01() {

        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");


        // dropdown'dan "Books" secenegini secin

        // Dropdown 3 adımda handle edilir
        // 1 - DROPDOWN LOCATE EDİLMELİDİR.
        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        // 2 - SELECT OBJESİ OLUSTURULUR.
        Select select = new Select(ddm);


        // 3 - OPTİONLARDAN BİR TANESİ SECİLMELİDİR.
        // select.selectByVisibleText("Books");
        // ddmVisibleText(ddm,"Books");

        // select.selectByIndex(5);
        // ddmIndex(ddm, 5);


        // select.selectByValue("search-alias=stripbooks-intl-ship");
        ddmValue(ddm,"search-alias=stripbooks-intl-ship");





        // arama cubuguna "Java" aratın
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Java" + Keys.ENTER);





        // arama sonuclarinin Java icerdigini test edin
        WebElement aramaSonucElementi =  driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));

        Assert.assertTrue(aramaSonucElementi.getText().contains("Java"));




    }



}
