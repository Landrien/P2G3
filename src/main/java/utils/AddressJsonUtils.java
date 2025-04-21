package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Provides methods to retrieve and parse address data from a JSON file.
 */

public class AddressJsonUtils
{
    public static final JSONParser parser = new JSONParser();
    public static final String addressesFilePath = "src/main/resources/addresses.json";

    /**
     * This method retrieves all information for a specific address from the JSON file.
     * @param addressKey The key corresponding to the address in the JSON file
     * @return A list of strings representing the values of the address elements
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
     * This method retrieves a specific element of an address from the JSON file.
     * @param addressKey The key corresponding to the address in the JSON file
     * @param elementKey The key corresponding to the specific element within the address
     * @return The value of the requested address element as a string
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
