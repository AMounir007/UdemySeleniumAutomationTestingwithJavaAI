package practice;

import abstractHelperClasses.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class TestDragAndDrop extends TestCase {

    public void testDragableTest(){
        driver.get("https://jqueryui.com/droppable/");
        Assert.assertEquals(driver.getTitle(),
                "Droppable | jQuery UI", "Page title does not match expected value");
        Actions actions = new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
        WebElement dragableElement= driver.findElement(By.xpath("//div[@id='draggable']/p"));
        WebElement dropableElement= driver.findElement(By.xpath("//div[@id='droppable']/p"));
        actions.dragAndDrop(dragableElement,dropableElement).build().perform();


    }
}
