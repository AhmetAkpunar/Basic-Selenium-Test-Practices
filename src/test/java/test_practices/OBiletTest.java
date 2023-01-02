package test_practices;

import Utilities.TestBase;
import Utilities.WaitMethodu;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class OBiletTest extends TestBase {

    @Test
    public void test01(){

        // 1- navigate to https://www.obilet.com/
        driver.get("https://www.obilet.com/");

        // 2- click on Uçak nav-bar button
        driver.findElement(By.xpath("//*[@data-event-action='Flight']")).click();

        // 3- click on Nereden
        WebElement nereden = driver.findElement(By.xpath("//input[@id='origin-input']"));
        nereden.click();
        nereden.sendKeys("Ankara");
        WaitMethodu.bekle(1);
        nereden.sendKeys(Keys.ENTER);

        // 4- click on Nereye
        WebElement nereye = driver.findElement(By.xpath("//input[@id='destination-input']"));
        nereye.click();
        WaitMethodu.bekle(1);
        nereye.sendKeys("İstanbul");
        WaitMethodu.bekle(1);
        nereye.sendKeys(Keys.ENTER);

        // 5- set journey date as 22-03-2023
        driver.findElement(By.xpath("//*[@id='departure-input']")).click();
        WaitMethodu.bekle(1);
        driver.findElement(By.xpath("(//th[@class='next'])[2]")).click();
        WaitMethodu.bekle(1);
        driver.findElement(By.xpath("//*[@data-date='2023-03-22']")).click();
        WaitMethodu.bekle(1);
        driver.findElement(By.xpath("//*[@id='search-button']")).submit();
        WaitMethodu.bekle(10);
        WebElement ucusBilgisi = driver.findElement(By.xpath("(//*[@class='journey row'])[1]"));


        // 6- Testing whether first found ticket is with promotion
        String expectedKelime ="Promosyonlu";
        Assert.assertTrue(ucusBilgisi.getText().contains(expectedKelime));










        WaitMethodu.bekle(3);
    }

}
