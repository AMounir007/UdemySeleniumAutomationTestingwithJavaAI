package pilotProject;

import abstractHelperClasses.TestCase;
import org.testng.annotations.Test;

public class BookAppointmentTest extends TestCase {
    @Test
    public void testBookAppointment(){
       // driver.get("https://www.sakraworldhospital.com/request-appointment");
        driver.get(properties.getProperty("sakraHospitalAppoinmentURL"));
    }
}
