package test_practices;

import Utilities.TestBase;
import Utilities.WaitMethodu;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

public class Test_WindowHandle extends TestBase {


    @Test
    public void test01(){

        // navigate to 1- "http://webdriveruniversity.com/"
        driver.get("http://webdriveruniversity.com/");
        // scroll down to "Login Portal" and click on "Login Portal"
        Actions actions = new Actions(driver);
        WebElement loginElement = driver.findElement(By.xpath("//*[text()='LOGIN PORTAL']"));
        WaitMethodu.bekle(2);
        actions.scrollToElement(loginElement);
        WaitMethodu.bekle(2);
        loginElement.click();
        String firstPageWHD = driver.getWindowHandle();

        // switch to new page and fill the "username" and "password" fields and click on login button
        Set<String> allWHD = driver.getWindowHandles();

        String secondPageWHD  ="";

        for (String eachWHD: allWHD) {

            if (!eachWHD.equals(firstPageWHD)) {
                secondPageWHD = eachWHD;
            }
        }

        driver.switchTo().window(secondPageWHD);
        WebElement username  = driver.findElement(By.xpath("//*[@id='text']"));
        Faker faker = new Faker();
        actions = new Actions(driver);
        username.click();
        actions.sendKeys(faker.internet().emailAddress()
                                 + Keys.TAB
                                 + faker.internet().password()
                                 + Keys.TAB + Keys.ENTER).perform();

        //System.out.println(secondPageWHD);

        // click on login button
        // Test its written "validation failed" on Popup
        String expectedAlertStr="validation failed";
        Assert.assertTrue(driver.switchTo().alert().getText().equals(expectedAlertStr));
        // close the Popup
        driver.switchTo().alert().accept();
        // navigate back to first page

        driver.switchTo().window(firstPageWHD);
        WaitMethodu.bekle(3);
        // Test returning the first page
        Assert.assertTrue(driver.getWindowHandle().equals(firstPageWHD));

        System.out.println(firstPageWHD);
        System.out.println(secondPageWHD);
    }
}
