package practice;

import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Test
public class TestDate {
    public void testCurrentDate() {
        System.out.println("Current date and time Using ()java.time.LocalDateTime.now(): "
                + java.time.LocalDateTime.now());

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//        Date date = new Date();
//        String currentDat = formatter.format(date);
        String currentDat2 = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        System.out.println("Current date and time Using java.util.Date: " + currentDat2);

        String year = new SimpleDateFormat("yyyy").format(new Date());
        System.out.println("Current year: " + year);
    }
}
