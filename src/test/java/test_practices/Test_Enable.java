package test_practices;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Test_Enable extends TestBase {

    @Test
    public void test01(){

        // navigate to https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // Test Textbook is disabled
        Assert.assertFalse(driver.findElement(By.xpath("//*[@type='text']")).isEnabled());

        // Click on Enable button and wait until textbook is enabled
        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Confirm "It's enabled!" message is displayed
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='message']")).isDisplayed());


        // confirm textbook is enabled
        Assert.assertTrue(driver.findElement(By.xpath("//*[@type='text']")).isEnabled());


    }
}
