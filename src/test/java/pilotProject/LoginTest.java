package pilotProject;

import abstractHelperClasses.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends TestCase {
    @Test
    public void testLoginSuccessfully(){
       // driver.get("https://www.sakraworldhospital.com/request-appointment");
        driver.get(properties.getProperty("orangeHRMURL"));
        // Implicit Wait for the page to load and the title to be available
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Assert that the title of the page is as expected
        Assert.assertEquals(driver.getTitle(), properties.getProperty("orangeHRMTitle"));
        // Explicit Wait for the username and password input fields to be visible and the login button to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //wait.until(driver -> driver.findElement(By.name(properties.getProperty("usernameText"))).isDisplayed());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(properties.getProperty("usernameText"))));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(properties.getProperty("passwordText"))));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("loginButton"))));

        // Find the username and password input fields and enter the credentials
        driver.findElement(By.name(properties.getProperty("usernameText")))
                .sendKeys(properties.getProperty("usernameValue"));
        driver.findElement(By.name(properties.getProperty("passwordText")))
                .sendKeys(properties.getProperty("passwordValue"));
        driver.findElement(By.xpath(properties.getProperty("loginButton"))).click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(properties.getProperty("MyInfoText"))));
        driver.findElement(By.linkText(properties.getProperty("MyInfoText"))).click();

        // Open Marital Status dropdown once
        By maritalStatusDropdown = By.xpath(properties.getProperty("maritalStatusXpath"));
        wait.until(ExpectedConditions.elementToBeClickable(maritalStatusDropdown)).click();

        // Select the actual option from the opened list (from properties)
        By marriedOption = By.xpath(properties.getProperty("marriedOptionXpath"));
        wait.until(ExpectedConditions.elementToBeClickable(marriedOption)).click();

        // Verify UI reflects the selected value (from properties)
        By selectedMaritalStatus = By.xpath(properties.getProperty("selectedMaritalStatusTextXpath"));
        String selectedValue = wait.until(ExpectedConditions.visibilityOfElementLocated(selectedMaritalStatus)).getText().trim();
        Assert.assertEquals(selectedValue, "Married", "Marital Status was not selected correctly.");

    }
}
