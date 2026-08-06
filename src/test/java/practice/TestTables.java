package practice;

import abstractHelperClasses.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestTables extends TestCase {

@Test
    public void testTables() {
    System.out.println("Running testTables...");
    driver.navigate().to("https://money.rediff.com/indices?src=moneyhome_bseIndices_more");
    Assert.assertTrue(driver.getTitle().contains("BSE Indices"), "Page title does not contain 'BSE Indices'");


    WebElement tableHeader = driver.findElement(By.xpath("//*[@id='dataTable']/thead/tr"));
    List<WebElement> tableRows = driver.findElements(By.xpath("//*[@id='dataTable']/tbody/tr"));
    System.out.println("Number of rows in the table: " + tableRows.size());

    List<WebElement> tableColumn = driver.findElements(By.xpath("//*[@id='dataTable']/thead/tr/th"));
    System.out.println("Number of columns in the table: " + tableColumn.size());

    System.out.println("************************************************");
    System.out.println("Data in the header columns:");
    for (WebElement column : tableColumn) {
        System.out.println(column.getText());
    }

    System.out.println("************************************************");
    System.out.println("Data in the table:");
    System.out.println(tableHeader.getText());
    for (WebElement row : tableRows) {
        System.out.println(row.getText());
    }

    System.out.println();
    // System.out.println(tableRows.getText());
//    //print 5th row data
//    WebElement fifthRow = driver.findElement(By.xpath("//*[@id='dataTable']/tbody/tr[5]"));
//    System.out.println("Data in the 5th row: " + fifthRow.getText());
//
//    //print 3rd column data
//    List<WebElement> thirdColumn = driver.findElements(By.xpath("//*[@id='dataTable']/tbody/tr/td[3]"));
//    System.out.println("Data in the 3rd column:");
//    for (WebElement cell : thirdColumn) {
//        System.out.println(cell.getText());
//    }
//    //print all data in the table
//    System.out.println("************************************************");
//    System.out.println("All data in the table:");
//    for (WebElement row : tableRows) {
//        System.out.println(row.getText());
//    }


    String searchValue = "Sensex";
    System.out.println("************************************************");
    System.out.println("Searching for value: " + searchValue);
    boolean found = false;
    int count = 1;
    System.out.println("Found value: " + searchValue);
    for (WebElement row : tableRows) {
        if (row.getText().contains(searchValue)) {
            System.out.println(count+" "+"Row data: " + row.getText());
            found = true;
            count++;
        }
      //  System.out.println("The total number of rows containing the value '" + searchValue + "' is: " + count);
    }
    int lastCount = count -1;
    System.out.println("The total number of rows containing the value '" + searchValue + "' is: " + lastCount);
 }
}