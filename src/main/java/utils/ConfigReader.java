package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader
{
    private static final Properties properties;

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
     * Retrieves the value associated with the specified key from the properties file.
     * @param key The key to search for in the properties file.
     * @return The value corresponding to the provided key.
     */
    public static String getProperty(String key)
    {
        return properties.getProperty(key);
    }
}
