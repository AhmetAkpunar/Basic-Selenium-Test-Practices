package test_practices;

import Utilities.TestBase;
import Utilities.WaitMethodu;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TestActions extends TestBase {

    @Test
    public void test01(){

        // navigate to http://webdriveruniversity.com/Actions/
        driver.get("http://webdriveruniversity.com/Actions/");

        // Move on "Hover on Me First" box
        Actions actions = new Actions(driver);
        WebElement hoverOnElement = driver.findElement(By.xpath("//*[text()='Hover Over Me First!']"));
        actions.moveToElement(hoverOnElement).perform();

        // Click on Link 1
        WebElement link1 = driver.findElement(By.xpath("(//a[@class='list-alert'])[1]"));
        actions.moveToElement(link1).click().perform();
        WaitMethodu.bekle(3);

        // Print Popup message
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        // Click and hold on "Click and hold" box
        WebElement clickAndHold = driver.findElement(By.xpath("//*[@id='click-box']"));
        actions.clickAndHold(clickAndHold).perform();
        System.out.println(clickAndHold.getText());

        // Click double on "Double click me"
        WebElement doubleClickMe = driver.findElement(By.tagName("h2"));
        WaitMethodu.bekle(2);
        actions.doubleClick(doubleClickMe).perform();

    }




}
