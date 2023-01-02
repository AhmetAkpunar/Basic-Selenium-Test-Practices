package test_practices;

import Utilities.TestBase;
import Utilities.WaitMethodu;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Test_IFrame extends TestBase {

    @Test
    public void test01(){

        // 1- navigate to http://webdriveruniversity.com/IFrame/index.html
        driver.get("http://webdriveruniversity.com/IFrame/index.html");

        // 2- click on "Our Products"
        driver.switchTo().frame("frame");
        driver.findElement(By.xpath("//a[@href='products.html']")).click();

        // 3- click on "Camera product"
        driver.findElement(By.xpath("//*[@id='camera-img']")).click();
        WaitMethodu.bekle(3);

        // 4- Print Popup message
        System.out.println(driver.findElement(By.xpath("//*[@class='modal-content']")).getText());
        driver.findElement(By.xpath("//button[text()='Close']")).click();

        // 5- Print WebdriverUniversity.com (IFrame) link
        driver.switchTo().defaultContent();
        System.out.println(driver.findElement(By.xpath("//*[@class='navbar-header']")).getText());

    }
}
