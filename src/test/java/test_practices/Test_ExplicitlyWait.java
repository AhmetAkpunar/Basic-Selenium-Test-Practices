package test_practices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Test_ExplicitlyWait {

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void ExplicitlyWait(){
        //3. navigate to https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. click on Remove button
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        //5. Test “It’s gone!” message is displayed
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement itsGoneElement =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));

        Assert.assertTrue(itsGoneElement.isDisplayed());

        //6. click on Add button
        driver.findElement(By.xpath("//*[text()='Add']"));

        //7. Test It’s back message is displayed
      WebElement itsBackElement =
              wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
      Assert.assertTrue(itsBackElement.isDisplayed());

    }

}
