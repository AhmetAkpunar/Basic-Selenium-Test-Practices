package test_practices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test_ImplicitlyWaitMethodu {

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void teardown(){
        driver.quit();
    }


    @Test
    public void implicitlyWait(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //3. navigate to https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. click on Remove button
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        //5. Test “It’s gone!” message is displayed
        WebElement itsGoneElement = driver.findElement(By.xpath("//*[@id='message']"));
        Assert.assertTrue(itsGoneElement.isDisplayed());

        //6. click on Add button
        driver.findElement(By.xpath("//*[text()='Add']")).click();
        //7. Test It’s back message is displayed
        WebElement itsBackElement = driver.findElement(By.xpath("//*[@id='message']"));
        Assert.assertTrue(itsBackElement.isDisplayed());
    }

}
