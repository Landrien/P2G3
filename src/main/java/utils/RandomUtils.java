package utils;

/**
 * Utility class for generating random data.
 */
public class RandomUtils
{
    /**
     * Generates a temporary email address.
     *
     * @return A unique email address based on the current timestamp.
     */
    public static String getRandomEmail()
    {
        return "test." + System.currentTimeMillis() + "@yopmail.com";
    }
}
