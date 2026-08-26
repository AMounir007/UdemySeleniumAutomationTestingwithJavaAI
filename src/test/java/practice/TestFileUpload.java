package practice;

import abstractHelperClasses.TestCase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Paths;

public class TestFileUpload extends TestCase {

    @Test
    public void testFileUpload() {
        // Implement your file upload test logic here
        System.out.println("Running file upload test...");
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        Assert.assertEquals(driver.getTitle(), "Web form");
//        String filePath = Paths.get("src", "test", "java", "practice", "resources", "1000_us.pdf")
//                .toAbsolutePath()
//                .toString();
//
//        File file = new File(filePath);
//        if (!file.exists()) {
//            throw new RuntimeException("Test file does not exist at: " + filePath);
//        }
        String filePath = System.getProperty("user.dir") +"/src/test/resources/1000_us.pdf";

        System.out.println("Uploading file: " + filePath);
        driver.findElement(By.name("my-file")).sendKeys(filePath);
    }
}
