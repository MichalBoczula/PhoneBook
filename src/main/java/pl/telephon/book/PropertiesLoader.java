package pl.telephon.book;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {
    private static PropertiesLoader propertiesLoader = getInstance();
    private Properties properties;

    private PropertiesLoader() {
        properties = new Properties();
        setProperties();
    }

    private void setProperties() {
        try {
            properties.load(new FileInputStream("A:\\Programowanie\\JavaStart\\telephonBook\\src\\main\\resources\\application.properties"));
        } catch (IOException e) {
            System.out.println("File NOT found on this location");
        }
    }

    public static PropertiesLoader getInstance() {
        if (propertiesLoader == null) {
            propertiesLoader = new PropertiesLoader();
        }
        return propertiesLoader;
    }

    public Properties getProperties() {
        return properties;
    }
}
