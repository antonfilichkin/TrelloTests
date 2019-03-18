package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestProperties {
    private static final String TEST_PROPERTY_FILE = "aut.properties";

    private static Properties autProperties = new Properties();

    public static String getProperty(String key) {
        if (!autProperties.containsKey(key)) {
            autProperties = getAutProperties();
        }
        // "default" form used to handle the absence of parameter​
        return getAutProperties().getProperty(key, "");
    }

    private static Properties getAutProperties() {
        try (InputStream in = TestProperties.class.getResourceAsStream(TEST_PROPERTY_FILE)){
            autProperties.load(in);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return autProperties;
    }
}