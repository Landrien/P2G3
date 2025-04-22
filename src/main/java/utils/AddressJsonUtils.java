package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class to read address data from a JSON file.
 */
public class AddressJsonUtils
{
    /**
     * JSON parser used to read the JSON file.
     */
    public static final JSONParser parser = new JSONParser();

    /**
     * Path to the JSON file containing address data.
     */
    public static final String addressesFilePath = "src/main/resources/addresses.json";

    /**
     * Retrieves all values of a specific address as a list of strings,
     * identified by the given key from the JSON file.
     *
     * @param addressKey The key corresponding to the desired address.
     * @return A list of address values, or {@code null} in case of an error.
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
     * Retrieves a specific element from a given address using the address and element keys.
     *
     * @param addressKey The key corresponding to the desired address.
     * @param elementKey The key of the element to retrieve.
     * @return The string value of the requested element, or {@code null} in case of an error.
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
