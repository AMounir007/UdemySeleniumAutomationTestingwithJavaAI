package practice;

import abstractHelperClasses.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class TestDragAndDrop extends TestCase {

    public void testDragable(){
        driver.get("https://jqueryui.com/droppable/");
        Assert.assertEquals(driver.getTitle(),
                "Droppable | jQuery UI", "Page title does not match expected value");
        Actions actions = new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
        WebElement dragableElement= driver.findElement(By.xpath("//div[@id='draggable']/p"));
        WebElement dropableElement= driver.findElement(By.xpath("//div[@id='droppable']/p"));
        actions.dragAndDrop(dragableElement,dropableElement).build().perform();
        Assert.assertEquals(dropableElement.getText(),"Dropped!","Dropable element text does not match expected value");

        driver.navigate().refresh();
       // driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
        actions.clickAndHold(dragableElement).moveToElement(dropableElement).release().build().perform();
        Assert.assertEquals(dropableElement.getText(),"Dropped!","Dropable element text does not match expected value after refresh and drag-drop");
    }
    public void testClickAndHoldAndRelease(){
        driver.get("https://jqueryui.com/droppable/");
        Assert.assertEquals(driver.getTitle(),
                "Droppable | jQuery UI", "Page title does not match expected value");
        Actions actions = new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
        WebElement dragableElement= driver.findElement(By.xpath("//div[@id='draggable']/p"));
        WebElement dropableElement= driver.findElement(By.xpath("//div[@id='droppable']/p"));

      //  driver.navigate().refresh();
       // driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
        actions.clickAndHold(dragableElement).moveToElement(dropableElement).release().build().perform();
        Assert.assertEquals(dropableElement.getText(),"Dropped!","Dropable element text does not match expected value after refresh and drag-drop");
    }
}
