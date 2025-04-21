package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class AddressJsonUtils
{
    public static final JSONParser parser = new JSONParser();
    public static final String addressesFilePath = "src/main/resources/addresses.json";

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
