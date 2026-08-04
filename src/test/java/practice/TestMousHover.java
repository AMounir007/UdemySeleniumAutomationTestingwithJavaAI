package practice;

import abstractHelperClasses.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class TestMousHover extends TestCase {

    @Test
    public void testMouseHover() {
        driver.get("https://www.amazon.com/");
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(50));
        driver.findElement(By.xpath("(//span[@class='a-button-inner']/input[@type='submit'])[1]")).click();
        Assert.assertTrue(driver.getTitle().contains("Amazon.com."), "Page title does not contain 'Amazon'");

       WebElement accountAndList= driver.findElement(By.cssSelector("div#nav-link-accountList"));
        Actions actions = new Actions(driver);
        actions.moveToElement(accountAndList).build().perform();

        driver.findElement(By.linkText("Recommendations")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("yourstore"),
                "URL does not contain 'recommendations'");

        // Add your mouse hover test logic here
    }
}
