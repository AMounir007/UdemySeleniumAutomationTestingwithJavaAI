package practice;

import abstractHelperClasses.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TestJavaScriptExecuter extends TestCase {
    @Test
    public void testActionsUsingJavaScriptExecuter() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.location.href ='https://www.example.com', '_blank';");
       // Get title of the current tab
        String FirstPageTitle = (String) js.executeScript("return document.title;");
        System.out.println("Title of the First page: " + FirstPageTitle);
        Assert.assertEquals(FirstPageTitle, "Example Domain", "Title of the first page is not as expected.");

        // Switch to the new tab and navigate to Ejada URL
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
        js.executeScript("window.open('https://www.ejada.com', '_blank');");
        // Get title of the current tab
        tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
        String secondPageTitle = (String) js.executeScript("return document.title;");
        System.out.println("Title of the second page: " + secondPageTitle);
        Assert.assertEquals(secondPageTitle, "Home - ejada - ejada.com", "Title of the second page is not as expected.");

        // scroll down to specific (x,y) using JavaScriptExecutor
        js.executeScript("window.scrollTo(0, 1000);");
        js.executeScript("window.scrollBy(0, 500);");

        // scroll to specific element using JavaScriptExecutor
        WebElement linkedInElement = driver.findElement(By.xpath("//*[@id=\"portlet_com_liferay_journal_content_web_portlet_JournalContentPortlet_INSTANCE_aldg\"]/div/div[2]/div/div/div/footer/div[1]/div/div/ul/li[3]/a"));
        js.executeScript("arguments[0].scrollIntoView(true);", linkedInElement);
        System.out.println("Scrolled to the LinkedIn element using JavaScriptExecutor.");
        System.out.println("LinkedIn element text: " + linkedInElement.getText());
        System.out.println("LinkedIn element href: " + linkedInElement.getAttribute("href"));

        //Perform Click Action
        WebElement learnMoreLinke = driver.findElement(By.xpath("(//*[@class='sp-layer']/a)[1]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> learnMoreLinke.isDisplayed());
        js.executeScript("arguments[0].click();", learnMoreLinke);
        wait.until(d -> driver.findElement(By.id("contactUsButton")).isDisplayed());
        js.executeScript("arguments[0].click();", driver.findElement(By.id("contactUsButton")));
        secondPageTitle = (String) js.executeScript("return document.title;");
        System.out.println("Title of the second page after clicking contact us: " + secondPageTitle);
        assert secondPageTitle != null;
        Assert.assertTrue(secondPageTitle.contains("Contact Us"), "String Contact Us is not found in the title of the second page after clicking contact us.");

        // open a new tab and navigate to a different URL
        js.executeScript("window.open('https://ehub.ejada.com/portal/login', '_blank');");
        tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));

        wait.until(d -> d.findElement(By.id("loginName")).isDisplayed());
        js.executeScript("arguments[0].value='Hello';", driver.findElement(By.id("loginName")));

    }
}
