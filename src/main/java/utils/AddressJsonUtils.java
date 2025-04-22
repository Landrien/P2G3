package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe pour lire les données d'adresses depuis un fichier JSON.
 */
public class AddressJsonUtils
{
    /**
     * Parser JSON utilisé pour lire les fichiers.
     */
    public static final JSONParser parser = new JSONParser();

    /**
     * Chemin du fichier JSON contenant les adresses.
     */
    public static final String addressesFilePath = "src/main/resources/addresses.json";

    /**
     * Récupère toutes les valeurs (sous forme de liste) d'une adresse spécifique
     * identifiée par sa clé dans le fichier JSON.
     *
     * @param addressKey La clé de l'adresse à récupérer
     * @return Une liste des valeurs de l'adresse, ou {@code null} en cas d'erreur.
     */
    public static List<String> getAddressInfo(String addressKey)
    {
        try
        {
            JSONObject addresses = (JSONObject) parser.parse(new FileReader(addressesFilePath));
            JSONObject address = (JSONObject) addresses.get(addressKey);

            List<String> addressInfo = new ArrayList<>();
            for (Object key : address.keySet())
            {
                Object value = address.get(key);
                addressInfo.add(String.valueOf(value));
            }
            return addressInfo;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Récupère une valeur spécifique d'une adresse à partir du fichier JSON.
     *
     * @param addressKey La clé de l'adresse
     * @param elementKey Le nom de l'élément à récupérer
     * @return La valeur correspondante sous forme de chaîne, ou {@code null} en cas d'erreur.
     */
    public static String getAddressElement(String addressKey, String elementKey)
    {
        try
        {
            JSONObject addresses = (JSONObject) parser.parse(new FileReader(addressesFilePath));
            JSONObject address = (JSONObject) addresses.get(addressKey);

            return String.valueOf(address.get(elementKey));
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
