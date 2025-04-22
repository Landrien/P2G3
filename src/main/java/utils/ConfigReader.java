package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Classe pour lire les propriétés de configuration à partir d'un fichier `config.properties`.
 */
public class ConfigReader
{
    /**
     * Objet {@link Properties} contenant les propriétés chargées depuis le fichier de configuration.
     */
    private static final Properties properties;

    // Chargement statique des propriétés dès le chargement de la classe
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
     * Récupère la valeur d'une propriété à partir de sa clé.
     *
     * @param key La clé de la propriété
     * @return La valeur associée à la clé, ou {@code null} si la clé n'existe pas.
     */
    public static String getProperty(String key)
    {
        return properties.getProperty(key);
    }
}
