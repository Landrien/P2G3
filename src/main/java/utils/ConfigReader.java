package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Utility class to read configuration properties from a {@code config.properties} file.
 */
public class ConfigReader
{
    /**
     * {@link Properties} object containing loaded configuration values.
     */
    private static final Properties properties;

    // Static block to load properties when the class is first loaded
    static
    {
        try (FileInputStream fileInputStream = new FileInputStream("src/main/resources/config.properties"))
        {
            properties = new Properties();
            properties.load(fileInputStream);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            throw new RuntimeException("Failed to load configuration file");
        }
    }

    /**
     * Retrieves the value of a property by its key.
     *
     * @param key The key of the property.
     * @return The corresponding value, or {@code null} if the key is not found.
     */
    public static String getProperty(String key)
    {
        return properties.getProperty(key);
    }
}
