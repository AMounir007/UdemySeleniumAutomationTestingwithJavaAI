package abstractHelperClasses;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesLoader {
    public static Properties getProperty() {
        Properties properties = new Properties();
        String path = System.getProperty("user.dir") + "/src/test/resources/sakraHospital_BookAppointment.properties";
        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            properties.load(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return properties;
    }
}
